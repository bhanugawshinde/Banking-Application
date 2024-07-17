<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Apana Bank - Services</title>
<style type="text/css">
.Transfer{
font-size: 20px;
margin 0px;
background-color: #005bb9;
box-shadow: 0px 0px 2px white;
text-shadow: 2px 1px black;
}
</style>
</head>
<body>
<h2>Transfer</h2>
	<%
	String msg = (String) request.getAttribute("msg");
	String cls = (String) request.getAttribute("cls");
	if (msg != null) {
		%>
		<p class=<%=cls%>><%=msg %></p>
	<%	
	}
	%>
	<form action="Transfer" method="post" id='myForm'>
		<div>
			<label for="accountNo">Account No: </label> <input type="text"
				name="accountNo" id="accountNo" required>
		</div>
		<div>
			<label for="userName">User Name:</label> <input type="text"
				name="userName" id="userName" required>
		</div>
		<div>
			<label for="password">Password:</label> <input type="password"
				name="password" id="password" required>
		</div>
		<div>
			<label for="amount">Amount: </label> <input type="number"
				name="amount" id="amount" required>
		</div>
		<div>
			<p>Transfer To:</p>


			<div>
				<label for="accountNo2">Account No: </label> <input type="text"
					name="accountNo2" id="accountNo2" required>
			</div>
			<div>
				<label for="userName2">User Name:</label> <input type="text"
					name="userName2" id="userName2" required>
			</div>
		</div>
		<div>
			<button type="submit" value=submit>Submit</button>
			<button type="reset">Clear</button>
		</div>

	</form>

	<script type="text/javascript" src="js/script.js"></script>
</body>
</html>

