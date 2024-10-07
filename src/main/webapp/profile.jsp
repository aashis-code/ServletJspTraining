<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profile</title>
</head>
  <%@ include file="base.jsp" %>
<body>
  <%@ include file="navbar.jsp" %>
  
  <div class="mt-4">
<form class="container">
 <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">User Id</label>
    <input type="number" class="form-control" id="id" name="id" aria-describedby="emailHelp" value="${emp.getId()}">
   </div>
   
    <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Name</label>
    <input type="text" class="form-control" id="name" name="name" aria-describedby="emailHelp" value="${emp.getName()}">
   </div>

  <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Email</label>
    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" value="${emp.getEmail()}">
   </div>
   
   <div class="mb-3">
   <label for="exampleInputEmail1" class="form-label">Select Any Country</label>
   <select class="form-select" aria-label="Default select example">
  <option value="USA" ${emp.getCountry().equalsIgnoreCase("usa")?"selected":""}>USA</option>
  <option value="Australia"  ${emp.getCountry().equalsIgnoreCase("australia")?"selected":""}>Australia</option>
  <option value="Canada"  ${emp.getCountry().equalsIgnoreCase("canada")?"selected":""}>Canada</option>
  <option value="Nepal"  ${emp.getCountry().equalsIgnoreCase("nepal")?"selected":""}>Nepal</option>
   </select>
   </div>
     
  <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label" value="${emp.getPassword()}">Password</label>
    <input type="password" class="form-control" id="exampleInputPassword1">
  </div>
  
  <button type="submit" class="btn btn-primary">Save & Update</button>
</form>
</div>
</body>
</html>