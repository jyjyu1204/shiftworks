package org.shiftworks.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.shiftworks.domain.EmployeeVO;
import org.shiftworks.domain.UserDTO;
import org.shiftworks.service.UserService;
import org.shiftworks.service.UserServiceImpl;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/login/*")
@AllArgsConstructor
@Log4j
public class MainPageController {
	
	private UserService user;
	
//	@GetMapping
//	public String main(Model model) {
//	
//		//�Ķ���ͷ� @AuthenticationPrincipal ������̼� ���ؼ� 
//		//UserDetails �������̽��� ������ SecurityUser��ü �ӿ� ����ִ�
//		//principal�ʵ�(����ID)�� ������ �� �ִ�.
//		//@AuthenticationPrincipal UserDetailsimpl userDetails
//		
//		return null;//�α��� �� ������ username������ ��� empVO��ü��
//		//"���������� url"�� �����ϸ� �Ѿ��.
//	}

		
	@PostMapping("/main")
	public String loginPOST(HttpServletRequest request, UserDTO userDTO, RedirectAttributes rttr) throws Exception{
		
		HttpSession session = request.getSession();
		EmployeeVO empVO= user.userLogin(userDTO);
		
		if(empVO == null) {
			int result = 0;
			rttr.addFlashAttribute("result", result);
			return "redirect:/";
		}
		session.setAttribute("user", empVO);
		
		return "redirect:/main";
	}

	
}
