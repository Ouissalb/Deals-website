package ma.ac.ensa.metier;

import ma.ac.ensa.dao.SubscriptionDAO;
import ma.ac.ensa.model.Subscription;

public class SubscriptionMe {

	public SubscriptionMe() {
		// TODO Auto-generated constructor stub
	}

	public static boolean userAlreadySubscribed(int id_user, int id_sujet) {
		
		return SubscriptionDAO.userAlreadySubscribed(id_user, id_sujet);
	}

	public static void addNewSubscription(Subscription subscription) {
		SubscriptionDAO.addNewSubscription(subscription);
		
	}

	public static void incrementSubscribers(int parseInt, int i) {
		SubscriptionDAO.incrementSubscribers(parseInt, i);
		
	}



}
