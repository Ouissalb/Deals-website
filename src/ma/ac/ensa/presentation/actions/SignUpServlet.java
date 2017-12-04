package ma.ac.ensa.presentation.actions;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ma.ac.ensa.dao.BaseDAO;
import ma.ac.ensa.metier.UtilisateurMe;
import ma.ac.ensa.model.Utilisateur;

//@WebServlet("/signUp")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 102L;
	
	private String username;
	private String password;
	private String passwordConf;
	private String email;
	private String role = "client";
	protected Utilisateur user;
	
	// ERROR MESSAGES
	String errorMsgEmail;
	String errorMsgUsername;
	String errorMsgPassword;
	

    public SignUpServlet() {
        // TODO Auto-generated constructor stub
    }

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		errorMsgEmail = null;
		errorMsgUsername = null;
		errorMsgPassword = null;
	
		
		username = request.getParameter("username");
		password = request.getParameter("password");
		passwordConf = request.getParameter("passwordC");
		email = request.getParameter("email");
		
		System.out.println("username : "+username);
		System.out.println("password : "+password);
		System.out.println("passwordConf : "+passwordConf);
		System.out.println("email : "+email);
		
		//DEBUG
		if (usernameCorrect(username))
			System.out.println("username CORRECT");
		else
			System.out.println("username INCORRECT");
		
		if (passwordCorrect(password, passwordConf))
			System.out.println("password CORRECT");
		else
		{
			System.out.println("password INCORRECT");
			System.out.println(errorMsgPassword);
		}
		
		if (emailCorrect(email))
			System.out.println("email CORRECT");
		else
			System.out.println("email INCORRECT");
		
		if (
				usernameCorrect(username) 
				&& passwordCorrect(password, passwordConf)
				&& emailCorrect(email)
			)
		{
			System.out.println("Everything's correct");
			
			try {
				user = new Utilisateur(username, UtilisateurMe.hashPassword(password), email, role);
				BaseDAO.createUser(user);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			request.getRequestDispatcher("/vues/index-logged-out.jsp").forward(request, response);
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public boolean usernameCorrect(String clientUsername)
	{
		if (BaseDAO.usernameTaken(clientUsername))
		{
			errorMsgUsername = "Ce nom d'utilisateur existe déjà !";
			return false;
		}
		else if (clientUsername.length() < 3 || clientUsername.length() > 14)
		{
			errorMsgUsername = "Le nombre de caractères du username doit être compris entre 4 et 14";
			return false;
		}
		return true;
	}
	
	
	public boolean passwordCorrect(String clientPassword, String passwordConf)
	{
		if (clientPassword.length() < 6 || clientPassword.length() > 16)
		{
			errorMsgPassword = "Le nombre de caractères du mot de passe doit être compris entre 6 et 16";
			return false;
		}
		else if (!clientPassword.equals(passwordConf))
		{
			errorMsgPassword = "Passwords don't match";
			return false;
		}
		return true;		
	}
	
	
	public boolean emailCorrect(String clientEmail)
	{
		if (clientEmail.length() < 8 )
		{
			errorMsgEmail = "L'email est incorrecte";
			return false;
		}
		else if ( clientEmail.length() > 40)
		{
			errorMsgEmail = "Vérifier votre adresse email";
			return false;
		}
		else if ( BaseDAO.emailTaken(clientEmail))
		{
			errorMsgEmail = "Un compte existe déjà avec cette adresse mail";
			return false;
		}
		return true;		
	}

}
