<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
<a href="${pageContext.request.contextPath }/home"><h1>
APEXX PORTAL</h1></a>
        <h1>Hello User!</h1>
       <p><h2 style="color:red">Welcome to Portal!!!</h2>
   
        </p>
         <pre>
        <a href="${pageContext.request.contextPath }/home/addauthority">Add an Authority</a>	<a href="${pageContext.request.contextPath }/home/viewauthority">View Authorities</a>
        <br/>
        <a href="${pageContext.request.contextPath }/home/addrole">Add Role</a>	<a href="${pageContext.request.contextPath }/home/viewroles">View Roles</a>
        <br/>
        <sec:authorize access="hasRole('ROLE_ADMIN')">
        <a href="${pageContext.request.contextPath }/home/listusers">Users</a>
        </sec:authorize>
        
        </pre>
       
        <a href="${pageContext.request.contextPath }/logout">Logout?</a>
    </body>
</html>
