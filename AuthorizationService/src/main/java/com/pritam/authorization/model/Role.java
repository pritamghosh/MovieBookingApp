package com.pritam.authorization.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * <pre>
 * <b>Description : </b>
 * Role.
 * 
 * @version $Revision: 1 $ $Date: Dec 20, 2017 11:22:39 AM $
 * @author $Author: pritam.ghosh $ 
 * </pre>
 */
@Entity
@Data
@Table(name = "ROLE")
public class Role {
    @Id
    @Column(name = "ROLE_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "ROLE_NAME", unique = true)
    @Enumerated(EnumType.STRING)
    private RoleType role;
    
    
}
