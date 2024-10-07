<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
</head>
  <%@ include file="base.jsp" %>
<body>
  <%@ include file="navbar.jsp" %>
  <div class="m-5">
<form class="container" action="saveServlet" method="post">

 <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Enter Id</label>
    <input type="number" class="form-control" id="id" name="id" aria-describedby="emailHelp">
    <div class="text-danger">${errors.get("id")}</div>
   </div>
   
    <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Enter Name</label>
    <input type="text" class="form-control" id="name" name="name" aria-describedby="emailHelp">
     <div class="text-danger">${errors.get("name")}</div>
   </div>

  <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Email address</label>
    <input type="email" class="form-control" id="email" name="email" aria-describedby="emailHelp">
    <div class="text-danger">${errors.get("email")}</div>
   </div>
   
   <div class="mb-3">
   <label for="exampleInputEmail1" class="form-label">Select Any Country</label>
   <select class="form-select" aria-label="Default select example">
  <option value="USA">USA</option>
  <option value="Australia">Australia</option>
  <option value="Canada">Canada</option>
  <option value="Nepal" selected>Nepal</option>
</select>
</div>
   
  <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">Password</label>
    <input type="password" class="form-control" id="exampleInputPassword1" name="password">
    <div class="text-danger">${errors.get("password")}</div>
  </div>

  <button type="submit" class="btn btn-primary">Register</button>
  <a href="login.jsp">Do you already have account?</a>
</form>
</div>
</body>
</html>