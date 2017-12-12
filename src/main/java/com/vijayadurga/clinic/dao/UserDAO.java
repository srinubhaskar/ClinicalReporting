package com.vijayadurga.clinic.dao;

import org.hibernate.Criteria;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.vijayadurga.clinic.entity.ClinicUser;

@Repository
public class UserDAO extends BaseDAO<ClinicUser, Integer>{

	public void save(ClinicUser u) {
		saveOrUpdate(u);
	}
	 
	public ClinicUser findByid(Integer id) {
		return (ClinicUser)find(ClinicUser.class, id);
	}
	
	public ClinicUser find(String userName){
		@SuppressWarnings("rawtypes")
		Query hibernateQuery = super.getCurrentSession().createQuery(
			    "from com.vijayadurga.clinic.entity.ClinicUser u where u.username=:userName" )
			.setParameter( "userName", userName );

		 return (ClinicUser)hibernateQuery.uniqueResult();
		 
	}
}
