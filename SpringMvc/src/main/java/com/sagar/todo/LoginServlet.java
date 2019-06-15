package com.sagar.todo;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns= "/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 3822361252611618252L;
	private Logger LOGGER = Logger.getLogger("com.sagar");

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		LOGGER.info(this.getServletName() + " Session id:" + session.getId());
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/html/login.jsp");
		requestDispatcher.forward(request, response);
	}
}
