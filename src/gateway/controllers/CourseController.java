/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gateway.controllers;

import gateway.dbconnection.DBConnection;
import gateway.model.Course;
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
public class CourseController {

    public static void addCourse(ArrayList<Course> courses) throws SQLException, ClassNotFoundException {

        for (Course course : courses) {
            String sql = "insert into course values (? ,? ,?,?,?,?,?,?) ";
            Connection connection = DBConnection.getDBConnection().getConnection();
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setObject(1, course.getCourseID());
            stm.setObject(2, course.getTeacherID());
            stm.setObject(3, course.getSubjectID());
            stm.setObject(4, course.getGradeID());
            stm.setObject(5, course.getFee());
            stm.setObject(6, course.getTime());
            stm.executeUpdate();

        }

    }

    //====================================================================
    // meme methodeka use wena then 
    //Add class 
    public static ArrayList<String[]> viewFilteredCourse(String grade, String subject, String teacher) throws SQLException, ClassNotFoundException {
        ResultSet filteredgrade = filterGrade(grade);
        ResultSet filteredsubject = filterSubject(subject, filteredgrade);
        ResultSet filteredteacher = filterTeacher(teacher, filteredsubject);
        ArrayList<String[]> courses = null;
        while (filteredteacher.next()) {
            String courseID = filteredteacher.getString(0);
            //methana join query gahanna wenawa ids walin names ena widiyata , select Course        
            String[] course = getCourse(courseID);
            courses.add(course);
        }
        return courses;
    }

    private static ResultSet filterGrade(String grade) throws SQLException, ClassNotFoundException {
        ResultSet filteredgrade;
        if (grade == null) {
            String sql = "select * from course";
            Connection connection = DBConnection.getDBConnection().getConnection();
            Statement stm = connection.createStatement();
            filteredgrade = stm.executeQuery(sql);
        } else {
            String sql = "select * from course where gradeId ='" + grade + "'";
            Connection connection = DBConnection.getDBConnection().getConnection();
            Statement stm = connection.createStatement();
            filteredgrade = stm.executeQuery(sql);
        }
        return filteredgrade;
    }

    private static ResultSet filterSubject(String subject, ResultSet filteredgrade) throws SQLException, ClassNotFoundException {
        ResultSet filteredsubject;
        if (subject == null) {
            filteredsubject = filteredgrade;
        } else {
            String sql = "select";
//sql query tika gahaganna ona , ewana querye sub queryak widiyata
//String sql="select * from course where subject='"+subject+"'";
            Connection connection = DBConnection.getDBConnection().getConnection();
            Statement stm = connection.createStatement();
            filteredsubject = stm.executeQuery(sql);
        }
        return filteredsubject;
    }

    private static ResultSet filterTeacher(String teacher, ResultSet filteredsubject) throws SQLException, ClassNotFoundException {
        ResultSet filteredteacher;

        String sql = "";
        if (teacher == null) {
            filteredteacher = filteredsubject;
        } else {
            //sql query tika gahaganna ona , ewana querye sub queryak widiyata
            //String sql="select * from course where teacher='"+teacher+"'";
            Connection connection = DBConnection.getDBConnection().getConnection();
            Statement stm = connection.createStatement();
            filteredteacher = stm.executeQuery(sql);
        }
        return filteredteacher;
    }
    //=============================================================================================
    //--------------------------------------------------------------------------------------------

    public static ArrayList<String[]> getCourse() throws SQLException, ClassNotFoundException {
        String sql = "select CourseDesc from course ";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<String[]> courses = new ArrayList<>();
        while (rst.next()) {
            String[] course = {rst.getString(1)};
            System.out.println(course[0]);
            courses.add(course);
        }
        return courses;
    }

    //----------------------------------------------------------------------------------------------
    //meken puluwan wenne courseid ekata adala course eka gennawaganna 
    public static String[] getCourse(String courseid) throws SQLException, ClassNotFoundException {
        String sql = "select CourseDescription from course where CourseID='" + courseid + "'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        rst.next();
        String courses[] = {rst.getString("CourseDescription")};
        return courses;
    }

    public static String getCourseId(String courseDesc) throws SQLException, ClassNotFoundException {
        String sql = "select CourseID from course where CourseDesc='" + courseDesc + "'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        rst.next();
        String courses = rst.getString("CourseID");
        return courses;
    }

    public static String getFee(String courseid) throws SQLException, ClassNotFoundException {
        String sql = "select MonthlyFee from course where CourseID='" + courseid + "'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        rst.next();
        String coursefee = Integer.toString(rst.getInt("MonthlyFee"));
        return coursefee;
    }

