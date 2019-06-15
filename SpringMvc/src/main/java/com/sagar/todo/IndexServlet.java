package com.sagar.todo;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sagar.todo.dao.ToDo;
import com.sagar.todo.dao.ToDoDao;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet(urlPatterns = "/index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ToDoDao todoDao;
	private Logger LOGGER = Logger.getLogger("com.sagar");

	@Override
	public void init() throws ServletException {
		todoDao = new ToDoDao();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<ToDo> allTodos = todoDao.getAllTodos();
		HttpSession session = request.getSession();
		LOGGER.info(this.getServletName() + " Session id:" +  session.getId());
		request.setAttribute("todos", allTodos);
		request.getRequestDispatcher("/html/index.jsp").forward(request, response);
		System.out.println(request.getContextPath());
	}

}
