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

/**
 *
 * @author DELL
 */
public class GradeController {
    
    public static ArrayList<String[]> getGrade() throws SQLException, ClassNotFoundException{
        String sql="select GradeDesc from grade";
        Connection connection =DBConnection.getDBConnection().getConnection();
        Statement stm=connection.createStatement();
        ResultSet rst= stm.executeQuery(sql);
        ArrayList<String[]> grades=new ArrayList<>();
        while(rst.next()){
            String[] grade={rst.getString("GradeDesc")};
            grades.add(grade);
        }
     return grades;
    }
    //methana wenna ona de thamai , ewana ngrade description 1ta adala gradeID eka yawana eka 
    public static String getGradeId(String gradeDesc) throws SQLException, ClassNotFoundException{
        //System.out.println(gradeDesc);
        String sql="select GradeID from grade where GradeDesc='"+gradeDesc+"'";
        Connection connection =DBConnection.getDBConnection().getConnection();
        Statement stm=connection.createStatement();
        ResultSet rst= stm.executeQuery(sql);
        rst.next();
        String gradeID=rst.getString("GradeID");
                    
         return gradeID;
    }

    public static String getGradeDesc(String gradeId) throws SQLException, ClassNotFoundException {
        String sql="select GradeDesc from grade where GradeId='"+gradeId+"'";
        Connection connection =DBConnection.getDBConnection().getConnection();
        Statement stm=connection.createStatement();
        ResultSet rst= stm.executeQuery(sql);
        rst.next();
        String gradeDesc=rst.getString("GradeDesc");
                    
         return gradeDesc;
    }
    
}
