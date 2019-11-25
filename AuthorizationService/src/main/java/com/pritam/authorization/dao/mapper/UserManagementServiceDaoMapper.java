package com.pritam.authorization.dao.mapper;

import com.pritam.authorization.dto.UserDto;
import com.pritam.authorization.model.Credential;
import com.pritam.authorization.model.User;

/**
 * <pre>
 * <b>Description : </b>
 * UserManagementServiceDaoMapper.
 * 
 * &#64;version $Revision: 1 $ $Date: Dec 13, 2017 1:17:03 PM $
 * &#64;author $Author: pritam.ghosh $
 * </pre>
 */
public class UserManagementServiceDaoMapper {

	/**
	 * <pre>
	 * <b>Description : </b>
	 * mapUserWithCreateUserRequest.
	 * 
	 * &#64;param dto
	 * &#64;return User , null if not found.
	 * </pre>
	 */
	public static User mapUserDAOCreateDTO(UserDto dto) {
		if (dto != null) {
			User user = new User();
			user.setName(dto.getName());
			user.setContact(dto.getContact());
			user.setEmail(dto.getEmail());
			Credential credential = new Credential();
			credential.setUser(user);
			credential.setUsername(dto.getUsername());
			credential.setPassword(dto.getPassword());
			user.setCredential(credential);
			return user;
		}
		return null;
	}

	/**
	 * <pre>
	 * <b>Description : </b>
	 * mapUserDAOWithRequest.
	 * 
	 * &#64;param credential
	 * &#64;return Object , null if not found.
	 * </pre>
	 */
	public static UserDto mapUser(Credential credential) {
		if (credential != null) {
			UserDto dto = new UserDto( credential.getUser());
			dto.setUsername(credential.getUsername());
			dto.setPassword(credential.getPassword());
			return dto;
		}
		return null;
	}

}
