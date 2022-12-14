/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Database.DBConnection;
import Model.userModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bibash kattel
 */
public class UserDao {

    private final DBConnection dBConnection = new DBConnection();
    private Connection connection;
    private final String table = "user";

    public int registerUser(String fname, String lname, String email, String phonenumber, String streetaddress, String housenumber, String city, String postcode, String password) {
        try {
            connection = dBConnection.getCOnnectedToDatabase();
            Statement statement = connection.createStatement();

            String sql = "INSERT INTO " + table + "(id, fname, lname, email, phonenumber, streetaddress, housenumber, city, postcode, password)"
                    + " values(NULL, '" + fname + "', '" + lname + "', '" + email + "', '" + phonenumber + "' , '" + streetaddress + "', '"
                    + housenumber + "', '" + city + "', '" + postcode + "', '" + password + "')";
            statement.executeUpdate(sql);
            System.err.println(sql);

            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            System.err.print(ex);
            return 0;
        }

    }

    public userModel loginUser(String email, String password) {
        try {
            connection = dBConnection.getCOnnectedToDatabase();
            Statement statement = connection.createStatement();

            String sql = "SELECT * FROM " + table + " WHERE email= '" + email + "' AND password ='" + password + "' LIMIT 1";
            System.err.println(sql);

            ResultSet resultSet = statement.executeQuery(sql);
             userModel model = null;
            if(resultSet.next()){
                  model = new userModel(
                    resultSet.getInt("id"),
                    resultSet.getString("fname"),
                    resultSet.getString("lname"),
                    resultSet.getString("email"),
                    resultSet.getString("phonenumber"),
                    resultSet.getString("streetaddress"),
                    resultSet.getInt("housenumber"),
                    resultSet.getString("city"),
                    resultSet.getString("postcode"),
                    resultSet.getString("password"),
                    resultSet.getString("usertype"));
            }
           
            return model;
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            System.err.print(ex);
            
        }
        return null;
        

    }

}
