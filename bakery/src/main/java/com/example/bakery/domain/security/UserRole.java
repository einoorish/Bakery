package com.example.bakery.domain.security;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.bakery.domain.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/* 
 * intermediate table :
 * one user can have multiple roles 
 * one role can be assigned to multiple users
*/
@Entity
@Table(name="user_role")
@Getter @Setter @NoArgsConstructor
public class UserRole implements Serializable {

	private static final long serialVersionUID = 482063369158375424L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long userRoleId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Role role;
	
	public UserRole(User user, Role role) {
		this.user = user;
		this.role = role;
	}
	
}
