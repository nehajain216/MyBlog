<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Edit Post</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="css/styles.css">
</head>
<body>
	<form action="EditPostServlet" method="POST">
		<nav class="navbar navbar-inverse navbar-fixed-top">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#navbar" aria-expanded="false"
						aria-controls="navbar">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="MainPageServlet">MyBlog</a>
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
				<div class="col-sm-10">
					<input type="hidden" name="postId" value="${postData.id}" /> <br>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<a href="MainPageServlet" class="btn btn-default">Cancel</a>
					&nbsp;&nbsp; <input class="btn btn-primary" type="submit"
						value="submit">

				</div>
			</div>
			<br> <br>
			<div class="form-group">
				<label for="inputTitle" class="col-sm-2 control-label">Comments</label>
				<div class="col-sm-10"></div>
			</div>
			<div class="form-group">
				<div class="col-sm-2 control-label">
					<c:forEach var="comment" items="${postData.comments}">
						<c:out value="${comment.name}" />
						<br>
						<c:out value="${comment.email}" />
						<br>
						<c:out value="${comment.content}" />
						<br>
						<a href="EditComment?id=${comment.id}&postId=${postData.id}">Edit</a>&nbsp; &nbsp; <a
							href="DeleteCommentServlet?id=${comment.id}&postId=${postData.id}"
							onclick="return confirm('Are you sure you want to Delete?');">Delete</a><br>
					</c:forEach>
				</div>
			</div>
		</div>

	</form>
</body>
</html>