package ma.ac.ensa.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ma.ac.ensa.model.Subscription;

public class SubscriptionDAO {

	public SubscriptionDAO() {
		// TODO Auto-generated constructor stub
	}

	public static boolean userAlreadySubscribed(int id_user, int id_sujet) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Query query = session.createQuery("from Subscription where id_client='"+id_user+"' and id_sujet ='"+id_sujet+"'");
			List users = query.list();
			if (users.isEmpty())
			{
				return false;
			}
			else 
			{
				return true;}
		}
		finally
		{
			session.close();
			HibernateUtil.shutdown();
		}

	}

	public static void addNewSubscription(Subscription subscription) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			
			session.save(subscription);
			
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

	public static void incrementSubscribers(int id_sujet, int i) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Transaction tx = null;
		try {
			tx = session.beginTransaction();	
			
			//String hqlUpdate = "update Sujet s set s.nbr_adherents = : "+i+" where s.id = : +"+id_sujet;
			String hqlUpdate = "update Sujet set nbr_adherents = :i where id = :id_sujet";
			int updatedEntities = session.createQuery( hqlUpdate )
			        .setLong( "i", i )
			        .setLong( "id_sujet", id_sujet )
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
