package com.nj.myblog.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nj.myblog.entities.Comment;
import com.nj.myblog.services.MyblogServices;

/**
 * Servlet implementation class EditComment
 */
public class EditComment extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public EditComment() {
        super();
    }

    MyblogServices myblogServices = new MyblogServices();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
			String commentId = request.getParameter("id");
			String postId = request.getParameter("postId");
			request.setAttribute("postId", postId);
			Comment comment = myblogServices.getCommentById(Integer.valueOf(commentId));
			request.setAttribute("commentData", comment);
			RequestDispatcher dispatcher = request.getRequestDispatcher("EditComment.jsp");
			dispatcher.forward(request, response);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
			String content = request.getParameter("content");
			String commentId =request.getParameter("commentId");
			String postId = request.getParameter("postId");
			Comment comment = new Comment();
			comment.setContent(content);
			comment.setId(Integer.valueOf(commentId));
			myblogServices.updateComment(comment);
			response.sendRedirect("EditPostServlet?id="+postId);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
