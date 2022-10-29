package org.shiftworks.service;

import java.util.List;

import org.shiftworks.domain.DepartmentVO;
import org.shiftworks.domain.EmployeeVO;
import org.shiftworks.domain.UserDTO;

public class UserServiceImpl implements UserService{

	@Override
	public int userLogin(UserDTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void fixEmpId(String emp_id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String searchEmpId(EmployeeVO empVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int resetEmpPw(String authNum) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public EmployeeVO userProfile(String emp_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmployeeVO userDetail(String emp_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateAccount(EmployeeVO empVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<EmployeeVO> readEmpChart() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmployeeVO searchEmployeeName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DepartmentVO searchDepartmentName(String dept_name) {
		// TODO Auto-generated method stub
		return null;
	}

}
