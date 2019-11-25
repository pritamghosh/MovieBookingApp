package com.pritam.authorization.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

/**
 * <pre>
 * <b>Description : </b>
 * Credential.
 * 
 * @version $Revision: 1 $ $Date: Dec 20, 2017 11:22:26 AM $
 * @author $Author: pritam.ghosh $ 
 * </pre>
 */
@Entity
@Table(name = "CREDENTIAL")
@Data
@NamedQueries({
    @NamedQuery(name = "fetchUserByUsernameAndPassword", query = "select cred from Credential cred "
        + " WHERE cred.username = :username and cred.password = :password"),
    @NamedQuery(name = "fetchUserByUsername", query = "select cred from Credential cred "
        + " WHERE cred.username = :username")
    })
public class Credential {
    @Id
    @Column(name = "CREDENTIAL_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "USER_ID")
    private User user;

    @Column(name = "USERNAME", unique = true)
    private String username;

    @Column(name = "PASSWORD")
    private String password; 
    
    

    

}
