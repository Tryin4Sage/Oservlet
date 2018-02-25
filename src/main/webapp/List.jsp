<%@page import="java.text.SimpleDateFormat"%>
<%@ page pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@ page import="java.util.*,entity.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>用户管理</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="css/style.css" />
	</head>
	<body>
		<div id="wrap">
			<div id="top_content"> 
				<div id="header">
					<div id="rightheader">
						<p>
							<%=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()) %>
							<br />
						</p>
					</div>
					<div id="topheader">
						<h1 id="title">
							<a href="#">团结</a>
						</h1>
					</div>
					<div id="navigation">
					</div>
				</div>
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
						<%
							List<User> users = (List<User>)request.getAttribute("users");
							for(int i=0; i< users.size(); i++){
								User user = users.get(i);
						%>
						<tr class="row<%=i%2+1 %>">
							<td><%=user.getId() %></td>
							<td><%=user.getName() %></td>
							<td><%=user.getAge()%></td>
							<td><%=user.getPhone() %></td>
							<td><a href="del.do?id=<%=user.getId()%>" 
							 onclick="return confirm('确认删除<%=user.getName()%>吗?');">delete</a>&nbsp;</td>
						</tr>
						<%
							}
						%>
					</table>
					<p>
						<input type="button" class="button" value="添加用户" 
						onclick="location='add.jsp'"/>
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