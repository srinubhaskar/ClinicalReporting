package com.vijayadurga.clinic.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ReportController {
private static final Logger logger = LoggerFactory.getLogger( HomeController.class);
	
	@RequestMapping(value="/createreport", method={RequestMethod.GET})
	public String showReport(){
		logger.info("in showReport");
		return "createReport";
	}

}
