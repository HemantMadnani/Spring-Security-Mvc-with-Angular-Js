<%@ page contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>


<html>
<head>
<title>Login</title>
</head>
<body>

<center><a href="${pageContext.request.contextPath }"><h1>
APEXX PORTAL</h1></a>
	<form:form modelAttribute="user" method="post" action="adduser" ><table><tr><td>
    Email			:</td><td>				<form:input path="email" class="form-control" /></td></tr><tr><td>
    Password		:			</td><td>	<form:password path="password" class="form-control" /></td></tr><tr><td>
    Confirm-Password:				</td><td>	<form:password path="confirmPassword" class="form-control"/></td></tr><tr><td>
			<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" /></td><td>
					<input type="submit" value="Register" class="btn btn-submit">	</td></tr>
		</table>
		
	</form:form>
	${SPRING_SECURITY_LAST_EXCEPTION }
	</center>
	<br><br>
</body>
</html>