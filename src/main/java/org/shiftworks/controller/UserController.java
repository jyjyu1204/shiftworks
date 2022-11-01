package org.shiftworks.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.shiftworks.domain.EmployeeVO;
import org.shiftworks.domain.UserDTO;
import org.shiftworks.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/login/*")
@Log4j
public class UserController {
	@Autowired
	private UserService userService;
	
	
//	@GetMapping("/accessError")
//	public void  accessDenied(Authentication auth, Model model) {
//		log.info("access Denied: " + auth);
//		model.addAttribute("msg", "Access Denied");
//	}
	
	@GetMapping("/customLogin")//customLogin
	public void loginInput(String error, String logout, Model model) {
		log.info("error : "+error);
		log.info("logout : "+logout);
		
		if(error != null) {
			model.addAttribute("error", "Login Error Check Your Account");
		}
		
		if(logout != null) {
			model.addAttribute("logout", "Log out!!");
		}
	}
	
	@PostMapping("/customLogin")
	public String loginPOST(HttpServletRequest request, UserDTO userDTO, RedirectAttributes rttr) throws Exception{
		
		HttpSession session = request.getSession();
		EmployeeVO empVO= userService.userLogin(userDTO);
		
		if(empVO == null) {
			int result = 0;
			rttr.addFlashAttribute("result", result);
			return "redirect:/customLogin";
		}
		session.setAttribute("user", empVO);
		
		return "redirect:/member";
	}

	
	@GetMapping("/customLogout")
	public void logoutGET() {
		
		log.info("user log out.........."  );
	}
	

	
}
