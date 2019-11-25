package com.pritam.authorization.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 * <pre>
 * <b>Description : </b>
 * User.
 * 
 * &#64;version $Revision: 1 $ $Date: Dec 20, 2017 11:22:12 AM $
 * &#64;author $Author: pritam.ghosh $
 * </pre>
 */
@Entity
@Data
@Table(name = "USER")
public class User {
	@Id
	@Column(name = "USER_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@NotNull
	@Column(name = "NAME")
	private String name;

	@NotNull
	@Column(name = "EMAIL", unique = true)
	private String email;

	@Column(name = "CONTACT", unique = true)
	private String contact;
	
	@Lob
	@Column(name = "IMAGE", columnDefinition = "BLOB")
	private byte[] image;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CREDENTIAL_ID")
	private Credential credential;
	

	
	@Column(name = "ROLE_TYPE", unique = true)
    @Enumerated(EnumType.STRING)
    private RoleType role;
}
