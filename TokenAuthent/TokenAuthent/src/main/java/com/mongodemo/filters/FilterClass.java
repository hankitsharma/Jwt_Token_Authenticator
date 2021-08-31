package com.mongodemo.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.filter.GenericFilterBean;

import com.sun.xml.bind.v2.runtime.ClassBeanInfoImpl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class FilterClass extends GenericFilterBean{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		final HttpServletRequest httpRequest = (HttpServletRequest) request;
		final HttpServletResponse httpResponse = (HttpServletResponse) response;
		final String header = httpRequest.getHeader("Authorization");
		
		if("OPTIONS".equals(httpRequest.getMethod())) {
			httpResponse.setStatus(HttpServletResponse.SC_OK);
		chain.doFilter(httpRequest, httpResponse);
		
		}else if( header == null || ! header.startsWith("Bearer ")) {
			throw new ServletException("error observer as header is null");
		}
		
		String token = header.substring(7);
		Claims claim = Jwts.parser().setSigningKey("secre").parseClaimsJws(token).getBody();
		request.setAttribute("claims", claim);
		
		chain.doFilter(httpRequest, httpResponse);
	}

}
