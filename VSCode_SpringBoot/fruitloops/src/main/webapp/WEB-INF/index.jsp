<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>First JSP</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
    <h1 class="ps-5">FRUIT!</h1>
<div class="container w-50 border border-2 shadow">
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Fruit</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="oneFruit" items="${fruitsFromCtrl}">
        <tr>
            <td><c:out value="${oneFruit.name}"></c:out></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</head>
