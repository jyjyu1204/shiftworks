package org.shiftworks.security.domain;

import java.util.Collection;

import org.shiftworks.domain.UserDTO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Getter;

@Getter
public class ShiftWorksUser extends User {

	private static final long serialVersionUID = 1L;
	
	private UserDTO user;

	public ShiftWorksUser(String username, String password, 
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
		}
	
//	public ShiftWorksUser(UserDTO dto) {
//		
//		this.user= dto;
//	}

}
