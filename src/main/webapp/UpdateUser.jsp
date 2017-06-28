<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html >
<html>
<head>
<title>Update User</title>
</head>
<body>
	<form action="UpdateUserServlet" method="POST">
		<table>
			<tr>
				<td>User Name: <input type="text" name="name"
					value="${userData.name}" /></td>
			</tr>
			<tr>
				<td>Email:<c:out value="${userData.email}" /></td>
			</tr>
			<tr>
				<td>Password: <input type="text" name="password"
					value="${userData.password}" /></td>
			</tr>
			<tr>
				<td>Role: <select name="role">
						<c:forEach var="item" items="${roles}">
							<option value="${item.id}"
								${item.id == userData.role.id ? 'selected="selected"' : ''}>${item.name}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>IsActive: <select name="active">
						<c:forEach var="item" items="${userStatus}">
							<option value="${item}"
								${item == userData.active ? 'selected="selected"' : ''}>${item}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>IsActive: <select name="activetemp">
							<option value="true" ${true == userData.active ? 'selected="selected"' : ''}>True</option>
							<option value="false" ${false == userData.active ? 'selected="selected"' : ''}>False</option>
				</select></td>
			</tr>
			<tr>
				<td><input type="hidden" name="userId" value="${userData.id}" /></td>
			</tr>
			<tr>
				<td align="right"><input type="submit" value="submit"></td>
			</tr>
			<tr>
				<td align="right"><a href="UserServlet">Back</a></td>
			</tr>

		</table>
	</form>
</body>
</html>