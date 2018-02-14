package com.vijayadurga.clinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.vijayadurga.clinic.service.ClinicalTestService;
import com.vijayadurga.clinic.service.ResultTypeService;
import com.vijayadurga.clinic.vo.ClinicalTestResultNameVO;
 
@Controller 
public class TestController {
	@Autowired
	ClinicalTestService clinicaltestService; 
	@Autowired
	ResultTypeService resultTypeService;
	
	@RequestMapping(value="/test1",method={RequestMethod.GET})
	public String getTest1(Model model){
		ClinicalTestResultNameVO clnclrstnameVO=new ClinicalTestResultNameVO();
		clnclrstnameVO.setTestList(clinicaltestService.getAllTests());
		model.addAttribute("clnclrstnameVO",clnclrstnameVO);
		return "tmp";
	}
	
	@RequestMapping(value="/reporttestdetail", method={RequestMethod.GET})
    public String getTestDetail(@RequestParam("id") Integer id, Model model){
		ClinicalTestResultNameVO clnclrstnameVO=new ClinicalTestResultNameVO();
		
		clnclrstnameVO.setResultList(resultTypeService.getTestdetails(id));
		clnclrstnameVO.setTestList(clinicaltestService.getAllTests());
		model.addAttribute("clnclrstnameVO",clnclrstnameVO);		
		return "tmp"; 
	}
}  
          