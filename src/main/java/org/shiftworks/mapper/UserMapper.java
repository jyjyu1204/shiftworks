package org.shiftworks.mapper;

import org.shiftworks.domain.EmployeeVO;
import org.shiftworks.domain.UserDTO;

public interface UserMapper {
	
	public UserDTO read(String emp_id);
	public EmployeeVO userLogin(EmployeeVO empVO);

}
