package com.pritam.idm.service.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pritam.idm.dao.UserRepository;
import com.pritam.idm.dto.UserDto;
import com.pritam.idm.model.User;

/**
 * <pre>
 * <b>Description : </b>
 * AuthenticationService.
 * 
 * &#64;version $Revision: 1 $ $Date: Dec 4, 2017 4:17:36 PM $
 * &#64;author $Author: pritam.ghosh $
 * </pre>
 */
@Service
@Transactional
public class AuthenticationService implements UserDetailsService {

	private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationService.class);

	@Autowired
	UserRepository userRepo;

	/**
	 * <pre>
	 * <b>Description : </b> loadUserByUsername.
	 * 
	 * @param arg0
	 * @return
	 * @throws UsernameNotFoundException AuthenticationService , null if not found
	 */
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<User> findByEmail = userRepo.findByEmail(email);
		if (findByEmail.isPresent()) {

			return new UserDto(findByEmail.get());
		}
		LOGGER.warn("no user forn with username : " + email);
		throw new UsernameNotFoundException("no user forn with username : " + email);
	}

	public UserDetails loadUserById(Long userId) {
		Optional<User> user = userRepo.findById(userId);
		if (user.isPresent()) {
			return new UserDto(user.get());
		}
		LOGGER.warn("no user forn with userId : " + userId);
		throw new UsernameNotFoundException("no user forn with userId : " + userId);
	}

}
