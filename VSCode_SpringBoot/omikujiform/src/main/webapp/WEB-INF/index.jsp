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
    
    <h1 class="p-3">Template wsorking!</h1>
    <p>Check Test: <c:out value="${check}"/></p>
    <p class="text-info">The time is: <%= new Date() %></p>

    <h3>Login</h3>
    <form action='/login' method='GET'>
	    <label>Email:</label>
    	<input type="text" name='email'>
	    <label>Password:</label>
    	<input type='text' name='password'>
    	<input type='submit' value='login'>
    </form>

</body>
</head>