package ma.ac.ensa.presentation.actions;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import ma.ac.ensa.metier.RubriqueMe;
import ma.ac.ensa.metier.SujetMe;
import ma.ac.ensa.model.Utilisateur;

public class ViewYourDealsAction extends ActionSupport implements SessionAware{

	private SessionMap sessionMap;
	boolean noErrors = false;
	
	public ViewYourDealsAction() {
		// TODO Auto-generated constructor stub
	}

	public String displayDeals()
	{
		sessionMap.clear();
		ArrayList<ArrayList<String>> libelles = new ArrayList<ArrayList<String>>();
		libelles = RubriqueMe.getItems();
		
		int numberOfRubriques = 0;
		numberOfRubriques = Integer.parseInt(libelles.get(1).get(2));
	
		ArrayList<Integer> tempArray = RubriqueMe.addRubriquesToHeaderFile(numberOfRubriques);
		sessionMap.put("rubriques", libelles);
		sessionMap.put("row1", tempArray.get(0));
		sessionMap.put("row2", tempArray.get(1));
		
		if(LoginAction.userLoggedIn)
		{
			Utilisateur user = LoginAction.getUserDetails();
			sessionMap.put("currentSessionUser", user);
			ArrayList<ArrayList<String>> sujet = new ArrayList<>();
			sujet = SujetMe.getUserDeals(user.getId());
			if (sujet.isEmpty())
			{
				noErrors = false;
				sessionMap.put("messageSubs", "you haven't posted any deals");
				return ERROR;
			}
			sessionMap.put("sujets", sujet);
			noErrors = true;
			return SUCCESS;
		}
		
		if (! LoginAction.userLoggedIn )
		{			
			sessionMap.put("messageSubs", ", you aren't logged in, you must login first");
			noErrors = false;
			return ERROR;
		}
		return null;
		
		
	}
	
	@Override
	public void setSession(Map map) {
		sessionMap = (SessionMap) map;
		
	}

}
