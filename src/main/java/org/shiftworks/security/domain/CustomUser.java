package org.shiftworks.security.domain;

import java.util.Collection;
import java.util.stream.Collectors;

import org.shiftworks.domain.EmployeeVO;
import org.shiftworks.domain.UserDTO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Getter;

@Getter
public class CustomUser extends User {

	private static final long serialVersionUID = 1L;
	
	private EmployeeVO empVO;

	public CustomUser(String username, String password, 
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
		}
	
	public CustomUser(EmployeeVO vo) {
		
		super(vo.getEmp_id(), vo.getPassword(), vo.getAuthList()
				.stream().map(authority -> new SimpleGrantedAuthority(authority.getAuthority()))
				.collect(Collectors.toList()));
		
		this.empVO = vo;
	}

}
