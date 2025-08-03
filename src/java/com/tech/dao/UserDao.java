package com.tech.dao;

import com.tech.entities.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.http.HttpSession;


/**
 *
 * @author akash_codeit04x
 */
public class UserDao {
   private Connection con;

    public UserDao(Connection con) {
        this.con = con;
    }
    // to insert user to database 
   public boolean saveUser(User user) {
    boolean f = false;
    try {
        // Check if the email already exists in the database
        String checkQuery = "SELECT COUNT(*) FROM users WHERE email = ?";
        PreparedStatement checkStatement = con.prepareStatement(checkQuery);
        checkStatement.setString(1, user.getEmail());
        ResultSet resultSet = checkStatement.executeQuery();
        resultSet.next();
        int count = resultSet.getInt(1);
        
        if (count > 0) {
            // Email already exists, return false
            System.out.println("Email already exists.");
            return false;
        }

        // Insert the user into the database
        String insertQuery = "INSERT INTO users(username, email, password) VALUES (?, ?, ?)";
        PreparedStatement insertStatement = con.prepareStatement(insertQuery);
        insertStatement.setString(1, user.getUsername());
        insertStatement.setString(2, user.getEmail());
        insertStatement.setString(3, user.getPassword());
        
        int rowsAffected = insertStatement.executeUpdate();
        
        if (rowsAffected > 0) {
            // User successfully inserted
            f = true;
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return f;
}

    //get user by email and password 
       
 
public User getUserbyEmailandPassword(String email, String password, HttpSession session) {
    User user = null;
    try {
        String query = "SELECT * FROM users WHERE email=? AND password=?";
        PreparedStatement pstmt = con.prepareStatement(query);
        pstmt.setString(1, email);
        pstmt.setString(2, password);
        ResultSet rs = pstmt.executeQuery();
        if(rs.next()) {
            user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setEmail(rs.getString("email"));
            // Set other user properties as needed
            
            // Set session email
            session.setAttribute("email", email);
        }
    } catch(Exception e) {
        e.printStackTrace();
    }
    return user;
}

    
    
}
