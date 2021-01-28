/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.humanbooster.repertoire.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author HB
 */
public class DataConnect {
    public static Connection getConnexion() throws SQLException, ClassNotFoundException{
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/examjeerispaljohan?serverTimezone=UTC&useUnicode=true&characterEncoding=UTF-8";
        String user = "root";
        String password = "root";

        Connection connection = DriverManager.getConnection(url, user, password);

        return connection;
    }

    public static void closeConnection(Connection connection) throws SQLException{
        connection.close();
    }
}
