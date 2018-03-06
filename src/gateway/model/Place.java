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
public class Place {
    private String placeId;
    private String position;
    private int crowd;
    private String furniture;
    private String multimedia;
    private String AC;

    public Place() {
    }

    public Place(String placeId, String position, int crowd, String furniture, String multimedia, String AC) {
        this.placeId = placeId;
        this.position = position;
        this.crowd = crowd;
        this.furniture = furniture;
        this.multimedia = multimedia;
        this.AC = AC;
    }

    /**
     * @return the placeId
     */
    public String getPlaceId() {
        return placeId;
    }

    /**
     * @param placeId the placeId to set
     */
    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    /**
     * @return the position
     */
    public String getPosition() {
        return position;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * @return the crowd
     */
    public int getCrowd() {
        return crowd;
    }

    /**
     * @param crowd the crowd to set
     */
    public void setCrowd(int crowd) {
        this.crowd = crowd;
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

    /**
     * @return the multimedia
     */
    public String getMultimedia() {
        return multimedia;
    }

    /**
     * @param multimedia the multimedia to set
     */
    public void setMultimedia(String multimedia) {
        this.multimedia = multimedia;
    }

    /**
     * @return the AC
     */
    public String getAC() {
        return AC;
    }

    /**
     * @param AC the AC to set
     */
    public void setAC(String AC) {
        this.AC = AC;
    }
    
}
