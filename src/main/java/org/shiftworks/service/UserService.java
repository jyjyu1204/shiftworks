package org.shiftworks.service;

import java.util.List;

import org.shiftworks.domain.DepartmentVO;
import org.shiftworks.domain.EmployeeVO;
import org.shiftworks.domain.UserDTO;

public interface UserService {
	
	public int userLogin(UserDTO dto);//로그인
	public void fixEmpId(String emp_id);//사번 저장
	public String searchEmpId(EmployeeVO empVO);//사번찾기->인증번호를 입력하면 찾는거... 좀이상하니 다시 살필것)
	public int resetEmpPw(String authNum);//비번 재설정(아니면 인증번호를 입력했을 때그냥 초기비번으로 돌아가는걸로)
	public EmployeeVO userProfile(String emp_id);///마이프로필
	public EmployeeVO userDetail(String emp_id);//나의 계정 정보
	public int updateAccount(EmployeeVO empVO);//계정정보 수정
	public List<EmployeeVO> readEmpChart();//조직도 보기
	public EmployeeVO searchEmployeeName(String name);//조직도에서 이름으로 검색
	public DepartmentVO searchDepartmentName(String dept_name);//조직도에서 부서명으로 검색


}
