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
public class Multimedia {
    private String id ;
    private String Multimedia;

    public Multimedia() {
    }

    public Multimedia(String id, String Multimedia) {
        this.id = id;
        this.Multimedia = Multimedia;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the Multimedia
     */
    public String getMultimedia() {
        return Multimedia;
    }

    /**
     * @param Multimedia the Multimedia to set
     */
    public void setMultimedia(String Multimedia) {
        this.Multimedia = Multimedia;
    }
    
    
}
