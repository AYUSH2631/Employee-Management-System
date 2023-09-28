package in.ayushsinha.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.ayushsinha.dao.loginDAO;
import in.ayushsinha.dao.loginDAOimpl;
import in.ayushsinha.entity.login;



public class loginController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	loginDAO loginDAO = null;
	
	public loginController() {
		loginDAO = new loginDAOimpl();
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		login login = new login();
		login.setEmail(request.getParameter("email"));
		login.setPassword(request.getParameter("password"));
		
		
		String result=loginDAO.authenticate(login);
		
		if(result.equals("true")){
			session.setAttribute("email",login.getEmail());
			response.sendRedirect("EmployeeController?action=LIST");
		}
		 
		if(result.equals("false")){
			response.sendRedirect("index.jsp?status=false");
		}
		 
		if(result.equals("error")){
		    response.sendRedirect("index.jsp?status=error");
		}
		
	}
}
