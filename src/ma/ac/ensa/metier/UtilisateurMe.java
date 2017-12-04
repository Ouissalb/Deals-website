package ma.ac.ensa.metier;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UtilisateurMe {

	public UtilisateurMe() {
		
	}
	
	//encrypting password with md5
	public static String hashPassword(String message) throws NoSuchAlgorithmException 
	{
		 MessageDigest md = MessageDigest.getInstance("MD5");
		 md.update(message.getBytes());
		 byte[] digest = md.digest();
		 StringBuffer sb = new StringBuffer();
		 for (byte b : digest) {
		    sb.append(String.format("%02x", b & 0xff));
		 }
		 return sb.toString();
	}

}
