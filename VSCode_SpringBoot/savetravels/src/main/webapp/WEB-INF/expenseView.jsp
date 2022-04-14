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
    <h1>ExpenseView Template working!</h1>
    <p>Check Test: <c:out value="${check}"/></p>
        <hr>
        <div class = "container">
            <p>ID: <c:out value="${expenseID}"/></p>
            <p>Name: <c:out value="${expenseName}"/></p>
            <p>Vendor: <c:out value="${expenseVendor}"/></p>
            <p>Cost: <c:out value="${expenseCost}"/></p>
        </div>
        <hr>
    <p>The time is: <%= new Date() %></p>
</body>
</head>
