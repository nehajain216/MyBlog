<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Add User</title>
</head>
<body>
	<form action="AddUserServlet" method="POST">
		<table>
			<tr>
				<td colspan="2">Name :<input type="text" name="name" /><br></td>
			</tr>
			<tr>
				<td colspan="2">Email :<input type="text" name="email" /><br></td>
			</tr>
			<tr>
				<td colspan="2">Password :<input type="text" name="password" /><br></td>
			</tr>
			<tr>
				<td>Role: <select name="role">
						<c:forEach var="item" items="${roles}">
							<option value="${item.id}">${item.name}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td><a href="UserServlet">Cancel</a></td>
				<td align="right"><input type="submit" value="submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>