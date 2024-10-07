package com.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.EmpDao;
import com.model.Employee;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		Employee emp = EmpDao.getByEmail(email);
		if(emp.getPassword()!= null && emp.getPassword().equals(password)) {
			
			HttpSession session = req.getSession(true);
			session.setAttribute("email", email);
			session.setAttribute("password", password);
			session.setAttribute("name", emp.getName());
			
			req.getRequestDispatcher("").forward(req, resp);
		} else {
			System.out.println("Not valid credentials!!");
			req.setAttribute("message", "Invalid username or password !!");
			req.getRequestDispatcher("login.jsp").include(req, resp);
		}	
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("DoGet method from login servlet");
	}

	
	
}
