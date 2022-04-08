<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>First JSP</title>
</head>
<body>
    <h1>FRUIT!</h1>
    <c:forEach var="oneFruit" items="${fruitsFromCtrl}">
        <p><c:out value="${oneFruit.name}"></c:out></p>
    </c:forEach>

</body>
</head>
