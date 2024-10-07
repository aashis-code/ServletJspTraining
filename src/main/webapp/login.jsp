<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
  <%@ include file="base.jsp" %>
<body>
  <%@ include file="navbar.jsp" %>
  
<div class="container">
<h3 class="text-danger">${message}</h3>
<form action="login" method="post">
  <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Email address</label>
    <input type="email" class="form-control" id="exampleInputEmail1" name="email" aria-describedby="emailHelp">
     </div>
  <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">Password</label>
    <input type="password" class="form-control" name="password" id="exampleInputPassword1">
  </div>
  
  <button type="submit" class="btn btn-primary">Submit</button>
</form>
</div>
</body>
</html>