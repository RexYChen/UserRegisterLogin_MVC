<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored ="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
  </head>
  
  <body style="text-align:center;">
  
  	<h2>Welcome xxxxxx home</h2>
  	<br/>
  	<div style="text-align:right;">
  	<c:if test="${user!=null}">
  		Welcome: ${user.username}
  		<a href="${pageContext.request.contextPath}/servlet/SignoutServlet">SIGN OUT</a>
  	</c:if>
  	
  	<c:if test="${user == null}">
  		<a href="${pageContext.request.contextPath}/servlet/RegisterUIServlet">SIGN UP</a>
    	<a href="${pageContext.request.contextPath}/servlet/LoginUIServlet">SIGN IN</a>
  	</c:if>
    </div>
  </body>
</html>
