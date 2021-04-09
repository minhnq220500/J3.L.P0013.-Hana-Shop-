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
public class UserErrorDTO {
    private String userIDError;
    private String passwordError;

    public UserErrorDTO() {
    }

    public UserErrorDTO(String userIDError) {
        this.userIDError = userIDError;
    }

    public UserErrorDTO(String userIDError, String passwordError) {
        this.userIDError = userIDError;
        this.passwordError = passwordError;
    }
    
    

    /**
     * @return the userIDError
     */
    public String getUserIDError() {
        return userIDError;
    }

    /**
     * @param userIDError the userIDError to set
     */
    public void setUserIDError(String userIDError) {
        this.userIDError = userIDError;
    }

    /**
     * @return the passwordError
     */
    public String getPasswordError() {
        return passwordError;
    }

    /**
     * @param passwordError the passwordError to set
     */
    public void setPasswordError(String passwordError) {
        this.passwordError = passwordError;
    }

    
}
