package com.pritam.authorization.service.impl;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.pritam.authorization.dao.CredentialRepository;
import com.pritam.authorization.dao.UserRepository;
import com.pritam.authorization.dao.mapper.UserManagementServiceDaoMapper;
import com.pritam.authorization.dto.UpdatePasswordRequest;
import com.pritam.authorization.dto.UserDto;
import com.pritam.authorization.exceptions.ApplicationCustomException;
import com.pritam.authorization.exceptions.BadCredentialException;
import com.pritam.authorization.exceptions.ErrorResponse;
import com.pritam.authorization.model.Credential;
import com.pritam.authorization.model.RoleType;
import com.pritam.authorization.model.User;
import com.pritam.authorization.service.UserMangementService;

@Service
public class UserMangementServiceImpl implements UserMangementService{

	@Autowired
	CredentialRepository credRepo;

	@Autowired
	UserRepository userRepo;

	@Override
	public boolean updatePassword(String username, @Valid UpdatePasswordRequest request) {
		if (request.getUsername().equalsIgnoreCase(username)) {
			List<Credential> findByUsername = credRepo.findByUsername(username);
			if (findByUsername != null) {
				for (Credential credential : findByUsername) {
					BCrypt.checkpw(request.getOldPassword(), credential.getPassword());
					if (BCrypt.checkpw(request.getOldPassword(), credential.getPassword())) {
						credential.setPassword(BCrypt.hashpw(request.getNewPassword(), BCrypt.gensalt(4)));
						credRepo.saveAndFlush(credential);
						return true;
					}
				}
			}
		}
		throw new BadCredentialException();
	}

	@Override
	public UserDto updateUser(String username, @Valid UserDto request) {
		if (request.getUsername().equalsIgnoreCase(username)) {
			List<Credential> findByUsername = credRepo.findByUsername(username);
			if (findByUsername != null) {
				for (Credential credential : findByUsername) {
					User userInDb = credential.getUser();
					if(request.getEmail()!=null) {
						userInDb.setEmail(request.getEmail());
					}
					if(request.getContact()!=null) {
						userInDb.setContact(request.getContact());
					}
					userRepo.saveAndFlush(userInDb);
				}
			}
		}
		return request;
	}

	@Override
	public boolean createUser(UserDto request) {
		List<Credential> findByUsername = credRepo.findByUsername(request.getUsername());
		if (!findByUsername.isEmpty()) {
			ErrorResponse errorResponse = new ErrorResponse("Username is not available");
			throw new ApplicationCustomException(errorResponse);
		}
		Optional<User> findByUserInfo = userRepo.findByEmail(request.getEmail());
		if (findByUserInfo.isPresent()) {
			ErrorResponse errorResponse = new ErrorResponse("Email is already registered");
			throw new ApplicationCustomException(errorResponse);
		}
		request.setPassword(BCrypt.hashpw(request.getPassword(), BCrypt.gensalt(4)));
		User user = UserManagementServiceDaoMapper.mapUserDAOCreateDTO(request);
		user.setRole(RoleType.USER);
		userRepo.saveAndFlush(user);
		return true;
	}

	@Override
	public UserDetails loadUserById(Long userId) {
		Optional<User> findById = userRepo.findById(userId);
		if (findById.isPresent()) {
			return new UserDto(findById.get());
		}
		return null;
	}

}
