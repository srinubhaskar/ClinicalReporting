package com.vijayadurga.clinic.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vijayadurga.clinic.dao.UserDAO;
import com.vijayadurga.clinic.entity.ClinicUser;

@Service
public class UserDetailService implements UserDetailsService{

	
	@Autowired
	private UserDAO userdao;
	
	private List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
	
	
	private Collection<? extends GrantedAuthority> getAuthorites() {
		grantedAuthorities.add(new SimpleGrantedAuthority("ADMIN"));
		grantedAuthorities.add(new SimpleGrantedAuthority("USER"));
		return grantedAuthorities;
	}
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		ClinicUser u = userdao.find(username);
		return createUser(u.getUsername(),u.getPassword());
	}
	
	private User createUser(String username, String password) {
		return new User(username, password, getAuthorites());
	}
	
	@Transactional
    public void signin(String username, String password) {
        SecurityContextHolder.getContext().setAuthentication(authenticate(username, password));
    }

    private Authentication authenticate(String username, String password) {
        return new UsernamePasswordAuthenticationToken(createUser(username, password), null, getAuthorites());
    }

	private class User extends org.springframework.security.core.userdetails.User {
		public User(String username, String password, Collection<? extends GrantedAuthority> authorities) {
			super(username, password, authorities);
		}
		private static final long serialVersionUID = -9187712637132857325L;
	}
}

