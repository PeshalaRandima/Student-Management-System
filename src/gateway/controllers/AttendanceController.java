/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gateway.controllers;

import gateway.dbconnection.DBConnection;
import gateway.model.Attendance;
import gateway.model.ClassDone;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author DELL
 */
public class AttendanceController {

    public static int markAttendance(Attendance attendance) throws SQLException, ClassNotFoundException {
        System.out.println(attendance.getDate());
        String ref = attendance.getDate();
        String[] split = ref.split("/");
        int monthint = Integer.parseInt(split[1]);
        int yearint = Integer.parseInt(split[0]);

        String registerDate = StudentController.getRegisterDate(attendance.getAdmissionNumber());
        System.out.println(registerDate);
        String[] splitregister = registerDate.split("-");
        int registerMonth = Integer.parseInt(splitregister[1]);
        int registerYear = Integer.parseInt(splitregister[0]);

        int payedlevel;
        int res;
        String courseId = ClassController.getCourseIdFromClassId(attendance.getClassID());
        if (yearint > registerYear || (yearint == registerYear && monthint < registerMonth)) {

            if (MonthlyPaymentController.checkThisMonthPay(attendance.getAdmissionNumber(), courseId, monthint)) {
                SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
                ClassDone classDone = new ClassDone(attendance.getClassID(), sdf.format(new Date()));
                ClassDoneController.markclass(classDone);
                attendance(attendance);
                res = 2;

            } else if (MonthlyPaymentController.checkLastMonthPay(attendance.getAdmissionNumber(), courseId, monthint)) {
                res = 1;
            } else {
                res = 0;
            }
        } else {
            if (MonthlyPaymentController.checkThisMonthPay(attendance.getAdmissionNumber(), courseId, monthint)) {
                SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
                ClassDone classDone = new ClassDone(attendance.getClassID(), sdf.format(new Date()));
                ClassDoneController.markclass(classDone);
                attendance(attendance);
                res = 2;
            } else {
                res = 1;
            }

        }

        return res;
    }

    public static void attendance(Attendance attendance) throws SQLException, ClassNotFoundException {
        String sql = "insert into Attendance values(?,?,?,?)";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setObject(1, attendance.getAdmissionNumber());
        stm.setObject(2, attendance.getClassID());
        stm.setObject(3, attendance.getDate());
        stm.setObject(4, attendance.getArrivalTime());

        int added = stm.executeUpdate();
    }

    static int getAttendanceCountOfLastMonth(String admissionNumber, ArrayList<String> classIds, String date) throws SQLException, ClassNotFoundException, ParseException {
        System.out.println("*************"+date);
        SimpleDateFormat sdf= new SimpleDateFormat("YYYY-MM-dd");
        String year=date.substring(0, 4);
        int intyear=Integer.parseInt(year);
        String month=date.substring(5, 7);
        int intmonth=Integer.parseInt(month);
        System.out.println(year+" "+month);
        int lastYear;
        int lastMonth;
        if(intmonth==1){
            lastYear=intyear-1;
            lastMonth=12;
        }else{
            lastYear=intyear;
            lastMonth=intmonth-1;
        }
       
       
        int totalCountOfAttendance = 0;

        for (String classId : classIds) {
            String sql = "select count(Date)as attendedDays from Attendance where AdmissionNumber='" + admissionNumber + "' and ClassId='" + classId + "' and month(Date)='" +lastMonth +"' and year(Date)='" + lastYear+ "'";
            Connection connection = DBConnection.getDBConnection().getConnection();
            Statement stm = connection.createStatement();
            ResultSet rst = stm.executeQuery(sql);
            rst.next();
            int count = rst.getInt("attendedDays");
            totalCountOfAttendance = totalCountOfAttendance + count;
        }
        return totalCountOfAttendance;
    }

    public static ArrayList<Object[]> getAttendedListToClasInAMonth(String classId, int selectedyear, int selectedMonth) throws SQLException, ClassNotFoundException {
        System.out.println(classId);
        String sql = "select a.AdmissionNumber ,s.Name ,count(a.Date) as  count\n"
                + "from attendance a , student s\n"
                + "where a.AdmissionNumber=s.AdmisionNumber and month(a.Date)="+selectedMonth+" and year(a.date)="+selectedyear+" and a.ClassID='"+classId+"'\n"
                + "group by a.AdmissionNumber";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<Object[]> rowDatas = new ArrayList<>();
        while (rst.next()) {
            System.out.println("    -----------------------     available");
            Object[] row = {rst.getString("AdmissionNumber"), rst.getString("Name"),rst.getInt("count")};
            rowDatas.add(row);
        }

        System.out.println(rowDatas);
        return rowDatas;
    }

}
