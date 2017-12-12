package ma.ac.ensa.dao;


import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import ma.ac.ensa.metier.UtilisateurMe;
import ma.ac.ensa.model.Utilisateur;

public class BaseDAO 
{
	public static void createUser(Utilisateur user)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
				
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			
			session.save(user);
			
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

	public static boolean usernameTaken(String clientUsername) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Transaction tx = null;
		try {
			
			tx = session.beginTransaction();
			
			System.out.println("Username exists??");
			Query query = session.createQuery("from Utilisateur where username='"+clientUsername+"'");
			List users = query.list();
			if (users.isEmpty())
			{
				System.out.println("Username NOT  taken");
				return false;
			}
			else 
			{
				System.out.println("Username TAKEN !!");
				return true;}
		}
		finally
		{
			session.close();
			HibernateUtil.shutdown();
		}
		
	}

	public static boolean emailTaken(String clientEmail) {
		// TODO Auto-generated method stub
		return false;
	}

	public static Utilisateur login(Utilisateur user) throws NoSuchAlgorithmException 
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Transaction tx = null;
		try {
			
			tx = session.beginTransaction();
			
			System.out.println("Username exists??");
			Query query = session.createQuery("from Utilisateur where email='"+user.getEmail()+"'");
			List users = query.list();
			if (users.isEmpty())
			{
				return null;
			}
			else 
			{
				Utilisateur user2 = (Utilisateur) users.get(0);
				String passwordEntered  = UtilisateurMe.hashPassword(user.getPassword());
				System.out.println("passwordEntered : " + passwordEntered);
				String userPassword = user2.getPassword();
				System.out.println("userPassword  : "+userPassword);
				if (passwordEntered.equals(userPassword))
					return user2;
				else return null;
			}
		}
		finally
		{
			session.close();
			HibernateUtil.shutdown();
		}
	}
}
