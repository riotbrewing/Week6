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
	<form method = "post" action = "navServlet">
	  <table>
		<c:forEach items="${requestScope.viewAll}" var="currentcharacter">
			<tr>
				<td><input type="radio" name="id" value="${currentcharacter.id}"></td>
				<td>${currentcharacter.characterName}</td>
				<td>${currentcharacter.characterClass}</td>
				<td>${currentcharacter.level}</td>
				<td>${currentcharacter.alignment}</td>
			</tr>
		</c:forEach>
	  </table>
	  <input type = "submit" value = "edit" name = "changeCharacter">
	  <input type = "submit" value = "delete" name = "changeCharacter">
	  <input type = "submit" value = "add" name = "changeCharacter">
  </form>
</body>
</html>