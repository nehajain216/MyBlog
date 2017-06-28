<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Users</title>
</head>
<body>
	<form action="UserServlet" method="GET">
		<table width="600">
			<tr>
				<td>Name</td>
				<td>Email</td>
				<td>IsActive</td>
				<td colspan="3"><a href="AddUserServlet">New User</a></td>
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

						<td><a href="DeleteUser?id=${user.id}">Delete</a></td>
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
	</form>
</body>
</html>