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
//		//파라미터로 @AuthenticationPrincipal 어노테이션 통해서 
//		//UserDetails 인터페이스를 구현한 SecurityUser객체 속에 들어있는
//		//principal필드(인증ID)를 가져올 수 있다.
//		//@AuthenticationPrincipal UserDetailsimpl userDetails
//		
//		return null;//로그인 후 인증된 username정보가 담긴 empVO객체를
//		//"메인페이지 url"에 전달하며 넘어간다.
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
