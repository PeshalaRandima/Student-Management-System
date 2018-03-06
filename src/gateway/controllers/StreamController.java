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
 * @author DELL
 */
public class StreamController {
    public static ArrayList<String> viewStreamNames() throws SQLException, ClassNotFoundException{
        String sql="select Stream from streams";
        Connection connection=DBConnection.getDBConnection().getConnection();
        Statement stm=connection.createStatement();
        ResultSet rst =stm.executeQuery(sql);
        ArrayList<String> streams = null;
        if(rst!=null){
        while(rst.next()){
            streams.add(rst.getString("Stream"));
            System.out.println(rst.getString("Stream"));
        }
        }
        return streams;
    }
    
}
