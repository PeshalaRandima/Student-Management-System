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
public class Course {
    private String courseID;
    private String CourseDesc;
    private String TeacherID;
    private String SubjectID;
    private String GradeID; 
    private int fee;
    private int Rate;
    private int time ;
    

    public Course() {
    }

    public Course(String courseID, String CourseDesc, String TeacherID, String SubjectID, String GradeID, int fee, int Rate, int time) {
        this.courseID = courseID;
        this.CourseDesc = CourseDesc;
        this.TeacherID = TeacherID;
        this.SubjectID = SubjectID;
        this.GradeID = GradeID;
        this.fee = fee;
        this.Rate = Rate;
        this.time = time;
    }

    
    
    
    

}