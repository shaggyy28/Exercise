package com.sagar.todo;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.sagar.todo.dao.AuthDao;

/**
 * Servlet Filter implementation class AuthenticationFilter
 */
@WebFilter("/*")
public class AuthenticationFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AuthenticationFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @throws ServletException 
	 * @throws IOException 
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException  {
		HttpServletRequest servletRequest = (HttpServletRequest) request;
		AuthDao authDao = new AuthDao();
		if(servletRequest.getRequestURI().startsWith("/todo/add")) {
			HttpSession httpSession = servletRequest.getSession();
			String username = (String)httpSession.getAttribute("username");
			String password = (String)httpSession.getAttribute("password");
			boolean validateUser = authDao.validateUser(username, password);
			if(!validateUser) {
				servletRequest.getRequestDispatcher("/html/login.jsp").forward(servletRequest, response);
			}else {
				chain.doFilter(request, response);
			}
		}else {
			chain.doFilter(request, response);
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
