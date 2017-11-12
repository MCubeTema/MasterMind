package java.main.Domain;

import java.util.ArrayList;

public class Board {
	
	private ArrayList<Row> mainBoard;
	private Code secretCode; 
	
	private int lengthCode; 
	private int numRows;
	private int numColors; 
	private boolean isFinished; 
	private int indexLastRow; 

	//Creates a default game of MasterMind without code (won't be needed most likely)
	public Board () {
		mainBoard = new ArrayList<Row>();
		secretCode = new Code(); 
		lengthCode = 4; 
		numRows = 10;
		numColors = 6;
		isFinished = false; 
		indexLastRow = 0; 
	}
	
	//Creates a generic game of MasterMind with a defined secret code 
	public Board (String secretCode, int length, int rows, int colors) {
		mainBoard = new ArrayList<Row>(); 
		this.secretCode = new Code(secretCode);
		lengthCode = length; 
		numRows = rows; 
		numColors = colors; 
		isFinished = false;
		indexLastRow = 0; 
	}
	
	//Needed to load already existing games (Code could be decreased with a setBoard method instead) 
	//rowsInfo contains (1-code, whites, blacks 2-code1, whites1, blacks1...) starting from the row 0.
	//rowsInfo.size() < numRows (checked on class Match) -- Won't even happen. Finished games cannot be saved 
	public Board (ArrayList<ArrayList<String>> rowsInfo, String secretCode, int length, int rows, int colors) {
		int nRowsDone = rowsInfo.size();
		Row aux;
		String code; 
		int whites, blacks; 
		for (int i = 0; i < nRowsDone; ++i) {
			code = rowsInfo.get(i).get(0);
			whites = Integer.parseInt(rowsInfo.get(i).get(1));
			blacks = Integer.parseInt(rowsInfo.get(i).get(2));
			aux = new Row();
			aux.setCode(code);
			aux.setScore(whites, blacks);
			mainBoard.add(aux);
		}
		this.secretCode = new Code(secretCode); //gc will check if secretCode is correct? 
		lengthCode = length; 
		numRows = rows; 
		numColors = colors; 
		isFinished = false;
		indexLastRow = rowsInfo.size() - 1; 
	}
	
	//indexLastRow == numRows
	public boolean gameFinished () {
		return isFinished; 
	}
	
	//Returns -1 if code is not correct (length)
	public int nextGuess (String code) {
		if (code.length() != lengthCode) return -1; 
		Row aux = new Row(); 
		aux.setCode(code); 
		mainBoard.add(aux); 
		indexLastRow++;
		if (indexLastRow == numRows) isFinished = true; 
		return 0; 
	}
	
	//Returns mean: 0. correct score, -1 incorrect score
	public int scoreGuess (int whites, int blacks) {
		Row lastRow = mainBoard.get(indexLastRow); 
		ArrayList<Integer> correctScore = lastRow.correctScore(secretCode, numColors); 
		if (blacks != correctScore.get(0) || whites != correctScore.get(1)) return -1; 
		else {
			lastRow.setScore(whites, blacks);
			++indexLastRow; 
			return 0; 
		}
	}
	
	public ArrayList<ArrayList<String>> getBoard () {
		ArrayList<ArrayList<String>> ret = new ArrayList<ArrayList<String>>(); 
		ArrayList<String> row = new ArrayList<String>(); 
		String code; 
		String whites; 
		String blacks; 
		for (int i = 0; i < mainBoard.size(); ++i) {
			Row iRow = mainBoard.get(i);
			code = iRow.getCode(); 
			blacks = Integer.toString(iRow.getScore().get(0)); //Can be optimized with less accesses
			if (blacks != "-1") {
				whites = Integer.toString(iRow.getScore().get(1)); 
				row.add(code); row.add(blacks); row.add(whites); 
			}
			else row.add(code); 
			ret.add(row);
			row.clear();
		}
		row.clear();
		row.add("SecretCode");row.add(secretCode.getCode());
		ret.add(row);
		row.clear();
		row.add("LengthCode"); row.add(Integer.toString(lengthCode)); 
		ret.add(row); 
		row.clear();
		row.add("NumRows"); row.add(Integer.toString(numRows)); 
		ret.add(row); 
		row.clear();
		row.add("NumColors"); row.add(Integer.toString(numColors)); 
		ret.add(row); 
		return ret; 
	}
}
