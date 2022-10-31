package org.shiftworks.service;

import java.util.List;

import org.shiftworks.domain.DepartmentVO;
import org.shiftworks.domain.EmployeeVO;
import org.shiftworks.domain.UserDTO;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;


@Service
@AllArgsConstructor
@Log4j
public class UserServiceImpl implements UserService{

	@Override
	public EmployeeVO userLogin(UserDTO userDTO) {
		
		return null;
	}

	@Override
	public void fixEmpId(String emp_id) {
		
		
	}

	@Override
	public String searchEmpId(EmployeeVO empVO) {
		
		return null;
	}

	@Override
	public int resetEmpPw(String authNum) {
	
		return 0;
	}

	@Override
	public EmployeeVO userProfile(String emp_id) {
		
		return null;
	}

	@Override
	public EmployeeVO userDetail(String emp_id) {
		
		return null;
	}

	@Override
	public int updateAccount(EmployeeVO empVO) {
		
		return 0;
	}

	@Override
	public List<EmployeeVO> readEmpChart() {
		
		return null;
	}

	@Override
	public EmployeeVO searchEmployeeName(String name) {
		
		return null;
	}

	@Override
	public DepartmentVO searchDepartmentName(String dept_name) {
		
		return null;
	}

}
