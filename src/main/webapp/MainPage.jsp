<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html>
<head>
<title>Welcome to MyBlog</title>
</head>
<body>
	<div style="padding: 5px;" align="right">
		<a href="LoginPage.jsp">logout</a>
	</div>
	<div style="padding: 5px;" align="right">
		<a href="UserServlet">Users</a>
	</div>
	<c:if test="${UserRole.role.id == 1}">
		<div style="padding: 5px;" align="right">
			<a href="AddPost.jsp">New Post</a>
		</div>
	</c:if>
	<table width="600">

		<c:if test="${Posts.isEmpty()}">
			<tr>
				<td colspan="4">No Post found</td>
			</tr>
		</c:if>
		<c:if test="${!Posts.isEmpty()}">
			<c:forEach var="post" items="${Posts}">
				<tr>
					<td><h3>
							<c:out value="${post.title}" />
						</h3></td>
				</tr>
				<tr>
					<td><c:out value="${post.content}" /></td>
				</tr>
				<tr>
					<td></td>
				</tr>
				<tr>
					<td><a href="EditPostServlet?id=${post.id}">Edit</a></td>
				</tr>
				<tr>
					<td><a href="DeletePostServlet?id=${post.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
</body>
</html>