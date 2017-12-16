package ma.ac.ensa.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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

		Session session = HibernateUtil.getSessionFactory().openSession();
				
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
		HibernateUtil.shutdown();
		
	}

	public static ArrayList<ArrayList<String>> getAllSujets() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
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
			HibernateUtil.shutdown();
		}
	
	}

	public static ArrayList<String> getSujetById(int id_sujet) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Transaction tx = null;
		try {
			
			tx = session.beginTransaction();
			Query query = session.createQuery("from Sujet where id ="+id_sujet);
			List items = query.list();
			if (items.isEmpty())
			{
				return null;
			}
			else 
			{
				
				ArrayList<String> sujetD = new ArrayList<String>();
				for(int i = 0; i<items.size(); i++)
				{
						Sujet sujet = (Sujet) items.get(i);
	
						//changing date format to match dd/mm/yyyy
						String[] parts = sujet.getEnd_date().split("-");
						String year = parts[0];
						String day = parts[1];
						String month = parts[2];
						String newDate = year+"/"+month+"/"+day;			
						int newPrice = SujetMe.calculatePrice(sujet.getNbr_adherents(), sujet.getPrix(), sujet.getFacteur_dim());
						
						sujetD.add(Integer.toString(sujet.getId())); //0
						sujetD.add(sujet.getDescription()); //1
						sujetD.add(newDate); //2
						sujetD.add(sujet.getEtat()); //3
						sujetD.add(Integer.toString(sujet.getFacteur_dim())); //4
						sujetD.add(Integer.toString(sujet.getId_client())); //5
						sujetD.add(Integer.toString(sujet.getIdentifiant_rubrique())); //6
						sujetD.add(sujet.getImage()); //7
						sujetD.add(Integer.toString(sujet.getPrix())); //8
						sujetD.add(Integer.toString(newPrice)); //9
						sujetD.add(Integer.toString(sujet.getNbr_adherents())); //10
						sujetD.add(sujet.getStart_date()); //11
						sujetD.add(sujet.getTitle()); //12
						System.out.println("SUBSCRIBERS OF DEAL N° "+sujet.getId()+" IS "+Integer.toString(sujet.getNbr_adherents()));
				}
				
				System.out.println(sujetD);
				return sujetD;
			}
		}
		finally
		{
			session.close();
			HibernateUtil.shutdown();
		}
	}

	public static boolean sujetExpired(int id_sujet) throws ParseException 
	{
	Session session = HibernateUtil.getSessionFactory().openSession();
		
		Transaction tx = null;
		try {
			
			tx = session.beginTransaction();
			Query query = session.createQuery("from Sujet where id ="+id_sujet);
			List items = query.list();
			if (items.isEmpty())
			{
				return true;
			}
			else 
			{
			    String today_date;
				long time = System.currentTimeMillis();
				Calendar cal = Calendar.getInstance();
				cal.setTimeInMillis(time);
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				today_date = dateFormat.format(cal.getTime());
				
				
				ArrayList<String> sujetD = new ArrayList<String>();
				for(int i = 0; i<items.size(); i++)
				{
						Sujet sujet = (Sujet) items.get(i);
						String sujet_end_date = sujet.getEnd_date();
						if(!SujetMe.compareDates(today_date, sujet_end_date))
							return true;
						else
							return false;
				}
			}
		}
		finally
		{
			session.close();
			HibernateUtil.shutdown();
		}
		return false;
	}

	public static ArrayList<ArrayList<String>> getUserDeals(int id) 
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
				
				Transaction tx = null;
				try {
					
					tx = session.beginTransaction();
					Query query = session.createQuery("from Sujet where id_client="+id);
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
								
								
								System.out.println("Deals of user N° "+id +" = "+row1);
								sujets.add(row1);
						}
						
						System.out.println(sujets);
						return sujets;
					}
						
					
				}
				finally
				{
					session.close();
					HibernateUtil.shutdown();
				}
	}

	public static void updateSujetWithImg(int i, String description, String dateEndMysqlFormat, int rubrique,
			String myFileFileName, int price, String title) 
	{
	Session session = HibernateUtil.getSessionFactory().openSession();
		
		Transaction tx = null;
		try {
			tx = session.beginTransaction();	
			
			String hqlUpdate = "update Sujet set description = :description,"
					+ " end_date = :dateEndMysqlFormat, identifiant_rubrique = :rubrique,"
					+ " image = :myFileFileName, prix = :price, title = :title "
					+ " where id = :i";
			
			int updatedEntities = session.createQuery( hqlUpdate )
					.setString("description", description)
					.setString("dateEndMysqlFormat", dateEndMysqlFormat)
					.setLong("rubrique", rubrique)
					.setString("myFileFileName", myFileFileName)
					.setLong("price", price)
			        .setLong( "i", i )
			        .setString( "title", title )
			        .executeUpdate();
			
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
		HibernateUtil.shutdown();
}	


	public static void updateSujet(int i, String description, String dateEndMysqlFormat, int rubrique, int price,
			String title) {
Session session = HibernateUtil.getSessionFactory().openSession();
		
		Transaction tx = null;
		try {
			tx = session.beginTransaction();	
			
			String hqlUpdate = "update Sujet set description = :description,"
					+ " end_date = :dateEndMysqlFormat, identifiant_rubrique = :rubrique,"
					+ "  prix = :price, title = :title "
					+ " where id = :i";
			
			int updatedEntities = session.createQuery( hqlUpdate )
					.setString("description", description)
					.setString("dateEndMysqlFormat", dateEndMysqlFormat)
					.setLong("rubrique", rubrique)
					.setLong("price", price)
			        .setLong( "i", i )
			        .setString( "title", title )
			        .executeUpdate();
			
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
		HibernateUtil.shutdown();
		
	}
	


}
