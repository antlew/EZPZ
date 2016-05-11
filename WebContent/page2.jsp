<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
    <%@ page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" type="text/css" href="EzpzStyle.css">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<div id="header">
<h1><i>This is a heading</i></h1>
</div>

<div id ="nav">
<ul>
  <li><a class="active" href="#home">Home</a></li>
  <li><a href="">Meals</a></li>
  <li><a href="">Recipes</a></li>
  <li><a href="">About</a></li>
</ul>
</div>

<% ArrayList<String> result = (ArrayList<String>) request.getAttribute("meals");
for(String a : result){
	out.println(a);
}

%>


<div id="footer">
Copyright © EZPZ
</div>

</body>
</html>


