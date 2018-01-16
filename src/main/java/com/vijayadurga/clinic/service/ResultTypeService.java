package com.vijayadurga.clinic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.vijayadurga.clinic.dao.ClincalTestDAO;
import com.vijayadurga.clinic.dao.ResultTypeDAO;
import com.vijayadurga.clinic.entity.ClinicalTest;
import com.vijayadurga.clinic.entity.ResultType;
import com.vijayadurga.clinic.vo.ClinicalTestResultNameVO;
@Service
public class ResultTypeService {

	@Autowired
	private ResultTypeDAO resultTypeDao;
	@Autowired 
	private ClincalTestDAO clinicalTestDao;
	
	@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
	public List<ResultType> getTestdetails(Integer testId) {
		return resultTypeDao.findbyClinicalTestId(testId);
	}

	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
	public void createResultName(ClinicalTestResultNameVO clnclrstnameVO) {
		ResultType rt=new ResultType();
		ClinicalTest ct=(ClinicalTest)clinicalTestDao.find(ClinicalTest.class, clnclrstnameVO.getTestId());
		rt.setResultName(clnclrstnameVO.getResultName());
		rt.setClinicalTest(ct);
		resultTypeDao.save(rt);	
	}
	
	

}
