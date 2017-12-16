package ma.ac.ensa.presentation.actions;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import ma.ac.ensa.metier.RubriqueMe;
import ma.ac.ensa.metier.SujetMe;
import ma.ac.ensa.model.Sujet;
import ma.ac.ensa.model.Utilisateur;

public class UpdateDealAction extends ActionSupport implements SessionAware{

	public UpdateDealAction() {
		// TODO Auto-generated constructor stub
	}
	
	private SessionMap sessionMap;
	
	private File myFile;
	private String myFileContentType;
	private String myFileFileName;
	private String destPath;
	
	private String id_sujet;
	private String dateEnd;
	private String description;
	private String title;
	private int price;
	//private int discount;
	private String photo;
	private String start_date;
	private int rubrique;
	protected Sujet sujet;
	
	public String updatedeal() {

		ArrayList<ArrayList<String>> libelles = new ArrayList<ArrayList<String>>();
		libelles = RubriqueMe.getItems();
		
		int numberOfRubriques = 0;
		numberOfRubriques = Integer.parseInt(libelles.get(1).get(2));
	
		ArrayList<Integer> tempArray = RubriqueMe.addRubriquesToHeaderFile(numberOfRubriques);
		sessionMap.put("rubriques", libelles);
		sessionMap.put("row1", tempArray.get(0));
		sessionMap.put("row2", tempArray.get(1));
		
		// Date posted
		long time = System.currentTimeMillis();
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(time);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		start_date = dateFormat.format(cal.getTime());

		destPath = "/run/media/ouissal/Data1/Documents/ENSAK/5emeAnnee/S9-18/J2EE/fileupload/";

		try {

			if (myFileFileName != null && myFileFileName != "")
			{
				File destFile  = new File(destPath, myFileFileName);
				FileUtils.copyFile(myFile, destFile);
				photo = destPath+"/"+myFileFileName;
			}
			
			Utilisateur currentUser = (Utilisateur) LoginAction.getSession().get("currentSessionUser");
			
			String[] parts = dateEnd.split("/");
			String year = parts[0];
			String month = parts[1];
			String day = parts[2];
			
            String dateEndMysqlFormat  = year+"-"+day+"-"+month;

            if (myFileFileName != null && myFileFileName != "")
			{
            	SujetMe.updateSujetWithImg(Integer.parseInt(id_sujet), description, dateEndMysqlFormat, rubrique, myFileFileName, price, title);
			}
            else
            {
            	SujetMe.updateSujet(Integer.parseInt(id_sujet), description, dateEndMysqlFormat, rubrique, price, title);
            }
			
			sessionMap.put("sujet_title", title);
			sessionMap.put("sujet_description", description);
			sessionMap.put("sujet_prix", price);
			sessionMap.put("sujet_img", myFileFileName);
			
			

		} catch(IOException e) {
			e.printStackTrace();
			return ERROR;
		}

		return SUCCESS;
	}
	
	public String populateRubriques()
	{
		ArrayList<ArrayList<String>> libelles = new ArrayList<ArrayList<String>>();
		libelles = RubriqueMe.getItems();
		System.out.println("LIBELLES FROM UPLOADDDEALS : "+libelles);
		sessionMap.put("rubriques", libelles);
		return SUCCESS;
	
	}

	public File getMyFile() {
		return myFile;
	}

	public void setMyFile(File myFile) {
		this.myFile = myFile;
	}

	public String getId_sujet() {
		return id_sujet;
	}

	public void setId_sujet(String id_sujet) {
		this.id_sujet = id_sujet;
	}

	public String getMyFileContentType() {
		return myFileContentType;
	}

	public void setMyFileContentType(String myFileContentType) {
		this.myFileContentType = myFileContentType;
	}

	public String getMyFileFileName() {
		return myFileFileName;
	}

	public void setMyFileFileName(String myFileFileName) {
		this.myFileFileName = myFileFileName;
	}


	public String getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(String dateEnd) {
		this.dateEnd = dateEnd;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}


	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	@Override
	public void setSession(Map map) {
		sessionMap = (SessionMap) map;
		
	}

	public int getRubrique() {
		return rubrique;
	}

	public void setRubrique(int rubrique) {
		this.rubrique = rubrique;
	}

}
