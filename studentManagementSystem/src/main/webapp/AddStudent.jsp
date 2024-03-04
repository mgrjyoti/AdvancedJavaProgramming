<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add New Student</title>
<style type="text/css">
#div1{
align-items: center;
background-color: gray;
height: 400px;
width: 400px;
color:blue;
border-radius: 30px;
margin-left: 400px;
margin-top: 100px;
}
h3{
align-items: center;
margin-left: 90px;
color: red;
}
label{
align-items: center;
margin-left: 50px;
}
button{
align-content: center;
margin-left: 150px;
line-height: 20px;
background-color: blue;
color: yellow;
border-radius: 5px;
}
</style>
</head>
<body>
	<div id='div1'>
	<h3>Student Registration</h3>
		<form action="./student" method="post">
			<table>
				<tr>
					<td> <label>ID</label> </td>
					<td> <input type="text" id="" name="id" > </td>
				</tr>
				<tr>
					<td> <label>NAME</label> </td>
					<td> <input type="text" id="" name="name" > </td>
				</tr>
				<tr>
					<td> <label>EMAIL</label> </td>
					<td> <input type="email" id="" name="email" > </td>
				</tr>
				<tr>
					<td> <label>CONTACT</label> </td>
					<td> <input type="number" id="" name="contact" > </td>
				</tr>
				<tr>
					<td> <label>FEES</label> </td>
					<td> <input type="number" id="" name="fees" > </td>
				</tr>
			</table>	
			<button type="submit"> SUBMIT </button>
		</form>
	</div>
	<% String message=(String) request.getAttribute("message");
	if(message !=null){
	%>
	<div>
		<h1> <%=message %> </h1>
	</div>
	<%
	}
	%>
</body>
</html>