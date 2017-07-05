package com.nj.myblog.filters;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class RequestLoggingFilters
 */
public class RequestLoggingFilters implements Filter {

	public RequestLoggingFilters() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpSession session = ((HttpServletRequest) request).getSession(true);
		String contextRoot = ((HttpServletRequest) request).getContextPath();
		String requestURI = ((HttpServletRequest) request).getRequestURI();

		Boolean defaultPage = false;
		List<String> defaultURI = Arrays.asList("/LoginPage.jsp", "/LoginServlet", "/MainPage.jsp", "/MainPageServlet");
		for (String uri : defaultURI) {
			if ((contextRoot + uri).equals(requestURI)) {
				defaultPage = true;
				break;
			}
		}
		if (defaultPage) {
			chain.doFilter(request, response);
		} else {
			Object loginUser = session.getAttribute("USER_LOGIN");			
			if (loginUser != null)
				chain.doFilter(request, response);
			else
				((HttpServletResponse) response).sendRedirect("MainPageServlet");
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
