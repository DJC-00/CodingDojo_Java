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
<a class="btn btn-primary" href="/expenses" role="button">Dashboard</a>
    <div class="container">
        <h1 class="p-3 text-center">Expense: <c:out value="${expenseName}"/></h1>
    </div>
    <div class="container col w-50  border shadow p-5">
        <table class="table table-striped ">
            <tbody>
                <tr>
                    <th>Name:</th>
                    <td><c:out value="${expenseName}"/></td>

                </tr>
                <tr>
                    <th>Vendor:</th>
                    <td><c:out value="${expenseVendor}"/></td>
                </tr>
                <tr>
                    <th>Cost:</th>
                    <td><c:out value="${expenseCost}"/></td>
                </tr>
                <tr>
                    <th>Created At:</th>
                    <td><c:out value="${createdAt}"/></td>
                </tr>
                <tr>
                    <th>Updated At:</th>
                    <td><c:out value="${updatedAt}"/></td>
                </tr>
            </tbody>
        </table>
    <div class="d-flex gap-3">
        <a class="btn btn-success btn-sm" href="/expense/${expenseID}/edit" role="button">edit</a>
        <form action="/expense/${expenseID}" method="post">
            <input type="hidden" name="_method" value="delete">
            <input class="btn text-white bg-danger btn-sm" type="submit" value="Delete">
            <%-- <input class="row text-white bg-primary"type="submit" value="Delete"/> --%>
            <%-- <a class="btn btn-danger btn-sm" href="/expense/${expense.id}/delete" role="button">delete</a> --%>
        </form>
    </div>
    <hr>
    <p>The time is: <%= new Date() %></p>
</body>
