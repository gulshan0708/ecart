<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register Here</title>


</head>
<body>


	<!--  RegisterServlet  form -->
	<form:form method="post" action="customer/registration">

		<center>User Details</center>

	First Name:
	<input type="text" placeholder="Enter First Name.." name="firstName"></input>

		<br>


	Last Name:
	<input type="text" placeholder="Enter Last Name.." name="lastName"></input>
		<br>

	Email Id:
	<input type="text" placeholder="Enter Email ID.." name="emailId"></input>
		<br>


	Phone Number: 
	<input type="text" placeholder="Enter Phone Number.." 	name="phoneNo">	</input>
	
	Password: 
	<input type="password" placeholder="Enter Password.." 	name="password">	</input>

		<hr />
		<br>
		<div>
			<center>Shipping Address</center>
		</div>

	Address: 	
	<textarea type="text" placeholder="Enter Shipping Address.." name="shippingAddress.address"></textarea>

		<br>

	City:
	<input type="text" placeholder="Enter Current City.."  name="shippingAddress.city"></input>
		<br>

	State:
	<input type="text" placeholder="Enter your State.."  name="shippingAddress.state"></input>

		<br>

	Country:
	<input type="text" placeholder="Enter your country.." 	name="shippingAddress.country"></input>
		<br>

	Zipcode:
	<input type="text" placeholder="Enter zipcode.." 		name="shippingAddress.zipcode"></input>

	<hr>
	<div>
		<center>Billing Address</center>
	</div>
	Address:
	<textarea type="text" placeholder="Enter Billing Address.." 	 name="billingAddress.address"></textarea>

		<br>
	City:
	<input type="text" placeholder="Enter your City.." 
					name="billingAddress.city"></input>

		<br>
	State:
	<input type="text" placeholder="Enter your state.."
					class="form-control" name="billingAddress.state"></input>

		<br>
	Country:
	<input type="text" placeholder="Enter your City.."
					name="billingAddress.country"></input>

		<br>
	Zipcode:
	<input type="text" placeholder="Enter Zipcode.."
					name="billingAddress.zipcode"></input>

		<br>
		<hr />

	Password:
	<input type="password" placeholder="********" class="form-control"
					name="users.password" id="pass"></input>
		<br>
	confirm password:	<input type="password" placeholder="********" 		class="form-control" id="confirmpass" />
	
	
	<div class="form-actions">
		<button type="submit" class="btn btn-lg btn-info"
						onclick="return Validate()">Submit</button>
	</div>
	




	</form:form>
</body>
</html>