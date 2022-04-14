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
        <h1>New Book</h1>
    </div>
    <div class="container col w-50  border shadow p-5">
        <form:form action="/books" method="post" modelAttribute="newBook">
            <p class="row">
                <form:errors class="text-danger border border-danger shadow-sm mb-2 w-50" path="title"/> <br>
                <form:label path="title">Title</form:label>
                <form:input path="title"/>
            </p>
            <p class="row">
                <form:errors class="text-danger border border-danger shadow-sm mb-2 w-50" path="description"/><br>
                <form:label path="description">Description</form:label>
                <form:textarea path="description"/>
            </p>
            <p class="row">
                <form:errors class="text-danger border border-danger shadow-sm mb-2 w-50" path="language"/><br>
                <form:label path="language">Language</form:label>
                <form:input path="language"/>
            </p>
            <p class="row">
                <form:errors  class="text-danger border border-danger shadow-sm mb-2 w-50" path="numberOfPages"/><br>
                <form:label path="numberOfPages">Pages</form:label>
                <form:input type="number" path="numberOfPages"/>
            </p>    
            <input class="row text-white bg-primary"type="submit" value="Create Book"/>
        </form:form>   
    </div>