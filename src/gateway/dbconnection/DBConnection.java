/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gateway.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author DELL
 */
public class DBConnection {
    private static DBConnection dbconnection;
    private Connection connection;
    private DBConnection() throws SQLException, ClassNotFoundException{
        if (connection== null){
            Class.forName("com.mysql.jdbc.Driver");
            connection=DriverManager.getConnection("jdbc:mysql://localhost/Gateway", "root", "mysql");
        }
        
    }
    public static  DBConnection getDBConnection() throws SQLException, ClassNotFoundException{
        if(dbconnection==null){
            dbconnection=new DBConnection();
        }
        return dbconnection;
    }
    public Connection getConnection(){
        return connection;
    }
    
}
