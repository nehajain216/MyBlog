package com.nj.myblog.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nj.myblog.entities.Comment;
import com.nj.myblog.entities.Post;
import com.nj.myblog.services.MyblogServices;

/**
 * Servlet implementation class AddNewCommentServlet
 */
public class AddCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MyblogServices myblogServices = new MyblogServices();

	public AddCommentServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Post post = myblogServices.getPostById(Integer.valueOf(request.getParameter("id")));
			request.setAttribute("postData", post);
			RequestDispatcher dispatcher = request.getRequestDispatcher("AddComment.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Comment comment = new Comment();
			comment.setName(request.getParameter("name"));
			comment.setEmail(request.getParameter("email"));
			comment.setContent(request.getParameter("content"));
			myblogServices.createComment(Integer.valueOf(request.getParameter("postId")), comment);
			response.sendRedirect("HomePageServlet");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
