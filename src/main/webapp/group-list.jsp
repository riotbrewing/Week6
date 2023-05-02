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
	<form method = "post" action="listNavServlet">
		<table>
			<c:forEach items="${requestScope.groupList}" var = "currentList">
				<tr>
					<td><input type = "radio" name = "id" value = "${currentList.id }"></td>
					<td><h2>${currentList.groupName }</h2></td>
				</tr>
				<tr>
					<td colspan="3">Party Name: ${currentList.party.partyName }</td>
					<td colspan="3">Characters In Party: ${currentList.party.numberInParty }</td>
				</tr>
				<c:forEach var = "listVal" items="${currentList.listOfCharacters }">
					<tr>
						<td></td>
						<td colspan="3">
							${listVal.characterName }, ${listVal.characterClass }, ${ listVal.level }, ${listVal.alignment }
						</td>
					</tr>
				</c:forEach>
			</c:forEach>
		</table>
		<input type = "submit" value = "edit" name = "doThisToList">
		<input type = "submit" value = "delete" name = "doThisToList">
		<input type = "submit" value = "add" name = "doThisToList">
	</form>
	<a href="index.html">Add New Character</a>
	<br />
	<a href="addNewCharactersToGroupServlet">Create a new List</a>
</body>
</html>