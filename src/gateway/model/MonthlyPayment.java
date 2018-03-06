/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gateway.model;

/**
 *
 * @author DELL
 */
public class MonthlyPayment {
    private String admissionNumber;
    private String courseID;  
    private String month;
    private String date;
    private String time;

    public MonthlyPayment(String admissionNumber, String courseID, String month, String date, String time) {
        this.admissionNumber = admissionNumber;
        this.courseID = courseID;
        this.month = month;
        this.date = date;
        this.time = time;
    }

    public MonthlyPayment() {
    }

    /**
     * @return the admissionNumber
     */
    public String getAdmissionNumber() {
        return admissionNumber;
    }

    /**
     * @param admissionNumber the admissionNumber to set
     */
    public void setAdmissionNumber(String admissionNumber) {
        this.admissionNumber = admissionNumber;
    }

    /**
     * @return the courseID
     */
    public String getCourseID() {
        return courseID;
    }

    /**
     * @param courseID the courseID to set
     */
    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    /**
     * @return the month
     */
    public String getMonth() {
        return month;
    }

    /**
     * @param month the month to set
     */
    public void setMonth(String month) {
        this.month = month;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the time
     */
    public String getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(String time) {
        this.time = time;
    }

}