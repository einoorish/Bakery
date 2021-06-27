package com.example.bakery.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.bakery.domain.security.Authority;
import com.example.bakery.domain.security.UserRole;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class User implements UserDetails, Serializable{

	private static final long serialVersionUID = 3617379818701138109L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id", nullable=false, updatable=false)
	private Long id;

	private String username;
	private String password;
	private String email;
	private String firstName;
	private String lastName;
	
	private boolean enabled = true;
	
	// CascadeType.ALL will propagate (cascade) all User operations to the relating entities.
	@OneToMany(mappedBy = "user", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	// using JsonIgnore to avoid infinite loop when serializing
	// loop appears because UserRoles has user field
	@JsonIgnore
	private Set<UserRole> userRoles = new HashSet<>();
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<GrantedAuthority> authorities = new HashSet<>();
		userRoles.forEach(el -> authorities.add(new Authority(el.getRole().getName())));
		
		return authorities;
	}


	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	
}