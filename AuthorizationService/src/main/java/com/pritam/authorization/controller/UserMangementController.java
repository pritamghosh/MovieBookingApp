package com.pritam.authorization.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pritam.authorization.dto.UpdatePasswordRequest;
import com.pritam.authorization.dto.UserDto;
import com.pritam.authorization.service.UserMangementService;

@RestController
public class UserMangementController {

	@Autowired
	UserMangementService service;

	@GetMapping(value = "/test")
	public String test() {
		return "Success";
	}

	@GetMapping("/user/me")
    public Principal user(Principal principal) {
        return principal;
    }
	@GetMapping("/user")
	public OAuth2Authentication user(OAuth2Authentication user) {
		user.eraseCredentials();
		return user;
	}

	@GetMapping("/secured/userdetails")
	public UserDto getUser(OAuth2Authentication user) {
		user.eraseCredentials();
		return  (UserDto) user.getPrincipal();
	}

	@PutMapping("/secured/update/password")
	public boolean updatePassword(OAuth2Authentication user,@RequestBody @Valid UpdatePasswordRequest request) {
		String username = ((UserDto) user.getPrincipal()).getUsername();
		return service.updatePassword(username,request);
	}
	
	@PutMapping("/secured/update/user")
	public UserDto updateUser(OAuth2Authentication user,@RequestBody @Valid UserDto request) {
		String username = ((UserDto) user.getPrincipal()).getUsername();
		return service.updateUser(username,request);
	}
	
	@PostMapping("/create/user")
	public boolean createUser(@RequestBody @Valid UserDto request) {
		return service.createUser(request);
	}

}
