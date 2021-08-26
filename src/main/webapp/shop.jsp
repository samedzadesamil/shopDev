<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="model.Users"%>
<%@ page import="model.Product"%>
<%@ page import="java.util.ArrayList"%>

<%
ArrayList<Product> myProducs = (ArrayList<Product>) request.getSession().getAttribute("productList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shop</title>
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
	<form action="productbuy" method="post">
	<input type="text" name="id" placeholder="ID" required="required" />
    <button type="submit" class="btn btn-primary btn-block btn-large">BUY</button>
	</form>
	</div>
	
	<div class="div-shop">
	<a href="home.jsp">
	<img src="image/hm.png"  width="100" height="100"  >
	</a>
</div>
</body>
</html>