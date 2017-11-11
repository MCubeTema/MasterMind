package java.main.Domain;

import java.util.ArrayList;

public class Board {
	
	private ArrayList<Row> mainBoard;
	private Code secretCode; 
	
	private int lengthCode; 
	private int numRows;
	private int numColors; 
	private boolean isFinished; 

	//Creates a default game of MasterMind without code (won't be needed most likely)
	public Board () {
		mainBoard = new ArrayList<Row>();
		secretCode = new Code(); 
		lengthCode = 4; 
		numRows = 10;
		numColors = 6;
		isFinished = false; 
	}
	
	//Creates a generic game of MasterMind with a defined secret code 
	public Board (String secretCode, int length, int rows, int colors) {
		mainBoard = new ArrayList<Row>(); 
		this.secretCode = new Code(secretCode);
		lengthCode = length; 
		numRows = rows; 
		numColors = colors; 
		isFinished = false; 
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
			aux = new Row(code, whites, blacks); 
			mainBoard.add(aux);
		}
		this.secretCode = new Code(secretCode); //gc will check if secretCode is correct? 
		lengthCode = length; 
		numRows = rows; 
		numColors = colors; 
		isFinished = false; 
	}
	
	public boolean gameFinished () {
		return isFinished; 
	}
}
