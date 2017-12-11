package ma.ac.ensa.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import ma.ac.ensa.metier.SujetMe;
import ma.ac.ensa.model.Rubrique;
import ma.ac.ensa.model.Sujet;

public class SujetDAO {

	public SujetDAO() {
		// TODO Auto-generated constructor stub
	}

	public static void createSujet(Sujet sujet) {

		Configuration config = new Configuration();
		config = config.configure("persistance.cfg.xml");
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
				
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			
			session.save(sujet);
			
			tx.commit();
			session.close();
			}
		catch (Exception e )
		{
			if (tx != null)
			{
				tx.rollback();
			}
			throw e;
		}
		sessionFactory.close();
		
	}

	public static ArrayList<ArrayList<String>> getAllSujets() {
		Configuration config = new Configuration();
		config = config.configure("persistance.cfg.xml");
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Transaction tx = null;
		try {
			
			tx = session.beginTransaction();
			Query query = session.createQuery("from Sujet");
			List items = query.list();
			if (items.isEmpty())
			{
				return null;
			}
			else 
			{
				
				ArrayList<ArrayList<String>> sujets = new ArrayList<ArrayList<String>>();
				for(int i = 0; i<items.size(); i++)
				{
					    ArrayList<String> row1 = new ArrayList<>();
						Sujet sujet = (Sujet) items.get(i);
						
						//changing date format to match dd/mm/yyyy
						String[] parts = sujet.getEnd_date().split("-");
						String year = parts[0];
						String day = parts[1];
						String month = parts[2];
						String newDate = year+"/"+month+"/"+day;			
						int newPrice = SujetMe.calculatePrice(sujet.getNbr_adherents(), sujet.getPrix(), sujet.getFacteur_dim());
						
						row1.add(Integer.toString(sujet.getId())); //0
						row1.add(sujet.getDescription()); //1
						row1.add(newDate); //2
						row1.add(sujet.getEtat()); //3
						row1.add(Integer.toString(sujet.getFacteur_dim())); //4
						row1.add(Integer.toString(sujet.getId_client())); //5
						row1.add(Integer.toString(sujet.getIdentifiant_rubrique())); //6
						row1.add(sujet.getImage()); //7
						row1.add(Integer.toString(sujet.getPrix())); //8
						row1.add(Integer.toString(newPrice)); //9
						row1.add(Integer.toString(sujet.getNbr_adherents())); //10
						row1.add(sujet.getStart_date()); //11
						row1.add(sujet.getTitle()); //12
						
						
						System.out.println("row1 = "+row1);
						sujets.add(row1);
				}
				
				System.out.println(sujets);
				return sujets;
			}
				
			
		}
		finally
		{
			session.close();
			sessionFactory.close();
		}
	
	}

}
