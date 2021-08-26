<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="model.Users"%>
<%@ page import="model.Product"%>
<%@ page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
<%
ArrayList<Product> myProducs = (ArrayList<Product>) request.getSession().getAttribute("productList");
Users users = (Users) request.getSession().getAttribute("user");
%>
<head>
<meta charset="ISO-8859-1">
<title>
	<%
	out.write(users.getName());
	%>
</title>
<link rel="stylesheet" href="css/homeStyle.css">
</head>
<body>

	<div class="div-table">
		<table class="styled-table">
			<thead>
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Category</th>
					<th>Count</th>
					<th>Price/$</th>
				</tr>
			</thead>
			<tbody>

				<%
				for (int i = 0; i < myProducs.size(); i++) {
				%>
				<tr>
					<th><%=myProducs.get(i).getId()%></th>
					<th><%=myProducs.get(i).getName()%></th>
					<th><%=myProducs.get(i).getCategory()%></th>
					<th><%=myProducs.get(i).getCount()%></th>
					<th><%=myProducs.get(i).getPrice()%></th>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
	</div>
	
	
	<div class="div-add">
	<form action="addProduct" method="post">
	<input type="text" name="name" placeholder="Product name" required="required" />
     <input type="text" name="category" placeholder="Category" required="required" />
     <input type="number" name="count" placeholder="Count" required="required" />
     <input type="number" name="price" placeholder="Price" required="required" />
     <button type="submit" class="btn btn-primary btn-block btn-large">Sell</button>
	</form>
	</div>
	
	<div class="div-remove">
	<form action="removeProduct" method="post">
	<input type="text" name="id" placeholder="ID" required="required" />
    <button type="submit" class="btn btn-primary btn-block btn-large">Delete</button>
	</form>
	</div>
	
	<div class="div-shop">
	<a href="shop">
	<img src="image/sh.png"  width="100" height="100"  >
	</a>
	
	
	
	</div>


</body>
</html>