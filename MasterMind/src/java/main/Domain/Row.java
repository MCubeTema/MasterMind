package java.main.Domain;

import java.util.ArrayList;
import java.lang.Math;

public class Row {

	private Code cd; 
	private Score sc;
	
	private boolean scoreIsSet; 
	
	public Row () {
		cd = new Code(); 
		sc = new Score();
		scoreIsSet = false; 
	}
	
	//Changes may be done (Row can be created without a score)
	//public Row (String code, int whites, int blacks) {
		//cd = new Code(code); 
		//sc = new Score(whites, blacks); 
	//}
	
	public String getCode () {
		return cd.getCode();
	}
	
	//On return index 1 is the number of black pins, index 2 is the number of white ones
	public ArrayList<Integer> getScore () {
		ArrayList<Integer> score = new ArrayList<Integer>(); 
		boolean failed;
		if (scoreIsSet) {
			failed = score.add(sc.getBlacks()); 
			failed = score.add(sc.getWhites()); 
		}
		else score.add(-1); 
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
		scoreIsSet = true; 
	}
	
	//Returns 1.blacks 2.whites in ArrayList
	public ArrayList<Integer> correctScore (Code otherCd, int numColors) {
		String code = cd.getCode(); 
		String otherCode = otherCd.getCode(); 
		int size = code.length(); 
		int white = 0;
		int black = 0; 
		for (int i = 0; i < size; ++i) {
			if (code.charAt(i) == otherCode.charAt(i)) ++black; 	
		}
		int colorInCode = 0; 
		int colorInOtherCode = 0; 
		for (int j = 0; j < numColors; ++j) {
			for (int k = 0; k < size; ++k) {
				if (code.charAt(k) == j) ++colorInCode; 
				if (otherCode.charAt(k) == j) ++colorInOtherCode; 
				white += Math.min(colorInCode, colorInOtherCode); 
			}
		}
		white = white - black; 
		ArrayList<Integer> ret = new ArrayList<Integer>(); 
		ret.add(black);
		ret.add(white); 
		return ret; 
	}
}
