/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trongtoan.entity;


public class UserError {
    private String userIDError ; 
    private String fullNameError ; 
    private String roldeIDError ; 
    private String passwordError ; 
    private String confirmError ; 
    private String messageError ; 
    

    public UserError() {
        this.userIDError = "";
        this.fullNameError = "";
        this.roldeIDError = "";
        this.passwordError = "";
        this.confirmError = "";
        this.messageError = "";
    }

    public UserError(String userIDError, String fullNameError, String roldeIDError, String passwordError, String confirmError , String messageError) {
        this.userIDError = userIDError;
        this.fullNameError = fullNameError;
        this.roldeIDError = roldeIDError;
        this.passwordError = passwordError;
        this.confirmError = confirmError;
        this.messageError = messageError;
    }

    public String getUserIDError() {
        return userIDError;
    }

    public void setUserIDError(String userIDError) {
        this.userIDError = userIDError;
    }

    public String getFullNameError() {
        return fullNameError;
    }

    public void setFullNameError(String fullNameError) {
        this.fullNameError = fullNameError;
    }

    public String getRoldeIDError() {
        return roldeIDError;
    }

    public void setRoldeIDError(String roldeIDError) {
        this.roldeIDError = roldeIDError;
    }

    public String getPasswordError() {
        return passwordError;
    }

    public void setPasswordError(String passwordError) {
        this.passwordError = passwordError;
    }

    public String getConfirmError() {
        return confirmError;
    }

    public void setConfirmError(String confirmError) {
        this.confirmError = confirmError;
    }

    public String getMessageError() {
        return messageError;
    }

    public void setMessageError(String messageError) {
        this.messageError = messageError;
    }
    
}
