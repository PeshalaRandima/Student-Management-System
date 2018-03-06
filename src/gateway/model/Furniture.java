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
public class Furniture {
    private String id;
    private String furniture;

    public Furniture() {
    }

    public Furniture(String id, String furniture) {
        this.id = id;
        this.furniture = furniture;
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
     * @return the furniture
     */
    public String getFurniture() {
        return furniture;
    }

    /**
     * @param furniture the furniture to set
     */
    public void setFurniture(String furniture) {
        this.furniture = furniture;
    }
    
    
}
