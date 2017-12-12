package ma.ac.ensa.metier;

import java.util.ArrayList;

import ma.ac.ensa.dao.SujetDAO;
import ma.ac.ensa.model.Sujet;

public class SujetMe {

	public SujetMe() {

	}
	
	public static void createSujet(Sujet sujet) 
	{
		SujetDAO.createSujet(sujet);
	}
	
	public static ArrayList<ArrayList<String>> getAllSujets()
	{
		return SujetDAO.getAllSujets();
	}

	public static int calculatePrice(int nbr_adherents, int prix, int facteur_dim) {
		int newPrice = prix;
		if (nbr_adherents != 0)
		{
			newPrice = prix - (facteur_dim - nbr_adherents);
		}
		return newPrice;
	}

	public static ArrayList<String> getSujetById(int id_sujet) {
		return SujetDAO.getSujetById(id_sujet);
	}

}
