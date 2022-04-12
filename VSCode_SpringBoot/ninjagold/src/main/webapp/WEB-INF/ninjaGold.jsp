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

        <div class="row mt-3 mb-5">
            <h2 class="col text-center">Adventurer <c:out value="${name}" /></h2>
            <h2 class="col text-center"> Gold: <c:out value="${gold}" /></h2>
        </div>
        <div class="row">
            <div class="col text-center border shadow mx-1">
                <h3>Farm</h3>
                <p>(Earn 10 - 20 gold)</p>
                <form action='/game/choice' method='POST' class="pb-3">
                    <input type='submit' name="action" value='Farm'>
                </form>
            </div>
            <div class="col text-center border shadow mx-1">
                <h3>Cave</h3>
                <p>(Earn 5 - 10 gold)</p>
                <form action='/game/choice' method='POST' class="pb-3">
                    <input type='submit' name="action" value='Cave'>
                </form>
            </div>
            <div class="col text-center border shadow mx-1">
                <h3>House</h3>
                <p>(Earn 2 - 5 gold)</p>
                <form action='/game/choice' method='POST' class="pb-3">
                    <input type='submit' name="action" value='House'>
                </form>
            </div>
            <div class="col text-center border shadow mx-1">
                <h3>Quest</h3>
                <p>(Gain or Lose up to 50 gold)</p>
                <form action='/game/choice' method='POST' class="pb-3">
                    <input type='submit' name="action" value='Quest'>
                </form>
            </div>
            <div class="col text-center border shadow mx-1">
                <h3>Spa</h3>
                <p>(Costs 5 gold)</p>
                <form action='/game/choice' method='POST' class="pb-3">
                    <input type='submit' name="action" value='Spa'>
                </form>
            </div>
        </div>
        <div class="row overflow-auto border shadow mt-5" style="max-width: 800px; max-height: 300px">
            <p>
                <c:forEach items="${eventLog}" var="event">
                    <c:out value="${event}" /><br><br>
                </c:forEach>
            </p>
        </div>

        
    </div>
</body>
</head>