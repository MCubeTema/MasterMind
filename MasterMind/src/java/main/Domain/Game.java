package java.main.Domain;

import java.util.ArrayList;

public class Game {
	
	private Board board;
	private Mode m; 
	
	private int numCluesUsed;
	private int numJokersUsed; 
	private int role; //0 Codemaker 1 codeBreaker
	
	
	public void createGame () {
	}
	
	public void setGame (ArrayList<ArrayList<String>> gameInfo) {
		int endBoard = 0; 
		int i = 0;
		boolean found = false; 
		while ( !found && i < gameInfo.size()) {
			if (gameInfo.get(i).get(0) == "SecretCode") endBoard = i; 
			++i; 
		}
		
		String secretCode;
		int lengthc, numr, numc; 
		for (i = i - 1; i < gameInfo.size(); ++i) {
			if (gameInfo.get(i).get(0) == "SecretCode") secretCode = gameInfo.get(i).get(1); 
			else if (gameInfo.get(i).get(0) == "LengthCode") lengthc = Integer.parseInt(gameInfo.get(i).get(1));
			else if (gameInfo.get(i).get(0) == "NumRows") numr = Integer.parseInt(gameInfo.get(i).get(1));
			else if (gameInfo.get(i).get(0) == "NumColors") numc = Integer.parseInt(gameInfo.get(i).get(1));
			else if (gameInfo.get(i).get(0) == "CluesUsed") numCluesUsed = Integer.parseInt(gameInfo.get(i).get(1));
			else if (gameInfo.get(i).get(0) == "JokersUsed") numJokersUsed = Integer.parseInt(gameInfo.get(i).get(1));
			else if (gameInfo.get(i).get(0) == "Mode") m = getModeByNum(Integer.parseInt(gameInfo.get(i).get(1)));
			else if (gameInfo.get(i).get(0) == "Role") role = Integer.parseInt(gameInfo.get(i).get(1)); //Not right
		}
		ArrayList<ArrayList<String>> board = new ArrayList<ArrayList<String>>(gameInfo.subList(0, endBoard)); 
		this.board = new Board(board, secretCode, lengthc, numr, numc); 
	}
	
	//Returns Board, numClues, numJokers and role
	public ArrayList<ArrayList<String>> getGame () {
		ArrayList<ArrayList<String>> ret = board.getBoard();
		ArrayList<String> retAux = new ArrayList<String>(); 
		retAux.add("CluesUsed"); retAux.add(Integer.toString(numCluesUsed));
		ret.add(retAux); 
		retAux.clear(); 
		retAux.add("JokersUsed"); retAux.add(Integer.toString(numJokersUsed));
		ret.add(retAux); 
		retAux.clear();
		retAux.add("Mode"); retAux.add(m.getNumMode()); //We need that number
		ret.add(retAux); 
		retAux.clear();
		retAux.add("Role"); retAux.add(Integer.toString(role));
		ret.add(retAux);
		return ret; 
	}
	
	public int getPlayerRole () {
		return role; 
	}
	
	
	
}
