package org.shiftworks.controller;

import java.util.List;

import org.shiftworks.domain.EmployeeVO;
import org.shiftworks.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@AllArgsConstructor
@RequestMapping("/myaccount/*")
public class MyAccountController {
	
	@Autowired
	private EmployeeService service;
	
	@Autowired
	private BCryptPasswordEncoder pwdEncoder;
	

	@GetMapping({"/get","/modify"})
	@PreAuthorize("isAuthenticated()")
	public ModelAndView get(Authentication auth) {
		UserDetails ud = (UserDetails)auth.getPrincipal();
		log.info(ud.getUsername());
		String emp_id = ud.getUsername();	
		
		EmployeeVO myInfo = service.get(emp_id);
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("myaccount/get");
		mav.addObject("employee", myInfo);
		log.info(myInfo);
		
		return mav;
		
	}
	
	
	@PostMapping("/modify")
	@PreAuthorize("isAuthenticated()")
	public String modify(EmployeeVO empVO, RedirectAttributes rttr) {
		String inputPass=empVO.getPassword();
		String pwd=pwdEncoder.encode(inputPass);
		empVO.setPassword(pwd);
		log.info("modify............my account.................");
		if(service.modifyMyAccount(empVO)) {
			rttr.addFlashAttribute("modifyResult", "success");
		}

		return "redirect:/myaccount/get";
	}
	



//	@GetMapping("/{emp_id}")
//	@PreAuthorize("isAuthenticated()")
//	public ResponseEntity<EmployeeVO> get(@PathVariable("emp_id") String emp_id)
//	{
//		log.info("get......" + emp_id);
//		return new ResponseEntity<EmployeeVO>(service.get(emp_id), HttpStatus.OK);
//	}
//	
//	@RequestMapping(method= {RequestMethod.PUT, RequestMethod.PATCH},
//			value="/{emp_id}")
//	public ResponseEntity<String> modify(@RequestBody EmployeeVO empVO,
//			@PathVariable("emp_id") String emp_id){
//		empVO.setEmp_id(emp_id);
//		log.info("ididi.............is..........."+emp_id);
//		return service.modify(empVO) ? new ResponseEntity<>("success", HttpStatus.OK)
//															: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//	}
//	public ModelAndView get(Authentication auth) {
//		UserDetails ud = (UserDetails)auth.getPrincipal();
//		log.info(ud.getUsername());
//		String emp_id = ud.getUsername();	
//		
//		EmployeeVO myInfo = service.get(emp_id);
//		ModelAndView mav = new ModelAndView();
//		
//		mav.setViewName("myaccount/get");
//		mav.addObject("employee", myInfo);
//		log.info(myInfo);
//		
//		return mav;
//		
//	}
	
//	@GetMapping("/modify/{emp_id}")
//	@PreAuthorize("isAuthenticated()")
//	public ModelAndView getModifyForm(@PathVariable("emp_id") String emp_id) {
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("myaccount/modify");
//		mav.addObject("employee", service.get(emp_id));
//		
//		return mav;
//	}
//	
//	
//	@PostMapping(value="/modify", consumes = "application/json",
//							produces = { org.springframework.http.MediaType.TEXT_PLAIN_VALUE
//	public String modify(@RequestBody EmployeeVO empVO) {
//		
//		String inputPass=empVO.getPassword();
//		String pwd=pwdEncoder.encode(inputPass);
//		empVO.setPassword(pwd);
//		log.info("modify............my account.................");
//		if(service.modifyMyAccount(empVO)) {
//			rttr.addFlashAttribute("modifyResult", "success");
//		}
//
//		return "redirect:/myaccount/get";
//	}
	

}
