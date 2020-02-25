package com.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc.bean.LoginBean;
import com.mvc.dao.LoginDaoServices;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		final long serialVersionUID = 1L;
		 
		 //Getting parameters from text box
		 String userName= request.getParameter("username");
		
		String password=request.getParameter("password");
		 
		 LoginBean loginBean=new LoginBean();
		 //Setting parameters to bean class
		 loginBean.setUserName(userName);
		 loginBean.setPassword(password);
		  LoginDaoServices loginDao=new LoginDaoServices();
		  try{
			  String userValidate=loginDao.authenticateUser(loginBean);
			  if(userValidate.equals("Admin_Role")){
				  System.out.println("Admin's Home");
				  HttpSession session=request.getSession();
				  session.setAttribute("Admin", userName);
				  request.setAttribute("userName", userName);
				  request.getRequestDispatcher("/JSP/Admin.jsp").forward(request, response);
			  }else if(userValidate.equals("Editor_Role")){
				  System.out.println("Editor's Home");
				  
				  HttpSession session=request.getSession();
				  session.setAttribute("Editor", userName);
				  request.setAttribute("userName", userName);
				  
				  request.getRequestDispatcher("/JSP/Editor.jsp").forward(request, response);
			  }else if(userValidate.equals("User_Role")){
				  
				  System.out.println("User's Home");
				  HttpSession session=request.getSession();
				  
				  session.setMaxInactiveInterval(10*60);
				  session.setAttribute("User", userName);
				  request.setAttribute("userName", userName);
				  
				  request.getRequestDispatcher("/JSP/Login.jsp").forward(request, response);
			  }else{
				  System.out.println("Error message ="+userValidate);
				  request.setAttribute("errMessage", userValidate);
				  request.getRequestDispatcher("/JSP/Login.jsp").forward(request, response);
			  }
			}catch(IOException e1){
				  e1.printStackTrace();
		  }catch(Exception e2){
			  e2.printStackTrace();
		  }
	}
	}


