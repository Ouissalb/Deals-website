package ma.ac.ensa.presentation.actions;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import ma.ac.ensa.metier.SubscriptionMe;
import ma.ac.ensa.metier.SujetMe;
import ma.ac.ensa.model.Utilisateur;

public class SubscribeAction extends ActionSupport implements SessionAware{
	
	private static SessionMap sessionMap;
	private static SessionMap userSession = null;
	
	private String id_sujet;
	private String description;
	private String date_end;
	private String etat;
	private String id_vendeur;
	private String id_rubrique;
	private String image;
	private String prix;
	private String nbr_adherents;
	private int id_user;
	
	
	public SubscribeAction() 
	{
	}
	
	public String subscribe() 
	{
		sessionMap.clear();
		Utilisateur user = null;
		userSession = LoginAction.getSession();	
		
		ArrayList<String> sujetDetails = new ArrayList<>();
		sujetDetails = SujetMe.getSujetById(Integer.parseInt(id_sujet));
		sessionMap.put("sujetDetails", sujetDetails);
		
		if (userSession != null)
		{
			user = (Utilisateur) LoginAction.getSession().get("currentSessionUser");
		}
		
		if (user == null || id_user != user.getId())
		{
			sessionMap.put("messageSubs", ", you aren't logged in : login");
			return ERROR;
		}
		else if (SubscriptionMe.userAlreadySubscribed() == true)
		{
			sessionMap.put("messageSubs", ", you are already subscribed to this deal");
			return ERROR;
		}
		else if (SujetMe.sujetExpired(id_sujet))
		{
			sessionMap.put("messageSubs", ", ce sujet a expiré");
			return ERROR;
		}
		else
		{
			sessionMap.put("messageSubs", ", you have successfully subscribed to this deal, you'll "
					+ "receive an email once payment is ready to be made");
			return SUCCESS;
		}
	}
	
	
	@Override
	public void setSession(Map map) {
		sessionMap = (SessionMap) map;
		
	}


	public String getId_sujet() {
		return id_sujet;
	}


	public void setId_sujet(String id_sujet) {
		this.id_sujet = id_sujet;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getDate_end() {
		return date_end;
	}


	public void setDate_end(String date_end) {
		this.date_end = date_end;
	}


	public String getEtat() {
		return etat;
	}


	public void setEtat(String etat) {
		this.etat = etat;
	}


	public String getId_vendeur() {
		return id_vendeur;
	}


	public void setId_vendeur(String id_vendeur) {
		this.id_vendeur = id_vendeur;
	}


	public String getId_rubrique() {
		return id_rubrique;
	}


	public void setId_rubrique(String id_rubrique) {
		this.id_rubrique = id_rubrique;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public String getPrix() {
		return prix;
	}


	public void setPrix(String prix) {
		this.prix = prix;
	}


	public String getNbr_adherents() {
		return nbr_adherents;
	}


	public void setNbr_adherents(String nbr_adherents) {
		this.nbr_adherents = nbr_adherents;
	}


	public int getId_user() {
		return id_user;
	}


	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

}
