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
    <h1 class="color-primary">Template working!</h1>
    <p>Check Test: <c:out value="${check}"/></p>
    <p>The time is: <%= new Date() %></p>
    <p class="p-5">Views: <c:out value="${viewCount}"/></p>
</body>
</head>