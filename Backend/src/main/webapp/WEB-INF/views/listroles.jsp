<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Roles List</title>
</head>
<body>
	<a href="${pageContext.request.contextPath }/home"><h1>APEXX
			PORTAL</h1></a>
	<center>
		<h1>List of Roles</h1>
		<table border="1">
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Description</th>
				<th>Authorities Assigned</th>
			</tr>
			<c:forEach var="role" items="${roles }">
				<tr>
					<td>${role.id }</td>
					<td>${role.name }</td>
					<td>${role.description }</td>
					<td><c:forEach var="auths" items="${role.authorities }">
        	 ${auths.name}&nbsp;
        </c:forEach></td>

				</tr>
			</c:forEach>

		</table>
	</center>
</body>
</html>
