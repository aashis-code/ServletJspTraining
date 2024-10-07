package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.EmpDao;
import com.model.Employee;

@WebServlet(urlPatterns = "/viewServlet", name="ViewServlet")
public class ViewServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<Employee> allEmployee = EmpDao.getAllEmployee();
		req.setAttribute("employee", allEmployee);
		RequestDispatcher dispatcher = req.getRequestDispatcher("ViewEmployeePage.jsp");
		dispatcher.forward(req, resp);
		
	}
	
	

}
