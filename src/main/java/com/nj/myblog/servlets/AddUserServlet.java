package com.nj.myblog.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nj.myblog.entities.Role;
import com.nj.myblog.entities.User;
import com.nj.myblog.services.MyblogServices;

/**
 * Servlet implementation class AddUserServlet
 */
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddUserServlet() {
		super();
	}

	MyblogServices myblogServices = new MyblogServices();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Role> roles = myblogServices.getAllRoles();
		request.setAttribute("roles", roles);
		RequestDispatcher dispatcher = request.getRequestDispatcher("AddUser.jsp");
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String roleId = request.getParameter("role");
			User user = new User();
			user.setName(name);
			user.setEmail(email);
			user.setPassword(password);
			user.setActive(true);
			Role role = new Role();
			role.setId(Integer.valueOf(roleId));
			user.setRole(role);			
			myblogServices.createUser(user);
			response.sendRedirect("UserServlet");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
