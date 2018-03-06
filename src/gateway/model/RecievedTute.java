/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gateway.model;

/**
 *
 * @author Pesshala
 */
public class RecievedTute {
    private String admissionNumber;
    private String tuteId;
    private String Date;

    public RecievedTute() {
    }

    public RecievedTute(String admissionNumber, String tuteId, String Date) {
        this.admissionNumber = admissionNumber;
        this.tuteId = tuteId;
        this.Date = Date;
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
     * @return the tuteId
     */
    public String getTuteId() {
        return tuteId;
    }

    /**
     * @param tuteId the tuteId to set
     */
    public void setTuteId(String tuteId) {
        this.tuteId = tuteId;
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
    
    
    
}
