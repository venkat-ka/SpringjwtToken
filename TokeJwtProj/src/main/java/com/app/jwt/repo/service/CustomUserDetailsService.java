package com.app.jwt.repo.service;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.app.jwt.repo.UserEntity;
import com.app.jwt.repo.UserRepoImpl;
import com.app.jwt.repo.UserRepository;



@Service
public class CustomUserDetailsService implements UserDetailsService {

    private UserRepoImpl userRepository;

	public CustomUserDetailsService(UserRepoImpl userRepository) {
		super();
		this.userRepository = userRepository;
	}



	@Override
	public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		 UserEntity user = userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
                 .orElseThrow(() ->
                         new UsernameNotFoundException("User not found with username or email: "+ usernameOrEmail));
		
		 System.out.println(user+" mmm  "+user.getEmail() +" lkjl "+user.getRoles());
        Set<GrantedAuthority> authorities = user
                .getRoles()
                .stream()
                .map((role) -> new SimpleGrantedAuthority(role.toString())).collect(Collectors.toSet());

        return new org.springframework.security.core.userdetails.User(user.getEmail(),
                user.getPassword(),
                authorities);
	}
}
