package com.nj.myblog.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nj.myblog.entities.Post;
import com.nj.myblog.entities.User;
import com.nj.myblog.services.MyblogServices;

/**
 * Servlet implementation class AddPost
 */
public class AddPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	MyblogServices myblogServices = new MyblogServices();
	
    public AddPost() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		if(title.isEmpty() || content.isEmpty())
		{
			Post post = new Post();
			post.setTitle(title);
			post.setContent(content);
			request.setAttribute("postData", post);
			//session.invalidate();
            request.setAttribute("errorMessage", "Both Title and Content is required. Please update.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("AddPost.jsp");
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			if(!title.isEmpty() && !content.isEmpty())
			{
				Post post = new Post();
				post.setTitle(title);
				post.setContent(content);
				HttpSession session = request.getSession();
				User createdBy = (User) session.getAttribute("User_Login");
				post.setCreatedBy(createdBy);
				myblogServices.createPost(post);
				response.sendRedirect("MainPageServlet");
			}
			else
			{
				doGet(request,response);
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
