/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gateway.controllers;

import gateway.dbconnection.DBConnection;
import gateway.libraries.CurInstance;
import gateway.model.Attendance;
import gateway.model.MonthlyPayment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author DELL
 */
public class MonthlyPaymentController {

    public static int markPayment(MonthlyPayment monthlyPayment) throws SQLException, ClassNotFoundException {

        String month = monthlyPayment.getMonth();
        int monthint = 0;

        switch (month) {
            case "January":
                monthint = 1;
                break;
            case "February":
                monthint = 2;
                break;
            case "March":
                monthint = 3;
                break;
            case "April":
                monthint = 4;
                break;
            case "May":
                monthint = 5;
                break;
            case "June":
                monthint = 6;
                break;
            case "July":
                monthint = 7;
                break;
            case "August":
                monthint = 8;
                break;
            case "September":
                monthint = 9;
                break;
            case "October":
                monthint = 10;
                break;
            case "November":
                monthint = 11;
                break;
            case "December":
                monthint = 12;
                break;
        }

        String ref = monthlyPayment.getDate();
        System.out.println("**************"+ref);
        String[] split = ref.split("-");
        int monthtoday = Integer.parseInt(split[1]);
        int yeartoday = Integer.parseInt(split[0]);

        int res;
        String registerDate = StudentController.getRegisterDate(monthlyPayment.getAdmissionNumber());
        System.out.println(registerDate);
        String[] splitregister = registerDate.split("-");
        int registerMonth = Integer.parseInt(splitregister[1]);
        int registerYear = Integer.parseInt(splitregister[0]);

//        String courseId = ClassController.getCourseIdFromClassId(attendance.getClassID());
        if (yeartoday > registerYear || (yeartoday == registerYear && monthtoday < registerMonth)) {

            if (checkLastMonthPay(monthlyPayment.getAdmissionNumber(), monthlyPayment.getCourseID(), monthint)) {
                String sql = "insert into MonthlyPayment values(?,?,?,?,?)";
                Connection connection = DBConnection.getDBConnection().getConnection();
                PreparedStatement stm = connection.prepareStatement(sql);
                stm.setObject(1, monthlyPayment.getAdmissionNumber());
                stm.setObject(2, monthlyPayment.getCourseID());
                stm.setObject(3, monthint);
                stm.setObject(4, monthlyPayment.getDate());
                stm.setObject(5, monthlyPayment.getTime());

                res = stm.executeUpdate();
            } else {
                res = 0;
            }
        } else {
            String sql = "insert into MonthlyPayment values(?,?,?,?,?)";
            Connection connection = DBConnection.getDBConnection().getConnection();
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setObject(1, monthlyPayment.getAdmissionNumber());
            stm.setObject(2, monthlyPayment.getCourseID());
            stm.setObject(3, monthint);
            stm.setObject(4, monthlyPayment.getDate());
            stm.setObject(5, monthlyPayment.getTime());

            res = stm.executeUpdate();

        }
        return res;
    }

    public static boolean checkLastMonthPay(String admissionNumber, String courseId, int month) throws SQLException, ClassNotFoundException {
        int premonth;
        if (month == 1) {
            premonth = 12;
        } else {
            premonth = month - 1;
        }
        System.out.println(admissionNumber);
        System.out.println(courseId);
        System.out.println(premonth);
        boolean paid;
        paid = true;
        String sql = "Select count(Date) from monthlypayment where admissionnumber='" + admissionNumber + "' and CourseId='" + courseId + "' and month=" + premonth;

        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        rst.next();
        int res = rst.getInt("count(Date)");
        System.out.println(res);
        if (res > 0) {
            paid = true;
        } else if (res <= 0) {
            paid = false;
        }
        return paid;

    }

