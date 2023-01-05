package com.app.jwt.repo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserRepoImpl implements UserRepository{
	Set<String> mn = new HashSet<String>();

	List<UserEntity> listOfUserEntity = new ArrayList<>(); 
	
	private PasswordEncoder passwordEncoder;
	
	public UserRepoImpl(Set<String> mn, List<UserEntity> listOfUserEntity, PasswordEncoder passwordEncoder) {
		super();
		  HashSet<String> set = new HashSet<String>();
		  set.add("ADMIN");
		this.mn = set;
		this.listOfUserEntity = Arrays.asList(new UserEntity("ve","use","ee@sss.com",passwordEncoder.encode("ccc"), set),
				new UserEntity("tve","tuse","tee@sss.com",passwordEncoder.encode("ccc"),set));
//				Arrays.asList(new UserEntity("ve","use","ee@sss.com","ccc"),
//				new UserEntity("tve","tuse","tee@sss.com","ccc"));
		
	}
	@Override
	public Optional<UserEntity> findByEmail(String email) {
		// TODO Auto-generated method stub
		Optional<UserEntity> usrEnty = listOfUserEntity.stream().filter(eml->eml.getEmail().equals(email)).findAny();
		return usrEnty;
	}
	@Override
	public Optional<UserEntity> findByUsernameOrEmail(String username, String email) {
		// TODO Auto-generated method stub
		return  listOfUserEntity.stream().filter(eml->eml.getEmail().equals(email)).findAny();
		
	}

	@Override
	public Optional<UserEntity> findByUsername(String username) {
		// TODO Auto-generated method stub
		return listOfUserEntity.stream().filter(eml->eml.getEmail().equals(username)).findAny();
	}

	@Override
	public Boolean existsByUsername(String username) {
		// TODO Auto-generated method stub
		return  listOfUserEntity.stream().filter(eml->eml.getUsername().equals(username)).count() > 0;
	}

	@Override
	public Boolean existsByEmail(String email) {
		// TODO Auto-generated method stub
		return   listOfUserEntity.stream().filter(eml->eml.getEmail().equals(email)).count() > 0;
	}

}
