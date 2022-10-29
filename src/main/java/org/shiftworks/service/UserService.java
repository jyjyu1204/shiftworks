package org.shiftworks.service;

import java.util.List;

import org.shiftworks.domain.DepartmentVO;
import org.shiftworks.domain.EmployeeVO;
import org.shiftworks.domain.UserDTO;

public interface UserService {
	
	public int userLogin(UserDTO dto);//�α���
	public void fixEmpId(String emp_id);//��� ����
	public String searchEmpId(EmployeeVO empVO);//���ã��->������ȣ�� �Է��ϸ� ã�°�... ���̻��ϴ� �ٽ� ���ʰ�)
	public int resetEmpPw(String authNum);//��� �缳��(�ƴϸ� ������ȣ�� �Է����� ���׳� �ʱ������� ���ư��°ɷ�)
	public EmployeeVO userProfile(String emp_id);///����������
	public EmployeeVO userDetail(String emp_id);//���� ���� ����
	public int updateAccount(EmployeeVO empVO);//�������� ����
	public List<EmployeeVO> readEmpChart();//������ ����
	public EmployeeVO searchEmployeeName(String name);//���������� �̸����� �˻�
	public DepartmentVO searchDepartmentName(String dept_name);//���������� �μ������� �˻�


}
