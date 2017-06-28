package com.nj.myblog.servlets;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
 * Servlet implementation class MainPageServlet
 */
public class MainPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	MyblogServices myblogServices = new MyblogServices();
    
    public MainPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		List<Post> post = new ArrayList<Post>();
		try
		{
			HttpSession session = request.getSession(true);
			User user = (User) session.getAttribute("User_Login");
			request.setAttribute("UserRole", user);
			int userId = user.getId();
			System.out.println(userId);
			post = myblogServices.getAllPost();
			request.setAttribute("Posts", post);
			RequestDispatcher dispatcher = request.getRequestDispatcher("MainPage.jsp");
			dispatcher.forward(request, response);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
