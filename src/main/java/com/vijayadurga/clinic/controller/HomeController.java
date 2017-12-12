package com.vijayadurga.clinic.controller;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.vijayadurga.clinic.service.UserDetailService;
import com.vijayadurga.clinic.service.UserService;
import com.vijayadurga.clinic.vo.UserAuthVO;

@Controller 
public class HomeController {
private static final Logger logger = LoggerFactory.getLogger( HomeController.class);

	@Autowired
	private UserDetailsService userDetailService;
	
	@Autowired
	private UserService userService;

	@RequestMapping(value="/hello", method={RequestMethod.POST, RequestMethod.GET})
	public String homePage(Model model){
		logger.info("In Home page");
		UserAuthVO authVo = new UserAuthVO();
		model.addAttribute("authVo",authVo);
		return "index";
	}
	
/*	@RequestMapping(value="authenticate",method={RequestMethod.GET,RequestMethod.POST})
	public String authenticate(UserAuthVO authVo){
		
		logger.info("Usrname::  "+authVo.getUsername());
		logger.info("Password::  "+authVo.getPassword());
		boolean success = userservice.authenticateUser(authVo);	
		if(success) {
			return "/success";
		}
		return "/hello";
	}*/
	
	@RequestMapping(value="/success", method=RequestMethod.POST)
	public ModelAndView success(ModelMap map){
		return new ModelAndView("redirect:/authSuccess", map);
	}
	
	@GetMapping("/registration")
	public String showRegistration(Model model){
		UserAuthVO authVo = new UserAuthVO();
		model.addAttribute("authVo",authVo);
		return "registration";
	} 
	
    @RequestMapping(value = "authSuccess", method = {RequestMethod.POST, RequestMethod.GET})
    public String index(Principal principal) {
        return principal != null ? "welcome" : "index";
    }
      
	@PostMapping("/register")
	public String register(UserAuthVO authVo){
		userService.createUser(authVo);
		((UserDetailService) userDetailService).signin(authVo.getUsername(), authVo.getPassword());
		System.out.println("in Registration");
		return "welcome";
	}
	
	
}
