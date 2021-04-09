/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minhnq.dtos;

/**
 *
 * @author admin
 */
public class UserDTO {
    private String userID;
    private String password;
    private String name;
    private String email;
    private String roleID;

    public UserDTO() {
    }

    public UserDTO(String userID, String password, String name, String email, String roleID) {
        this.userID = userID;
        this.password = password;
        this.name = name;
        this.email = email;
        this.roleID = roleID;
    }

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

    /**
     * @return the roleID
     */
    public String getRoleID() {
        return roleID;
    }

    /**
     * @param roleID the roleID to set
     */
    public void setRoleID(String roleID) {
        this.roleID = roleID;
    }
    
    
}
