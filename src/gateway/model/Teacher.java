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
public class Teacher {
    private String id ;
    private String registerDate;
    private String name;
    private String photo;
    private String Adress;
    private String TP;
    private String Fax;
    private String Email;
    private String School;
    private String SchoolAdress;
    private String password;

// id,date,name,photo,adress,mobile,fax,email,school,schooladress,password)
    public Teacher() {
    }

    public Teacher(String id, String registerDate, String name, String photo, String Adress, String TP, String Fax, String Email, String School, String SchoolAdress, String password) {
        this.id = id;
        this.registerDate = registerDate;
        this.name = name;
        this.photo = photo;
        this.Adress = Adress;
        this.TP = TP;
        this.Fax = Fax;
        this.Email = Email;
        this.School = School;
        this.SchoolAdress = SchoolAdress;
        this.password = password;
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
     * @return the registerDate
     */
    public String getRegisterDate() {
        return registerDate;
    }

    /**
     * @param registerDate the registerDate to set
     */
    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the photo
     */
    public String getPhoto() {
        return photo;
    }

    /**
     * @param photo the photo to set
     */
    public void setPhoto(String photo) {
        this.photo = photo;
    }

    /**
     * @return the Adress
     */
    public String getAdress() {
        return Adress;
    }

    /**
     * @param Adress the Adress to set
     */
    public void setAdress(String Adress) {
        this.Adress = Adress;
    }

    /**
     * @return the TP
     */
    public String getTP() {
        return TP;
    }

    /**
     * @param TP the TP to set
     */
    public void setTP(String TP) {
        this.TP = TP;
    }

    /**
     * @return the Fax
     */
    public String getFax() {
        return Fax;
    }

    /**
     * @param Fax the Fax to set
     */
    public void setFax(String Fax) {
        this.Fax = Fax;
    }

    /**
     * @return the Email
     */
    public String getEmail() {
        return Email;
    }

    /**
     * @param Email the Email to set
     */
    public void setEmail(String Email) {
        this.Email = Email;
    }

    /**
     * @return the School
     */
    public String getSchool() {
        return School;
    }

    /**
     * @param School the School to set
     */
    public void setSchool(String School) {
        this.School = School;
    }

    /**
     * @return the SchoolAdress
     */
    public String getSchoolAdress() {
        return SchoolAdress;
    }

    /**
     * @param SchoolAdress the SchoolAdress to set
     */
    public void setSchoolAdress(String SchoolAdress) {
        this.SchoolAdress = SchoolAdress;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

}
