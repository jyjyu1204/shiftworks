package org.shiftworks.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.shiftworks.domain.EmployeeVO;
import org.shiftworks.domain.UserDTO;
import org.shiftworks.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/login/*")
@Log4j
public class LoginController {
	
	private UserService user;
	
	@GetMapping("testlogin")
	public String loginGET() {
		return null;
	}
		
	@PostMapping("/testlogin")
	public String loginPOST(HttpServletRequest request, UserDTO userDTO, RedirectAttributes rttr) throws Exception{
		
		HttpSession session = request.getSession();
		EmployeeVO empVO= user.userLogin(userDTO);
		
		if(empVO == null) {
			int result = 0;
			rttr.addFlashAttribute("result", result);
			return "redirect:/testlogin";
		}
		session.setAttribute("user", empVO);
		
		return "redirect:/testmain";
	}

	
}
