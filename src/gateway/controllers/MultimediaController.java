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
public class MultimediaController {
    public static ArrayList<String[]> getMultimedia() throws SQLException, ClassNotFoundException{
        String sql="select PackageDesc from package";
        Connection connection=DBConnection.getDBConnection().getConnection();
        Statement stm=connection.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        ArrayList<String[]> rows=new ArrayList<>();
        
        while(rst.next()){
            String[] row={rst.getString(1)};
            rows.add(row);
        }
        return rows;
    }
    public static String getMultimediaId(String packageDesc) throws SQLException, ClassNotFoundException{
        String sql="select MultimediaID from multimediapackages where PackageDesc='"+packageDesc+"'";
        Connection connection =DBConnection.getDBConnection().getConnection();
        Statement stm=connection.createStatement();
        ResultSet rst= stm.executeQuery(sql);
        rst.next();
        String multimediaID=rst.getString("MultimediaID");
                    
         return multimediaID;
    }
    public static ArrayList<String[]> getMultimediaDescription() throws SQLException, ClassNotFoundException{
        String sql="select PackageID ,package name Multimediafascility   from Multimedia,multimediaFascility ,package where.... ";
        //methana queryata ganna one package table eken packageID,package Table eken PackageDesc ekai, mutimedia tabl eken multimedia facility ekai ganna widiyata
        Connection connection=DBConnection.getDBConnection().getConnection();
        Statement stm=connection.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        ArrayList<String[]> rows=new ArrayList<>();
        
        while(rst.next()){          
            String[] row={rst.getString(0),rst.getString(1),rst.getString(2)};
            rows.add(row);          
        }
        
        return rows;
    }
    
}
