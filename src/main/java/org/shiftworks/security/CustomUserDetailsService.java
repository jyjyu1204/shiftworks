package org.shiftworks.security;

import org.shiftworks.domain.EmployeeVO;
import org.shiftworks.mapper.UserMapper;
import org.shiftworks.security.domain.CustomUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import lombok.extern.log4j.Log4j;

@Log4j
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		log.warn("Load User By UserName: " + userName);
		
		EmployeeVO vo = userMapper.read(userName);
		
		log.warn("queried by user mapper"+vo);
		
		return vo == null ? null : new CustomUser(vo);
	}

}
