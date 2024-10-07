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

public class IsAdminFilter  implements Filter {

	private static final String String = null;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		 HttpServletRequest req = (HttpServletRequest) request;
	     HttpServletResponse resp = (HttpServletResponse) response;
	     
		 HttpSession session = req.getSession();
		 
		 if(session != null) {
			 
			 String email = (String)session.getAttribute("email");
			 String password = (String)session.getAttribute("password");
			 
			 if(email!= null && password!=null && email.equals("admin@gmail.com") && password.equals("admin")) {
		    	 chain.doFilter(request, response);
		     } else {
		    	 req.setAttribute("message", "You need to have ADMIN authority.");
//		    	 req.getRequestDispatcher("login").forward(request, response);
		    	 resp.sendRedirect("login.jsp");
		     }
		 }   
		
	}

}
