package com.filters;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class FormValidation  implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		 HttpServletRequest req = (HttpServletRequest) request;
//	     HttpServletResponse resp = (HttpServletResponse) response;
	     
	     Map<String, String> errors = new HashMap<String, String>();
	     
//	     For Id field validation
	     String id = req.getParameter("id");
	     if(id.equals("") || id == null) {
	    	 errors.put("id", "Enter valid Id.");
	     }
	     
//	     For Name validation
	     String name = req.getParameter("name");
	     boolean isEmailValid = Pattern.matches("^[A-Za-z][A-Za-z0-9!@#$%^&*?|/]{4,8}$", name);
	     if(!isEmailValid) {
	    	 errors.put("name", "Name must begin with capital letter and 5-10 characters long.");
	     }
	     
//	     For name validation
	     String email = req.getParameter("email");
	     boolean isNameValid = Pattern.matches("^[a-zA-Z0-9._%+-]{3,8}@[a-zA-Z0-9.-]{4,8}\\.[a-zA-Z]{2,}$",email);
	     if(!isNameValid) {
	    	 errors.put("email", "Enter valid email.");
	     }
	     
//	     For password validation
	     String password = req.getParameter("password");
	     boolean isPasswordValid = Pattern.matches("^[A-Z][A-Za-z0-9!@#$%^&*]{3,7}$",password);
	     if(!isPasswordValid) {
	    	 errors.put("password", "Enter password containing first letter capital of 4 to 8 characters long.");
	     }
	     
	     
	     if(errors.isEmpty()) {
	    	 chain.doFilter(request, response);
	     } else {
	    	 req.setAttribute("errors", errors);
	    	 req.getRequestDispatcher("register.jsp").forward(request, response);
	     }
		
	}

}
