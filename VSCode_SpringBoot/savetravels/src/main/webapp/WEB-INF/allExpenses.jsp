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
    <h1>Template working!</h1>
    <p>Check Test: <c:out value="${check}"/></p>
    <p>The time is: <%= new Date() %></p>

    <hr>

    <h1 class="px-5">Expense Sheet</h1>
    <hr>
    <div class="container">
        <table class="table">
            <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Expense</th>
                    <th scope="col">Vendor</th>
                    <th scope="col">Cost</th>
                </tr>
            </thead>
            <tbody>
                
                <c:forEach items="${allExpenses}" var="expense">
                <tr>
                    <th><c:out value="${expense.id}"/></th>
                    <td><a href="/expense/${expense.id}"><c:out value="${expense.expense}"/></a></td>
                    <td><c:out value="${expense.vendor}"/></td>
                    <td><c:out value="${expense.cost}"/></td>
                </tr>
                </c:forEach>
                
            </tbody>
        </table>
    </div>
    <hr>
    <p class="px-5">The time is: <%= new Date() %></p>
</body>
</head>