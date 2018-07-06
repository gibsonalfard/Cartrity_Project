/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author Gibran
 */
public class ModelUser {

    /**
     * @return the last_login
     */
    public Date getLast_login() {
        return last_login;
    }

    /**
     * @param last_login the last_login to set
     */
    public void setLast_login(Date last_login) {
        this.last_login = last_login;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
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
    public static final String FILE_NAME = "*/../src/Excel/DataTransaksi.xlsx";
    
    private String username;
    private String password;
    private Date last_login;
    private String userID;

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
}
