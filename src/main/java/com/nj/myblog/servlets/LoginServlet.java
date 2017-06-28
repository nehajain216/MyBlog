package com.nj.myblog.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nj.myblog.entities.User;
import com.nj.myblog.services.MyblogServices;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	MyblogServices myblogServices = new MyblogServices();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			HttpSession session = request.getSession();
			User user = myblogServices.login(email, password);
			if(user!=null)
			{
				session.setAttribute("User_Login", user);
				response.sendRedirect("MainPageServlet");
			}
			else
			{
				session.invalidate();
                request.setAttribute("errorMessage", "Invalid email or password");
                RequestDispatcher dispatcher = request.getRequestDispatcher("LoginPage.jsp");
    			dispatcher.forward(request, response);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
