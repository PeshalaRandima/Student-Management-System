/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gateway.controllers;

import gateway.dbconnection.DBConnection;
import gateway.model.Furniture;
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
public class FurnitureController {
    public static boolean addFurniture(ArrayList<Furniture> rows) throws SQLException, ClassNotFoundException{
        Connection connection=DBConnection.getDBConnection().getConnection();
        int size=0;
        for(Furniture furnitures:rows){
            String sql="insert into furniture values(?,?)";
            PreparedStatement stm=connection.prepareStatement(sql);
            stm.setObject(1, furnitures.getId());
            stm.setObject(2, furnitures.getFurniture());
            int res=stm.executeUpdate();
            
            size+=1;
            
       }
        if (size==rows.size()){
            return true;
        }else 
        {
            return false;
        }
        
    }
      public static ArrayList<String[]> getFurniture() throws SQLException, ClassNotFoundException{
        String sql="select FurnitureDesc from furniture";
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
    public static String getFurnitureId(String furnitureDesc) throws SQLException, ClassNotFoundException{
        String sql="select FurnitureID from furniture where furnitureDesc='"+furnitureDesc+"'";
        Connection connection =DBConnection.getDBConnection().getConnection();
        Statement stm=connection.createStatement();
        ResultSet rst= stm.executeQuery(sql);
        rst.next();
        String FurnitureID=rst.getString("FurnitureID");
                    
         return FurnitureID;
    }
}
