package ma.ac.ensa.presentation.actions;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import ma.ac.ensa.dao.BaseDAO;
import ma.ac.ensa.metier.UtilisateurMe;
import ma.ac.ensa.model.Utilisateur;

public class SignUpAction  extends ActionSupport  implements SessionAware{

	
	
	private static SessionMap sessionMap;
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
	
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public void setSession(Map map) {
		sessionMap = (SessionMap) map;
		
	}
	public static SessionMap getSession()
	{
		return sessionMap;
	}

	public SignUpAction() 
	{
		
	}
	public String signupproc()
	{
		ArrayList<ArrayList<String>> sujets = new ArrayList<ArrayList<String>>();
		sujets = (ArrayList<ArrayList<String>>) IndexAction.getSessionMap().get("sujets");
		sessionMap.put("sujets", sujets);
		
		errorMsgEmail = null;
		errorMsgUsername = null;
		errorMsgPassword = null;
		
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
			System.out.println("password  : " +password);
			System.out.println("passwordConf : "+passwordConf);
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
					return ERROR;
				}
			//sessionMap.put("currentSessionUser", user);
			return "client-success";
	    }
		else 
			return ERROR;
}
		
		public String getPasswordConf() {
		return passwordConf;
	}

	public void setPasswordConf(String passwordConf) {
		this.passwordConf = passwordConf;
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
