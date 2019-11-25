package com.pritam.authorization.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pritam.authorization.model.User;

import java.lang.String;
import java.util.List;
import java.util.Optional;

/**
 * <pre>
 * <b>Description : </b>
 * UserRepository.
 * 
 * @version $Revision: 1 $ $Date: Dec 20, 2017 7:27:01 PM $
 * @author $Author: pritam.ghosh $ 
 * </pre>
 */
public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByContact(String contact);

	Optional<User> findByEmail(String email);
}
