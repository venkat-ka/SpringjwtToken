package com.app.jwt.repo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserEntity {	  
	    private Long id;
	    private String name;
	    private String username;
	    private String email;
	    private String password;
	    private Set<String> roles = new HashSet<>();
	    
	    
	    
	    public List<String> setRoles() {
	    	return Arrays.asList("ADMIN", "USER");
	    }
	    //Cannot invoke "java.util.Set.stream()" because the return value of "com.app.jwt.repo.UserEntity.getRoles()" is null
//	    public String getRoles() {
//	    	return "ADMIN";
//	    }

		public UserEntity(String name, String username, String email, String password, Set<String> roles) {
			super();
			this.name = name;
			this.username = username;
			this.email = email;
			this.password = password;
			this.roles = roles;
		}
		public void setRoles(Set<String> roles) {
			Set<String> mstr = new HashSet<>();
			mstr.add("ADMIN");
			roles.addAll(mstr);
			this.roles = roles;
		}
		
}
