package com.vijayadurga.clinic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.vijayadurga.clinic.dao.ClincalTestDAO;
import com.vijayadurga.clinic.entity.ClinicalTest;
import com.vijayadurga.clinic.vo.ClinicalTestNameVO;
@Service
public class ClinicalTestService {
	
	@Autowired
	ClincalTestDAO clinicalDao; 
	
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
	public void createTestName(ClinicalTestNameVO clinicaltestVO) {
		clinicalDao.save(transformVotoEntity(clinicaltestVO));
	}
	
	@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
	public List<ClinicalTest> getAllTests(){      
		return clinicalDao.findAll();
	}
	
	private ClinicalTest transformVotoEntity(ClinicalTestNameVO clinicaltestVO){
		ClinicalTest clinicaltest=new ClinicalTest();
		clinicaltest.setTestName(clinicaltestVO.getTestName());
		return clinicaltest;
	}
}
