<%@ page import="java.util.Date" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Demo JSP</title>
    </head>
<body>
    <!-- Inserting a for loop into your jsp -->
    <% for(int i = 0; i < 2; i++) { %>
        <% if(i%2 == 0){ %>
            <h1 style="color:blue"><%= i %> person</h1>
        <% } else {%>
            <h1 style="color:green"><%= i %> person</h1>
        <% } %>
    <% } %>
    <h1 style="color:red"><c:out value="${2+2}"/></h1>
    <h1 style="color:yellow"><c:out value="${fruit}"/></h1>
    <p>The time is: <%= new Date() %></p>
</body>
</html>