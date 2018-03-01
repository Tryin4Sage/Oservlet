<%@page pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<html>
	<head>
		<title>登陆</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css"
			href="css/style.css" />
	</head>

	<body>
		<div id="wrap">
			<div id="top_content">
			
				<%@include file="header.jsp" %>
					
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						用户登陆:
					</h1>
					<form action="login.do" method="post">
						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">
							<tr>
								<td valign="middle" align="right">
									用户名:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="name" />
									<span style="color: red; font-size: 24px;">${login_fil }</span>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									手机号:
								</td>
								<td valign="middle" align="left">
									<input type="password" class="inputgri" name="phone" />
								</td>
							</tr>
						</table>
						<p>
							<input type="submit" class="button" value="确定" />
						</p>
					</form>
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
