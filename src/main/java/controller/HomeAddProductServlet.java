package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Product;
import model.ProductDAO;
import model.ProductDAOImpl;
import model.Users;

@WebServlet("/addProduct")
public class HomeAddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProductDAO productDAO=new ProductDAOImpl();
		ArrayList<Product> list=new ArrayList<Product>();
		Product product=new Product();
		product.setName(request.getParameter("name"));
		product.setCategory(request.getParameter("category"));
		product.setCount(Integer.valueOf(request.getParameter("count")));
		product.setPrice(Integer.parseInt(request.getParameter("price")));
		product.setOwner(LoginServlet.userID);
		productDAO.addProduct(product);
		
		list=productDAO.getMyProductList(LoginServlet.userID);
		request.getSession().setAttribute("productList", list);
		request.getRequestDispatcher("home.jsp").forward(request, response);
		
		
		


	}
	
}
