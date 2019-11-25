package com.pritam.authorization.dto;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import com.pritam.authorization.model.User;

import lombok.Getter;
import lombok.Setter;

/**
 * <pre>
 * <b>Description : </b>
 * CreateUserRequest.
 * 
 * &#64;version $Revision: 1 $ $Date: Dec 20, 2017 1:03:54 PM $
 * &#64;author $Author: pritam.ghosh $
 * </pre>
 */
@Setter@Getter
public class UserDto  implements OAuth2User,UserDetails,CredentialsContainer, Serializable {

	private static final long serialVersionUID = 5254441590605994962L;
	private String password;
    private String name;
    private String email;
    private String contact;
    private String role;
    private String username;
    private Map<String, Object> attributes;
    private long id;
    
    
    
    @Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Arrays.asList(new SimpleGrantedAuthority(role));
	}
    @Override
    public final String getPassword() {
    	return password;
    }
   
	@Override
    public final String getUsername() {
        return username;
    }
    public final void setUsername(String username) {
        this.username = username;
    }

	@Override
	public void eraseCredentials() {
		this.password=null;
		
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public Map<String, Object> getAttributes() {
		// TODO Auto-generated method stub
		return attributes;
	}
	public UserDto(User user) {
		super();
		this.name = user.getName();
		this.email = user.getEmail();
		this.contact = user.getContact();
	}
	
	public UserDto(User user,Map<String, Object> attributes) {
		this(user);
		this.attributes = attributes;
	}
    

	

}
