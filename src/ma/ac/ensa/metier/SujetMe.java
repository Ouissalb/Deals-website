package ma.ac.ensa.metier;

import ma.ac.ensa.dao.SujetDAO;
import ma.ac.ensa.model.Sujet;

public class SujetMe {

	public SujetMe() {

	}
	
	public static void createSujet(Sujet sujet) {
		SujetDAO.createSujet(sujet);
	}

}
