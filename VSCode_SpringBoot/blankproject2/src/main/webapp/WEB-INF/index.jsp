<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>Template for JSP</title>
</head>
<body>
    <h1>Template working!</h1>
    <p>Check Test: <c:out value="${check}"/></p>
    <p>The time is: <%= new Date() %></p>
</body>
</head>