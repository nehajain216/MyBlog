<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html>
<head>
<title>Comment</title>
</head>
<body>
	<form action="AddCommentServlet" method="POST">
		<table>
			<tr>
				<td><b><c:out value="${postData.title}" /></b></td>
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
			<tr><td><b>Comments</b><br></td></tr>
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
				<td>Leave a Reply<br></td>
			</tr>
			<tr>
				<td><textarea rows="4" cols="50" name="content"></textarea></td>
			</tr>
			<tr>
				<td>Name :<input type="text" name="name" /><br></td>
			</tr>
			<tr>
				<td>Email :<input type="text" name="email" /></td>
			</tr>			
			<tr>
				<td align="right"><input type="submit" value="submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>