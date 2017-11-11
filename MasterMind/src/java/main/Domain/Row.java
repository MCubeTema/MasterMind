package java.main.Domain;

import java.util.ArrayList;

public class Row {

	private Code cd; 
	private Score sc;
	
	public Row () {
		cd = new Code(); 
		sc = new Score(); 
	}
	
	//Changes may be done (Row can be created without a score
	public Row (String code, int whites, int blacks) {
		cd = new Code(code); 
		sc = new Score(whites, blacks); 
	}
	
	public String getCode () {
		return cd.getCode();
	}
	
	//On return index 1 is the number of black pins, index 2 is the number of white ones
	public ArrayList<Integer> getScore () {
		ArrayList<Integer> score = new ArrayList<Integer>(); 
		boolean failed;
		failed = score.add(sc.getBlacks()); 
		failed = score.add(sc.getWhites()); 
		//Exception; couldn't add to ArrayList
		return score; 
	}
	
	//We expect a correct code 
	public void setCode (String code) {
		cd.setCode(code); 
	}
	
	public void setScore (int whites, int blacks) {
		sc.setWhites(whites);
		sc.setBlacks(blacks);
	}
	
}
