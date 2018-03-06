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

/**
 *
 * @author Pesshala
 */
public class PeriodController {

    static String getStartingTime(String periodId) throws SQLException, ClassNotFoundException {
        String sql = "select Startingtime from period where periodid='" + periodId + "'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        rst.next();
        String startingTime = rst.getString(1);
        return startingTime;
    }

    static String getEndingTime(String periodId) throws SQLException, ClassNotFoundException {
       String sql = "select endingtime from period where periodid='" + periodId + "'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        rst.next();
        String endingTime = rst.getString(1);
        return endingTime;
    }

}
