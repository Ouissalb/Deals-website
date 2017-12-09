package ma.ac.ensa.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

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

}
