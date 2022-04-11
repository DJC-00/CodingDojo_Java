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
    <div class="d-flex gap-3 pb-5">
        <h4>Template working!</h4>
        <p>The time is: <%= new Date() %></p>
    </div>

    <div class="container w-50 shadow border">
        <%-- <h2><c:out value="${num}" /></h2>
        <h2><c:out value="${city}" /></h2>
        <h2><c:out value="${person}" /></h2>
        <h2><c:out value="${hobby}" /></h2>
        <h2><c:out value="${livingThing}" /></h2>
        <h2><c:out value="${niceThing}" /></h2> --%>

        <p>
            In <c:out value="${num}" /> years, you will live in <c:out value="${city}" /> with <c:out value="${person}" />
            as your roomate, selling <c:out value="${hobby}" /> for a living. The next time you see a <c:out value="${livingThing}" />
            you will have good luck. Also, <c:out value="${niceThing}" />
        </p> 
    </div>

</body>
</head>