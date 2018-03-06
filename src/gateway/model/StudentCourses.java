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
public class StudentCourses {
    private String admissionNumber;
    private String courseid;
    private String classId;
    private String dateOfRegistry;

    public StudentCourses() {
    }

    public StudentCourses(String admissionNumber, String courseid, String classId, String dateOfRegistry) {
        this.admissionNumber = admissionNumber;
        this.courseid = courseid;
        this.classId = classId;
        this.dateOfRegistry = dateOfRegistry;
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
     * @return the courseid
     */
    public String getCourseid() {
        return courseid;
    }

    /**
     * @param courseid the courseid to set
     */
    public void setCourseid(String courseid) {
        this.courseid = courseid;
    }

    /**
     * @return the classId
     */
    public String getClassId() {
        return classId;
    }

    /**
     * @param classId the classId to set
     */
    public void setClassId(String classId) {
        this.classId = classId;
    }

    /**
     * @return the dateOfRegistry
     */
    public String getDateOfRegistry() {
        return dateOfRegistry;
    }

    /**
     * @param dateOfRegistry the dateOfRegistry to set
     */
    public void setDateOfRegistry(String dateOfRegistry) {
        this.dateOfRegistry = dateOfRegistry;
    }

    
   
}
