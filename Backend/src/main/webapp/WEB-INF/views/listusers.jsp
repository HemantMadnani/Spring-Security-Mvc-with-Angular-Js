<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Users List</title>
    </head>
    <body>
<a href="${pageContext.request.contextPath }/home"><h1>
APEXX PORTAL</h1></a>
   <center>     <h1>List of Users</h1>
        <table border="1">
        <tr>
        <th>ID</th>
        <th>Email</th>
        <th>Status</th>
        <th>Roles Assigned</th>
        </tr>
        <c:forEach var="user" items="${users }">
        <tr>
        <td>${user.id }</td>
        <td>${user.email }</td>
        <td><c:choose><c:when test="${user.active }">Active</c:when><c:otherwise>Inactive</c:otherwise></c:choose></td>
        <td><c:forEach var="roles"  items="${user.roles }">
        	 ${roles.name}&nbsp;
        </c:forEach></td>
        
        </tr>
        </c:forEach>
        
        </table></center>
    </body>
</html>
