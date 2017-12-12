package com.vijayadurga.clinic.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.vijayadurga.clinic.entity.ClinicalTest;

@Repository
public class ClincalTestDAO extends BaseDAO<ClinicalTest,Integer>{

	public void save(ClinicalTest ct) {
		saveOrUpdate(ct);
	}
	
	public List<ClinicalTest> findAll() {
		return findAll(ClinicalTest.class);
	}
}
