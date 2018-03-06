/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gateway.controllers;

import gateway.dbconnection.DBConnection;
import gateway.model.Tute;
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
public class TuteController {

    public static ArrayList<String[]> getTutes(String courseId) throws SQLException, ClassNotFoundException {
        String sql = "select TuteDesc , IssuedDate from Tute where coursId='" + courseId + "'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<String[]> courses = new ArrayList<>();
        while (rst.next()) {
            String[] course = {rst.getString("TuteDesc"), rst.getString("IssueDate")};
            courses.add(course);
        }
        return courses;

    }

    public static int addTute(ArrayList<Tute> tutes) throws SQLException, ClassNotFoundException {
        int count=0;
        for (Tute tute : tutes) {
            String sql = "insert into Tute values(?,?,?,?)";
            Connection connection = DBConnection.getDBConnection().getConnection();
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setObject(1, tute.getTuteId());
            stm.setObject(2, tute.getCourseId());
            stm.setObject(3, tute.getTuteDesc());
            stm.setObject(4, tute.getDateofissue());

            int res = stm.executeUpdate();
            if(res>0){
                count+=1;
            }
        }
        return count;
//
    }

    public static String getTuteDesc(String tuteId) throws SQLException, ClassNotFoundException {
        String sql="select TuteDesc from Tute where TuteId='"+tuteId+"'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        String tuteDesc;
        if(rst.next()){
            tuteDesc=rst.getString("TuteDesc");
        }else{
            tuteDesc=null;
        }
        return tuteDesc;
        
    }
    public static String getTuteId(String tuteDesc) throws SQLException, ClassNotFoundException {
        String sql="select TuteId from Tute where TuteDesc='"+tuteDesc+"'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        String tuteId;
        if(rst.next()){
            tuteId=rst.getString("TuteId");
        }else{
            tuteId=null;
        }
        return tuteId;
    }
    public static ArrayList<String> getUncollectedTutes(ArrayList<String> myTutes, String courseId) throws SQLException, ClassNotFoundException {
        String sql="select Tutedesc from Tute where courseId='"+courseId+"'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<String> unCollectedTutes=new ArrayList<>();
        int count=-1;
        while(rst.next()){
            String uncollectedTute=rst.getString("TuteDesc");
            unCollectedTutes.add(uncollectedTute);
            count+=1;
            for(String myTute:myTutes){
                System.out.println("checking"+"       "+uncollectedTute);
                if(uncollectedTute.equals(myTute)){
                    unCollectedTutes.remove(count);
                    count-=1;
                    System.out.println("         "+"removed");
                }
            }
        }
        return unCollectedTutes;
    }
    public static String getTuteCourse(String tuteId) throws SQLException, ClassNotFoundException {
        String sql="select CourseId from Tute where TuteId='"+tuteId+"'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        String courseId;
        if(rst.next()){
            courseId=rst.getString("CourseId");
        }else{
            courseId=null;
        }
        return courseId;
    }
}

