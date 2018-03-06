/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gateway.controllers;

import gateway.dbconnection.DBConnection;
import gateway.model.MultimediaFascility;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



/**
 *
 * @author DELL
 */
public class MultimediaFascilityController {
    public static boolean addFascility(ArrayList<MultimediaFascility> medias) throws SQLException, ClassNotFoundException{
        Connection connection=DBConnection.getDBConnection().getConnection();
        int size=0;
        for(MultimediaFascility media:medias){
            String sql="insert into MultimediaFascility values(?,?)";
            PreparedStatement stm=connection.prepareStatement(sql);
            stm.setObject(1, media.getId());
            stm.setObject(2, media.getFascility());
            stm.executeUpdate();
            
            size+=1;
            
        }
        boolean res;
        if(size==medias.size()){
            res=true;
        }else{
            res=false;
        }
        return res;
        
    }
    public static ArrayList<Object[]> viewAvailableFascilities() throws SQLException, ClassNotFoundException{
        String sql="select* from multimedia ";
        Connection connection=DBConnection.getDBConnection().getConnection();
        Statement stm=connection.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        
        ArrayList<Object[]> rows=new ArrayList<>();
        while(rst.next()){
            Object[] row={rst.getString(1),rst.getString(2)};
            rows.add(row);

        }
        return rows;
    }
    public static String getMultimediaFaciltyDesc(String multimediaID) throws SQLException, ClassNotFoundException{
        String sql="select MultimediaDesc from multimedia where MultimediaID='"+multimediaID+"'";
        Connection connection =DBConnection.getDBConnection().getConnection();
        Statement stm=connection.createStatement();
        ResultSet rst= stm.executeQuery(sql);
        rst.next();
        String multimediaDesc=rst.getString("MultimediaDesc");
                    
         return multimediaDesc;
    }
}
