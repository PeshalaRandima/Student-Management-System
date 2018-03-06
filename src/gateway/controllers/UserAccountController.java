/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gateway.controllers;

import gateway.dbconnection.DBConnection;
import gateway.model.AdminAccount;
import gateway.model.UserAccount;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Pesshala
 */
public class UserAccountController {

    public static String getTeacherID(String userName) throws SQLException, ClassNotFoundException {
        String sql = "Select password from UserAccount where Username='" + userName + "'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        rst.next();
        String password = rst.getString("password");
        return password;
    }

    public static ArrayList<String> getUsers() throws SQLException, ClassNotFoundException {
        String sql = "Select UserName from UserAccount";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);

        ArrayList<String> users = new ArrayList<>();
        while (rst.next()) {
            String user = rst.getString("UserName");
            users.add(user);
        }
        return users;
    }

    public static String getPassword(String userName) throws ClassNotFoundException, SQLException {
        String sql = "Select password from UserAccount where Username='" + userName + "'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        rst.next();
        String password = rst.getString("password");
        return password;
    }

    public static String newUserAccount(String userName) throws ClassNotFoundException, SQLException {
        String sql = "insert into UserAccount values(password(" + pass + "))";
        String sql = "select  username from userAAccount where password=password("++
        ") "
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        rst.next();
        String password = rst.getString("password");
        return password;
    }

    public static int addUserAccount(UserAccount userAccount) throws SQLException, ClassNotFoundException {

        String sql = "insert into useraccount values(?,?,password(?))";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setObject(1, userAccount.getName());
        stm.setObject(2, userAccount.getUserName());
        stm.setObject(3, userAccount.getPassword());

        int res = stm.executeUpdate();
        return res;
    }

    public static boolean checkPassword(String userName, String password) throws SQLException, ClassNotFoundException {
        boolean pass=false;
        String sql = "select username from useraccount where password=password('" + password + "')";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        while (rst.next()) {
            if (rst.getString("username").equals(userName)) {
                pass = true;
                break;
            }
        }
        return pass;
    }

}
