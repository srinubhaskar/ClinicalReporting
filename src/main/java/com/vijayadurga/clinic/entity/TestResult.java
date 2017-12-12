package com.vijayadurga.clinic.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class TestResult implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7962304103379596599L;
	@Column(unique = true)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@OneToOne
	@JoinColumn(name="resultId",nullable=false)
	private ResultType resultType;
	
	@Column
	private Float resultValue;
	@Column
	private Float resultRangeLow;
	@Column
	private Float resultRangeHigh;
	@ManyToOne
	@JoinColumn(name = "patientId", nullable = false)
	private Patient patient;
	@OneToOne
	@JoinColumn(name = "testId", nullable = false)
	private ClinicalTest clinicalTest;



	public ResultType getResultType() {
		return resultType;
	}

	public void setResultType(ResultType resultType) {
		this.resultType = resultType;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Float getResultValue() {
		return resultValue;
	}

	public void setResultValue(Float resultValue) {
		this.resultValue = resultValue;
	}

	public Float getResultRangeLow() {
		return resultRangeLow;
	}

	public void setResultRangeLow(Float resultRangeLow) {
		this.resultRangeLow = resultRangeLow;
	}

	public Float getResultRangeHigh() {
		return resultRangeHigh;
	}

	public void setResultRangeHigh(Float resultRangeHigh) {
		this.resultRangeHigh = resultRangeHigh;
	}

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
}
