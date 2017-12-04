/*package ma.ac.ensa.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import modele.Commande;
import modele.Personne;

public class HibernatePersistanceHQL {

	public static void main(String[] args)  throws Exception
	{
		// TODO Auto-generated method stub
		Configuration config = new Configuration();
		config = config.configure("persistance.cfg.xml");
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Transaction tx = null;
		try {
			
			/*tx = session.beginTransaction();
			Personne personne1 = new Personne("Ouissal1", "Benameur1");
			session.save(personne1);
			
			Commande commande1 = new Commande("code1", "cmd1", "500dh");
			session.save(commande1);
			Commande commande2 = new Commande("code2", "cmd2", "1260dh");
			session.save(commande2);
			Commande commande3 = new Commande("code3", "cmd3", "86dh");
			session.save(commande3);
			
			System.out.println("Les personnes dont le nom = Ouissal Benameur");
			Query query = session.createQuery("from Personne where nom='Ouissal'"+
				"and prenom='Benameur'"	);
			List personnes = query.list();
		    for(int i = 0; i<personnes.size(); i++)
			{
					Personne personne = (Personne) personnes.get(i);
					System.out.println("Nom = " +personne.getNom());
					System.out.println("Prenom = " +personne.getPrenom());
			}
			
			System.out.println("Les commandes dont la valeur du code = code1");
			Query query2 = session.createQuery("from Commande where code='code1'");
				List commandes = query2.list();
				for(int i = 0; i<commandes.size(); i++)
				{
						Commande cmd = (Commande) commandes.get(i);
						System.out.println("Code = " +cmd.getCode());
						System.out.println("Libelle = " +cmd.getLibelle());
						System.out.println("Montant = " +cmd.getMontant());
				}
				
				System.out.println("Les commandes dont la valeur du code commence par co..");
				Query query3 = session.createQuery("from Commande where code like 'co%'");
					List commandes2 = query3.list();
					for(int i = 0; i<commandes2.size(); i++)
					{
							Commande cmd = (Commande) commandes2.get(i);
							System.out.println("Code = " +cmd.getCode());
							System.out.println("Libelle = " +cmd.getLibelle());
							System.out.println("Montant = " +cmd.getMontant());
					}
		}
		finally
		{
			session.close();
		}
		sessionFactory.close();
		
;	}

}
*/