package com.pritam.authorization.dto;

/**
 * <pre>
 * <b>Description : </b>
 * ChanngePasswordRequest.
 * 
 * @version $Revision: 1 $ $Date: Dec 3, 2017 4:05:15 PM $
 * @author $Author: pritam.ghosh $ 
 * </pre>
 */
public class UpdatePasswordRequest {
    private String username;
    private String oldPassword;
    private String newPassword;
    public final String getUsername() {
        return username;
    }
    public final void setUsername(String username) {
        this.username = username;
    }
    public final String getOldPassword() {
        return oldPassword;
    }
    public final void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }
    public final String getNewPassword() {
        return newPassword;
    }
    public final void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
    
}
