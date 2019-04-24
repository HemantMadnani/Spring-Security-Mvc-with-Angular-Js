<%@ page contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>


<html>
<head>
<title>Login</title>
</head>
<body>
<a href="${pageContext.request.contextPath }"><h1>
APEXX PORTAL</h1></a>
<pre>
<c:if test="${param.error }">
<p style="color:red">Invalid username or password</p>
</c:if>
	<c:url var="loginUrl" value="authLog"></c:url>
	<form:form modelAttribute="user" method="post" action="${loginUrl }" >
    Username:				<form:input path="email" class="form-control" />
    Password:				<form:password path="password" class="form-control" />
			<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
					<input type="submit" value="Login" class="btn btn-submit">
		
		
	</form:form>
	${SPRING_SECURITY_LAST_EXCEPTION }
	</pre>
	<br><br>
</body>
</html>