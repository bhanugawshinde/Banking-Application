<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Apana Bank - Services</title>
<style type="text/css">
.CheckBalance{
font-size: 20px;
margin 0px;
background-color: #005bb9;
box-shadow: 0px 0px 2px white;
text-shadow: 2px 1px black;
}
</style></head>
<body>
<h2>Check Balance</h2>
	<%
	String msg = (String) request.getAttribute("msg");
	String cls = (String) request.getAttribute("cls");
	if (msg != null) {
		%>
		<p class=<%=cls%>><%=msg %></p>
	<%	
	}
	%>
	<form action="Balance" method="post" id='myForm'>
		<div>
			<label for="userName">User Name:</label> <input type="text"
				name="userName" id="userName" required>
		</div>
		<div>
			<label for="password">Password:</label> <input type="password"
				name="password" id="password" required>
		</div>

		<div>
			<button type="submit" value=submit>Submit</button>
			<button type="reset">Clear</button>
		</div>
	</form>

	<script type="text/javascript" src="js/script.js"></script>
</body>
</html>

