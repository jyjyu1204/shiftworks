package org.shiftworks.mapper;

import org.shiftworks.domain.EmployeeVO;
import org.shiftworks.domain.UserDTO;

public interface UserMapper {
	
	public EmployeeVO read(String emp_id);
	
	public EmployeeVO userLogin(UserDTO userDTO);

}
