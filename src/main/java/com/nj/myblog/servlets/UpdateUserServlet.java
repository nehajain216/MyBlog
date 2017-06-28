package com.nj.myblog.servlets;

import java.io.IOException;
import java.util.ArrayList;
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
 * Servlet implementation class UpdateUserServlet
 */
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MyblogServices myblogServices = new MyblogServices();

	public UpdateUserServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String userId = request.getParameter("id");
			User user = myblogServices.getUserById(Integer.valueOf(userId));
			request.setAttribute("userData", user);
			List<Role> roles = myblogServices.getAllRoles();
			request.setAttribute("roles", roles);
			List<String> userStatus = new ArrayList<String>();
			userStatus.add("True");
			userStatus.add("False");
			request.setAttribute("userStatus", userStatus);
			RequestDispatcher dispatcher = request.getRequestDispatcher("UpdateUser.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			String userId = request.getParameter("userId");
			String userStatus = request.getParameter("active");
			String roleId = request.getParameter("role");
			User user = new User();
			user.setId(Integer.valueOf(userId));
			user.setName(name);
			user.setPassword(password);
			user.setActive(Boolean.valueOf(userStatus));
			Role role = new Role();
			role.setId(Integer.valueOf(roleId));
			user.setRole(role);
			myblogServices.updateUser(user);
			response.sendRedirect("UserServlet");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
