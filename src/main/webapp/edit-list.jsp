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
	<form action = "editGroupDetialsServlet" method = "post">
		<input type = "hidden" name = "id" value = "${groupToEidt.id }">
		Group Name: <input type = "text" name = "groupName" value = "${groupToEdit.groupName }">
		Party Name: <input type = "text" name = "partyName" value = "${groupToEdit.party.partyName }">
		Party Size: <input type = "text" name = "partyName" value = "${groupToEdit.party.numberInParty }">
		
		<c:forEach var = "listVal" items="${groupToEdit.listOfCharacters }">
					<tr>
						<td></td>
						<td colspan="3">
							${listVal.characterName }, ${listVal.characterClass }, ${ listVal.level }, ${listVal.alignment }
						</td>
					</tr>
				</c:forEach>

		<input type = "submit" value= "Edit List and Add Items">
	</form>
</body>
</html>