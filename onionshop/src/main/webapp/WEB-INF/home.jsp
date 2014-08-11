<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	
	<div>
		<h2>Uzytkownicy:</h2>
		<ol class="user-list">
			<c:forEach var="users" items="${getall}">
				<c:out value="${users.name}" />
			</c:forEach>
		</ol>
	</div>
	<a href="registration">Zarejestruj sie w Hapajto!</a>
</body>
</html>