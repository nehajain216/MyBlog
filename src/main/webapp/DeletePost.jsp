<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Post</title>
</head>
<body>
	<form action="DeletePostServlet" method="POST">
		<table>
			<tr>
				<td><c:out value="${postData.title}" /></td>
			</tr>
			<tr>
				<td><c:out value="${postData.content}" /></td>
			</tr>
			<tr>
				<td><input type="hidden" name="postId" value="${postData.id}" /></td>
			</tr>			
			<tr>
				<td><br></td>
			</tr>
			<tr>
				<td><b>Comments</b><br></td>
			</tr>
			<c:forEach var="comment" items="${postData.comments}">

				<tr>
					<td><c:out value="${comment.name}" /></td>
				</tr>
				<tr>
					<td><c:out value="${comment.email}" /></td>
				</tr>
				<tr>
					<td><c:out value="${comment.content}" /></td>
				</tr>
			</c:forEach>
			<tr>
				<td align="right"><input type="submit" value="Delete"></td>
			</tr>
		</table>
	</form>
</body>
</html>