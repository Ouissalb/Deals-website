package ma.ac.ensa.presentation.actions;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ma.ac.ensa.dao.BaseDAO;
import ma.ac.ensa.metier.UtilisateurMe;
import ma.ac.ensa.model.Utilisateur;

//@WebServlet("/signUp")
public class LoginServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 13L;
	protected Utilisateur user;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException 
	{ 
		boolean successfullyConnected = true;
		try 
		{
           
			String errorMsg = null;
			user = new Utilisateur(null, null, null, null);
			user.setEmail(request.getParameter("email"));
			user.setPassword(request.getParameter("password"));
			user = BaseDAO.login(user);
			
			
			if (user.getRole().equals("admin"))
			{
				HttpSession session = request.getSession(true);
				
				session.setAttribute("currentSessionUser",user);
				
				response.sendRedirect(request.getContextPath() +"/adminPanel");
				successfullyConnected = true;
				request.setAttribute("successfullyConnected", successfullyConnected );
			}
			else if (user.getRole().equals("client"))
			{
				System.out.println("CLIENT IS LOGGED IN");
				HttpSession session = request.getSession(true);
				session.setAttribute("currentSessionUser",user);
				successfullyConnected = true;
				request.setAttribute("successfullyConnected", successfullyConnected );
				request.getRequestDispatcher("/vues/index-logged-out.jsp").forward(request, response);
			}
				
			
			if (user == null) 
			{
				errorMsg = "Login et/ou mot de passe incorrectes";
				successfullyConnected = false;
				request.setAttribute("successfullyConnected", successfullyConnected );
				request.setAttribute("error", errorMsg );
				request.getRequestDispatcher("/vue/index-logged-out.jsp").forward(request, response);
			}
		} 
		catch (Throwable theException) 
		{ 
			System.out.println(theException);
			theException.printStackTrace();
		} 
	} 

}
