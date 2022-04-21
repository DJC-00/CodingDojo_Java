<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!-- c:out ; c:forEach ; c:if -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Formatting (like dates) -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8" />
	<title>Title Here</title>
	<!-- Bootstrap -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
		rel="stylesheet"
		integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
		crossorigin="anonymous" />
</head>

<body>
	<div class="container">
		<!-- Beginning of Container -->

		<h1>All Projects</h1>

		<br />
		<div class="container d-flex gap-3 pb-3">
			<a class="btn btn-primary" href="/dashboard">Dashboard</a>
			<a class="btn btn-primary" href="/newVenture">Make a Venture</a>
			<a class="btn btn-primary" href="/newTeam">Make a Team</a>
			<a class="btn btn-danger" href="/logout">Logout</a>
		</div>



		<table class="table table-dark table-striped table-hover border shadow">
			<thead>
				<tr>
					<th class="align-middle">ID: </th>
					<th class="align-middle">Venture: </th>
					<th class="align-middle">Team Lead: </th>
					<th class="align-middle">Due Date</th>
					<th class="align-middle">Actions</th>
				</tr>
			</thead>
			<tbody>
				<%-- <c:forEach var="ventureInList" items="${allVentures}">
					<tr>
						<td>
							<a href="/oneVenture/${ventureInList.id}">
								<c:out value="${ventureInList.title}"></c:out>
							</a>
						</td>
						<td>
							<c:out value="${ventureInList.team.teamLead}"></c:out>
							<br>
							<c:out value="${ventureInList.team.name}"></c:out>
						</td>
						<td>
							<c:out value="${ventureInList.dueDate}"></c:out>
						</td>
						<td>
							<a href="/oneTeam/${ventureInList.team.id}">
								<c:out value="${ventureInList.team.name}"></c:out>
							</a>
						</td>
						<td>
							<a class="btn btn-primary"
								href="/oneVenture/${ventureInList.id}/edit">Update This Venture</a>
							<a class="btn btn-danger" href="/delete/${ventureInList.id}">Delete</a>
						</td>
					</tr>
					</c:forEach> --%>
					<c:forEach var="ventureInList" items="${allVentures}">
						<tr>
							<td>
								<c:out value="${ventureInList.user.id}"></c:out>
							</td>
							<td>
								<a href="/oneVenture/${ventureInList.id}">
									<c:out value="${ventureInList.title}"></c:out>
								</a>
							</td>
							<td>
								<c:out value="${ventureInList.user.firstName}"></c:out>
							</td>
							<td>
								<c:out value="${ventureInList.dueDate}"></c:out>
							</td>
							<%-- <td>
								<a href="/oneTeam/${ventureInList.team.id}">
									<c:out value="${ventureInList.team.name}"></c:out>
								</a>
								</td> --%>
							<td>
								<a class="btn btn-primary"
									href="/oneVenture/${ventureInList.id}/edit">Update</a>
								<a class="btn btn-danger"
									href="/delete/${ventureInList.id}">Delete</a>
							</td>
						</tr>
					</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="container pt-5">
		<!-- Beginning of Container -->
<%-- \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\ --%>
		<h1>My Projects</h1>


		<table class="table table-dark table-striped table-hover border shadow">
			<thead>
				<tr>
					<th class="align-middle">Venture</th>
					<th class="align-middle">Team Lead</th>
					<th class="align-middle">Due Date</th>
					<th class="align-middle">Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="teamInList" items="${userTeams}">
					<%-- <c:if test="${teamInList.users.id == currentUser.id}"> --%>

						<tr>
							<%-- <td>
								<c:out value="${teamInList.users.id}"></c:out>
							</td> --%>
							<%-- <td>
								<c:out value="${teamInList.users.firstName}"></c:out>
							</td> --%>
							<td>
								<c:out value="${teamInList.ventures.title}"></c:out>
							</td>
							<td>
								<c:out value="${teamInList.ventures.user.firstName}"></c:out>
							</td>
							<td>
								<c:out value="${teamInList.ventures.dueDate}"></c:out>
							</td>

							<%-- <td>
								<a href="/oneTeam/${ventureInList.team.id}">
									<c:out value="${ventureInList.team.name}"></c:out>
								</a>
								</td> --%>
							<td>
							<c:choose>
								<c:when test="${teamInList.ventures.user.id == user_id}">
									<a class="btn btn-primary" href="/oneVenture/${teamInList.ventures.id}/edit">Update</a>
									<a class="btn btn-danger" href="/team/delete/${teamInList.id}">Delete</a>
								</c:when>
							
								<c:otherwise>
										<a class="btn btn-danger" href="/joinLeaveTeam/${teamInList.ventures.id}">Leave Team</a>
								</c:otherwise>
							</c:choose>
							</td>
						</tr>
					<%-- </c:if> --%>
				</c:forEach>
			</tbody>
		</table>
