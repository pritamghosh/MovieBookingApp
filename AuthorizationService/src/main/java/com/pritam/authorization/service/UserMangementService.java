package com.pritam.authorization.service;

import javax.validation.Valid;

import org.springframework.security.core.userdetails.UserDetails;

import com.pritam.authorization.dto.UpdatePasswordRequest;
import com.pritam.authorization.dto.UserDto;

public interface UserMangementService {

	boolean updatePassword(String username, @Valid UpdatePasswordRequest request);

	UserDto updateUser(String username, @Valid UserDto request);

	boolean createUser(@Valid UserDto request);

	UserDetails loadUserById(Long userId);

}
