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
    <div class="container m-4">
        <h1 class="text-primary">Template working!</h1>
        <p>Check Test: <c:out value="${check}"/></p>
        <p>The time is: <%= new Date() %></p>

        <h3>Send an Omikuji</h3>
        <form action='/login' method='POST'>
            <label>Pick A Number between 5 and 25:</label><br>
            <input type="number" name='num' min="5" max="25"><br>
            <label>Enter The Name Of A City:</label><br>
            <input type="text" name='city'><br>
            <label>Enter The Name Of Any Real Person:</label><br>
            <input type='text' name='person'><br>
            <label>Enter A Professional Endeavor Or Hobby:</label><br>
            <input type='text' name='hobby'><br>
            <label>Enter Any Type Of Living Thing:</label><br>
            <input type='text' name='livingThing'><br>
            <label>Say Something Nice To Someone:</label><br>
            <textarea name="niceThing" rows="4" cols="24"></textarea><br>
            <input type='submit' value='Send'>
        </form>
    </div>
</body>
</head>