package com.vijayadurga.clinic.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ResultType {

	@Column(unique=true)
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(unique=true,nullable=false)
	private String resultName;
	@ManyToOne
	@JoinColumn(name = "clinicalTestId", nullable = false)
	private ClinicalTest clinicalTest; 

	public ClinicalTest getClinicalTest() {
		return clinicalTest;
	}
	public void setClinicalTest(ClinicalTest clinicalTest) {
		this.clinicalTest = clinicalTest;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getResultName() {
		return resultName;
	}
	public void setResultName(String resultName) {
		this.resultName = resultName;
	}
	
}
