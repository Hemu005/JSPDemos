<%@ page import="java.util.*" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSTL</title>
</head>
<body>
<% request.setAttribute("message", "Great Day"); %>
<% String mess1=(String)request.getAttribute("message");
out.println(mess1);%><br>
<%=mess1 %><br>
<h1>Today is a ${message}</h1><br>
<c:out value="Today is a ${message }"></c:out>

<c:set var="mess" value="Good Day" scope="session"></c:set>
${sessionScope.mess}
<c:out value="Today is a ${mess }"></c:out>

<% List<String> fruits=
    Arrays.asList("apple","guava","mango","banana","kiwi");
    session.setAttribute("fruitsList", fruits);
    %>
<h2>Using EL</h2>
${fruitsList }<br>

<h2>Using c:forEach</h2>
<c:forEach items="${fruitsList }" var="fruit" step="2">
${fruit}<br>
</c:forEach>  
</body>
</html>