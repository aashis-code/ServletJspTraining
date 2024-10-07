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

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession(false);
		String email = (String)session.getAttribute("email");
	
		if(email==null) {
			req.setAttribute("message", "Please, login first to see your profile !!");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		} else {
			Employee emp = EmpDao.getByEmail(email);
			req.setAttribute("emp", emp);
			req.getRequestDispatcher("profile.jsp").forward(req, resp);
		}
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	

}
