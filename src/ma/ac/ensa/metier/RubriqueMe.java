package ma.ac.ensa.metier;

import java.util.ArrayList;
import java.util.List;

import ma.ac.ensa.dao.RubriqueDAO;

public class RubriqueMe {

		 public static ArrayList<ArrayList<String>> getItems() {
		        return RubriqueDAO.getItems();
		    }
	
}

