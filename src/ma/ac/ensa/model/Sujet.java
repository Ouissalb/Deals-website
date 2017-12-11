package ma.ac.ensa.model;

public class Sujet {
	private int id;
	private String description;
	private String end_date;
	private String etat;
	private int facteur_dim;
	private int identifiant_rubrique;
	private String image;
	private static int nbr_adherents;
	private int prix;
	private String start_date;
	private int visible;
	private int id_client;
	private String title;
	
	
	public Sujet() {
	}
	public Sujet(String description, String end_date, String etat, int facteur_dim,
			int identifiant_rubrique, String image, int prix, String start_date, int visible, String title, int id_client) {
		super();
		this.description = description;
		this.end_date = end_date;
		this.etat = etat;
		this.facteur_dim = facteur_dim;
		this.identifiant_rubrique = identifiant_rubrique;
		this.image = image;
		this.prix = prix;
		this.start_date = start_date;
		this.visible = visible;
		this.title = title;
		this.id_client = id_client;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public int getFacteur_dim() {
		return facteur_dim;
	}
	public void setFacteur_dim(int facteur_dim) {
		this.facteur_dim = facteur_dim;
	}
	public int getIdentifiant_rubrique() {
		return identifiant_rubrique;
	}
	public void setIdentifiant_rubrique(int identifiant_rubrique) {
		this.identifiant_rubrique = identifiant_rubrique;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public static int getNbr_adherents() {
		return nbr_adherents;
	}
	public static void setNbr_adherents(int nbr_adherents) {
		Sujet.nbr_adherents = nbr_adherents;
	}
	public int getPrix() {
		return prix;
	}
	public void setPrix(int prix) {
		this.prix = prix;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public int isVisible() {
		return visible;
	}
	public void setVisible(int visible) {
		this.visible = visible;
	}
	public int getId_client() {
		return id_client;
	}
	public void setId_client(int id_client) {
		this.id_client = id_client;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getVisible() {
		return visible;
	}

}
