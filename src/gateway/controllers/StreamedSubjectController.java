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
public class StreamedSubjectController {
    public static boolean addStreamedSubject(Subject subject,ArrayList<String> streams,Connection connection) throws SQLException{
        int size=0;
        for(String stream:streams){
            String sql="Insert int streamedsubject values(?,?)";
            PreparedStatement stm=connection.prepareStatement(sql);
            stm.setObject(1, subject.getId());
            stm.setObject(2, stream);
             int res=stm.executeUpdate();
            if(res>0){
                size+=1;
            }
        }
        boolean resp;
        if(size==streams.size()){
           resp=true;
         }else{
            resp=false;
        }
        return resp;
    }
    public static ArrayList<String> viewStreamedSubject(String stream) throws SQLException, ClassNotFoundException{
        String sql="Select subject from " ;
        Connection connection =DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        ArrayList<String[]> streamedSubjects=new ArrayList<>();
        while(rst.next()){
            String[] streamedSubject={rst.getString(1),rst.getString(2)};
            streamedSubjects.add(streamedSubject);
        }
        return new ArrayList<>();
    }
    
}
