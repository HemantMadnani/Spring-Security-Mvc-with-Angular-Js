<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Authority List</title>
    </head>
    <body>
<a href="${pageContext.request.contextPath }/home"><h1>
APEXX PORTAL</h1></a>
   <center>     <h1>List of Authorities</h1>
        <table border="1">
        <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Description</th>
        <th>Actions</th>
        </tr>
        <c:forEach var="auth" items="${authorities }">
        <tr>
        <td>${auth.id }</td>
        <td>${auth.name }</td>
        <td>${auth.description }</td>
        <td>
        <a href="${pageContext.request.contextPath }/home/auth/update/${auth.id }"><button>Update</button></a>
        <a href="${pageContext.request.contextPath }/home/auth/view/${auth.id }"><button>View</button></a>
        <a href="${pageContext.request.contextPath }/home/auth/delete/${auth.id }"><button>Delete</button></a>
        </td>
        </tr>
        
        </c:forEach>
        
        </table></center>
    </body>
</html>
