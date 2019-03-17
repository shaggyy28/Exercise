package com.sagar;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class EchoServlet extends HttpServlet{
	private static final long serialVersionUID = -2947776160064626813L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String text = req.getParameter("text");
		String action = req.getParameter("ok");
		PrintWriter writer = resp.getWriter();
		
		writer.println("<h1>" + text + "</h1>");
		
	}
}
