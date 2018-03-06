/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gateway.controllers;

import gateway.dbconnection.DBConnection;
import gateway.model.ClassDone;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pesshala
 */
public class ClassDoneController {

    public static void markClassDone(ClassDone classDone) throws SQLException, ClassNotFoundException {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
            Date date = sdf.parse(classDone.getDate());
            String sql = "Select *  from ClassDone where ClassId='" + classDone.getClassId() + "' and Date='" + date + "'";

            Connection connection = DBConnection.getDBConnection().getConnection();
            Statement stm = connection.createStatement();
            ResultSet rst = stm.executeQuery(sql);
            if (!rst.next()) {
                markclassnow(classDone);
            }
        } catch (ParseException ex) {
            Logger.getLogger(ClassDoneController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void markclassnow(ClassDone classDone) throws SQLException, ClassNotFoundException {
        String sql = "insert into student values(?,?)";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setObject(1, classDone.getClassId());
        stm.setObject(2, classDone.getDate());

        int res = stm.executeUpdate();

    }

    public static int getNumberOfDoneClasses(String clas, Date date) throws SQLException, ClassNotFoundException {
        SimpleDateFormat sdfyear = new SimpleDateFormat("YYYY");
        SimpleDateFormat sdfmonth = new SimpleDateFormat("MM");

        String sql = "select count(Date) as dayscount from ClassDone where ClassId='" + clas + "' and year(Date)='" + sdfyear.format(date) + "' and month(Date)='" + sdfmonth.format(date) + "'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        rst.next();

        int countOfDays = rst.getInt("dayscount");
        return countOfDays;

    }
}
