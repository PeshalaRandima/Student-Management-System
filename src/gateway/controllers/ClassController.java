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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class ClassController {

    public static ArrayList<String[]> getClas() throws SQLException, ClassNotFoundException {
        String sql = "select ClassDesc from class ";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<String[]> classes = new ArrayList<>();
        while (rst.next()) {
            String[] clas = {rst.getString(1)};
            classes.add(clas);
        }
        return classes;
    }

    public static String getClassdesc(String clasID) throws SQLException, ClassNotFoundException {
        String sql = "select classDesc from class where classID=' " + clasID + "'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        rst.next();
        String clasdesc = rst.getString(1);
        return clasdesc;
    }

    public static String getClassId(String clasDesc) throws SQLException, ClassNotFoundException {
        String sql = "select classID from class where classDesc='" + clasDesc + "'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        rst.next();
        String classId = rst.getString("classID");
        return classId;
    }

    public static String getCourseIdFromClassId(String clasId) throws SQLException, ClassNotFoundException {
        String sql = "select courseID from class where classID='" + clasId + "'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        rst.next();
        String courseId = rst.getString(1);
        return courseId;
    }
//------------------------------------------------------------------------------------------------------------------------------------------
    //me method eken puluwan courseID list ekak ewwama , e list ekata adalawa tyena okkoma classes wala classdesc tika ganna 

    public static ArrayList<String> getClassesDesc(ArrayList<String> courses) {
        ArrayList<String> Classes = null;
        if (Classes == null) {
            for (String course : courses) {
                try {
                    //System.out.println(course);
                    String sql = "select ClassDesc from class where courseId='" + course + "'";
                    Connection connection = DBConnection.getDBConnection().getConnection();
                    Statement stm = connection.createStatement();
                    ResultSet rst = stm.executeQuery(sql);
                    Classes = new ArrayList<>();
                    while (rst.next()) {
                        String clas = rst.getString("ClassDesc");
                        Classes.add(clas);
                    }
                } catch (SQLException | ClassNotFoundException ex) {
                    Logger.getLogger(ClassController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return Classes;
        }
        return null;
    }

    public static ArrayList<String[]> Getclasses(String Id) {
        try {
            String sql = "select cl.ClassDesc from Student st, StudentCourses sc, Course co, Class cl where st.AdmisionNumber = '" + Id + "' and  st.AdmisionNumber = sc.AdmissionNumber and sc.CourseID = co.CourseID and co.CourseID = cl.CourseID";
            Connection connection = DBConnection.getDBConnection().getConnection();
            Statement stm = connection.createStatement();
            ResultSet rst = stm.executeQuery(sql);
            ArrayList<String[]> classes = new ArrayList<>();
            while (rst.next()) {
                String[] clas = {rst.getString(1)};
                classes.add(clas);
            }
            return classes;
        } catch (SQLException ex) {
            Logger.getLogger(ClassController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClassController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public static ArrayList<String> getClassesOfCourse(String courseId) throws ClassNotFoundException, SQLException {
        String sql = "select ClassDesc from class where courseId='" + courseId + "'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<String> Classes = new ArrayList<>();
        while (rst.next()) {
            String clas = rst.getString("ClassDesc");
            Classes.add(clas);
        }
        return Classes;
    }
    public static ArrayList<String> getClassesAndVenuesOfCourse(String courseId) throws ClassNotFoundException, SQLException {
        String sql = "select ClassDesc ,  from class where courseId='" + courseId + "'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<String> Classes = new ArrayList<>();
        while (rst.next()) {
            String clas = rst.getString("ClassDesc");
            Classes.add(clas);
        }
        return Classes;
    }
    public static ArrayList<String> getClassIds(String courseId) throws ClassNotFoundException, SQLException {
        String sql = "select ClassId   from class where courseId='" + courseId + "'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<String> Classes = new ArrayList<>();
        while (rst.next()) {
            String clas = rst.getString("ClassId");
            Classes.add(clas);
        }
        return Classes;
    }

}
