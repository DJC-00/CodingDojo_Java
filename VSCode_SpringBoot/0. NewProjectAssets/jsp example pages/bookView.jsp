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
    <h1>BookView Template working!</h1>
    <p>Check Test: <c:out value="${check}"/></p>
        <hr>
        <div class = "container">
            <p>Book ID: <c:out value="${bookID}"/></p>
            <p>Book Title: <c:out value="${bookTitle}"/></p>
            <p>Book Desc: <c:out value="${bookDesc}"/></p>
            <p>Book Lang: <c:out value="${bookLang}"/></p>
            <p>Book PageCnt: <c:out value="${bookPageCnt}"/></p>
        </div>
        <hr>
        <div class = "container">
            <c:forEach items="${allBooks}" var="book">
               <p><c:out value="${book.toString()}" /></p>
               <br> 
            </c:forEach>
            <p>test</p>
            <c:forEach items="${allBooks}" var="book">
                    <p>Book ID: <c:out value="${book.ID}"/></p>
                    <p>Book Title: <c:out value="${book.title}"/></p>
                    <p>Book Desc: <c:out value="${book.description}"/></p>
                    <p>Book Lang: <c:out value="${book.language}"/></p>
                    <p>Book PageCnt: <c:out value="${book.numberOfPages}"/></p>
                    <br>
            </c:forEach>

            <%-- <c:forEach items="${allBooks}" var="book">
                <c:forEach items="${book.keySet()}" var="key">
                    <p><c:out value="${key}" /></p> 
                </c:forEach>
            </c:forEach> --%>
            
        </div>
    <hr>
    <p>The time is: <%= new Date() %></p>
</body>
</head>
