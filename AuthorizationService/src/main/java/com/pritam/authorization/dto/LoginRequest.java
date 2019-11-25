package com.pritam.authorization.dto;

import javax.validation.constraints.NotEmpty;

/**
 * <pre>
 * <b>Description : </b>
 * LoginRequest.
 * 
 * @version $Revision: 1 $ $Date: Dec 3, 2017 4:01:57 PM $
 * @author $Author: pritam.ghosh $ 
 * </pre>
 */
public class LoginRequest {
	
	@NotEmpty
    private String username;
	
	@NotEmpty
    private String password;
    

    public final String getUsername() {
        return username;
    }

    public final void setUsername(String username) {
        this.username = username;
    }

    public final String getPassword() {
        return password;
    }

    public final void setPassword(String password) {
        this.password = password;
    }
}
