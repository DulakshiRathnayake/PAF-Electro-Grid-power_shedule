<%@page import="Frontend.pshedulerRepository"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Powercut Schedule Management</title>
<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.2.1.min.js"></script>
<script src="Components/items.js"></script>
</head>
<body> 
<div class="container"><div class="row"><div class="col-6"> 
<h1>Powercut Schedule Manager</h1>
<form id="formschedule" name="formschedule">
 Powercut Shedule ID: 
 <input id="pLid" name="pLid" type="text" 
 class="form-control form-control-sm">
 <br> Duration: 
 <input id="pduration" name="pduraton" type="text" 
 class="form-control form-control-sm">
 <br> Location: 
 <input id="plocation" name="plocation" type="text" 
 class="form-control form-control-sm">
 <br> Reason: 
 <input id="preason" name="preason" type="text" 
 class="form-control form-control-sm">
 <br>Description: 
 <input id="pdesc" name="pdesc" type="text" 
 class="form-control form-control-sm">
 <input id="btnSave" name="btnSave" type="button" value="Save" 
 class="btn btn-primary">
 <input type="hidden" id="hidItemIDSave" 
 name="hidItemIDSave" value="">
</form>
<div id="alertSuccess" class="alert alert-success"></div>
<div id="alertError" class="alert alert-danger"></div>
<br>
<div id="divItemsGrid">
 <%
 pshedulerRepository pshedulerObj = new pshedulerRepository(); 
 out.print(pshedulerObj.getPshedulers()); 
 %>
</div>
</div> </div> </div> 
</body>
</html>