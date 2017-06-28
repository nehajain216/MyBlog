<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Post</title>
</head>
<body>
	<form action="AddPost" method="POST">
		<table>
			<tr>
				<td colspan="2">Title :<input type="text" name="title" /><br></td>
			</tr>
			<tr>
				<td colspan="2">Content: <textarea rows="4" cols="50" name="content"></textarea></td>
			</tr>
			<tr>
				<td><a href="MainPageServlet">Cancel</a></td>
				<td align="right"><input type="submit" value="submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>