package com.vijayadurga.clinic.vo;

import java.io.Serializable;
import java.util.List;

import com.vijayadurga.clinic.entity.ClinicalTest;
import com.vijayadurga.clinic.entity.ResultType;

public class ClinicalTestResultNameVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2190111713676062727L;
	private String resultName;
	private List<ResultType> resultList;
	private List<ClinicalTest> testList;      
	private Integer testId;      
	
	public Integer getTestId() {
		return testId;
	}
	public void setTestId(Integer testId) {
		this.testId = testId;
	}
	public List<ClinicalTest> getTestList() {
		return testList;
	}
	public void setTestList(List<ClinicalTest> testList) {
		this.testList = testList;
	}
	public String getResultName() {
		return resultName;
	}
	public void setResultName(String resultName) {
		this.resultName = resultName;
	}
	public List<ResultType> getResultList() {
		return resultList;
	}
	public void setResultList(List<ResultType> resultList) {
		this.resultList = resultList;
	}

	
	
	

}
