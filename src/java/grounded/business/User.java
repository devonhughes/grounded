/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grounded.business;

/**
 *
 * @author Primary
 */
public class User {
    
    private String userID;
    private String email;
    private String password;
    
    public User(){
        userID = "";
        email = "";
        password = "";

    }

//    public User(String userID, String password, String email){
//        userID = this.userID;
//        password = this.password;
//        email = this.email;
//    }
    /**
     * @return the userID
     */
    public String getUserID() {
        return userID;
    }

    /**
     * @param userID the userID to set
     */
    public void setUserID(String userID) {
        this.userID = userID;
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

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
}
