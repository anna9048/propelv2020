package com.mvc.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.bean.RegisterBean;
import com.mvc.dao.RegisterDaoServices;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private RegisterDaoServices objRegister;

	public void init() {
		objRegister = objRegister.getInstance();
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		//Fetching action from url
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/new":
				System.out.println("in switch");
				showNewForm(request, response);
				break;
			case "/insert":
				try {
					insertUser(request, response);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case "/delete":
				deleteUser(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateUser(request, response);
				break;
			default:
				listUser(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	// List all registers
	private void listUser(HttpServletRequest request,
			HttpServletResponse response) throws SQLException, IOException,
			ServletException {
		//Calling list user method
		List<RegisterBean> listUser = objRegister.selectAllUsers();
		request.setAttribute("listUser", listUser);
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("JSP/Register-list.jsp");
		dispatcher.forward(request, response);
	}

	// Add New User
	private void showNewForm(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("inshow new");
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("JSP/Admin.jsp");
		dispatcher.forward(request, response);
	}

	// Edit and Update
	private void showEditForm(HttpServletRequest request,
			HttpServletResponse response) throws SQLException,
			ServletException, IOException {
		//Search current user 
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println(request.getParameter("id"));
		RegisterBean existingUser = objRegister.selectUser(id);
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("JSP/Admin.jsp");
		request.setAttribute("user", existingUser);
		dispatcher.forward(request, response);

	}

	// Insert new user
	private void insertUser(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//Fetching data from jsp page
		String fullName = request.getParameter("FullName");
		String email = request.getParameter("email");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String isActive = request.getParameter("status");
		String roleName = request.getParameter("role");
		String gender = request.getParameter("gender");
		String regDate = request.getParameter("regDate");
		java.util.Date date = null;

		//Converting date to sql format
		java.text.DateFormat format = new java.text.SimpleDateFormat(
				"yyyy-MM-dd");
		try {

			date = format.parse(regDate);
		} catch (ParseException ex) {

			System.out.println(ex);
		}

		RegisterBean newUser = new RegisterBean(fullName, email, userName,
				password, isActive, roleName, gender, date);
		String result = null;
		result = objRegister.registerUser(newUser);
		if (result.equals("SUCCESS")) {
			response.sendRedirect("list");
		} else {
			System.out.println("Not inserted");
		}
	}

	// update user
	private void updateUser(HttpServletRequest request,
			HttpServletResponse response) throws SQLException, IOException {

		//Fetching data from jsp page
		int slNo = Integer.parseInt(request.getParameter("id"));
		String fullName = request.getParameter("FullName");
		String email = request.getParameter("email");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String isActive = request.getParameter("status");
		if (isActive == "Y") {

		} else {

		}

		String roleName = request.getParameter("role");
		String gender = request.getParameter("gender");
		String regDate = request.getParameter("regDate");
		java.util.Date date = null;

		//Converting date to sql format
		java.text.DateFormat format = new java.text.SimpleDateFormat(
				"yyyy-MM-dd");
		try {

			date = format.parse(regDate);
		} catch (ParseException ex) {

			System.out.println(ex);
		}

		RegisterBean registerData = new RegisterBean(slNo, fullName, email,
				userName, password, isActive, roleName, gender, date);

		objRegister.updateUser(registerData);
		response.sendRedirect("list");
	}

	// delete user
	private void deleteUser(HttpServletRequest request,
			HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		objRegister.deleteUser(id);
		response.sendRedirect("list");
	}
}
