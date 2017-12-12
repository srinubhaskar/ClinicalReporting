package com.vijayadurga.clinic.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.vijayadurga.clinic.entity.ResultType;
@Repository
public class ResultTypeDAO extends BaseDAO<ResultType,Integer>{
	
	public void save(ResultType rt) {
		saveOrUpdate(rt);
	}

	public List<ResultType> findAll() {
		return findAll(ResultType.class);
	}
}
