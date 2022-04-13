<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>Template for JSP</title>
    <link rel='stylesheet' href='/webjars/bootstrap/css/bootstrap.min.css'>
</head>
<body>
    <h1 class="px-5">All Books</h1>
    <hr>
    <div class="container">
        <table class="table">
            <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Title</th>
                    <th scope="col">Lang</th>
                    <th scope="col">Pagecount</th>
                </tr>
            </thead>
            <tbody>
                
                <c:forEach items="${allBooks}" var="book">
                <tr>
                    <th><c:out value="${book.ID}"/></th>
                    <td><c:out value="${book.title}"/></td>
                    <td><c:out value="${book.language}"/></td>
                    <td><c:out value="${book.numberOfPages}"/></td>
                </tr>
                </c:forEach>
                
            </tbody>
        </table>
    </div>
    <hr>
    <p class="px-5">The time is: <%= new Date() %></p>

</body>
</head>
