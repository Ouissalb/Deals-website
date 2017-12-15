package ma.ac.ensa.metier;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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

	public static boolean sujetExpired(int id_sujet) throws ParseException {
		return SujetDAO.sujetExpired(id_sujet);
	}

	public static boolean compareDates(String today_date, String sujet_end_date) throws ParseException 
	{
		//date format : yyyy-MM-dd
		SimpleDateFormat formatter2=new SimpleDateFormat("yyyy-MM-dd"); 
		Date date_today =formatter2.parse(today_date);  
		Date date_end =formatter2.parse(sujet_end_date);  

        if (date_end.compareTo(date_today) > 0) 
           return true;
        else
        	return false;
		
	}

	public static ArrayList<ArrayList<String>> getUserDeals(int id) {
		return SujetDAO.getUserDeals(id);
	}


}
