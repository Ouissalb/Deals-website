package ma.ac.ensa.metier;

import java.util.ArrayList;
import java.util.List;

import ma.ac.ensa.dao.RubriqueDAO;

public class RubriqueMe {

		 public static ArrayList<ArrayList<String>> getItems() {
		        return RubriqueDAO.getItems();
		    }

		public static ArrayList<Integer> addRubriquesToHeaderFile(int numberOfRubriques) {
			ArrayList<Integer> tempArray = new ArrayList<>();
			int row1, row2;
			if (numberOfRubriques %2 == 0)
			{
				row1 = numberOfRubriques/2;
				row2 = numberOfRubriques/2;			
			}
			else
			{
				row1 = numberOfRubriques/2;
				row2 = numberOfRubriques - row1;
			}
			tempArray.add(row1);
			tempArray.add(row2);
			return tempArray;
		}
	
}

