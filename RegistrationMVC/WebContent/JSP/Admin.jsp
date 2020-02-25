  <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="anna"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title>Admin: User Registration</title>
<script>
	function validate(){
		var fullName=document.form.fullname.value;
		var email=document.form.email.value;
		var userName=document.form.username.value;
		var password=document.form.password.value;
		var conpassword=document.form.conpassword.value;
		 if(fullName==null ||fullName==""){
			 alert("Full Name cant't be blank");
			 return false;
		 }else if(email==null || email==""){
			 alert("Email can't be blank");
			 return false;
		 }else if(userName==null||userName==""){
			 alert("Username can't be blank");
			 return false;
		 }else if(password.length<6){
			 alert("Password must be at least 6 characters long");
			 return false;
		 }else if(password!=conpassword){
			 alert("Confirm Password should match with the password");
			 return false;
		 }
	}
</script>
</head>
<%if((request.getSession(false).getAttribute("Admin")==null)){ %>
<jsp:forward page="/JSP/Login.jsp"></jsp:forward>
<%} %>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark" style="background-color: RebeccaPurple">
				<div>
					<a href="" class="navbar-brand"> User Management App </a>
				</div>
	
				<ul class="navbar-nav">
					<li><a href="<%=request.getContextPath()%>/list"
						class="nav-link">Users</a></li>
				</ul>
		</nav>
	</header>
	<br>
	<center>
		<h2>Registration Application using MVC and Oracle</h2>
	</center>	
	Welcome&nbsp;&nbsp;<b><%=session.getAttribute("Admin") %></b>

	<div style="padding-left: 80%;padding-right: 10%">
		<a href="<%=request.getContextPath()%>/LogoutServlet" class="list-group-item list-group-item-primary">Logout</a>
	</div>
	<hr>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
			
				<anna:if test="${user != null}">
					<form action="update" method="post">
				</anna:if>
				<anna:if test="${user == null}">
					<form action="insert" method="post" onsubmit="return validate()">
				</anna:if>

				<caption>
					<h2>
					<anna:if test="${user != null}">
            			Edit User
            		</anna:if>
					
					<anna:if test="${user == null}">
            			Add New User
            		</anna:if>
					</h2>
				</caption>

				<anna:if test="${user != null}">
					<input type="hidden" name="id" value="<anna:out value='${user.id}'/>" />
				</anna:if>
	
				<fieldset class="form-group">
					<label>Full Name</label> 
					<input type="text" value="<anna:out value='${user.fullName}' />" class="form-control"
					name="FullName" placeholder="Enter Full Name" required>
				</fieldset>

				<fieldset class="form-group">
					<label>Email</label> 
					<input type="text" value="<anna:out value='${user.email}' />" class="form-control"
					name="email" placeholder="Enter email" required>
				</fieldset>

				<fieldset class="form-group">
					<label>Username</label> 
					<input type="text" value="<anna:out value='${user.userName}' />" class="form-control"
					name="userName" placeholder="Enter username" required>
				</fieldset>
				<fieldset class="form-group">
					<label>Password</label> 
					<input type="password" value="<anna:out value='${user.password}' />" class="form-control"
						name="password" placeholder="Enter password" required>
				</fieldset>
				<fieldset class="form-group">
					<label>IsActive?</label> 
					<input type="checkbox" value="Y" name="status" required>
				</fieldset>
				<fieldset class="form-group">
					<label>Role</label> <select name="role" required>
					<option value="0">Select role</option>
					<option value="Admin">Admin</option>
					<option value="Editor">Editor</option>
					<option value="User">User</option></select>
				</fieldset>
				<fieldset class="form-group">
					<label>Gender</label> &nbsp;&nbsp;<input type="radio" name="gender" value="F">F&nbsp;&nbsp;&nbsp;
					<input type="radio" name="gender" value="M">M&nbsp;&nbsp;&nbsp;
					<input type="radio" name="gender" value="Other">Other
				</fieldset>
				<fieldset class="form-group">
					<label>Register Date</label> <input type="date" name="regDate" value="<anna:out value='${user.regDate}' />">
				</fieldset>
				<input type="submit" class="btn btn-primary" value="Register">
				<input type="reset" value="Reset" class="btn btn-success" >
				</form>
			</div>
		</div>
	</div>
	
</body>
</html>