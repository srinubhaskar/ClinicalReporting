package com.vijayadurga.clinic.dao;

import org.springframework.stereotype.Repository;

import com.vijayadurga.clinic.entity.Patient;
import com.vijayadurga.clinic.entity.TestResult;
@Repository
public class TestResultDAO extends BaseDAO<TestResult,Integer> {

	public void save(TestResult tr) {
		saveOrUpdate(tr);
	}
}
