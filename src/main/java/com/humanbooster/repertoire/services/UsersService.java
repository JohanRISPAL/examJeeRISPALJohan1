/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.humanbooster.repertoire.services;

import com.humanbooster.repertoire.models.Users;
import com.humanbooster.repertoire.utils.DataConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author HB
 */
public class UsersService {
    
    private Connection connection;

    public UsersService() {
        try {
            this.connection = DataConnect.getConnexion();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<Users> getUsers() throws SQLException{
        
        ArrayList<Users> users = new ArrayList<Users>();
        
        String query = "SELECT * FROM users;";
        PreparedStatement prepareStatement = this.connection.prepareStatement(query);
        ResultSet rs = prepareStatement.executeQuery();

        while(rs.next()) {
            Integer id = rs.getInt("id");
            String image_link = rs.getString("image_link");
            String name = rs.getString("name");
            String firstName = rs.getString("firstname");
            String date_hire = rs.getString("date_hire");
            String cellphone_Number = rs.getString("cellphone_number");
            boolean isAdmin = rs.getBoolean("isAdmin");
            Users user = new Users(image_link, name, firstName, date_hire, cellphone_Number, isAdmin);
            user.setId(id);
            users.add(user);
        }

        rs.close();
        prepareStatement.close();
        
        return users;
    }
    
    public Users getUserById(String userId) throws SQLException{
        
        Users user = null;
        
        String query = "SELECT * FROM users WHERE id = ?;";
        PreparedStatement prepareStatement = this.connection.prepareStatement(query);
        prepareStatement.setString(1, userId);
        
        
        ResultSet rs = prepareStatement.executeQuery();

        while(rs.next()) {
            Integer id = rs.getInt("id");
            String image_link = rs.getString("image_link");
            String name = rs.getString("name");
            String firstName = rs.getString("firstname");
            String date_hire = rs.getString("date_hire");
            String cellphone_Number = rs.getString("cellphone_number");
            boolean isAdmin = rs.getBoolean("isAdmin");
            user = new Users(image_link, name, firstName, date_hire, cellphone_Number, isAdmin);
            user.setId(id);
        }

        rs.close();
        prepareStatement.close();
        
        return user;
    }
    
    public boolean userExist(String login, String password) throws SQLException{
        
        boolean exist = false;
        
        String query = "SELECT * FROM users WHERE login = ? AND pwd = ?;";
        PreparedStatement prepareStatement = this.connection.prepareStatement(query);
        prepareStatement.setString(1, login);
        prepareStatement.setString(2, password);
        
        ResultSet rs = prepareStatement.executeQuery();

        if(rs.next()) {
            exist = true;
        }

        rs.close();
        prepareStatement.close();
        
        return exist;
    }
    
    public boolean getUserByLoginAndPassword(String login, String password) throws SQLException{
        
        boolean isAdmin = false;
        
        String query = "SELECT * FROM users WHERE login = ? AND pwd = ?;";
        PreparedStatement prepareStatement = this.connection.prepareStatement(query);
        prepareStatement.setString(1, login);
        prepareStatement.setString(2, password);
        
        ResultSet rs = prepareStatement.executeQuery();

        if(rs.next()) {
            if(rs.getInt("isAdmin") == 1){
                isAdmin = true;
            }
        }

        rs.close();
        prepareStatement.close();
        
        return isAdmin;
    }
    
    public void createUser(Users u, String login, String pwd) throws SQLException{
        String query = "INSERT INTO users (image_link, name, firstname, date_hire, cellphone_number, isAdmin, login, pwd) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
        PreparedStatement prepareStatement = this.connection.prepareStatement(query);
        prepareStatement.setString(1, u.getImage_link());
        prepareStatement.setString(2, u.getName());
        prepareStatement.setString(3, u.getFirstName());
        prepareStatement.setString(4, u.getDate_hire());
        prepareStatement.setString(5, u.getCellphone_number());
        prepareStatement.setBoolean(6, u.isIsAdmin());
        prepareStatement.setString(7, login);
        prepareStatement.setString(8, pwd);
        
        
        prepareStatement.executeUpdate();
        
        prepareStatement.close();
    }

    public void updateUser(String name, String firstName, String date_hire, String cellphone, String id) throws SQLException{
        String query = "UPDATE users SET name = ?, firstname = ?, date_hire = ?, cellphone_number = ? WHERE id = ?;";
        PreparedStatement prepareStatement = this.connection.prepareStatement(query);
        prepareStatement.setString(1, name);
        prepareStatement.setString(2, firstName);
        prepareStatement.setString(3, date_hire);
        prepareStatement.setString(4, cellphone);
        prepareStatement.setString(5, id);
        
        prepareStatement.executeUpdate();
        
        prepareStatement.close();
    }

    public void deleteUser(Integer id) throws SQLException {
        
        String query = "DELETE FROM users WHERE id = ?;";
        PreparedStatement prepareStatement = this.connection.prepareStatement(query);
        prepareStatement.setInt(1, id);
        
        prepareStatement.executeUpdate();
        
        prepareStatement.close();
    }
}
