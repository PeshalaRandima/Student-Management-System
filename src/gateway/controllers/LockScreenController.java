/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gateway.controllers;

import gateway.dbconnection.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Pesshala
 */
public class LockScreenController {

    public static int addLock(String lock, String oldLock) throws SQLException, ClassNotFoundException {       
        String sql="update lockcode from Lock where lockCode='"+oldLock+"' to '"+lock+"'";
        Connection connection =DBConnection.getDBConnection().getConnection();
        Statement stm=connection.createStatement();
        int res= stm.executeUpdate(sql);
         return res ;
        }

    public static String getLock() throws SQLException, ClassNotFoundException {
        
        String sql="select * from lock ";
        Connection connection=DBConnection.getDBConnection().getConnection();
        Statement stm=connection.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        rst.next();
        String lock=rst.getString("lockcode");
        
       
        return lock;
    
    }
    
    
    
    
}
