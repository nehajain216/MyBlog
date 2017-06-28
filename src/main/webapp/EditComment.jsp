<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Edit Comment</title>
</head>
<body>
	<form action="EditComment" method="POST">
		<table>

			<tr>
				<td><textarea rows="4" cols="50" name="content">${commentData.content}</textarea></td>
			</tr>
			<tr>
				<td><input type="hidden" name="commentId"
					value="${commentData.id}" /></td>
			</tr>
			<tr>
				<td align="right"><input type="submit" value="submit"></td>
			</tr>
			<tr>
				<td><a href="MainPageServlet">Back</a></td>
			</tr>
		</table>
	</form>
</body>
</html>