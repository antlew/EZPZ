<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="EzpzStyle.css">
<title>Insert title here</title>
</head>
<body>

	<div id="header">
		<h1>
			<i>Easy Peasy</i>
		</h1>
	</div>

	<div id="nav">
		<ul>
			<li><a class="active" href="#home">Home</a></li>
			<li><a href="">Meals</a></li>
			<li><a href="">Recipes</a></li>
			<li><a href="">About</a></li>
		</ul>
	</div>

	<table>

		<tr>
			<td><select id="opts" onchange="showForm()">
					<option value="0">Select Meat</option>
					<option value="chicken">Chicken</option>
					<option value="beef">Beef</option>
					<option value="pork">Pork</option>
					<option value="fish">Fish</option>
			</select>

				<div id="f1" style="display: none">
					<form name="form1">
						<select id="opts" onchange="showForm()">
							<option value="0">Shepard's Pie</option>
							<option value="1">Chicken Tacos</option>
							<option value="2">Chicken Alfredo</option>
						</select>
					</form>
				</div>

				<div id="f2" style="display: none">
					<form name="form2">
						<select id="opts" onchange="showForm()">
							<option value="0">Ribs</option>
							<option value="1">Lasagna</option>
							<option value="2">Spaghetti with Meatballs</option>
						</select>
					</form>
				</div>
				<div id="f3" style="display: none">
					<form name="form3">
						<select id="opts" onchange="showForm()">
							<option value="0">Pork Ribs</option>
							<option value="1">Meatloaf</option>
							<option value="2">Pork Chops</option>
						</select>
					</form>
				</div>
				<div id="f4" style="display: none">
					<form name="form4">
						<select id="opts" onchange="showForm()">
							<option value="0">Fish Tacos</option>
							<option value="1">Salmon</option>
							<option value="2">Tuna Casserole</option>
						</select>
					</form>
				</div></td>
		</tr>
	</table>

	<div id="footer">Copyright © EZPZ</div>

	<script type="text/javascript">
		function showForm() {
			var selopt = document.getElementById("opts").value;
			if (selopt == "chicken") {
				document.getElementById("f1").style.display = "block";
				document.getElementById("f2").style.display = "none";
				document.getElementById("f3").style.display = "none";
				document.getElementById("f4").style.display = "none";
			}
			if (selopt == "beef") {
				document.getElementById("f2").style.display = "block";
				document.getElementById("f1").style.display = "none";
				document.getElementById("f3").style.display = "none";
				document.getElementById("f4").style.display = "none";
			}
			if (selopt == "pork") {
				document.getElementById("f2").style.display = "none";
				document.getElementById("f1").style.display = "none";
				document.getElementById("f3").style.display = "block";
				document.getElementById("f4").style.display = "none";
			}
			if (selopt == "fish") {
				document.getElementById("f2").style.display = "none";
				document.getElementById("f1").style.display = "none";
				document.getElementById("f3").style.display = "none";
				document.getElementById("f4").style.display = "block";
			}
		}
	</script>

</body>
</html>