package com.santechture.api.security;

import java.util.ArrayList;

import com.santechture.api.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.santechture.api.repository.AdminRepository;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private AdminRepository adminRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		  Admin admin = adminRepository.findByUsernameIgnoreCase(username);
		if (admin == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(admin.getUsername(),
				admin.getPassword(), new ArrayList<>());
	}
}
