/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gateway.controllers;

import gateway.dbconnection.DBConnection;
import gateway.model.Subject;
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
public class SubjectController {

    public static boolean addSubject(Subject subjects, ArrayList<String> streams) throws SQLException, ClassNotFoundException {
        String sql = "insert int subject values(?,?)";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setObject(1, subjects.getId());
        stm.setObject(2, subjects.getSubject());
        int res = stm.executeUpdate();
        boolean resp;
        if (res > 0) {
            resp = StreamedSubjectController.addStreamedSubject(subjects, streams, connection);
        } else {
            resp = false;
        }
        return resp;

    }

    public static ArrayList<String[]> getSubject() throws SQLException, ClassNotFoundException {
        String sql = "select SubjectDesc from subject ";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<String[]> subjects = new ArrayList<>();
        while (rst.next()) {
            String[] subject = {rst.getString(1)};
            subjects.add(subject);
        }
        return subjects;
    }

    public static String getSubjectId(String SubjectDesc) throws SQLException, ClassNotFoundException {
       // System.out.println(SubjectDesc);
        String sql = "select SubjectID from subject where SubjectDesc='" + SubjectDesc + "'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        rst.next();
        String subjectID = rst.getString("SubjectID");

        return subjectID;
    }

    static String getSubjectDesc(String subjectId) throws SQLException, ClassNotFoundException {
        String sql = "select SubjectDesc from subject where SubjectId='" + subjectId + "'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        rst.next();
        String subjectDesc = rst.getString("SubjectDesc");

        return subjectDesc;
    }
}
