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
public class Log {
    private String clasID;
    private String date;
    private String time;
    private String content;

    public Log() {
    }

    public Log(String clasID, String date, String time, String content) {
        this.clasID = clasID;
        this.date = date;
        this.time = time;
        this.content = content;
    }

    /**
     * @return the clasID
     */
    public String getClasID() {
        return clasID;
    }

    /**
     * @param clasID the clasID to set
     */
    public void setClasID(String clasID) {
        this.clasID = clasID;
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

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }
    
    
}
