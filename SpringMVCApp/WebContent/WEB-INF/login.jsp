<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>
 <div class="container" align="center"> 
<font color="red">
<%
   String m=(String)request.getAttribute("msg");
  if(m!=null)
  out.println(m);
%>
</font>
  <h1>Login Form</h1>
  <form action="LoginCheck" method="post">
 <p> UID  <input type="text" name="uid" /> </p>
  <p>Password<input type="password" name="pwd" /></p>
  <p><input type="submit" class="btn btn-info" value="Login"/></p>
   </form>
   </div> 
</body>
</html>




