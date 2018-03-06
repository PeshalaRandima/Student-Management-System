/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gateway.controllers;

import gateway.dbconnection.DBConnection;
import gateway.model.StudentCourses;
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
public class StudentCoursesController {

    public static int addStudentCourse(ArrayList<StudentCourses> rowData) throws SQLException, ClassNotFoundException {
        int count = 0;

        for (StudentCourses row : rowData) {
            String sql = "insert into studentcourses values(?,?,?,?)";
            Connection connection = DBConnection.getDBConnection().getConnection();
            PreparedStatement stm = connection.prepareStatement(sql);
            System.out.println(row.getClassId());
            stm.setObject(1, row.getAdmissionNumber());
            stm.setObject(2, row.getCourseid());
            stm.setObject(3, row.getClassId());
            stm.setObject(4, row.getDateOfRegistry());

            int res = stm.executeUpdate();
            if (res > 0) {
                count += 1;
            }
        }
        return count;
    }

    public static ArrayList<Object[]> getNameListOfStudentsRegisteredToClass(String classId) throws SQLException, ClassNotFoundException {
        System.out.println(classId);
        String sql = "select sc.AdmissionNumber , s.Name from studentcourses sc, student s where sc.AdmissionNumber=s.AdmisionNumber and sc.ClassId='" + classId + "' order by sc.AdmissionNumber ;";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<Object[]> rowDatas = new ArrayList<>();
        while (rst.next()) {
            Object[] row = {rst.getString("AdmissionNumber"), rst.getString("Name")};
            rowDatas.add(row);
        }

        System.out.println(rowDatas);
        return rowDatas;
    }

    public static ArrayList<Object[]> getNameListOfStudentsRegisteredToCourse(String courseId) throws SQLException, ClassNotFoundException {
        System.out.println(courseId);
        String sql = "select sc.AdmissionNumber , s.Name from studentcourses sc, student s where sc.AdmissionNumber=s.AdmisionNumber and sc.courseId='" + courseId + "' order by sc.AdmissionNumber ;";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<Object[]> rowDatas = new ArrayList<>();
        while (rst.next()) {
            Object[] row = {rst.getString("AdmissionNumber"), rst.getString("Name")};
            rowDatas.add(row);
        }

        System.out.println(rowDatas);
        return rowDatas;
    }

    public static ArrayList<Object[]> getNameListWithClassOfStudentsRegisteredToCourse(String courseId) throws SQLException, ClassNotFoundException {
        System.out.println(courseId);
        String sql = "select sc.AdmissionNumber , s.Name ,c.ClassDesc\n"
                + "from studentcourses sc, student s,class c\n"
                + "where sc.AdmissionNumber=s.AdmisionNumber and c.ClassID=sc.ClassId and sc.CourseId='" + courseId + "'\n"
                + "group by sc.AdmissionNumber\n"
                + "order by sc.AdmissionNumber ";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<Object[]> rowDatas = new ArrayList<>();
        while (rst.next()) {
            Object[] row = {rst.getString("AdmissionNumber"), rst.getString("Name"),rst.getString("classDesc")};
            rowDatas.add(row);
        }

        System.out.println(rowDatas);
        return rowDatas;
    }
}

}
