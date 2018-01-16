package com.vijayadurga.clinic.vo;

import java.io.Serializable;
import java.util.List;

public class ClinicalTestNameVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 163004861837344429L;
	private String testName; 
	private List<String> testNameList;    
	

	public List<String> getTestNameList() {
		return testNameList;
	}

	public void setTestNameList(List<String> testNameList) {
		this.testNameList = testNameList;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}
	

}
