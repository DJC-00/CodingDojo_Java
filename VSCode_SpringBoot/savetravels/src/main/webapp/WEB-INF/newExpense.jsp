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
    <div class="container text-center mb-5">
        <h1>New Expense</h1>
    </div>
    <div class="container col w-50  border shadow p-5">
        <form:form action="/expenses" method="post" modelAttribute="newExpense">
            <p class="row">
                <form:errors class="text-danger border border-danger shadow-sm mb-2 w-50" path="expense"/> <br>
                <form:label path="expense">Expense</form:label>
                <form:input path="expense"/>
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
            <input class="row text-white bg-primary"type="submit" value="Add Expense"/>
        </form:form>   
    </div>