<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NavBar</title>
</head>
  <%@ include file="base.jsp" %>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light p-3">
  <div class="container-fluid d-flex flex-row justify-content-around">
  <div>
    <a class="navbar-brand" href="#">Employee Management</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    </div>
    
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
     <div>
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="#">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="viewServlet">ViewAll</a>
        </li>
         <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="profile">Profile</a>
        </li>
       </div>
       </div>
       <!-- Login and Logout Button -->
       
       
       <div class="d-flex flex-row list-unstyled gap-4">
       </li>
         <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="register.jsp"><%= session.getAttribute("email")!=null?"Hello!! "+session.getAttribute("name"):"Register/Login" %> </a>
        </li>
        
         </li>
         <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="logOut" <%= session.getAttribute("email")==null?"hidden":"" %>>Logout</a>
        </li>
      </ul>
     </div>
     
    </div>
  </div>
</nav>
</body>
</html>