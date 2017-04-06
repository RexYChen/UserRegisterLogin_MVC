<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>User Register</title>
</head>

<body style="text-align: center;">
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/ShowCalendar.js"></script>
	<form
		action="${pageContext.request.contextPath}/servlet/RegisterServlet"
		method="post">
		<table width="60%" border="1">
			<tr>
				<td>Username</td>
				<td>
					<input type="text" name="username" value=${form.username}>
					<span class="message">${form.errorsMap.username}</span>
				
				</td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password" value=${form.password}>
					<span class="message">${form.errorsMap.password}</span>
				</td>
			</tr>
			<tr>
				<td>Confirm password</td>
				<td><input type="password" name="password2" value=${form.password2} >
					<span class="message">${form.errorsMap.password2}</span>
				</td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="text" name="email" value=${form.email}>
					<span class="message">${form.errorsMap.email}</span>
				</td>
			</tr>
			<tr>
				<td>Birthday</td>
				<td>
					<input name="birthday" type="text" id="birthday" title="Click Seclect" onClick="showCalendar(this.id)" value=${form.birthday}>
					<span class="message">${form.errorsMap.birthday}</span>
				</td>
			</tr>
			<tr>
				<td><input type="reset" value="Reset"></td>
				<td><input type="submit" value="Submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>