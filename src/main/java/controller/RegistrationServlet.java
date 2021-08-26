package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Users;
import model.UsersDAO;
import model.UsersDAOImpl;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsersDAO usersDAO=new UsersDAOImpl();
		Users user=new Users();
		String name=request.getParameter("nameR");
		String username=request.getParameter("usernameR");
		String password=request.getParameter("passwordR");
		String password2=request.getParameter("password2R");
		
		user.setName(name);
		user.setUsername(username);
		user.setPassword(password);
		
		
		if(password.equals(password2)) {
			if(usersDAO.usernameControl(username)) {
				usersDAO.insertUsers(user);
				request.setAttribute("message", "qeydiyyatdan ugurla kecdiniz!");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}else {
				request.setAttribute("message", "daxil etdiyiniz username movcuddur");
				request.getRequestDispatcher("registration.jsp").forward(request, response);
				
			}
		}else {
			request.setAttribute("message", "sifreni kontrol edin");
			request.getRequestDispatcher("registration.jsp").forward(request, response);
		}
		
		
		
		
		
		
	}

}
