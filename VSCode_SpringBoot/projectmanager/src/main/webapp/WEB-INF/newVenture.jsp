<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <!-- c:out ; c:forEach ; c:if -->
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
   <!-- Formatting (like dates) -->
 <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
   <!-- form:form -->
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
   <!-- for rendering errors on PUT routes -->
 <%@ page isErrorPage="true" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Ninja Page</title>
  <!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" 
      rel="stylesheet" 
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" 
      crossorigin="anonymous">

</head>
<body>
    <div class="container"> <!-- Beginning of Container -->
    
    <h1>Create a new Venture</h1>

    <br>
    <div class="container d-flex gap-3 pb-3">
        <a class="btn btn-primary" href="/dashboard">Dashboard</a>
        <a class="btn btn-primary" href="/newNinja">Make a Ninja</a>
        <a class="btn btn-primary" href="/newDojo">Make a Dojo</a>
    </div>
    <hr>
    <div class="container border shadow w-50 pt-5 pb-5 col">
        <h1 class="text-center">New Ninja Form</h1>
        <form:form class="px-5" action="/processVenture" method="post" modelAttribute="venture">
            <p class="row">
                <form:label path="title">Venture: </form:label>
                <form:errors class="alert-danger"  path="title"/>
                <form:input path="title"/>
            </p>
            <p class="row">
                <form:label path="description">Description: </form:label>
                <form:errors class="alert-danger"  path="description"/>
                <form:input path="description"/>
            </p>
            <p class="row pb-3">
                <form:label path="dueDate">Due Date</form:label>
                <form:errors class="alert-danger" path="dueDate"/>
                <form:input type="date" path="dueDate"/>
            </p>
            <%-- <div class="row pb-3">
                <form:select path="dojo">
                    <c:forEach var="dojoInList" items="${allDojos}">
                        <form:option value="${dojoInList.id}">${dojoInList.name}</form:option>
                    </c:forEach>
                </form:select>
            </div> --%>
            <input type="submit" value="Submit"/>
        </form:form>  
        </div>
			        
        
        
    </div> <!-- End of Container -->
</body>
</html>

 <%-- @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    private String title;

    @NotNull
    @NotBlank
    private String description;

    @NotNull
    @NotBlank
    private Date dueDate;

    @Column(updatable=false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;

    @OneToMany(mappedBy = "ventures")
    Set<Team> teams; --%>