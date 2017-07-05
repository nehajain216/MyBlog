<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Users</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="css/styles.css">
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="MainPageServlet">MyBlog</a>
			</div>
		</div>
	</nav>
	<table class="table table-striped">
		<tr>
			<td>Name</td>
			<td>Email</td>
			<td>IsActive</td>
			<td>Role</td>
			<td colspan="2"><a href="AddUserServlet">New User</a></td>
		</tr>
		<c:if test="${user.isEmpty()}">
			<tr>
				<td colspan="4">No users found</td>
			</tr>
		</c:if>
		<c:if test="${!user.isEmpty()}">
			<c:forEach var="user" items="${user}">
				<tr>
					<td><c:out value="${user.name}" /></td>

					<td><c:out value="${user.email}" /></td>

					<td><c:out value="${user.active ? 'Yes' : 'No'}" /></td>

					<td><c:out value="${user.role.name}" /></td>

					<td><a href="UpdateUserServlet?id=${user.id}">Edit</a></td>

					<td><a href="DeleteUser?id=${user.id}"
						onclick="return confirm('Are you sure you want to Delete?');">Delete</a></td>
				</tr>
			</c:forEach>
		</c:if>
		<tr>
			<td colspan="6"><br></td>
		</tr>
		<tr>
			<td align="right" colspan="6"><a href="MainPageServlet">Back</a></td>
		</tr>
	</table>
</body>
</html>