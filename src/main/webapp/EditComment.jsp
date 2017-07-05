<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Edit Comment</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="css/styles.css">
</head>
<body>
	<form action="EditComment" method="POST">
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
			<div class="form-group">
				<label for="inputComment" class="col-sm-2 control-label">Comment</label>
				<div class="col-sm-10">
					<textarea class="form-control" placeholder="Post Content" rows="6"
						name="content">${commentData.content}</textarea>
					<br>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-10">
					<input type="hidden" name="commentId" value="${commentData.id}" /> <br>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-10">
					<input type="hidden" name="postId" value="${postId}" /> <br>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<a href="EditPostServlet" class="btn btn-default">Cancel</a>
					&nbsp;&nbsp; <input class="btn btn-primary" type="submit"
						value="submit">

				</div>
			</div>
		</div>
	</form>
</body>
</html>