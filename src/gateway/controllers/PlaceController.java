/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gateway.controllers;

import gateway.dbconnection.DBConnection;
import gateway.model.Place;
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
public class PlaceController {

    public static int addPlace(Place place) throws SQLException, ClassNotFoundException {
        String sql = "inset into place values(?,?,?,?,?,?)";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setObject(1, place.getPlaceId());
        stm.setObject(2, place.getPosition());
        stm.setObject(3, place.getCrowd());
        stm.setObject(4, place.getFurniture());
        stm.setObject(5, place.getMultimedia());
        stm.setObject(6, place.getAC());
        int res = stm.executeUpdate();
        return res;

    }

    public static ArrayList<Object[]> viewPlace() throws SQLException, ClassNotFoundException {
        String sql = "select* from place";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<Object[]> rows = new ArrayList<>();

        while (rst.next()) {

            Object[] row = {rst.getString(1), rst.getString(2), rst.getInt(3), rst.getString(4), rst.getString(5), rst.getString(6)};

            rows.add(row);
        }
        return rows;
    }

    public static ArrayList<String> filterPlace(int crowd, String furniture, String multimedia, String AC) throws SQLException, ClassNotFoundException {
        ArrayList<String> places = null;
        String sql = "select PlaceDescription from place where " + (crowd + 100) + ">MaximummCrowd>" + crowd + ",FurnitureID='" + furniture + "',MultimediaID='" + multimedia + "'AC/NonAC='" + AC + "'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);

        if (rst != null) {
            while (rst.next()) {
                String place = rst.getString(1);
                places.add(place);
            }
        } else {
            String place = "no matching places found";
            places.add(place);

        }
        return places;
    }

    public static ArrayList<String> getPlaces() throws SQLException, ClassNotFoundException {
        String sql = "Select placeDesc from Place";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<String> rows = new ArrayList<>();
        while (rst.next()) {
            System.out.println(rst.getString(1));
            String row = rst.getString(1);
            rows.add(row);

        }
        return rows;
    }

    public static String getPlaceId(String placeDesc) throws SQLException, ClassNotFoundException {
        String sql="select placeId from place where placeDesc ='" + placeDesc + "'  ";

        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        String courses=null;
        if (rst.next()) {
            courses = rst.getString("placeId");
            System.out.println(courses);
        }
        return courses;
    }

}
