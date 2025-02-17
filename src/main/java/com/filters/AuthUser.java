package com.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthUser implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("Auth filter.");
		 HttpServletRequest req = (HttpServletRequest) request;
	     HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession(false);
		
		if(session != null) {
			chain.doFilter(request, response);
		} else {
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
		
	}

}
