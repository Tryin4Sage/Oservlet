<%@ page pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<title>用户管理</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="css/style.css" />
	</head>
	<body>
		<div id="wrap">
			<div id="top_content"> 
			
				<%@include file="header.jsp" %>
				
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						欢迎!
					</h1>
					<table class="table">
						<tr class="table_header">
							<td>ID</td>
							<td>用户名</td>
							<td>年龄</td>
							<td>Phone</td>
							<td>操作</td>
						</tr>
						<c:forEach items="${users }" var="user" varStatus="i">
						<tr class="row${i%2+1 }">
							<td>${user.id }</td>
							<td>${user.name }</td>
							<td>${user.age }</td>
							<td>${user.phone }</td>
							<td><a href="del.do?id=${user.id }" 
							 onclick="return confirm('确认删除<${user.name }吗?');">delete</a>&nbsp;</td>
						</tr>
						</c:forEach>
					</table>
					<p>
						<input type="button" class="button" value="添加用户" 
						onclick="location='add.jsp'"/>
						<input type="button" class="button" value="测试登陆" 
						onclick="location='login.jsp'"/>
					</p>
				</div>
			</div>
			<div id="footer">
				<div id="footer_bg" align="right">
				@github:Tryin4Sage
				</div>
			</div>
		</div>
	</body>
</html>