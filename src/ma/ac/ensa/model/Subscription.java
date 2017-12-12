package ma.ac.ensa.model;

public class Subscription {

	private int identifiant;
	private int id_client;
	private int id_vendeur;
	private int id_sujet;
	private String date;
	private int etat;
	private Integer prix_final;
	
	public Subscription(int id_client, int id_vendeur, int id_sujet, String date, int etat) {
		super();
		this.id_client = id_client;
		this.id_vendeur = id_vendeur;
		this.id_sujet = id_sujet;
		this.date = date;
		this.etat = etat;
	}

	public Subscription() {
	}

	public int getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
	}

	public int getId_client() {
		return id_client;
	}

	public void setId_client(int id_client) {
		this.id_client = id_client;
	}

	public int getId_vendeur() {
		return id_vendeur;
	}

	public void setId_vendeur(int id_vendeur) {
		this.id_vendeur = id_vendeur;
	}

	public Integer getPrix_final() {
		return prix_final;
	}

	public void setPrix_final(Integer prix_final) {
		this.prix_final = prix_final;
	}

	public int getId_sujet() {
		return id_sujet;
	}

	public void setId_sujet(int id_sujet) {
		this.id_sujet = id_sujet;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getEtat() {
		return etat;
	}

	public void setEtat(int etat) {
		this.etat = etat;
	}

}