    public static boolean checkThisMonthPay(String admissionNumber, String courseId, int month) throws SQLException, ClassNotFoundException {

        boolean paid;
        paid = true;
        String sql = "Select count(Date) from monthlypayment where admissionnumber='" + admissionNumber + "' and CourseId='" + courseId + "' and month=" + month;

        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        rst.next();
        int res = rst.getInt(1);
        if (res > 0) {
            paid = true;
        } else if (res <= 0) {
            paid = false;
        }
        return paid;

    }

    public static ArrayList<Object[]> todaysPayments(String teacherId, String date) throws SQLException, ClassNotFoundException {
        System.out.println(teacherId);
        String sql = "Select mp.CourseId,count(mp.month) as count,mp.Date from MonthlyPayment mp , Course c where mp.CourseId=c.CourseId and c.TeacherId='" + teacherId + "' and mp.Date='" + date + "'group by mp.CourseId";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = connection.prepareStatement(sql);
        ResultSet rst = stm.executeQuery();
        ArrayList<Object[]> rowDatas = new ArrayList<>();
        while (rst.next()) {
            System.out.println("next");

            String CourseId = rst.getString("CourseId");
            System.out.println("          " + CourseId);

            int cardCount = Integer.parseInt(rst.getString("count"));
            System.out.println("           " + cardCount);

            String[] CourseDescAndFee = CourseController.getCourseDescAndCourseFee(CourseId);
            String Course = CourseDescAndFee[0];
            System.out.println("            " + Course);

            int fee = Integer.parseInt(CourseDescAndFee[1]);
            System.out.println(fee);

            int TotalAmount = fee * cardCount;
            System.out.println("          " + TotalAmount);

            int rate = CourseController.getRate(CourseId);
            System.out.println(rate);

            int TeacherAmount = TotalAmount * rate / 100;
            System.out.println("             " + TeacherAmount);

            int instituteComission = TotalAmount - TeacherAmount;

            Object[] rowData = {Course, cardCount, TotalAmount, TeacherAmount, instituteComission};
            rowDatas.add(rowData);
        }
        return rowDatas;
    }

//    public static ArrayList<String[]> getDailyAmounts(String teacherId) throws SQLException, ClassNotFoundException {
//        String sql = "select date ,  count(month) from monthlypayment mp, course c where mp.courseid=c.courseid and teacherid='" + teacherId + "' group by date";
//        Connection connection = DBConnection.getDBConnection().getConnection();
//        PreparedStatement stm = connection.prepareStatement(sql);
//        ResultSet rst = stm.executeQuery();
//        ArrayList<Object[]> rowDatas = new ArrayList<>();
//
//        return rowDatas;
//    }
    public static boolean lastmonthstatus(Attendance attendance) throws ClassNotFoundException, SQLException, ParseException {
        boolean lastMOnthPayed;
        ArrayList<String> classIds = ClassController.getClassIds(ClassController.getCourseIdFromClassId(attendance.getClassID()));
        int lastMonthAttendanceCount = AttendanceController.getAttendanceCountOfLastMonth(attendance.getAdmissionNumber(), classIds, attendance.getDate());
        if (0 < lastMonthAttendanceCount && lastMonthAttendanceCount < 2) {
            if (MonthlyPaymentController.islastMonthPaymentDone(attendance.getAdmissionNumber(), ClassController.getCourseIdFromClassId(attendance.getClassID()), attendance.getDate())) {
                lastMOnthPayed = true;
            } else {
                lastMOnthPayed = false;
            }
        } else {
            lastMOnthPayed = true;
        }
        return lastMOnthPayed;
    }

    public static boolean payedforthismonth(Attendance attendance) throws ParseException, ClassNotFoundException, SQLException {
        boolean isPayedForThisMonth;
        String courseId = ClassController.getCourseIdFromClassId(attendance.getClassID());
        SimpleDateFormat sdfmonth = new SimpleDateFormat("MM");

        String sql = "select count(date) as payed  from MonthlyPayment where admisionNumber='" + attendance.getAdmissionNumber() + "'and courseId='" + courseId + "'and month(Date)=" + sdfmonth.parse(attendance.getDate());
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = connection.prepareStatement(sql);
        ResultSet rst = stm.executeQuery();

        int count = rst.getInt("payed");
        if (count > 0) {
            isPayedForThisMonth = true;
        } else {
            isPayedForThisMonth = false;
        }
        return isPayedForThisMonth;
    }

