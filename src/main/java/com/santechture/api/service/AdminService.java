package com.santechture.api.service;

import com.santechture.api.dto.GeneralResponse;
import com.santechture.api.dto.admin.AdminDto;
import com.santechture.api.entity.Admin;
import com.santechture.api.exception.BusinessExceptions;
import com.santechture.api.repository.AdminRepository;
import com.santechture.api.validation.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import com.santechture.api.security.JwtTokenProvider ;

import java.util.Objects;

@Service
public class AdminService {


    private final AdminRepository adminRepository;

    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtTokenProvider JwtTokenProvider ;
    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

	public ResponseEntity<GeneralResponse> login(LoginRequest request) throws BusinessExceptions {
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(request.getUsername(),
				request.getPassword());
		// we let the manager do its job.
		
		authenticationManager.authenticate(token);
		
		// if there is no exception thrown from authentication manager,
		// we can generate a JWT token and give it to user.
		String jwt = JwtTokenProvider.generate(request.getUsername());
		Admin admin = adminRepository.findByUsernameIgnoreCase(request.getUsername());
		AdminDto adminDto = new AdminDto(admin);
		adminDto.setToken(jwt);
		return new GeneralResponse().response(adminDto);
	}
}
