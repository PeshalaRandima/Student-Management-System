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
public class Attendance {
    private String AdmissionNumber;
    private String ClassID;
    private String   Date;
    private String  ArrivalTime;

    public Attendance() {
    }

    public Attendance(String AdmissionNumber, String ClassID, String Date, String ArrivalTime) {
        this.AdmissionNumber = AdmissionNumber;
        this.ClassID = ClassID;
        this.Date = Date;
        this.ArrivalTime = ArrivalTime;
    }

    /**
     * @return the AdmissionNumber
     */
    public String getAdmissionNumber() {
        return AdmissionNumber;
    }

    /**
     * @param AdmissionNumber the AdmissionNumber to set
     */
    public void setAdmissionNumber(String AdmissionNumber) {
        this.AdmissionNumber = AdmissionNumber;
    }

    /**
     * @return the ClassID
     */
    public String getClassID() {
        return ClassID;
    }

    /**
     * @param ClassID the ClassID to set
     */
    public void setClassID(String ClassID) {
        this.ClassID = ClassID;
    }

    /**
     * @return the Date
     */
    public String getDate() {
        return Date;
    }

    /**
     * @param Date the Date to set
     */
    public void setDate(String Date) {
        this.Date = Date;
    }

    /**
     * @return the ArrivalTime
     */
    public String getArrivalTime() {
        return ArrivalTime;
    }

    /**
     * @param ArrivalTime the ArrivalTime to set
     */
    public void setArrivalTime(String ArrivalTime) {
        this.ArrivalTime = ArrivalTime;
    }

}
