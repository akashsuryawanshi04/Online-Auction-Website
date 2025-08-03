package com.tech.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
    
    private static Connection con;
    
    public static Connection getConnection() {
        try {
            if(con == null || con.isClosed()) {
                // Driver class load 
                Class.forName("com.mysql.cj.jdbc.Driver");
                // Connection with database 
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/on_product", "your_database_username","pasword");
            }
        } catch(ClassNotFoundException e) {
            e.printStackTrace(); // Log or handle this exception appropriately
        } catch(SQLException e) {
            e.printStackTrace(); // Log or handle this exception appropriately
        }
        return con;
    }
    
    public static void closeConnection() {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
            }
        } catch(SQLException e) {
            e.printStackTrace(); // Log or handle this exception appropriately
        }
    }
}
