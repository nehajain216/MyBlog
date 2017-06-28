<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Edit Post</title>
</head>
<body>
	<form action="EditPostServlet" method="POST">
		<table>
			<tr>
				<td><input type="text" name="title" value="${postData.title}" /></td>
			</tr>
			<tr>
				<td><textarea rows="4" cols="50" name="content">${postData.content}</textarea></td>
			</tr>
			<tr>
				<td><input type="hidden" name="postId" value="${postData.id}" /></td>
			</tr>
			<tr>
				<td align="right"><input type="submit" value="submit"></td>
			</tr>
			<tr>
				<td align="right"><a href="MainPageServlet">Back</a></td>
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
				<tr>
					<td><a href="EditComment?id=${comment.id}">Edit</a></td>
				</tr>
				<tr>
					<td><a href="DeleteCommentServlet?id=${comment.id}&postId=${postData.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</form>
</body>
</html>