    public static ArrayList<String> getHisCourses(String Id) throws SQLException, ClassNotFoundException {

        String sql = "Select courseDesc from course c, StudentCourses sc where sc.AdmissionNumber='" + Id + "'and sc.courseId=c.courseID";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<String> courses = new ArrayList<>();
        while (rst.next()) {
            String clas = rst.getString(1);
            courses.add(clas);
        }
        System.out.println(courses);
        return courses;
    }

    public static ArrayList<String> getFilteredCourses(String teacher, String subject, String grade) throws SQLException, ClassNotFoundException {

        String sql = "Select courseDesc from course course c , grade g, teacher t,subject s where c.teacherId=t.teacherId and g.gradeId=c.gradeId and s.subjectId=c.subjectId and t.Name='Gayan Sangeewa' and s.subjectDesc='Physics' and g.gradeDesc ='1'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<String> courses = new ArrayList<>();
        while (rst.next()) {
            String clas = rst.getString(1);
            courses.add(clas);
        }
        System.out.println(courses);
        return courses;
    }

    public static ArrayList<String> getCourseOfGradeAndSubject(String subject, String grade) throws SQLException, ClassNotFoundException {
        System.out.println(subject + "   " + grade);
        String sql = "select courseDesc from course where SubjectID='" + subject + "' and GradeId='" + grade + "'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<String> courses = new ArrayList<>();
        if (rst == null) {
            String text = "No Courses";
            courses.add(text);
        } else {
            while (rst.next()) {
                String clas = rst.getString(1);
                courses.add(clas);
            }
        }
        System.out.println(courses);
        return courses;
    }

    public static String getCourseDesc(String courseId) throws SQLException, ClassNotFoundException {
        System.out.println(courseId);
        String sql = "select CourseDesc from course where CourseId='" + courseId + "'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        rst.next();
        String courses = rst.getString("CourseDesc");
        System.out.println(courses);
        return courses;

    }

    public static String[] getCourseDescAndCourseFee(String courseId) throws SQLException, ClassNotFoundException {
        String sql = "select CourseDesc , MonthlyFee from course where CourseId='" + courseId + "'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        rst.next();
        //String[] courses=null;
        //if (rst.next()) {
        //String[] courses={rst.getString("CourseDesc"),C.};
        String desc = rst.getString("CourseDesc");
        String fee = Integer.toString(rst.getInt("MonthlyFee"));
        String[] courseDescAndFee = {desc, fee};

        return courseDescAndFee;

    }

    public static ArrayList<String[]> getCourseForGrade(String GradeId, String studentId) throws SQLException, ClassNotFoundException {
        System.out.println(GradeId+"    "+studentId);
        String sqlprevious = "select CourseID from StudentCourses where AdmissionNumber='" + studentId + "'";
        Connection connectionprevious = DBConnection.getDBConnection().getConnection();
        Statement stmprevious = connectionprevious.createStatement();
        ResultSet rstprevious = stmprevious.executeQuery(sqlprevious);
        

        String sql = "Select * from Course where GradeId='" + GradeId + "'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);

        ArrayList<String[]> rowDatas = new ArrayList<>();

        int count = -1;
        
        while (rst.next()) {
            System.out.println(rst.getString("CourseId"));
            String[] row = {SubjectController.getSubjectDesc(rst.getString("SubjectId")),TeacherController.getTeacherId(rst.getString("TeacherId")),rst.getString("CourseDesc"),Integer.toString(rst.getInt("MonthlyFee"))};// methana adda kraganna table eke view wenna ona dewal tika 
            rowDatas.add(row);
            count += 1;
            rstprevious.first();
            rstprevious.previous();
            while (rstprevious.next()) {
                System.out.println(rstprevious.getString("CourseId")+"...........");
                if (rst.getString("CourseId").equals(rstprevious.getString("CourseId"))) {
                    System.out.println("             "+"available");
                    rowDatas.remove(count);
                    count=count-1;
                }
            }
        }
        return rowDatas;

    }

    public static ArrayList<String> getTeachersCourses(String teacher) throws SQLException, ClassNotFoundException {
        System.out.println("            "+teacher);
        String sql = "Select CourseDesc from Course where teacherID='"+teacher+"'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<String> courses = new ArrayList<>();
        while (rst.next()) {
            System.out.println(rst.getString("CourseDesc"));
            String course = rst.getString(1);
            courses.add(course);
        }
        return courses;
    }

    public static String getTeacher(String courseId) throws SQLException, ClassNotFoundException {
       String sql = "Select TeacherId from Course where CourseDesc='"+courseId+"'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        String teacher=null;
        if(rst.next()){
            teacher=TeacherController.getTeacherName(rst.getString("TeacherId"));
        }
        return teacher;
    }

    static int getRate(String CourseId) throws SQLException, ClassNotFoundException {
         String sql = "Select Rate from course where CourseId='"+CourseId+"'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        int rate=0;
        if(rst.next()){
            rate=rst.getInt("Rate");
            
        }
        return rate;
    }

  
    

}
