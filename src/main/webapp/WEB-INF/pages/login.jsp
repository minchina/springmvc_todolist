<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ncmao
  Date: 8/28/15
  Time: 11:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<%

  String errorString = (String)request.getAttribute("error");
  if(errorString != null && errorString.trim().equals("true")){
    out.println("Incorrect login name or password. Please retry using correct login name and password.");
  }
%>
<c:url value="/j_spring_security_check" var="loginUrl" />

<form name='f' action='${loginUrl}' method='POST'>

  <c:if test="${param.error != null}">
    <p>
      Invalid username and password.
    </p>
  </c:if>
  <c:if test="${param.logout != null}">
    <p>
      You have been logged out.
    </p>
  </c:if>
  <table>
    <tr><td>User:</td><td><input type='text' name='j_username' id="loginUser" value=''></td></tr>
    <tr><td>Password:</td><td><input type='password' name='j_password' id="loginPass"/></td></tr>
    <tr><td colspan='2'><input name="submit" type="submit" value="Login" id="login"/></td></tr>
  </table>
</form>

</body>
</html>
