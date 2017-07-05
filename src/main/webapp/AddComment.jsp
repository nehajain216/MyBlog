<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html>
<head>
<title>Comment</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="css/styles.css">
</head>
<body>
	<form action="AddCommentServlet" method="POST">
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
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">${postData.title}</h3>
				</div>
				<div class="panel-body">${postData.content}</div>
			</div>
			<div class="form-group">
				<div class="col-sm-10">
					<input type="hidden" name="postId" value="${postData.id}" /> <br>
				</div>
			</div>
			<br>
			<div class="form-group">
				<label for="inputComments" class="col-sm-2 control-label">Comments</label>
				<div class="col-sm-10">
					<c:forEach var="comment" items="${postData.comments}">
						<c:out value="${comment.content}" />
						<br>
						<c:out value="${comment.name}" />
						<br>
						<c:out value="${comment.email}" />
						<br>
						<br>
					</c:forEach>
				</div>
			</div>
			<div class="form-group">
				<label for="inputComment" class="col-sm-2 control-label">Leave
					a Reply</label><br>
				<div class="col-sm-10">
					<textarea class="form-control" placeholder="Post Content" rows="6"
						name="content"></textarea>
				</div>
			</div>
			<br>
			<div class="form-group">
				<label for="inputName" class="col-sm-2 control-label">Name</label>
				<div class="col-sm-10">
					<input type="text" name="name" class="form-control"> <br>
				</div>
			</div>
			<br>
			<div class="form-group">
				<label for="inputName" class="col-sm-2 control-label">Email</label>
				<div class="col-sm-10">
					<input type="text" name="email" class="form-control"> <br>
				</div>
			</div>
			<br>
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