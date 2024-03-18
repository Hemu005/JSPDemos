<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="errorHandler.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome to JS</h1>
<% String name="Hemu";%>
 <%="welcome "+name%>
<% int x=10;int y=20;%>
<%="Sum ="+ (x+y)%>

<% int counter=0; %>
You are visitor no:<%= ++counter %>
<br>
<%! String greet(){
	return "Welcome back";
	}
%>
<%= greet() %>
<%=counter++%>
<% int x=10/0; %>
</body>
</html>