/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gateway.controllers;

import gateway.dbconnection.DBConnection;
import gateway.model.AdminAccount;
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
public class AdministratorController {

    public static boolean adminAvailable() throws SQLException, ClassNotFoundException {
        boolean admin = false;
        String sql = "select count(*) from adminaccount"; //get count of rows in admin table;
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        if (rst.next()) {
            int admincount = rst.getInt(1);

            if (admincount > 0) {
                admin = true;
            } else if (admincount <= 0) {
                admin = false;
            }
        }

        return admin;
    }

    public static boolean getAdminPassword(String password) throws SQLException, ClassNotFoundException {
        boolean permision;
        String sql = "select count(AdminName) from adminaccount where password=password('"+password+"')";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        rst.next();
        int res=rst.getInt("count(AdminName)");
        if(res>0){
            permision=true;
        }else{
            permision=false;
        }
        return permision;
        
        

    }

    public static int addAdmin(AdminAccount adminAccount) throws SQLException, ClassNotFoundException {
      String sql = "insert into adminaccount values(?,?,password(?))";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setObject(1, adminAccount.getDate());
        stm.setObject(2, adminAccount.getUserName());
        stm.setObject(3, adminAccount.getPassword());
       

        int res = stm.executeUpdate();
        return res;
    }

}
