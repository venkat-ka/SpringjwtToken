package com.app.jwt.repo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.jwt.Dto.LoginDto;
import com.app.jwt.Dto.RegisterDto;
import com.app.jwt.Security.JwtTokenProvider;
import com.app.jwt.repo.UserEntity;

@Service
public class AuthServiceImpl implements AuthService {

	private AuthenticationManager authenticationManager;
	// private UserRepoImpl userRepository;
	// private RoleRepository roleRepository;
	private PasswordEncoder passwordEncoder;
	private JwtTokenProvider jwtTokenProvider;
	List<UserEntity> listOfUserEntity = new ArrayList<>(); 

	
	public AuthServiceImpl(AuthenticationManager authenticationManager, PasswordEncoder passwordEncoder,
			JwtTokenProvider jwtTokenProvider, List<UserEntity> listOfUserEntity) {
		super();
		 HashSet<String> set = new HashSet<String>();
		  set.add("ADMIN");
		this.authenticationManager = authenticationManager;
		this.passwordEncoder = passwordEncoder;
		this.jwtTokenProvider = jwtTokenProvider;
		this.listOfUserEntity = Arrays.asList(new UserEntity("ve", "use", "ee@sss.com", passwordEncoder.encode("ccc"),set),
				new UserEntity("tve", "tuse", "tee@sss.com", passwordEncoder.encode("ccc"),set));
		 
		
	}

	@Override
	public String login(LoginDto loginDto) {
		System.out.println("comingggg");
		System.out.println(loginDto.getUsernameOrEmail());
		System.out.println(passwordEncoder.encode(loginDto.getPassword())+ loginDto.getPassword());
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
				loginDto.getUsernameOrEmail(), loginDto.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		String token = jwtTokenProvider.generateToken(authentication);

		return token;
	}

	@Override
	public String register(RegisterDto registerDto) {
		// TODO Auto-generated method stub
		// add check for username exists in database

		return "User registered successfully!.";
	}

//	private AuthenticationManager authenticationManager;
//	private UserRepository userRepository;
//	private RoleRepository roleRepository;
//	private PasswordEncoder passwordEncoder;
//	private JwtTokenProvider jwtTokenProvider;
//
//	public AuthServiceImpl(AuthenticationManager authenticationManager, UserRepository userRepository,
//			RoleRepository roleRepository, PasswordEncoder passwordEncoder, JwtTokenProvider jwtTokenProvider) {
//		this.authenticationManager = authenticationManager;
//		this.userRepository = userRepository;
//		this.roleRepository = roleRepository;
//		this.passwordEncoder = passwordEncoder;
//		this.jwtTokenProvider = jwtTokenProvider;
//	}
//
//	@Override
//	public String login(LoginDto loginDto) {
//
//		Authentication authentication = authenticationManager.authenticate(
//				new UsernamePasswordAuthenticationToken(loginDto.getUsernameOrEmail(), loginDto.getPassword()));
//
//		SecurityContextHolder.getContext().setAuthentication(authentication);
//
//		String token = jwtTokenProvider.generateToken(authentication);
//
//		return token;
//	}
//
//	@Override
//	public String register(RegisterDto registerDto) {
//
//		// add check for username exists in database
//		if (userRepository.existsByUsername(registerDto.getUsername())) {
//			throw new BlogAPIException(HttpStatus.BAD_REQUEST, "Username is already exists!.");
//		}
//
//		// add check for email exists in database
//		if (userRepository.existsByEmail(registerDto.getEmail())) {
//			throw new BlogAPIException(HttpStatus.BAD_REQUEST, "Email is already exists!.");
//		}
//
//		User user = new User();
//		user.setName(registerDto.getName());
//		user.setUsername(registerDto.getUsername());
//		user.setEmail(registerDto.getEmail());
//		user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
//
//		Set<Role> roles = new HashSet<>();
//		Role userRole = roleRepository.findByName("ROLE_USER").get();
//		roles.add(userRole);
//		user.setRoles(roles);
//
//		userRepository.save(user);
//
//		return "User registered successfully!.";
//	}
}
