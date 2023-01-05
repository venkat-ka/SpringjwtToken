package com.app.jwt.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.jwt.Dto.JWTAuthResponse;
import com.app.jwt.Dto.LoginDto;
import com.app.jwt.repo.service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	  private AuthService authService;
	  
	  public AuthController(AuthService authService) {
	        this.authService = authService;
	    }
	  
	
	 @PostMapping(value = {"/login", "/signin"})
	    public ResponseEntity<JWTAuthResponse> login(@RequestBody LoginDto loginDto){
	        String token = authService.login(loginDto);

	        JWTAuthResponse jwtAuthResponse = new JWTAuthResponse();
	        jwtAuthResponse.setAccessToken(token);

	        return ResponseEntity.ok(jwtAuthResponse);
	    }
}
