package com.pritam.authorization.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pritam.authorization.model.Role;

/**
 * <pre>
 * <b>Description : </b>
 * RolesRepository.
 * 
 * @version $Revision: 1 $ $Date: Dec 20, 2017 1:07:42 PM $
 * @author $Author: pritam.ghosh $ 
 * </pre>
 */
public interface RoleRepository extends JpaRepository<Role, Integer> {
    List<Role> findByRole(String role);
}
