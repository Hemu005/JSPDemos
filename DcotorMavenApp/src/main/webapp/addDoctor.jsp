<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>
	<form action="addServlet">
		Enter your name <input type="text" name="doctorname"><br>
		Enter your speciality <select name="speciality">
			<option value=null></option>
			<option value="ORTHOPEDIATRICIAN">ORTHOPEDIATRICIAN</option>
			<option value="PEDIATRICIAN">PEDIATRICIAN</option>
			<option value="GENERAL PHYSICIAN">GENERAL PHYSICIAN</option>
			<option value="GYNAECOLOGIST">GYNAECOLOGIST</option>
			<option value="NEUROLOGY">NEUROLOGY</option>
			<option value="DERMATOLOGIST">DERMATOLOGIST</option>
		</select><br> Enter your experience<input type="text" name="experience"><br>
		Enter your rating<input type="text" name="rating"><br>
		Enter your consultation fees<input type="text" name="fees"><br>
		<input type="submit" name="submit">
	</form>
</body>
</html>