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
    <meta charset="UTF-8" />
    <title>Title Here</title>
    <!-- Bootstrap -->
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
      crossorigin="anonymous"
    />
  </head>
  <body>
    <div class="container">
      <!-- Beginning of Container -->

      <h1>Ninjas and Dojos List</h1>

      <br />
      <div class="container d-flex gap-3 pb-3">
        <a class="btn btn-primary" href="/dashboard">Dashboard</a>
        <a class="btn btn-primary" href="/newNinja">Make a Ninja</a>
        <a class="btn btn-primary" href="/newDojo">Make a Dojo</a>
        <a class="btn btn-danger" href="/logout">Make a Dojo</a>
      </div>



      <table class="table table-dark table-striped table-hover border shadow">
        <thead>
          <tr>
            <th class="align-middle">First Name: </th>
            <th class="align-middle">Last Name:</th>
            <th class="align-middle">Age</th>
            <th class="align-middle">Dojo</th>
            <th class="align-middle">Actions</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach var="ninjaInList" items="${allNinjas}">
            <tr>
              <td>
                <a href="/oneNinja/${ninjaInList.id}">
                  <c:out value="${ninjaInList.firstName}"></c:out>
                </a>
              </td>
              <td> <c:out value="${ninjaInList.lastName}"></c:out> </td>
              <td> <c:out value="${ninjaInList.age}"></c:out></td>
              <td>
              <a href="/oneDojo/${ninjaInList.dojo.id}">
                 <c:out value="${ninjaInList.dojo.name}"></c:out> 
              </a>
              </td> 
              <td> 
                <a class="btn btn-primary" href="/oneNinja/${ninjaInList.id}/edit">Update This Ninja</a>
                <a class="btn btn-danger"  href="/delete/${ninjaInList.id}">Delete</a>
              </td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
    </div>
    <!-- End of Container -->
  </body>
</html>