/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gateway.controllers;

import gateway.dbconnection.DBConnection;
import gateway.model.Student;
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
public class StudentController {

    public static int addStudent(Student student) throws SQLException, ClassNotFoundException {
        String sql = "insert into student values(?,?,?,?,?,?,?,?,?)";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setObject(1, student.getId());
        stm.setObject(2, student.getDate());
        stm.setObject(3, student.getName());
        stm.setObject(4, student.getPhoto());
        stm.setObject(5, student.getDOB());
        stm.setObject(6, student.getAdress());
        stm.setObject(8, student.getMobile());
        stm.setObject(7, student.getLand());
        stm.setObject(9, student.getGrade());

        int res = stm.executeUpdate();
        return res;
    }

    public static String[] getStudent(String Id) throws SQLException, ClassNotFoundException {
        String sql = "select Name , StudentPhoto  from student Where AdmisionNumber='" + Id + "' ";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        String[] student = null;
        if (rst.next()) {
            student = new String[]{rst.getString(1), rst.getString(2)};
        } else {
            student = null;
        }
        return student;
    }

    public static String getGradeOfStudent(String id) throws SQLException, ClassNotFoundException {
        String sql = "select GradeId From Student where AdmisionNumber='" + id + "'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        String grade = null;
        if (rst.next()) {
            grade = rst.getString("GradeId");
        }

        return grade;
    }

    public static String getRegisterDate(String admissionNumber) throws SQLException, ClassNotFoundException {
        String sql = "select DateOfAdmission From Student where AdmisionNumber='" +admissionNumber + "'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        String date = null;
        if (rst.next()) {
            date = rst.getString("DateOfAdmission");
        }

        return date;
    }
}
