package com.sagar;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/root")
public class RootServlet extends HttpServlet{
	private static final long serialVersionUID = -4629683884008755141L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("in root servlet");
		Map<String, ? extends ServletRegistration> servletRegistrations = req.getServletContext().getServletRegistrations();
		PrintWriter writer = resp.getWriter();
		writer.println("<html>");
		writer.println("<body>");
		writer.println("<ol>");
		for(Entry<String, ? extends ServletRegistration> set :servletRegistrations.entrySet())
			writer.println("<li>" + set.getKey() + ":===> " + set.getValue().getClassName() + "</li>");
		writer.println("</ol>");
		writer.println("</body>");
		writer.println("</html>");
	}
}
