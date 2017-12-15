package ma.ac.ensa.presentation.actions;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import ma.ac.ensa.metier.RubriqueMe;
import ma.ac.ensa.metier.SujetMe;
import ma.ac.ensa.model.Utilisateur;

public class ManageDealAction extends ActionSupport implements SessionAware{

	private SessionMap sessionMap;
	
	private int id_sujet;
	
	public int getId_sujet() {
		return id_sujet;
	}

	public void setId_sujet(int id_sujet) {
		this.id_sujet = id_sujet;
	}
	
	public ManageDealAction() {
		
	}
	
	public String manageDeal()
	{
		ArrayList<ArrayList<String>> libelles = new ArrayList<ArrayList<String>>();
		libelles = RubriqueMe.getItems();
		
		int numberOfRubriques = 0;
		numberOfRubriques = Integer.parseInt(libelles.get(1).get(2));
	
		ArrayList<Integer> tempArray = RubriqueMe.addRubriquesToHeaderFile(numberOfRubriques);
		sessionMap.put("rubriques", libelles);
		sessionMap.put("row1", tempArray.get(0));
		sessionMap.put("row2", tempArray.get(1));
		
		if (!SubscribeAction.noErrors)
			SubscribeAction.getSubscribeSession().clear();
		if(LoginAction.userLoggedIn)
		{
			Utilisateur currentUser = (Utilisateur) LoginAction.getSession().get("currentSessionUser");
			System.out.println("USER IS "+ currentUser);
			sessionMap.put("currentSessionUser", currentUser);
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
}
