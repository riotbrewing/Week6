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
	<form action = "createNewGroupServlet" method="post">
		Group Name: <input type = "text" name = "groupName"><br/>
		Party Name: <input type = "text" name = "partyName"><br/>
		Party Size:<input type = "text" name = "numberInParty"><br/>
		
		<h1>Character Details:</h1>
		Character Name: <input type = "text" name = "characterName"><br/>
		Character Class: <input type = "text" name = "characterClass"><br/>
		Character Level: <input type = "text" name = "level"><br/>
		Character Alignment: <input type = "text" name = "alignment"><br/>
		<br>
		<input type = "submit" value = "Create New Group And Add A Character">
	</form>
	<a href = "index.html">Or Create A New Character</a>
</body>
</html>