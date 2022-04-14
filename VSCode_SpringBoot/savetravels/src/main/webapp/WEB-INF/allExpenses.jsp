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

    <hr>

    <h1 class="text-center p-3">Expense Sheet</h1>
    <div class="container col  border shadow p-5">
        <table class="table table-striped ">
            <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Expense</th>
                    <th scope="col">Vendor</th>
                    <th scope="col">Cost</th>
                    <th scope="col">Actions</th>
                </tr>
            </thead>
            <tbody>
                
                <c:forEach items="${allExpenses}" var="expense">
                <tr>
                    <th><c:out value="${expense.id}"/></th>
                    <td><a href="/expense/${expense.id}"><c:out value="${expense.item}"/></a></td>
                    <td><c:out value="${expense.vendor}"/></td>
                    <td><c:out value="${expense.cost}"/></td>
                    <td class="d-flex gap-2">
                        <a class="btn btn-primary btn-sm" href="/expense/${expense.id}" role="button">view</a> 
                        <a class="btn btn-success btn-sm" href="/expense/${expense.id}/edit" role="button">edit</a>
                        <form action="/expense/${expense.id}" method="post">
                            <input type="hidden" name="_method" value="delete">
                            <input class="btn text-white bg-danger btn-sm" type="submit" value="Delete">
                            <%-- <input class="row text-white bg-primary"type="submit" value="Delete"/> --%>
                            <%-- <a class="btn btn-danger btn-sm" href="/expense/${expense.id}/delete" role="button">delete</a> --%>
                        </form>
                    </td>

                    
                </tr>
                </c:forEach>
                
            </tbody>
        </table>
    <div class="container">
    <a class="btn btn-primary" href="/expenses/new" role="button">Add Expense</a>
    </div>   
    
    </div>
    <hr>
    <p class="px-5">The time is: <%= new Date() %></p>
</body>
</head>