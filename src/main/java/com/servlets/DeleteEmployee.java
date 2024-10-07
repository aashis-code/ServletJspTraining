package com.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.EmpDao;
import com.model.Employee;

@WebServlet(urlPatterns = "/deleteEmployee", name = "DeleteEmployee")
public class DeleteEmployee extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		int id = Integer.valueOf(req.getParameter("id"));
		
		Employee emp = EmpDao.getById(id);
		
		if(emp !=null) {
			int status = EmpDao.delete(id);
			if(status>0) {
				req.setAttribute("message", "Successfully deleted Employee.");
				req.getRequestDispatcher("Success.jsp").forward(req, resp);
			}
		} else {
			
		}
		
		
		
		
		
	}
	
	

}
