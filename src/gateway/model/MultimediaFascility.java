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
public class MultimediaFascility {
    private String id;
    private String Fascility;

    public MultimediaFascility() {
    }

    public MultimediaFascility(String id, String Fascility) {
        this.id = id;
        this.Fascility = Fascility;
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
     * @return the Fascility
     */
    public String getFascility() {
        return Fascility;
    }

    /**
     * @param Fascility the Fascility to set
     */
    public void setFascility(String Fascility) {
        this.Fascility = Fascility;
    }
    
    
}
