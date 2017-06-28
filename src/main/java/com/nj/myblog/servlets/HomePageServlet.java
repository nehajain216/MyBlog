package com.nj.myblog.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nj.myblog.entities.Post;
import com.nj.myblog.services.MyblogServices;

/**
 * Servlet implementation class HomePageServlet
 */
public class HomePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   MyblogServices myblogServices = new MyblogServices();
    public HomePageServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		List<Post> allPosts = myblogServices.getAllPost();
		request.setAttribute("ListOfAllPosts", allPosts);
		RequestDispatcher dispatcher = request.getRequestDispatcher("HomePage.jsp");
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
