<%@ page language="java" pageEncoding="UTF-8"%>
 <!DOCTYPE HTML>
 <html>
   <head>
     <title>User Login</title>
   </head>
   
   <body>
     <form action="${pageContext.request.contextPath }/servlet/LoginServlet" method="post">
         Username：<input type="text" name="username"><br/>
         Password：<input type="password" name="password"><br/>
         <input type="submit" value="Sign In">
     </form>
   </body>
 </html>