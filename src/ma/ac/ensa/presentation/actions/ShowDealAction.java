package ma.ac.ensa.presentation.actions;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import ma.ac.ensa.metier.SujetMe;
import ma.ac.ensa.model.Utilisateur;

public class ShowDealAction extends ActionSupport implements SessionAware{
	private static SessionMap sessionMap;
	private static SessionMap sessionMapUser = null;
	

	private int id_sujet;
	
	public int getId_sujet() {
		return id_sujet;
	}

	public void setId_sujet(int id_sujet) {
		this.id_sujet = id_sujet;
	}

	public ShowDealAction() {
	}
	
	public String showDealDetails()
	{
		if(LoginAction.getSession() != null)
		{
			sessionMapUser = LoginAction.getSession();
			Utilisateur user = (Utilisateur) sessionMapUser.get("currentSessionUser");
			
			sessionMap.put("currentSessionUserId",  user.getId());
		}
		
		ArrayList<String> sujetDetails = new ArrayList<>();
		sujetDetails = SujetMe.getSujetById(id_sujet);
		sessionMap.put("sujetDetails", sujetDetails);
		return SUCCESS;
	}
	
	@Override
	public void setSession(Map map) {
		sessionMap = (SessionMap) map;
		
	}
	
	public static SessionMap getSession()
	{
		return sessionMap;
	}
}
