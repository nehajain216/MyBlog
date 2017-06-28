package com.nj.myblog.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nj.myblog.services.MyblogServices;

/**
 * Servlet implementation class DeleteCommentServlet
 */
public class DeleteCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteCommentServlet() {
        super();
    }

    MyblogServices myblogServices = new MyblogServices();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
			String commentId = request.getParameter("id");
			String postId = request.getParameter("postId");
			System.out.println("Comment Id"+commentId);
			myblogServices.deleteComment(Integer.parseInt(commentId));
			response.sendRedirect("EditPostServlet?id="+postId);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
