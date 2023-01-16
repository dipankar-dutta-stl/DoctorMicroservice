package com.spring.microservice.doctor.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.spring.microservice.doctor.security.DoctorLoginDetails;
import com.spring.microservice.doctor.security.DoctorLoginDetailsService;

@Component
public class JwtFilter extends OncePerRequestFilter {

	@Autowired
	private JwtUtills jwtUtills;

	@Autowired
	private DoctorLoginDetailsService doctorLoginDetailsService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String auth = request.getHeader("Authorization");
		String token = null;
		String email = null;
		if (auth != null && auth.startsWith("Bearer")) {
			token = auth.substring(6);
			email = jwtUtills.getUsernameFromToken(token);
		}

		if (email != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			DoctorLoginDetails currentUser = (DoctorLoginDetails) doctorLoginDetailsService.loadUserByUsername(email);

			UsernamePasswordAuthenticationToken userAuthToken = new UsernamePasswordAuthenticationToken(currentUser,
					null, currentUser.getAuthorities());
			userAuthToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
			SecurityContextHolder.getContext().setAuthentication(userAuthToken);
		}

		filterChain.doFilter(request, response);

	}

}
