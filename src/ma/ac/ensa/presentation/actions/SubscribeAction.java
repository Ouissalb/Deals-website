package ma.ac.ensa.presentation.actions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import ma.ac.ensa.metier.RubriqueMe;
import ma.ac.ensa.metier.SubscriptionMe;
import ma.ac.ensa.metier.SujetMe;
import ma.ac.ensa.model.Subscription;
import ma.ac.ensa.model.Utilisateur;

public class SubscribeAction extends ActionSupport implements SessionAware{
	
	private static SessionMap sessionMap;
	
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
	
	public static boolean noErrors = true;
	
	String today_date = null;
	
	
	public SubscribeAction() 
	{
	}
	
	public String subscribe() throws NumberFormatException, ParseException 
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
		
		ArrayList<String> sujetDetails = new ArrayList<>();
		sujetDetails = SujetMe.getSujetById(Integer.parseInt(id_sujet));
		sessionMap.put("sujetDetails", sujetDetails);
		
		if(LoginAction.userLoggedIn)
		{
			Utilisateur user = LoginAction.getUserDetails();
			System.out.println("USER IS2 "+ user.getEmail());
			id_user = user.getId();
			System.out.println("id_user = "+id_user+ ", user.getId() = "+ user.getId());
			sessionMap.put("currentSessionUser", user);
		}
		
		if (! LoginAction.userLoggedIn )
		{
			
			sessionMap.put("messageSubs", ", you aren't logged in, you must login first");
			noErrors = false;
			return ERROR;
		}
		else if (SubscriptionMe.userAlreadySubscribed(id_user, Integer.parseInt(id_sujet)) == true)
		{
			sessionMap.put("messageSubs", ", you are already subscribed to this deal");
			noErrors = false;
			return ERROR;
		}
		else if (SujetMe.sujetExpired(Integer.parseInt(id_sujet)))
		{
			noErrors = false;
			sessionMap.put("messageSubs", ", this deal has expired or no longer exists");
			return ERROR;
		}
		else
		{
			long time = System.currentTimeMillis();
			Calendar cal = Calendar.getInstance();
			cal.setTimeInMillis(time);
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			today_date = dateFormat.format(cal.getTime());
			
			Subscription subscription =  new Subscription(id_user, Integer.parseInt(id_vendeur)
					, Integer.parseInt(id_sujet),today_date, 0);
			
			SubscriptionMe.addNewSubscription(subscription);
			SubscriptionMe.incrementSubscribers(Integer.parseInt(id_sujet), Integer.parseInt(nbr_adherents)+1);
			noErrors = false;
			sessionMap.put("messageSubs", ", you have successfully subscribed to this deal, you'll "
					+ "receive an email once payment is ready to be made");
			return SUCCESS;
		}
	}
	
	
	@Override
	public void setSession(Map map) {
		sessionMap = (SessionMap) map;
		
	}
	
	public static SessionMap getSubscribeSession()
	{
		return sessionMap;
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
