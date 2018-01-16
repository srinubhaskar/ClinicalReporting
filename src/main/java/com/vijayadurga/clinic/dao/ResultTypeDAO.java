package com.vijayadurga.clinic.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vijayadurga.clinic.entity.ClinicalTest;
import com.vijayadurga.clinic.entity.ResultType;
@Repository
public class ResultTypeDAO extends BaseDAO<ResultType,Integer>{
	
	@Autowired
	private ClincalTestDAO clinicalTestDao;
	
	public void save(ResultType rt) {
		saveOrUpdate(rt);
	}

	public List<ResultType> findAll() {
		return findAll(ResultType.class);
	}
	
	public List<ResultType> findbyClinicalTestId(Integer id){
		Query hibernateQuery = super.getCurrentSession().createQuery(
			    "from ResultType r where r.clinicalTest=:clinicalTest")
			.setParameter( "clinicalTest", clinicalTestDao.find(ClinicalTest.class, id) );
		return hibernateQuery.getResultList();
		
	} 
}
