<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<title>Login</title>
<style type="text/css">
body{
padding-top: 10%;
padding-left: 10%;
padding-right: 10%;
background-color: pink;
}
</style>
</head>
<body >
	<form action="<%=request.getContextPath()%>/LoginServlet"
	method="post">
	<center><h1>Please Login</h1></center><br>
	
		<b/>User name:<br/>
		<input type="text" name="username" class="form-control" required autocomplete="off"/><br/>
		<br/>
		<b/>Password:<br/>
		<input type="password" name="password" required class="form-control" /><br/><br/>
		<div>
			<span style="color:green"><%=(request.getAttribute("errMessage")==null)?"":request.getAttribute("errMessage") %></span>
		</div>
		<input type="submit" value="Login"class="btn btn-primary" style="width:50%">
		<input type="reset" value="Reset"class="btn btn-success" style="width:30%"><br/><br/>
	</form>		

	
</body>
</html>