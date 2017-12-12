package ma.ac.ensa.presentation.actions;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import ma.ac.ensa.metier.SujetMe;

public class ShowDealAction extends ActionSupport implements SessionAware{
	private SessionMap sessionMap;
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
