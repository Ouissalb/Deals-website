package ma.ac.ensa.presentation.actions;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import ma.ac.ensa.metier.RubriqueMe;
import ma.ac.ensa.metier.SujetMe;
import ma.ac.ensa.model.Utilisateur;

public class IndexAction extends ActionSupport implements SessionAware
{

	private static SessionMap sessionMap;
	
	public static SessionMap getSessionMap() {
		return sessionMap;
	}

	public void setSessionMap(SessionMap sessionMap) {
		IndexAction.sessionMap = sessionMap;
	}

	public IndexAction() 
	{	
	}
	
	public String showIndexPage()
	{
		if (LoginAction.userLoggedIn)
		{
			Utilisateur user =  LoginAction.getUserDetails();	
			sessionMap.put("currentSessionUser", user);
		}
		
		ArrayList<ArrayList<String>> sujets = new ArrayList<ArrayList<String>>();
		sujets = SujetMe.getAllSujets();
		sessionMap.put("sujets", sujets);

		ArrayList<ArrayList<String>> libelles = new ArrayList<ArrayList<String>>();
		libelles = RubriqueMe.getItems();
		
		int numberOfRubriques = 0;
		numberOfRubriques = Integer.parseInt(libelles.get(1).get(2));
	
		ArrayList<Integer> tempArray = RubriqueMe.addRubriquesToHeaderFile(numberOfRubriques);
		sessionMap.put("rubriques", libelles);
		sessionMap.put("row1", tempArray.get(0));
		sessionMap.put("row2", tempArray.get(1));
		
		return SUCCESS;
	}
	
	@Override
	public void setSession(Map map) {
		sessionMap = (SessionMap) map;
		
	}

}
