
<%@page import="bean.UserBean"%>
<html>
<head>
<title>Insert title here</title>
<style type="text/css">
.Account{
font-size: 20px;
margin 0px;
background-color: #005bb9;
box-shadow: 0px 0px 2px white;
text-shadow: 2px 1px black;
}
</style>
</head>
<body>
<h2>Account</h2>
	<%
	UserBean userBean = (UserBean) request.getAttribute("userBean");
	String msg = (String) request.getAttribute("msg");
	String cls = (String) request.getAttribute("cls");
	if (userBean != null) {
		%>
		<p class=<%=cls%>><%=msg %></p>
	<br>
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
		<tr>
			<td>Address</td>
			<td><%=userBean.getAddress()%></td>
		</tr>
		<tr>
			<td>Phone</td>
			<td><%=userBean.getPhone()%></td>
		</tr>
	</table>

	<%
	}
	%>
</body>
</html>
