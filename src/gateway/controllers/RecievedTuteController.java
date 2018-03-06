/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gateway.controllers;

import gateway.dbconnection.DBConnection;
import gateway.model.RecievedTute;
import gateway.view.studentaccount.Arraylist;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Pesshala
 */
public class RecievedTuteController {

    public static Arraylist<String[]> getMyTutesAllDetails(String admissionNumber) throws SQLException, ClassNotFoundException {
        System.out.println(admissionNumber);
        String sql = "select * from ReceivedTute where admissionNumber='" + admissionNumber + "'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<String[]> recievedTutes = new ArrayList<>();
        while (rst.next()) {
            String[] tute = {rst.getString("admissionNumber"), rst.getString("TuteId"), rst.getString("DateOfRegistry")};
            recievedTutes.add(tute);
        }
        return recievedTutes;

    }

    public static ArrayList<String> getMyTutes(String admissionNumber, String Courseid) throws SQLException, ClassNotFoundException {
        ArrayList<String[]> tutedetails = getMyTutesAllDetails(admissionNumber);
        ArrayList<String> myTutes = new ArrayList<>();
        for (String[] tute : tutedetails) {
            if (TuteController.getTuteCourse(tute[1]) == Courseid) {
                String myTute = TuteController.getTuteDesc(tute[1]);
                myTutes.add(myTute);
            }
        }
        return myTutes;
    }

    public static int addReceivedTute(ArrayList<RecievedTute> tutes) throws SQLException, ClassNotFoundException {
        int count = 0;
        for (RecievedTute tute : tutes) {
            String sql = "insert into student values(?,?,?)";
            Connection connection = DBConnection.getDBConnection().getConnection();
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setObject(1, tute.getAdmissionNumber());
            stm.setObject(2, tute.getTuteId());
            stm.setObject(3, tute.getDate());

            int res = stm.executeUpdate();
            if (res > 0) {
                count += 1;

            }
        }
        return count;
    }

    public static ArrayList<String[]> getmyTuteDetails(String admissionNumber, String CourseId) throws SQLException, ClassNotFoundException {
        ArrayList<String[]> tutedetails = getMyTutesAllDetails(admissionNumber);
        ArrayList<String[]> myTutes = new ArrayList<>();
        for (String[] tute : tutedetails) {
            if (TuteController.getTuteCourse(tute[1]) == CourseId) {
                String[] myTute = {TuteController.getTuteDesc(tute[1]),tute[1],tute[2]};
                myTutes.add(myTute);
            }
        }
        return myTutes;
    }

}
