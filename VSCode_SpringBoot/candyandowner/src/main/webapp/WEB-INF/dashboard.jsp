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

      <h1>Welcome to the Candy Carnivale`</h1>

      <br />
      <a href="/dashboard">Dashboard</a>
      <a href="/newCandy">New Candy</a>
      <a href="/oneCandy">One Candy</a>
      <a class="btn btn-primary"  href="/newOwner">Make an Owner</a>

      <!-- <c:forEach var="i" items="${allCands}">
        <p> <c:out value="${ i.name }" ></c:out> 
         <c:out value="${ i.brand }" ></c:out> 
         <c:out value="${ i.price }" ></c:out> 
         <c:out value="${ i.rating }" ></c:out> </p>
      </c:forEach> -->

      <table class="table table-dark table-striped table-hover">
        <thead>
          <tr>
            <th class="align-middle">Name</th>
            <th class="align-middle">Brand</th>
            <th class="align-middle">Price</th>
            <th class="align-middle">Rating</th>
            <th class="align-middle">Actions</th>
            <th class="align-middle">Owner</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach var="i" items="${allCands}">
            <tr>
              <td>
                <a href="/oneCandy/${i.id}">
                  <c:out value="${i.name}"></c:out>
                </a>
              </td>
              <td> <c:out value="${i.brand}"></c:out> </td>
              <td> $ <c:out value="${i.price}"></c:out>.00 </td>
              <td> <c:out value="${i.rating}"></c:out> </td>

              <td> 
                <a class="btn btn-primary" href="/updateCandy/${i.id}">Update This Candy</a>
                <a class="btn btn-danger"  href="/delete/${i.id}">Delete</a>
              </td>
              <td> <c:out value="${i.owner.firstName} ${i.owner.lastName}"></c:out> </td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
    </div>
    <!-- End of Container -->
  </body>
</html>