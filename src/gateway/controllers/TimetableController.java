package gateway.controllers;

import gateway.dbconnection.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DELL
 */
public class TimetableController {

    public static String[][] getTimetable(String place) throws SQLException, ClassNotFoundException {

        String sql = "select ClassID, DayID ,PeriodID from timetable t where t.PlaceID='" + place + "'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        String[][] rowData = new String[7][28];
        System.out.println(Arrays.deepToString(rowData));
        while (rst.next()) {
            int day = Integer.parseInt(rst.getString(2));
            int pieriod = Integer.parseInt(rst.getString(3));

            rowData[day - 1][pieriod - 1] = rst.getString(1);
        }
        System.out.println(Arrays.deepToString(rowData));
        return rowData;
    }

    public static ArrayList<String[]> getClassTimes(String courseId) throws SQLException, ClassNotFoundException {
        System.out.println(courseId);
        String sql = "Select Classdesc from class where courseid='" + courseId + "'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<String[]> rowdatas = new ArrayList<>();
        ArrayList<String> classes = new ArrayList<>();
        while (rst.next()) {
            classes.add(rst.getString("classdesc"));
            System.out.println(rst.getString(1));
        }
        for (String clas : classes) {
            System.out.println("        " + clas);
            String classid = ClassController.getClassId(clas);
            System.out.println(classid);
            String sql2 = "select  DayId , PeriodId from timetable where Classid='" + classid + "'order by  PeriodId asc";
            Connection connection2 = DBConnection.getDBConnection().getConnection();
            Statement stm2 = connection2.createStatement();
            ResultSet rst2 = stm2.executeQuery(sql2);

            rst2.next();
            String day = DayController.getDay(rst2.getString("DayId"));
            System.out.println("                      " + day);
            String startingTime = PeriodController.getStartingTime(rst2.getString(2));//  methana case 1 thamai methana ganne peiriodid ekai
            System.out.println("                      " + startingTime);

            rst2.last();
            String endingTime = PeriodController.getEndingTime(rst2.getString(2));
            System.out.println("                      " + endingTime);

            String[] rowdata = {clas, day, startingTime+" -  "+ endingTime};
            rowdatas.add(rowdata);
            System.out.println(clas + "    " + day + "    " + startingTime + "       " + endingTime);
        }

        return rowdatas;
    }
}
