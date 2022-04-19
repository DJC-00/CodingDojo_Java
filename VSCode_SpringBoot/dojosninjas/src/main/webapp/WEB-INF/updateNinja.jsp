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
    
        <h1>What Changes Would You Like to Make to This ninja?</h1>
        
        <br>

        <div class="container d-flex gap-3 pb-3">
            <a class="btn btn-primary" href="/dashboard">Dashboard</a>
            <a class="btn btn-primary" href="/newNinja">Make a Ninja</a>
            <a class="btn btn-primary" href="/newDojo">Make a Dojo</a>
        </div>

        <hr>

        <div class="container border shadow w-50 pt-5 pb-5 col">
        <h4 class="text-center">Make Changes to ${ninja.firstName}  ${ninja.lastName}</h4>
            <form:form class="p-5" action="/oneNinja/${ninja.id}" method="post" modelAttribute="ninja">
            <input  type="hidden" name="_method" value="put"/>
                <p class="row">
                    <form:label path="firstName">First Name: </form:label>
                    <form:errors class="alert-danger"  path="firstName"/>
                    <form:input path="firstName"/>
                </p>
                <p class="row">
                    <form:label path="lastName">Last Name: </form:label>
                    <form:errors class="alert-danger"  path="lastName"/>
                    <form:input path="lastName"/>
                </p>
                <p class="row">
                    <form:label path="age">Age: </form:label>
                    <form:errors class="alert-danger" path="age"/>
                    <form:input type="number" path="age"/>
                </p>
                <div class="row pb-3">
                    <form:label path="dojo">Dojo: </form:label>
                    <form:select path="dojo">
                        <c:forEach var="dojoInList" items="${allDojos}">
                            <c:choose>
                                <c:when test="${ninja.dojo.id == dojoInList.id}">
                                    <form:option value="${dojoInList.id}" selected="true">${dojoInList.name}</form:option>
                                </c:when>
                                <c:otherwise>
                                    <form:option value="${dojoInList.id}">${dojoInList.name}</form:option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </form:select>
                </div>
                <input type="submit" value="Submit"/>
            </form:form>  
        </div>
    </div> <!-- End of Container -->
</body>
</ht