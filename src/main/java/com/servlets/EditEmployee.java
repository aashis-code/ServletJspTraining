package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.EmpDao;
import com.model.Employee;

@WebServlet(urlPatterns = "/editEmployee", name = "EditEmployeeServlet")
public class EditEmployee extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		int id = Integer.valueOf(req.getParameter("id"));
		
		Employee emp = EmpDao.getById(id);
	
		out.print(emp.getCountry());
		
		  out.print("<html>");
          out.print("<head><title>Form Example</title></head>");
          out.print("<body>");
          out.print("<h1>Registration Form</h1>");
          out.print("<form action='editEmployee' method='post'>");
          
          out.print("<input type='text' hidden name='id'value='"+emp.getId()+"' required /><br/><br/>");
          out.print("Name: <input type='text' name='name' value='"+emp.getName()+"' required /><br/><br/>");
          out.print("Email: <input type='email' name='email' value='"+emp.getEmail()+"' required /><br/><br/>");
          
          out.print("Country: <select name='country' required>");
          out.print("<option value=''>Select your country</option>");
          out.print("<option value='USA' "+(emp.getCountry().equalsIgnoreCase("usa")?"selected":"")+">USA</option>");
          out.print("<option value='Canada' "+(emp.getCountry().equalsIgnoreCase("canada")?"selected":"")+">Canada</option>");
          out.print("<option value='UK' "+(emp.getCountry().equalsIgnoreCase("uk")?"selected":"")+">UK</option>");
          out.print("<option value='Australia' "+(emp.getCountry().equalsIgnoreCase("australia")?"selected":"")+">Australia</option>");
          out.print("<option value='Nepal' "+(emp.getCountry().equalsIgnoreCase("nepal")?"selected":"")+">Nepal</option>");
          out.print("</select><br/><br/>");
          
          out.print("Password: <input type='password' name='password' value="+emp.getPassword()+" /><br/><br/>");
          
          out.print("<input type='submit' value='Save&Update' />");
          out.print("</form>");
          out.print("</body>");
          out.print("</html>");
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	   
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		Integer id = Integer.valueOf(req.getParameter("id"));
		String name = req.getParameter("name");
		String email = req.getParameter("email"); 
		String country = req.getParameter("country");
		String password = req.getParameter("password");
		
		Employee emp = new Employee();
		emp.setId(id);
		emp.setName(name);
		emp.setEmail(email);
		emp.setCountry(country);
		emp.setPassword(password);
		
		int update = EmpDao.update(emp);
		
		if(update>0) {
			out.print("Successfully updated data to database.");
			req.getRequestDispatcher("Success.jsp").include(req, resp);
		} else {
			out.print("Some error happen, Please try again!!");
			req.getRequestDispatcher("editEmployee?id="+id).include(req, resp);
		}		
	}
	
	

}
