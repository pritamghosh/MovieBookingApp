package com.pritam.authorization.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pritam.authorization.model.Credential;


/**
 * <pre>
 * <b>Description : </b>
 * AuthenticationMangerDao.
 * 
 * @version $Revision: 1 $ $Date: Dec 4, 2017 4:47:54 PM $
 * @author $Author: pritam.ghosh $ 
 * </pre>
 */
public interface CredentialRepository extends JpaRepository<Credential, Long> {
    List<Credential> findByUsername(String username);
}