    private static boolean islastMonthPaymentDone(String admissionNumber, String courseIdFromClassId, String date) throws SQLException, ClassNotFoundException, ParseException {
        boolean isLastMonthPayed;
        SimpleDateFormat sdfmonth = new SimpleDateFormat("MM");
        SimpleDateFormat sdfyear = new SimpleDateFormat("YYYY");
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(sdf.parse(date));
        calendar.add(Calendar.MONTH, -1);
        String month = sdfmonth.format(calendar.getTime());
        String year = sdfyear.format(calendar.getTime());

        String sql = "select count(date) as payedDays from MonthlyPayment where AdmissionNumber='" + admissionNumber + "'and CourseId='" + courseIdFromClassId + "' and month(date)='" + month + "'and year(date)='" + year + "'";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = connection.prepareStatement(sql);
        ResultSet rst = stm.executeQuery();
        rst.next();
        int payed = rst.getInt("payedDays");
        if (payed > 0) {
            isLastMonthPayed = true;
        } else {
            isLastMonthPayed = false;
        }
        return isLastMonthPayed;
    }

    public static ArrayList<String[]> viewPreviousPayments(String teacherId) {
         == == == month || course || totalnumber of students registered || average attendance to a course    ||Totalnumber of cards ||
    }

    public static ArrayList<Object[]> showTodayPaymentsOfAllTeachers(String Date) throws SQLException, ClassNotFoundException {

        ArrayList<Object[]> coursewiseEarnings = showTodaysEarningsCourseWise(Date);
        ArrayList<Object[]> rowDatas = new ArrayList<>();

        for (Object[] objects : coursewiseEarnings) {
            Object[] asd = new Object[]{objects[1], objects[5], objects[6], objects[7]};
            if (rowDatas.isEmpty()) {
                rowDatas.add(asd);
            } else {
                Boolean updated = false;
                for (int i = 0; i < rowDatas.size(); i++) {
                    if (rowDatas.get(i)[0].toString().equals(asd[0].toString())) {
                        Object[] zxc = rowDatas.get(i);
                        zxc[1] = Integer.parseInt(String.valueOf(rowDatas.get(i)[1])) + Integer.parseInt(String.valueOf(asd[1]));
                        zxc[2] = Double.parseDouble(String.valueOf(rowDatas.get(i)[2])) + Double.parseDouble(String.valueOf(asd[2]));
                        zxc[3] = Double.parseDouble(String.valueOf(rowDatas.get(i)[3])) + Double.parseDouble(String.valueOf(asd[3]));
                        rowDatas.set(i, zxc);
                        updated = true;
                    } else {

                    }
                }
                if (updated == false) {
                    rowDatas.add(asd);
                }
            }
        }

        /*Object[] newArray= new Object[4];
         int count=0;
       
         for(Object[] coursewiseEarning:coursewiseEarnings){
         System.out.println(coursewiseEarning[0]+"   "+coursewiseEarning[1]+"   "+coursewiseEarning[2]+"   "+coursewiseEarning[3]);
         if (count==0){
         newArray[0]=coursewiseEarning[1];
         newArray[1]=0;
         newArray[2]=0;
         newArray[3]=0;
         System.out.println("..........."+newArray[0]+"   "+newArray[1]+"   "+newArray[2]+"   "+newArray[3]);
               
               
               
               
         }
         count=count+1;
           
         if(newArray[0]==coursewiseEarning[1]){
         System.out.println("*******"+coursewiseEarning[1]);
         int nowTotal=Integer.parseInt(newArray[1].toString());
         int thisTotal=Integer.parseInt(coursewiseEarning[5].toString());
         nowTotal=nowTotal+thisTotal;;
               
         double nowTeachersTotal=Double.parseDouble((newArray[2].toString()));
         double thisTeachersTotal=Double.parseDouble(String.valueOf(coursewiseEarning[6]));
         nowTeachersTotal=nowTeachersTotal+thisTeachersTotal;
               
         newArray[1]=nowTotal;
         newArray[2]=nowTeachersTotal;
         newArray[3]=nowTotal-nowTeachersTotal;
         }else{
         rowDatas.add(newArray);
         newArray[0]=coursewiseEarning[1];
         newArray[1]=coursewiseEarning[5];
         newArray[2]=coursewiseEarning[6];
         newArray[3]=coursewiseEarning[7];
                   
               
         }
         }*/
        return rowDatas;
    }

