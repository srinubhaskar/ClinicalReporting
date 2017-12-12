package com.vijayadurga.clinic.dao;

import org.springframework.stereotype.Repository;

import com.vijayadurga.clinic.entity.ClinicUser;
import com.vijayadurga.clinic.entity.Patient;

@Repository
public class PatientDAO extends BaseDAO<Patient,Integer>{
	
	public void save(Patient p) {
		saveOrUpdate(p);
	}

}
