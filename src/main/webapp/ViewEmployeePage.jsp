<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.List"%>
<%@page import="com.model.Employee"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Employee List.</title>

</head>
<body>
  <%@ include file="navbar.jsp" %>
  
  <% List<Employee> emp = (List<Employee>)request.getAttribute("employee"); %>

  <table class="table p-2">
  <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">Name</th>
      <th scope="col">Country</th>
      <th scope="col">Email</th>
      <th scope="col">Password</th>
    </tr>
  </thead>
  <tbody>
  
   <%  for(Employee em : emp){
    	 %>
     <tr>
          <td class="table-info"><%= em.getId() %> </td>
           <td class="table-info"><%= em.getName() %> </td>
            <td class="table-info"><%= em.getEmail() %> </td>
             <td class="table-info"><%= em.getCountry()%> </td>
              <td class="table-info"><%= em.getPassword()%> </td>
               <td class="table-info"><a href="<%= application.getContextPath()%>/editEmployee?id=<%= em.getId() %>"><button type="button" class="btn btn-warning">Edit</button></a> </td>
               <td class="table-info"><a href="<%= application.getContextPath()%>/deleteEmployee?id=<%= em.getId() %>"><button type="button" class="btn btn-danger">Delete</button></a> </td>
     </tr>
    <%
       }
    %> 
  
   
</table>

</body>
</html>