    public static ArrayList<Object[]> showTodaysEarningsCourseWise(String date) throws SQLException, ClassNotFoundException {
        String sql = "select c.CourseDesc,t.Name,c.MonthlyFee,c.Rate, count(mp.month) ,\n"
                + "(c.MonthlyFee)*(count(mp.Month)) as TotalAmount,\n"
                + "((c.MonthlyFee*count(mp.Month)*c.Rate)/100 )as TeachersAmount  ,\n"
                + "((c.MonthlyFee)*(count(mp.Month)) -((c.MonthlyFee*count(mp.Month)*c.Rate)/100 )) as InstituteComission\n"
                + "from monthlypayment mp, course c , teacher t\n"
                + "where mp.CourseID=c.CourseID and c.TeacherID=t.TeacherID and mp.Date='" + date + "'\n"
                + "group by mp.CourseID\n"
                + "order by t.Name;";

        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<Object[]> rowDatas = new ArrayList<>();
        while (rst.next()) {
            Object[] row = {rst.getString("CourseDesc"), rst.getString("Name"), rst.getInt("MonthlyFee"), rst.getInt("Rate"), rst.getInt("count(mp.month)"), rst.getInt("TotalAmount"), rst.getString("TeachersAmount"), rst.getString("InstituteComission")};
            rowDatas.add(row);
        }
        return rowDatas;

    }

    public static ArrayList<Object[]> fromToPayments(String teacherId, String date1, String date2) throws SQLException, ClassNotFoundException {
        System.out.println(teacherId);
        String sql = "Select mp.CourseId,count(mp.month) as count \n"
                + "from MonthlyPayment mp , Course c\n"
                + "where mp.CourseId=c.CourseId and c.TeacherId='"+teacherId+"' and mp.Date between'"+date1+"'and '"+date2+"'\n"
                + "group by mp.CourseId order by mp.Date ";

        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = connection.prepareStatement(sql);
        ResultSet rst = stm.executeQuery();
        ArrayList<Object[]> rowDatas = new ArrayList<>();
        while (rst.next()) {
            System.out.println("next");

            String CourseId = rst.getString("CourseId");
            System.out.println("          " + CourseId);

            int cardCount = Integer.parseInt(rst.getString("count"));
            System.out.println("           " + cardCount);

            String[] CourseDescAndFee = CourseController.getCourseDescAndCourseFee(CourseId);
            String Course = CourseDescAndFee[0];
            System.out.println("            " + Course);

            int fee = Integer.parseInt(CourseDescAndFee[1]);
            System.out.println(fee);

            int TotalAmount = fee * cardCount;
            System.out.println("          " + TotalAmount);

            int rate = CourseController.getRate(CourseId);
            System.out.println(rate);

            int TeacherAmount = TotalAmount * rate / 100;
            System.out.println("             " + TeacherAmount);

            int instituteComission = TotalAmount - TeacherAmount;

            Object[] rowData = {Course, cardCount, TotalAmount, TeacherAmount, instituteComission};
            rowDatas.add(rowData);
        }
        return rowDatas;
    }

}
