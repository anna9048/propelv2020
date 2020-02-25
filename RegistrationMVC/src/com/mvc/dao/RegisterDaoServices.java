package com.mvc.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mvc.bean.RegisterBean;
import com.mvc.helper.ConnectionFactory;

public class RegisterDaoServices {
	
	//Implements singleton design pattern
	private static RegisterDaoServices instance=null;
	
	//getInstance method
	public static RegisterDaoServices getInstance() {
		if(instance==null){
			instance=new RegisterDaoServices();
		}
		return instance;
	}
	//default constructor
	public RegisterDaoServices() {
		// TODO Auto-generated constructor stub
	}
	
	private static final String INSERT_USERS_SQL="INSERT INTO users(usr_fullName,usr_email,usr_userName,usr_password,usr_isActive,usr_role,usr_gender,usr_date)values(?,?,?,?,?,?,?,?)";
	private static final String SELECT_USER_BY_ID="SELECT * FROM USERS WHERE USR_SLNO=?";
	private static final String SELECT_ALL_USERS = "select * from USERS";
	private static final String DELETE_USERS_SQL = "DELETE from USERS where USR_SLNO=?";
	private static final String UPDATE_USERS_SQL = "UPDATE USERS set usr_fullName=?,usr_email=?,usr_userName=?,usr_password=?,usr_isActive=?,usr_role=?,usr_gender=?,usr_date=? where USR_SLNO= ?";

	// Creating objects
			private Connection connection = null;
			private PreparedStatement statement = null;
			private ResultSet resultSet = null;
			
	public String registerUser(RegisterBean registerBean)throws Exception{
		try{
			
			connection=ConnectionFactory.getConnection();
			statement=connection.prepareStatement(INSERT_USERS_SQL);
			statement.setString(1, registerBean.getFullName());
			statement.setString(2,registerBean.getEmail());
			statement.setString(3, registerBean.getUserName());
			statement.setString(4, registerBean.getPassword());
			statement.setString(5, registerBean.getActive());
			statement.setString(6, registerBean.getRoleId());
			statement.setString(7, registerBean.getGender());
			statement.setDate(8, new java.sql.Date(registerBean.getRegDate().getTime()));
		
		int i=statement.executeUpdate();
		if(i!=0){
			return "SUCCESS";
		}
		}catch(Exception e){
			e.printStackTrace();
		}
	return "Oops...something went wrong there!...";
	}
	
	public RegisterBean selectUser(int id){
		RegisterBean register=null;
		try{
			connection=ConnectionFactory.getConnection();
			statement=connection.prepareStatement(SELECT_USER_BY_ID);
			statement.setInt(1, id);
			System.out.println(statement);
			resultSet=statement.executeQuery();
			while(resultSet.next()){
				
				Integer slNo=resultSet.getInt("USR_SLNO");
				String fullName=resultSet.getString("USR_FULLNAME");
				String email=resultSet.getString("USR_EMAIL");
				String userName=resultSet.getString("USR_USERNAME");
				String password=resultSet.getString("USR_PASSWORD");
				String active=resultSet.getString("USR_ISACTIVE");
				String role=resultSet.getString("USR_ROLE");
				String gender=resultSet.getString("USR_GENDER");
				Date regDate=resultSet.getDate("USR_DATE");
				
				register=new RegisterBean(slNo, fullName, email, userName, password, active, role, gender, regDate);
			}
		}catch(SQLException e){
			System.out.println(e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return register;
		
	}
	public List<RegisterBean> selectAllUsers(){
		RegisterBean register=null;
		List<RegisterBean> users=new ArrayList<>();
		
		try{
			connection=ConnectionFactory.getConnection();
			statement=connection.prepareStatement(SELECT_ALL_USERS);
			System.out.println(statement);
			resultSet=statement.executeQuery();
			while(resultSet.next()){
				
				Integer slNo=resultSet.getInt("USR_SLNO");
				String fullName=resultSet.getString("USR_FULLNAME");
				String email=resultSet.getString("USR_EMAIL");
				String userName=resultSet.getString("USR_USERNAME");
				String password=resultSet.getString("USR_PASSWORD");
				String active=resultSet.getString("USR_ISACTIVE");
				String role=resultSet.getString("USR_ROLE");
				String gender=resultSet.getString("USR_GENDER");
				Date regDate=resultSet.getDate("USR_DATE");
				
				users.add(new RegisterBean(slNo, fullName, email, userName, password, active, role, gender, regDate));
			}
		}catch(SQLException e){
			System.out.println(e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
		
	}

	public boolean deleteUser(int id) throws SQLException {
		boolean rowDeleted = false;
		
		try {
				connection=ConnectionFactory.getConnection();
				statement=connection.prepareStatement(DELETE_USERS_SQL);
				statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}catch(SQLException e){
		System.out.println(e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowDeleted;
	}
	
	public boolean updateUser(RegisterBean registerBean) throws SQLException {
		boolean rowUpdated = false;
		try
		{
			connection=ConnectionFactory.getConnection();
			statement=connection.prepareStatement(UPDATE_USERS_SQL);
			statement.setString(1, registerBean.getFullName());
			statement.setString(2,registerBean.getEmail());
			statement.setString(3, registerBean.getUserName());
			statement.setString(4, registerBean.getPassword());
			statement.setString(5, registerBean.getActive());
			statement.setString(6, registerBean.getRoleId());
			statement.setString(7, registerBean.getGender());
			statement.setDate(8, new java.sql.Date(registerBean.getRegDate().getTime()));
			statement.setInt(9, registerBean.getid());

			rowUpdated = statement.executeUpdate() > 0;
		}catch(SQLException e){
			System.out.println(e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowUpdated;
	}
}
