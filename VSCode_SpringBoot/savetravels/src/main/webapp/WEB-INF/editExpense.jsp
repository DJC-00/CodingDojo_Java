<!-- additional tags to add -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
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
    

    <div class="container">
    <a class="btn btn-primary" href="/expenses" role="button">Dashboard</a>
    </div>     
    <div class="container text-center mb-5">
        <h1>Edit Expense</h1>
    </div>
    <div class="container col w-50  border shadow p-5">
        <form:form action="/expense/${expense.id}" method="post" modelAttribute="expense">
        <input type="hidden" name="_method" value="put">
            <p class="row">
                <form:errors class="text-danger border border-danger shadow-sm mb-2 w-50" path="item"/> <br>
                <form:label path="item">Expense</form:label>
                <form:input path="item"/>
            </p>
            <p class="row">
                <form:errors class="text-danger border border-danger shadow-sm mb-2 w-50" path="vendor"/><br>
                <form:label path="vendor">Vendor</form:label>
                <form:input path="vendor"/>
            </p>
            <p class="row">
                <form:errors class="text-danger border border-danger shadow-sm mb-2 w-50" path="cost"/><br>
                <form:label path="cost">Cost</form:label>
                <form:input type="number" step="0.01" path="cost"/>
            </p> 
            <input class="row text-white bg-primary"type="submit" value="Submit Changes"/>
        </form:form>   
    </div>
</body>