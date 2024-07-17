<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Apana Bank - Services</title>
<style type="text/css">
.NewAccount {
	font-size: 20px; margin 0px;
	background-color: #005bb9;
	box-shadow: 0px 0px 2px white;
	text-shadow: 2px 1px black;
}
</style>
</head>
<body>
	<h2>New Account</h2>
	<%
	String msg = (String) request.getAttribute("msg");
	String cls = (String) request.getAttribute("cls");
	if (msg != null) {
		%>
		<p class=<%=cls%>><%=msg %></p>
	<%	
	}
	%>
	<form action="CreateAccount" method="post" id='myForm'>
		<div>
			<label for="userName">User Name:</label>
			<input type="text"	name="userName" id="userName" pattern="^\S{1,50}$" required>
		</div>
		<div>
			<label for="password">Password:</label> <input type="password"
				name="password" id="password" pattern="^\S{1,50}$" required>
		</div>
		<div>
			<label for="rePassword">Re-enter Password:</label> <input
				type="password" name="rePassword" pattern="^\S{1,50}$" id="rePassword" required>
		</div>
		<div>
			<label for="amount">Amount:</label> <input type="number"
				name="amount" id="amount" required min=100>
		</div>
		<div>
			<label for="address">Address:</label> <input type="text"
				name="address" id="address" required maxlength="50">
		</div>
		<div>
			<label for="phone">Phone:</label> <input type="tel" name="phone"
				id="phone" maxlength="10" required >
		</div>
		<div>
			<button type="submit" value=submit>Submit</button>
			<button type="reset">Clear</button>
		</div>
	</form>

	<script type="text/javascript" src="js/script.js"></script>
</body>
</html>

