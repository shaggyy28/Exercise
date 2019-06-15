package com.sagar.todo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sagar.todo.dao.Status;
import com.sagar.todo.dao.ToDo;
import com.sagar.todo.dao.ToDoDao;

/**
 * Servlet implementation class AddTodoServlet
 */
public class AddTodoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ToDoDao todoDao;

	@Override
	public void init() throws ServletException {
		todoDao = new ToDoDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String event = request.getParameter("event");
		String status = request.getParameter("status");
		todoDao.addTodo(new ToDo(event, Status.valueOf(status)));
		request.getRequestDispatcher("/index").forward(request, response);
	}

}
