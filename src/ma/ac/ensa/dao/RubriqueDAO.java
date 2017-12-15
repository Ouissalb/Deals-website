package ma.ac.ensa.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import ma.ac.ensa.metier.UtilisateurMe;
import ma.ac.ensa.model.Rubrique;
import ma.ac.ensa.model.Utilisateur;


public class RubriqueDAO {

	public RubriqueDAO() {
	}
	
	public static ArrayList<ArrayList<String>> getItems()
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Transaction tx = null;
		try {
			
			tx = session.beginTransaction();
			Query query = session.createQuery("from Rubrique");
			List items = query.list();
			if (items.isEmpty())
			{
				return null;
			}
			else 
			{
				
				ArrayList<ArrayList<String>> libelles = new ArrayList<ArrayList<String>>();
				for(int i = 0; i<items.size(); i++)
				{
					    ArrayList<String> row1 = new ArrayList<>();
						Rubrique rubrique = (Rubrique) items.get(i);
						row1.add(Integer.toString(rubrique.getIdentifiant()));
						row1.add((String) rubrique.getLibelle());
						System.out.println("row1 = "+row1);
						row1.add(Integer.toString(items.size()));
						libelles.add(row1);
				}
				
				System.out.println(libelles);
				return libelles;
			}
				
			
		}
		finally
		{
			session.close();
			HibernateUtil.shutdown();
		}
	}
	
}


