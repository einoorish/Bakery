package com.example.bakery.domain.security;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
public class Role implements Serializable{
	
	private static final long serialVersionUID = -6823203507901501146L;
	
	@Id
	private int roleId;
	
	private String name;
	
	private Set<UserRole> userRoles = new HashSet<>();
	
}
