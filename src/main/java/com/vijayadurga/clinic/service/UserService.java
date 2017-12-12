package com.vijayadurga.clinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.vijayadurga.clinic.dao.UserDAO;
import com.vijayadurga.clinic.entity.ClinicUser;
import com.vijayadurga.clinic.entity.UserContact;
import com.vijayadurga.clinic.vo.UserAuthVO;


@Service
@EnableAsync(proxyTargetClass=true)
public class UserService{

	@Autowired
	private UserDAO userdao;
    @Autowired
    private PasswordEncoder passwordEncoder;

/*	@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
	public boolean authenticateUser(UserAuthVO authVo) {

		ClinicUser user = userdao.find(authVo.getUsername());
		if (authVo.getPassword() != null) {
			if (authVo.getPassword().equals(user.getPassword())){
				return true;
			}
		}
		return false;
	}*/

	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
	public void createUser(UserAuthVO authVo) {
		ClinicUser user=transformVO(authVo);
		userdao.save(user);
		
	}

	
	private ClinicUser transformVO(UserAuthVO authVo) {
		
		
		UserContact contact =new UserContact();
		contact.setAddressline1(authVo.getContact().getAddressline1());
		contact.setAddressline2(authVo.getContact().getAddressline2());
		contact.setCountry(authVo.getContact().getCountry());
		contact.setEmail(authVo.getContact().getEmail());
		contact.setPhone(authVo.getContact().getPhone());
		contact.setState(authVo.getContact().getState());
		contact.setZip(authVo.getContact().getZip());
		ClinicUser usr =new ClinicUser(authVo.getUsername(), passwordEncoder.encode(authVo.getPassword()),authVo.getFirstname(), authVo.getLastname(), authVo.getGender(),Boolean.TRUE,contact);
		
		return usr;
	}
	

}
