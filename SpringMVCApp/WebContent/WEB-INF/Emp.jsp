<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<head>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

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
    <h1>Welcome   ${user}</h1>

  <h1>Employee Form !</h1>
  
  ${msg}
  
 <div class="row" >
<div class="col-sm-6" >
  <form class="form-horizontal" action="insert" method="post" align="center">
   <div class="form-group" align="center">
    <label class="control-label col-sm-2" for="email">Eid:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="eid" name="eid"  required placeholder="Enter Eid">
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="pwd">Name:</label>
    <div class="col-sm-10"> 
      <input type="text" class="form-control" id="pwd" name="ename" placeholder="Enter Name">
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="pwd">Salary:</label>
    <div class="col-sm-10"> 
      <input type="number" class="form-control" id="pwd" name="salary" placeholder="Enter Salary">
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="pwd">City:</label>
    <div class="col-sm-10"> 
     <select class="form-control" id="pwd"  name="city" >
     <option>-select-</option>
     <option>Mumbai</option>
     <option>Pune</option>
     <option>Indore</option>
     <option>Nagpur</option>
     </select>
    </div>
  </div>
  
  <div class="form-group">
    <label class="control-label col-sm-2" for="pwd">Address:</label>
    <div class="col-sm-10"> 
      <textarea name="address" class="form-control" id="pwd" placeholder="Enter Address"></textarea>
    </div>
  </div>
  
  <div class="form-group"> 
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-primary">Submit</button>
    </div>
 </div>
</form>
</div></div></div>
</body>
</html>