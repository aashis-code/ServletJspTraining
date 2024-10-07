<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Success!!</title>
</head>
<body>
  <h1>You have successfully completed the request !!</h1>
  
  <h2>Message is : <%= request.getAttribute("message") %></h2>
</body>
</html>