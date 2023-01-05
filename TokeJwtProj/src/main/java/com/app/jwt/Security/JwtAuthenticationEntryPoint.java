package com.app.jwt.Security;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
	
		@Override
		public void commence(javax.servlet.http.HttpServletRequest request,
				javax.servlet.http.HttpServletResponse response, AuthenticationException authException)
				throws IOException, javax.servlet.ServletException {
			 response.sendError(HttpServletResponse.SC_UNAUTHORIZED, authException.getMessage());
			
		}


}
