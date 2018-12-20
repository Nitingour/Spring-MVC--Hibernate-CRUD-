
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<body>
<%
response.addHeader("pragma","no-cache");
response.addHeader("cache-control","no-store");
response.addHeader("expire","0");
%>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Employee Portal</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="home">Home</a></li>
      
      <li><a href="Emp"> Create Employee Account</a></li>
          <li><a href="View">View All Employees Account</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="LogoutServlet"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
    </ul>
  </div>
</nav>
   <div class="container" align="center">
       <h1>Welcome  ${user} </h1>

   <h1>View All Employees Details</h1>
   <%@page import="java.util.ArrayList,bean.EmployeeBean" %>
    
   
 </h2> <font color="Red"> ${msg}</font></h2>
   
   <table class="table table-hover">
   <tr><th>EID</th><th>Name</th><th>Salary</th><th>City</th><th>Address</th><th></th></tr>
   <% 
   ArrayList<EmployeeBean> list=(ArrayList<EmployeeBean>) request.getAttribute("LIST"); 
   for(EmployeeBean e:list)
   {
	  %>
	   <tr>
	     <td> <%=e.getEid()%></td>
	     <td><%=e.getEname()%></td>
	     <td><%=e.getSalary()%></td>
	     <td><%=e.getCity()%></td>
	     <td><%=e.getAddress()%></td>
	     <td><a href="UpdateEmp?empid=<%=e.getEid()%>" class="btn btn-info">Update </a> | <a href="DeleteEmp?empid=<%=e.getEid()%>" onclick="return confirm('Do you really want to delete this record???')" class="btn btn-info">Delete</a></td>
	   </tr>
    <% 	   
      }
    %>
   </table>
   
   
   </div>
   
</body>
</html>