<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>New Post</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="css/styles.css">
</head>
<body>
	<form action="AddPost" method="POST" class="form-horizontal">
		<nav class="navbar navbar-inverse navbar-fixed-top">
			<div class="container" align="right">
				<div id="navbar" class="collapse navbar-collapse">
					<ul class="nav navbar-nav">
						<li><a href="MainPageServlet">MyBlog</a></li>
						<li><a href="LoginPage.jsp">Logout</a></li>
					</ul>
				</div>
			</div>
		</nav>
		<div>
			<div style="color: #ff0000">
				<c:if test="${not empty errorMessage}">
					<c:out value="${errorMessage}" />
				</c:if>
			</div>

			<div class="form-group">
				<label for="inputTitle" class="col-sm-2 control-label">Title</label>
				<div class="col-sm-10">
					<input type="text" name="title" value="${postData.title}"
						class="form-control" placeholder="Post Title"> <br>
				</div>
			</div>


			<div class="form-group">
				<label for="inputContent" class="col-sm-2 control-label">Content</label>
				<div class="col-sm-10">
					<textarea class="form-control" placeholder="Post Content" rows="6"
						name="content">${postData.content}</textarea>
					<br>
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<a href="MainPageServlet" class="btn btn-default">Cancel</a>
					&nbsp;&nbsp; <input class="btn btn-primary" type="submit"
						value="submit">

				</div>
			</div>
		</div>
	</form>
</body>
</html>