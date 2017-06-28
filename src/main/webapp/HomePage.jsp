<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html>
<head>
<title>Welcome to MyBlog</title>
</head>
<body>
	<div style="padding: 5px;" align="right">
		<a href="LoginPage.jsp">login</a>
	</div>
	<table>
		<c:if test="${ListOfAllPosts.isEmpty()}">
			<tr>
				<td colspan="4">No Post found</td>
			</tr>
		</c:if>
		<c:if test="${!ListOfAllPosts.isEmpty()}">

			<c:forEach var="allPosts" items="${ListOfAllPosts}">
				<tr>
					<td><h3>
							<b><c:out value="${allPosts.title}" /></b>
						</h3></td>
				</tr>
				<tr>
					<td><a href="AddCommentServlet?id=${allPosts.id}"><c:out value="${allPosts.content}" /></a></td>
				</tr>
				<tr>
					<td></td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
</body>
</html>