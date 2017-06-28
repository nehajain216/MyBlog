package com.nj.myblog.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nj.myblog.services.MyblogServices;

/**
 * Servlet implementation class DeletePostServlet
 */
public class DeletePostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	MyblogServices myblogServices = new MyblogServices();
    public DeletePostServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String postId = request.getParameter("id");
		myblogServices.deletePost(Integer.valueOf(postId));
		response.sendRedirect("MainPageServlet");
	}

}
