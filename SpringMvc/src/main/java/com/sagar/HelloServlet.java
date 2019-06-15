package com.sagar;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private Logger LOGGER = Logger.getLogger("com.sagar");
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		response.setHeader("Content-type", "text/html");
		response.addCookie(new Cookie("name", "sagar"));
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/html/main.html");
		requestDispatcher.forward(request, response);

		ServletConfig servletConfig = getServletConfig();
		ServletContext servletContext = getServletContext();
		System.out.println("hello");
		LOGGER.info(servletConfig.getInitParameter("name"));
		LOGGER.info(servletContext.getInitParameter("url"));
		LOGGER.info(servletContext.getContextPath());
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BufferedReader reader = request.getReader();
		String line = "";
		while((line=reader.readLine()) != null) {
			LOGGER.info(line);
		}
		
		ServletConfig servletConfig = getServletConfig();
		ServletContext servletContext = getServletContext();
		
		LOGGER.info(servletConfig.getInitParameter("name"));
		LOGGER.info(servletContext.getInitParameter("url"));
		LOGGER.info(servletContext.getContextPath());
		
	}

}