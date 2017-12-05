package ma.ac.ensa.presentation.actions;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import ma.ac.ensa.dao.BaseDAO;
import ma.ac.ensa.model.Utilisateur;

public class LoginAction extends ActionSupport  implements SessionAware
{
	
	private SessionMap sessionMap;
	
	@Override
	public void setSession(Map map) {
		sessionMap = (SessionMap) map;
		
	}
	
	private String email;
	private String password;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String loginproc()
	{
		HttpSession session = ServletActionContext.getRequest().getSession(true);
		boolean successfullyConnected = true;
		try 
		{
            Utilisateur user = new Utilisateur();
			String errorMsg = null;
			user = new Utilisateur(null, null, null, null);
			user.setEmail(email);
			user.setPassword(password);
			user = BaseDAO.login(user);
			
			if (user == null) 
			{
				errorMsg = "Login et/ou mot de passe incorrectes";
				successfullyConnected = false;
				return ERROR;
			}
			if (user.getRole().equals("admin"))
			{
				//HttpSession session = request.getSession(true);	
				//session.setAttribute("currentSessionUser",user);
				sessionMap.put("currentSessionUser", user);
				return "admin-success";
				//response.sendRedirect(request.getContextPath() +"/adminPanel");
				//successfullyConnected = true;
				//request.setAttribute("successfullyConnected", successfullyConnected );
			}
			else if (user.getRole().equals("client"))
			{
				System.out.println("CLIENT IS LOGGED IN");
				sessionMap.put("currentSessionUser", user);
				//HttpSession session = request.getSession(true);
				//session.setAttribute("currentSessionUser",user);
				successfullyConnected = true;
				return "client-success";
				//request.setAttribute("successfullyConnected", successfullyConnected );
				//request.getRequestDispatcher("/vues/index-logged-out.jsp").forward(request, response);
			}
				
			
			
		} 
		catch (Throwable theException) 
		{ 
			System.out.println(theException);
			theException.printStackTrace();
		}
		return ERROR; 
	}




}
