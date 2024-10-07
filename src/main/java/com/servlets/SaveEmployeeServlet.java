package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.EmpDao;
import com.model.Employee;

public class SaveEmployeeServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		Employee emp = new Employee();
		
		Integer id = Integer.valueOf(req.getParameter("id"));
		String name = req.getParameter("name");
		String email = req.getParameter("email"); 
		String country = req.getParameter("country");
		String password = req.getParameter("password");
		
		emp.setId(id);
		emp.setName(name);
		emp.setEmail(email);
		emp.setCountry(country);
		emp.setPassword(password);	
		
		int save = EmpDao.save(emp);
		
		if(save>0) {
			out.print("""
					<h1>Id : </h1> %s
					<h1>Name : </h1> %s
					<h1>Email : </h1> %s
					<h1>Country : </h1> %s
					<h1>Password : </h1> %s
					""".formatted(id,name,email,country,password));
			
			
			
		} else {
			resp.sendRedirect("Contact.jsp");
		}
		
		System.out.println("Post method"+id);
		
		out.println("<a href='index.jsp'>Add New Employee</a>");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		super.doGet(req, resp);
	}
	
	
	

}
