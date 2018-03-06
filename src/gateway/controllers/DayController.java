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
public class DayController {

    public static String getDay(String dayid) throws SQLException, ClassNotFoundException {

        String sql = "select Day from day where dayid='" + dayid + "'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        String day = "";
        if (rst.next()) {
            day = rst.getString("Day");
        }
        return day;

    }

}
