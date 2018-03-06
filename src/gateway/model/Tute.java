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
public class Tute {
    private String tuteId;
    private String courseId;
    private String TuteDesc;
    private String dateofissue;

    public Tute() {
    }

    public Tute(String tuteId, String courseId, String TuteDesc, String dateofissue) {
        this.tuteId = tuteId;
        this.courseId = courseId;
        this.TuteDesc = TuteDesc;
        this.dateofissue = dateofissue;
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
     * @return the courseId
     */
    public String getCourseId() {
        return courseId;
    }

    /**
     * @param courseId the courseId to set
     */
    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    /**
     * @return the TuteDesc
     */
    public String getTuteDesc() {
        return TuteDesc;
    }

    /**
     * @param TuteDesc the TuteDesc to set
     */
    public void setTuteDesc(String TuteDesc) {
        this.TuteDesc = TuteDesc;
    }

    /**
     * @return the dateofissue
     */
    public String getDateofissue() {
        return dateofissue;
    }

    /**
     * @param dateofissue the dateofissue to set
     */
    public void setDateofissue(String dateofissue) {
        this.dateofissue = dateofissue;
    }
    
    
}
