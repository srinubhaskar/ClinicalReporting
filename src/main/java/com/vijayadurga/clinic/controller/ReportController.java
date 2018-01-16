package com.vijayadurga.clinic.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vijayadurga.clinic.service.ClinicalTestService;
import com.vijayadurga.clinic.service.ResultTypeService;
import com.vijayadurga.clinic.vo.ClinicalTestNameVO;
import com.vijayadurga.clinic.vo.ClinicalTestResultNameVO;

@Controller
public class ReportController { 
private static final Logger logger = LoggerFactory.getLogger( HomeController.class);

	@Autowired
	ClinicalTestService clinicaltestService;         
	@Autowired
	ResultTypeService resultTypeService;
	
	@RequestMapping(value="/createreport", method={RequestMethod.GET})
	public String showReport(){
		logger.info("in showReport");
		return "createReport";             
	} 
	
	@RequestMapping(value="/createtest", method={RequestMethod.GET})
	public String createTest(Model model){
		ClinicalTestNameVO clinicaltestVO=new ClinicalTestNameVO();
		List<String> names= new ArrayList<String>();
		clinicaltestService.getAllTests().forEach(item->names.add(item.getTestName()));
		clinicaltestVO.setTestNameList(names);
		model.addAttribute("clinicaltestVO",clinicaltestVO);
		logger.info("in Create Test");
		return "clinicalTestName";    
	} 
	
	@RequestMapping(value="/createtestname", method={RequestMethod.POST})
	public String createTestName(ClinicalTestNameVO clinicaltestVO, Model model){
		
		clinicaltestService.createTestName(clinicaltestVO);
		List<String> names= new ArrayList<String>();
		clinicaltestService.getAllTests().forEach(item->names.add(item.getTestName()));
		clinicaltestVO.setTestNameList(names);
		model.addAttribute("clinicaltestVO",clinicaltestVO);
		return "clinicalTestName";
	}
	
	@RequestMapping(value="/createresult", method={RequestMethod.GET})
	public String createResult(Model model){
		ClinicalTestResultNameVO clnclrstnameVO=new ClinicalTestResultNameVO();
		clnclrstnameVO.setTestList(clinicaltestService.getAllTests());
		model.addAttribute("clnclrstnameVO",clnclrstnameVO);
		
		return "clinicalResultName";
	}
	
	@RequestMapping(value="/testdetail/{id}", method={RequestMethod.GET})
    public String getTestDetail(@PathVariable Integer id, Model model){
		ClinicalTestResultNameVO clnclrstnameVO=new ClinicalTestResultNameVO();
		
		clnclrstnameVO.setResultList(resultTypeService.getTestdetails(id));
		//clnclrstnameVO.setTestList(clinicaltestService.getAllTests());
		model.addAttribute("clnclrstnameVO",clnclrstnameVO);		
		return "clinicalResultName :: resList"; 
	}
	

	@RequestMapping(value="/createresultname", method={RequestMethod.POST})
	public String createResultName(ClinicalTestResultNameVO clnclrstnameVO, Model model){
		
		resultTypeService.createResultName(clnclrstnameVO);
		clnclrstnameVO.setTestList(clinicaltestService.getAllTests());
		model.addAttribute("clnclrstnameVO",clnclrstnameVO);
		return "clinicalResultName";
	}
}
