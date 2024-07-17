<!DOCTYPE html>
<%@page import="bean.UserBean"%>
<html>
<head>
<meta charset="UTF-8">
<title>Apana Bank - Services</title>
<style type="text/css">
.Balance{
font-size: 20px;
margin: 0px;
background-color: #005bb9;
box-shadow: 0px 0px 2px white;
text-shadow: 2px 1px black;
}
</style></head>
<body>
<h2>Balance</h2>

	<%
	UserBean userBean = (UserBean) request.getAttribute("userBean");
	if (userBean != null) {
	%>
	<table style="width: 100%">
		<tr>
			<td>AccountNo</td>
			<td><%=userBean.getAccountNo()%></td>
		</tr>
		<tr>
			<td>User Name</td>
			<td><%=userBean.getUserName()%></td>
		</tr>
		<tr>
			<td>Amount</td>
			<td><%=userBean.getAmount()%></td>
		</tr>
	</table>

	<%
	}
	%>

	<script type="text/javascript" src="js/script.js"></script>
</body>
</html>

