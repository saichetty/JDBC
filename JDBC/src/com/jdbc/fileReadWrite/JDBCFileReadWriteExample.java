package com.jdbc.fileReadWrite;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCFileReadWriteExample {
	   
    public static void main(String[] args) {
  
        

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root","root")) {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO employees (id, name) VALUES (?, ?)");
            BufferedReader reader = new BufferedReader(new FileReader("employees.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                preparedStatement.setInt(1, Integer.parseInt(data[0]));
                preparedStatement.setString(2, data[1]);
                preparedStatement.executeUpdate();
            }
            reader.close();

            FileWriter writer = new FileWriter("employees_copy.txt");
            preparedStatement  = connection.prepareStatement("SELECT * FROM employees");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                writer.write(id + "," + name + "\n");
            }
            
            writer.close();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}

