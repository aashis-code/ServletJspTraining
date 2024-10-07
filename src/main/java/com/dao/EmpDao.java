package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.model.Employee;

public class EmpDao {
	
	
	static Connection getConnection() {
		
		Connection conn=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet","root","root");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return conn;
	}
	
	public static int save(Employee emp) {
		int result = 0;
		try {
			
			Connection conn = EmpDao.getConnection();
			String query = "insert into employee(id, name, country, email, password) values(?, ?, ?, ?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, emp.getId());
			pstmt.setString(2, emp.getName());
			pstmt.setString(3, emp.getCountry());
			pstmt.setString(4, emp.getEmail());
			pstmt.setString(5, emp.getPassword());
			
			result = pstmt.executeUpdate();
			conn.close();
			
		} catch (Exception e) {
			
		}
		return result;
	}
	
	
	public static List<Employee> getAllEmployee(){
		List<Employee> emp = new ArrayList<Employee>();
		
		try {
			Connection conn = EmpDao.getConnection();
			String query = "select * from employee";
			
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
			   Employee em=new Employee();
			   em.setId(rs.getInt("id"));
			   em.setName(rs.getString("name"));
			   em.setEmail(rs.getString("email"));
			   em.setCountry(rs.getString("country"));
			   em.setPassword(rs.getString("password"));
			   
			   emp.add(em);
			}
			
		} catch(Exception ex) {
			System.out.println("Exceptio occur while Getting all student list.");
			ex.printStackTrace();
		}
		return emp;
	}
	
	public static Employee getById(int id) {
		Employee em = new Employee();
		
		try {
			Connection conn = EmpDao.getConnection();
			String query = "select * from employee where id=?";
			
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				   
				   em.setId(rs.getInt("id"));
				   em.setName(rs.getString("name"));
				   em.setEmail(rs.getString("email"));
				   em.setCountry(rs.getString("country"));
				   em.setPassword(rs.getString("password"));
			}
			
		} catch (Exception e) {
			System.out.println("Exception occur while fetching single employee.");
			e.printStackTrace();
		}
		return em;
	}
	
//	Fetch Employee based on email address
	public static Employee getByEmail(String email) {
		Employee em = new Employee();
		
		try {
			Connection conn = EmpDao.getConnection();
			String query = "select * from employee where email=?";
			
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, email);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				   
				   em.setId(rs.getInt("id"));
				   em.setName(rs.getString("name"));
				   em.setEmail(rs.getString("email"));
				   em.setCountry(rs.getString("country"));
				   em.setPassword(rs.getString("password"));
			}
			
		} catch (Exception e) {
			System.out.println("Exception occur while fetching single employee By Email.");
			e.printStackTrace();
		}
		return em;
	}
	
	
	public static int update(Employee emp) {
		int status=0;
		try {
			Connection conn = EmpDao.getConnection();
			String query = "update employee set name=? ,email=? ,country=? ,password=? where id=?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, emp.getName());
			pstmt.setString(2, emp.getEmail());
			pstmt.setString(3, emp.getCountry());
			pstmt.setString(4, emp.getPassword());
			pstmt.setInt(5, emp.getId());
			
			status = pstmt.executeUpdate();
			
			
		} catch (Exception e) {	
			System.out.println("Exception occur while fetching single employee.");
			e.printStackTrace();
		}
		return status;
	}
	
	public static int delete(int id) {
		int status = 0;
		
		try {
			Connection conn = EmpDao.getConnection();
			String query = "delete from employee where id= ?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, id);
			
			status = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("Exception occur while fetching single employee.");
			e.printStackTrace();
		}
		
		return status;
	}

}
