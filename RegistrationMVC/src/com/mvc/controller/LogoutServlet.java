package com.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public LogoutServlet() {

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		//request.getRequestDispatcher("link.html").include(request, response);
		
		HttpSession session = request.getSession();
		out.print(session.getId()+"<br>");
		session.removeAttribute("log");
		
		session.removeAttribute("Admin");
		session.invalidate();
		
		out.print("You are successfully logged out!<br>");
		out.print(session.getId()+"<br>");
		//request.getRequestDispatcher("/JSP/Login.jsp").include(request, response);
		response.sendRedirect(request.getContextPath()
				+"/JSP/Login.jsp");
		
		eraseCookie(request,response);

		out.close();
	}
	
	
	private void eraseCookie(HttpServletRequest req, HttpServletResponse resp) {
	    Cookie[] cookies = req.getCookies();
	    if (cookies != null)
	        for (Cookie cookie : cookies) {
	            cookie.setValue("");
	            cookie.setPath("/");
	            cookie.setMaxAge(0);
	            resp.addCookie(cookie);
	        }
	}
}
