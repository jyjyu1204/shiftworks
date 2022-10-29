package org.shiftworks.mapper;

import org.shiftworks.domain.UserDTO;

public interface EmployeeMapper {
	
	public UserDTO read(String emp_id);

}
