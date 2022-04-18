<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <!-- c:out ; c:forEach ; c:if -->
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
   <!-- Formatting (like dates) -->
 <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
   <!-- form:form -->
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
   <!-- for rendering errors on PUT routes -->
 <%@ page isErrorPage="true" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Title Here</title>
  <!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" 
      rel="stylesheet" 
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" 
      crossorigin="anonymous">

</head>
<body>
    <div class="container"> <!-- Beginning of Container -->
    
    <h1>Ninja Profile</h1>
    
    <br>
    <div class="container d-flex gap-3 pb-3">
        <a class="btn btn-primary" href="/dashboard">Dashboard</a>
        <a class="btn btn-primary" href="/newNinja">Make a Ninja</a>
        <a class="btn btn-primary" href="/newDojo">Make a Dojo</a>
    </div>
    <hr>
    

    <c:forEach items="${dojo.ninjas}" var="ninja">
        <p>Name: ${ninja.firstName} ${ninja.lastName} </p>
        <p>Age: ${ninja.age} </p>
        <p>Dojo: ${ninja.dojo.name}</p>
        <hr>
    </c:forEach>
        
    </div> <!-- End of Container -->
</body>
</html>