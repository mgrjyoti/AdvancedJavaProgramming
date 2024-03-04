<%@page import="com.jspiders.studentManagementSystem.object.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Student</title>
</head>
<style>
#table{
background-color: aqua;
color: red;
font-size: large;
}
</style>
<body>
<%
Student student= (Student)request.getAttribute("student");
if(student != null){
%>
<div align="center" id="table">
	<form action="UpdateStudent" method="post">
		<table >
			<tr>
				<td>ID</td>
				<td> <input type="text" name="id" value="<%=student.getId() %>" readonly="true" > </td>
			</tr>
		</table>
	</form>
</div>
<%
}
%>
</body>
</html>