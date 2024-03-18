<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
   <h2>User Details</h2>
   <% String username=(String)request.getAttribute("username");
   out.print("Welcome "+username);
   %>
  <form action="movieservlet">
  select language<select name="language">
  <option value="English">English</option>
  <option value="Kannada">Kannada</option>
  <option value="Telugu">Telugu</option>
  <option value="Tamil">Tamil</option>
  </select>
  <input type="submit" value="show movies">
  </form>
</body>
</html>