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
    
        <h1>Editing Venture ${venture.title}</h1>
        
        <br>

        <div class="container d-flex gap-3 pb-3">
            <a class="btn btn-primary" href="/dashboard">Dashboard</a>
        </div>

        <hr>

        <div class="container border shadow w-50 pt-5 pb-5 col">
        <h4 class="text-center">Make Changes to ${ninja.firstName}  ${ninja.lastName}</h4>
            <form:form class="p-5" action="/oneVenture/${venture.id}" method="post" modelAttribute="venture">
            <input  type="hidden" name="_method" value="put"/>
                <p class="row">
                    <form:label path="title">First Name: </form:label>
                    <form:errors class="alert-danger"  path="title"/>
                    <form:input path="title"/>
                </p>
                <p class="row">
                    <form:label path="description">Last Name: </form:label>
                    <form:errors class="alert-danger"  path="description"/>
                    <form:input path="description"/>
                </p>
                <p class="row">
                    <form:label path="dueDate">Age: </form:label>
                    <form:errors class="alert-danger" path="dueDate"/>
                    <form:input type="date" path="dueDate"/>
                </p>
                <input type="submit" value="Submit"/>
            </form:form>  
        </div>
    </div> <!-- End of Container -->
</body>
</html>