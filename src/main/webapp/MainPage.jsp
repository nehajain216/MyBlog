<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html>
<head>
<title>Welcome to MyBlog</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="css/styles.css">
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container" align="right">
			<div id="navbar" class="collapse navbar-collapse">
				<c:if test="${UserRole.role.id == 1}">
					<div style="color: #FFFFFF">Welcome,${UserRole.name}!</div>
					<ul class="nav navbar-nav">
						<li><a href="UserServlet">Users</a></li>
						<li><a href="AddPost.jsp">New Post</a></li>
						<li><a href="LoginPage.jsp">Logout</a></li>
					</ul>
				</c:if>

				<c:if test="${UserRole.role.id != 1}">
					<ul class="nav navbar-nav">
						<li class="active"><a href="LoginPage.jsp">Login</a></li>
					</ul>
				</c:if>

			</div>
		</div>
	</nav>
	<div class="panel panel-primary">
		<c:if test="${Posts.isEmpty()}">
			<div class="panel-body">No Post found</div>
		</c:if>
		<c:if test="${!Posts.isEmpty()}">
			<c:forEach var="post" items="${Posts}">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title">
							<c:out value="${post.title}" />
						</h3>
					</div>
					<div class="panel-body">
						<a href="AddCommentServlet?id=${post.id}"><c:out
								value="${post.content}" /></a>
					</div>

					<c:if test="${UserRole.role.id == 1}">
						<div class="panel-footer">
							<a href="EditPostServlet?id=${post.id}" >Edit</a>&nbsp;&nbsp;&nbsp;
							<a href="DeletePostServlet?id=${post.id}"
								onclick="return confirm('Are you sure you want to Delete?');">Delete</a>
						</div>
					</c:if>
				</div>
			</c:forEach>
		</c:if>
	</div>

</body>
</html>