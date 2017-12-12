package ma.ac.ensa.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	public HibernateUtil() {
	
	}
	private static SessionFactory sessionFactory = buildSessionFactory();
	 private static SessionFactory buildSessionFactory()
	 {
		 try {
		    if (sessionFactory == null)
		    {
		    Configuration config = new Configuration();
			config = config.configure("persistance.cfg.xml");
			sessionFactory = config.buildSessionFactory();
		    }
		    return sessionFactory;
		  } catch (Throwable ex)
	      {
	         System.err.println("Initial SessionFactory creation failed." + ex);
	         throw new ExceptionInInitializerError(ex);
	      }
		  
	   }
	 
	   public static SessionFactory getSessionFactory()
	   {
	      return sessionFactory;
	   }

	   public static void shutdown()
	   {
	      getSessionFactory().close();
	   }
	 
}


