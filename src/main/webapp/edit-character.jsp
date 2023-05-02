<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action = "editCharacterServlet" method = "post">
		<input type="text"  name ="characterName" value = "${changeCharacter.characterName }">
		<input type="text"  name ="characterClass" value = "${changeCharacter.characterClass }">
		<input type="text"  name ="level" value = "${changeCharacter.level }">
		<input type="text"  name ="alignment" value = "${changeCharacter.alignment }">
		<input type="hidden" name = "id" value = "${changeCharacter.id }">
		<input type="submit" value = "Edit Cast Member" >
	</form>
</body>
</html>