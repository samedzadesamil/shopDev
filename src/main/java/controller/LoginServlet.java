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
import model.UsersDAO;
import model.UsersDAOImpl;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static int userID;

 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsersDAO usersDAO=new UsersDAOImpl();
		ProductDAO productDAO=new ProductDAOImpl();
		String username=request.getParameter("u");
		String password=request.getParameter("p");
		Users user=usersDAO.getUsers(username, password);
		userID=user.getId();
		ArrayList<Product> list=new ArrayList<Product>();
		
		
		if(user.getName()!=null) {
		request.getSession().setAttribute("user", user);
		list=productDAO.getMyProductList(user.getId());		
		request.getSession().setAttribute("productList", list);
		request.getRequestDispatcher("home.jsp").forward(request, response);
		}else {
			request.setAttribute("message", "giris bilgisi sehvdir");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
		
	}

}
