package com.mvc.controller;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.bean.RegisterBean;
import com.mvc.dao.RegisterDaoServices;


@WebServlet(name = "RegisterServlet", urlPatterns = { "/RegisterServlet" })
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//delcare the variable and assign the values from textbox name
				String fullName=request.getParameter("FullName");
				String email=request.getParameter("email");
				String userName=request.getParameter("userName");
				String password=request.getParameter("password");
				String isActive=request.getParameter("status");
				String roleName=request.getParameter("role");
				String gender=request.getParameter("gender");
			    String regDate=request.getParameter("regDate");
			    java.util.Date date = null;
					
			    java.text.DateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd");
			    try {
			        
			       date = format.parse(regDate);
			    } catch (ParseException ex) {
			        
			        System.out.println(ex);
			    }
			    
				RegisterBean registerBean=new RegisterBean();
				
				registerBean.setFullName(fullName);
				registerBean.setEmail(email);
				registerBean.setUserName(userName);
				registerBean.setPassword(password);
				registerBean.setActive(isActive);
				registerBean.setRoleId(roleName);
				registerBean.setGender(gender);	
				registerBean.setRegDate(date);
				
				
				RegisterDaoServices registerDao=new RegisterDaoServices();
				
				try {
					String registerUser=registerDao.registerUser(registerBean);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				request.getRequestDispatcher("/JSP/Home.jsp").forward(request, response);
				
			}

	}


