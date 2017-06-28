package com.nj.myblog.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nj.myblog.entities.Post;
import com.nj.myblog.services.MyblogServices;

/**
 * Servlet implementation class EditPostServlet
 */
public class EditPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public EditPostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	MyblogServices myblogServices = new MyblogServices();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
			String postId = request.getParameter("id");
			Post post = myblogServices.getPostById(Integer.valueOf(postId));
			request.setAttribute("postData", post);
			RequestDispatcher dispatcher = request.getRequestDispatcher("EditPost.jsp");
			dispatcher.forward(request, response);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			String postId = request.getParameter("postId");
			Post post = new Post();
			post.setContent(content);
			post.setTitle(title);
			post.setId(Integer.valueOf(postId));
			myblogServices.updatePost(post);
			response.sendRedirect("MainPageServlet");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
