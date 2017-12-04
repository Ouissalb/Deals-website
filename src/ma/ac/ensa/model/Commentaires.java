package ma.ac.ensa.model;

public class Commentaires 
{
	private int id;
	private String contenu;
	private String username;
	private int id_sujet;
	
	public Commentaires(String contenu, String username, int id_sujet) {
		super();
		this.contenu = contenu;
		this.username = username;
		this.id_sujet = id_sujet;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getId_sujet() {
		return id_sujet;
	}
	public void setId_sujet(int id_sujet) {
		this.id_sujet = id_sujet;
	}
	

}
