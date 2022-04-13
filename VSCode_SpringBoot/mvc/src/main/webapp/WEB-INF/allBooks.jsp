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
    <h1>All Books</h1>
    <hr>
        <div class = "container">
            <c:forEach items="${allBooks}" var="book">
                <p class="text-info">-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_</p>
                <p>Book ID: <c:out value="${book.ID}"/></p>
                <p>Book Title: <c:out value="${book.title}"/></p>
                <p>Book Desc: <c:out value="${book.description}"/></p>
                <p>Book Lang: <c:out value="${book.language}"/></p>
                <p>Book PageCnt: <c:out value="${book.numberOfPages}"/></p>
                
            </c:forEach>
            <p class="text-info">-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_</p>
        </div>
    <hr>
    <p>The time is: <%= new Date() %></p>
</body>
</head>