<%-- \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\ --%>
		<br>
		<br>
<%-- \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\ --%>
		<h1>Projects Not Joined</h1>


		<table class="table table-dark table-striped table-hover border shadow">
			<thead>
				<tr>
					<th class="align-middle">Venture</th>
					<th class="align-middle">Team Lead</th>
					<th class="align-middle">Due Date</th>
					<th class="align-middle">Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="teamInList" items="${otherTeams}">
						<tr>
							<%-- <td>
								<c:out value="${teamInList.users.id}"></c:out>
							</td> --%>
							<%-- <td>
								<c:out value="${teamInList.users.firstName}"></c:out>
							</td> --%>
							<td>
								<c:out value="${teamInList.ventures.title}"></c:out>
							</td>
							<td>
								<c:out value="${teamInList.ventures.user.firstName}"></c:out>
							</td>
							<td>
								<c:out value="${teamInList.ventures.dueDate}"></c:out>
							</td>

							<%-- <td>
								<a href="/oneTeam/${ventureInList.team.id}">
									<c:out value="${ventureInList.team.name}"></c:out>
								</a>
								</td> --%>
							<td>
							<c:choose>
								<c:when test="${teamInList.ventures.user.id == user_id}">
									<a class="btn btn-primary" href="/oneVenture/${teamInList.ventures.id}/edit">Update</a>
									<a class="btn btn-danger" href="/delete/${ventureInList.id}">Delete</a>
								</c:when>
							
								<c:otherwise>
										<a class="btn btn-danger" href="/joinLeaveTeam/${teamInList.ventures.id}">Join Team</a>
								</c:otherwise>
							</c:choose>
							</td>
						</tr>
				</c:forEach>
			</tbody>
		</table>
<%-- \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\ --%>
		<br>
		<br>

		<%-- <h1>Not My Projects</h1>
		<table class="table table-dark table-striped table-hover border shadow">
			<thead>
				<tr>
					<th class="align-middle">Venture</th>
					<th class="align-middle">Team Lead</th>
					<th class="align-middle">Due Date</th>
					<th class="align-middle">Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="teamInList" items="${allTeams}">
					<c:if test="${teamInList.users.id != currentUser.id}">

						<tr>
							<td>
								<c:out value="${teamInList.users.id}"></c:out>
							</td>
							<td>
								<c:out value="${teamInList.users.firstName}"></c:out>
							</td>
							<td>
								<c:out value="${teamInList.ventures.title}"></c:out>
							</td>
							<td>
								<c:out value="${teamInList.ventures.user.firstName}"></c:out>
							</td>
							<td>
								<c:out value="${teamInList.ventures.dueDate}"></c:out>
							</td>

							<td>
								<a href="/oneTeam/${ventureInList.team.id}">
									<c:out value="${ventureInList.team.name}"></c:out>
								</a>
								</td>
							<td>
								<a class="btn btn-danger" href="/delete/${ventureInList.id}">Join</a>
							</td>
						</tr>
					</c:if>
				</c:forEach>
			</tbody>
		</table>
	<h1><c:out value="ID: ${currentUser.id}" /></h1>
	<h1><c:out value="User: ${currentUser.firstName}" /></h1> --%>

		<h1><c:out value="ID: ${currentUser.id}" /></h1>
		<h1><c:out value="User: ${currentUser.firstName}" /></h1>
	</div>
	<!-- End of Container -->


</body>

</html>