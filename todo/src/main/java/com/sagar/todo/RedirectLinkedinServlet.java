package com.sagar.todo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/linkedin")
public class RedirectLinkedinServlet extends HttpServlet{

	private static final long serialVersionUID = 3898974322927417488L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("https://www.linkedin.com/in/sagar-ingale-178100b1/");
	}
}
