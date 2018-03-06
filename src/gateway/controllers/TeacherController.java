/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gateway.controllers;

import gateway.dbconnection.DBConnection;
import gateway.model.Teacher;
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
public class TeacherController {
    public static int addTeacher(Teacher teacher) throws SQLException, ClassNotFoundException{
        String sql = "Insert into teacher values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Connection connection=DBConnection.getDBConnection().getConnection();
        PreparedStatement stm=connection.prepareStatement(sql);
        stm.setObject(1, teacher.getId());
        stm.setObject(2, teacher.getRegisterDate());
        stm.setObject(3, teacher.getName());
        stm.setObject(4, teacher.getPhoto());
        stm.setObject(5, teacher.getAdress());
        stm.setObject(6, teacher.getTP());
        stm.setObject(7, teacher.getFax());
        stm.setObject(8, teacher.getEmail());
        stm.setObject(9, teacher.getSchool());
        stm.setObject(10, teacher.getSchoolAdress());
        stm.setObject(11, teacher.getPassword());
        
        
        int res=stm.executeUpdate();
        return res;
        
    }
    public static ArrayList<String[]> getTeacherID() throws SQLException, ClassNotFoundException{
        String sql="select TeacherID from teacher";
        Connection connection =DBConnection.getDBConnection().getConnection();
        Statement stm=connection.createStatement();
        ResultSet rst= stm.executeQuery(sql);
        ArrayList<String[]> teacherID=new ArrayList<>();
        while(rst.next()){
            String[] id={rst.getString(1)};
            teacherID.add(id);
        }
     return teacherID;
    }
    public static ArrayList<String[]> getTeacherName() throws SQLException, ClassNotFoundException{
        String sql="select Name from teacher";
        Connection connection =DBConnection.getDBConnection().getConnection();
        Statement stm=connection.createStatement();
        ResultSet rst= stm.executeQuery(sql);
        ArrayList<String[]> teacherName=new ArrayList<>();
        while(rst.next()){
            String[] name={rst.getString(1)};
            System.out.println(name);
            teacherName.add(name);
        }
     return teacherName;
    }
     public static String[] getTeacher(String Id) throws SQLException, ClassNotFoundException{
        String sql="select Name , Photo  from teacher where TeacherID='"+Id+"'";
        Connection connection=DBConnection.getDBConnection().getConnection();
        Statement stm=connection.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        String[] teacher=null;
        if (rst.next()){
            teacher=new String[]{rst.getString(1),rst.getString(2)};
        }else {
            teacher=null;
        }
        return teacher;               
    }
     public static ArrayList<String[]> getTeacherIDName() throws SQLException, ClassNotFoundException{
        String sql="select TeacherID,Name from teacher";
        Connection connection =DBConnection.getDBConnection().getConnection();
        Statement stm=connection.createStatement();
        ResultSet rst= stm.executeQuery(sql);
        ArrayList<String[]> teacherIdName=new ArrayList<>();
        while(rst.next()){
            String[] idname={rst.getString(1),rst.getString(1)};
            teacherIdName.add(idname);
        }
     return teacherIdName;
    }
     public static String getTeacherId(String Id) throws SQLException, ClassNotFoundException{
        String sql="select Name from teacher where TeacherID='"+Id+"'";
        Connection connection=DBConnection.getDBConnection().getConnection();
        Statement stm=connection.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        String teacher=null;
        if (rst.next()){
            teacher=rst.getString("Name");
        }else {
            teacher=null;
        }
        return teacher;

     }

    public static String getTeacherName(String teacherDesc) throws SQLException, ClassNotFoundException {
        String sql="select TeacherId from teacher where Name='"+teacherDesc+"'";
        Connection connection=DBConnection.getDBConnection().getConnection();
        Statement stm=connection.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        String teacher=null;
        if (rst.next()){
            teacher=rst.getString("TeacherId");
        }else {
            teacher=null;
        }
        return teacher;
    }
}
