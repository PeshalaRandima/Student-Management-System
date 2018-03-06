/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gateway.controllers;

import gateway.dbconnection.DBConnection;
import gateway.model.Furniture;
import gateway.model.Log;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class LogController {
      public static int enterLog(Log log) throws SQLException, ClassNotFoundException{
        Connection connection=DBConnection.getDBConnection().getConnection();
        String sql="insert into log values(?,?,?,?)";
        PreparedStatement stm=connection.prepareStatement(sql);
        stm.setObject(1, log.getClasID());
        stm.setObject(2, log.getDate());
        stm.setObject(3, log.getTime());
        stm.setObject(4, log.getContent());
        int res=stm.executeUpdate();
        return res;
     }
}