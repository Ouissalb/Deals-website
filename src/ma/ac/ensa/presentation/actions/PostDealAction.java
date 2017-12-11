package ma.ac.ensa.presentation.actions;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import ma.ac.ensa.metier.RubriqueMe;

public class PostDealAction extends ActionSupport implements SessionAware{

	private SessionMap sessionMap;
	public PostDealAction() {
		// TODO Auto-generated constructor stub
	}

	public String populateRubriques()
	{
		ArrayList<ArrayList<String>> libelles = new ArrayList<ArrayList<String>>();
		libelles = RubriqueMe.getItems();
		System.out.println("LIBELLES FROM UPLOADDDEALS : "+libelles);
		sessionMap.put("rubriques", libelles);
		return SUCCESS;
	
	}
	
	@Override
	public void setSession(Map map) {
		sessionMap = (SessionMap) map;
		
	}

}
