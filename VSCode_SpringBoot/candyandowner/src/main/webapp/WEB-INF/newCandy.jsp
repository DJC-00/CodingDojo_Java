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
    
    <h1>What Candy WIll You Bring to the Carnivale`?</h1>
    
    <br>
    <a href="/dashboard">Dashboard</a>
    <a href="/newCandy">New Candy</a>
    <a href="/oneCandy">One Candy</a>
    <a href="/updateCandy">Update Candy</a>
    
        <h1>New Candy Form:Form </h1>
			<form:form action="/processCandy" method="post" modelAttribute="candy">
			    <p>
			        <form:label path="name">Name</form:label>
			        <form:errors class="alert-danger"  path="name"/>
			        <form:input path="name"/>
			    </p>
			    <p>
			        <form:label path="brand">Brand</form:label>
			        <form:errors class="alert-danger" path="brand"/>
			        <form:input path="brand"/>
			    </p>
			    <p>
			        <form:label path="price">Price</form:label>
			        <form:errors class="alert-danger" path="price"/>
			        <form:input type="number" path="price"/>
			    </p>
			    <p>
			        <form:label path="rating">Rating</form:label>
			        <form:errors class="alert-danger" path="rating"/>     
			        <form:input type="number" path="rating"/>
			    </p>
			    
			    <form:select path="owner">
				    <c:forEach var="i" items="${allOwners}">
				    	<form:option value="${i.id}">${i.firstName} ${i.lastName}</form:option>
				    </c:forEach>
			    </form:select>
			       
			    <input type="submit" value="Submit"/>
			</form:form>  
			        
        
        
    </div> <!-- End of Container -->
</body>
</html>