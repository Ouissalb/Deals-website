package ma.ac.ensa.presentation.actions;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import ma.ac.ensa.metier.RubriqueMe;
import ma.ac.ensa.metier.SujetMe;

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
		ArrayList<ArrayList<String>> sujets = new ArrayList<ArrayList<String>>();
		sujets = SujetMe.getAllSujets();
		sessionMap.put("sujets", sujets);
		return SUCCESS;
	}
	
	@Override
	public void setSession(Map map) {
		sessionMap = (SessionMap) map;
		
	}

}
