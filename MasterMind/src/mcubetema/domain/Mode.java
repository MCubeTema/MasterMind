package mcubetema.domain;

public class Mode {
	
	private String type;
	private Double difFactor;
	private Double clueFactor;
	private Double rowBon;
	private Integer numberColors;
	private Integer nRows;
	private Integer nCols;
	
	public Mode() {
		
	}
	/*Create a new mode with the difficulty t*/
	public Mode(String t) {
		type = t;
		if (type.equals("Easy")) {
			setEasy();
		}
		else if (type.equals("Medium")) {
			setMedium();
		}
		else if(type.equals("Difficult")) {
			setDifficult();
		}
	}
	/*Set all values of difficult mode*/
	public void setDifficult() {
		difFactor = 1.25;
		clueFactor = 50.0;
		rowBon = 125.0;
		numberColors = 8;
		nRows = 12;
		nCols = 5;
	}
	/*Set all values of medium mode*/
	public void setMedium() {
		difFactor = 1.0;
		clueFactor = 35.0;
		rowBon = 100.0;
		numberColors = 5;
		nRows = 10;
		nCols = 4; 
	}
	/*Set all values of easy mode*/
	public void setEasy() {
		difFactor = 0.75;
		clueFactor = 20.0;
		rowBon = 100.0;
		numberColors = 5;
		nRows = 8;
		nCols = 4;
	}
	/*Pre: True
	  Post: Return the difficulty of Match*/
	public String getType() {
		return type;
	}
	/*Pre: True
	  Post: Return the diffFactor to calculate the score in game*/
	public Double getdifFactor() {
		return difFactor;
	}
	/*Pre: True
	  Post: Return the clueFactor to calculate the score in game*/
	public Double getclueFactor() {
		return clueFactor;
	}
	/*Pre: True
	  Post: Return the rowBon to calculate the score in game*/
	public Double getrowBon() {
		return rowBon;
	}
	/*Pre: True
	  Post: Return the number of colors for a game mode*/
	public Integer getnumberColors() {
		return numberColors;
	}
	/*Pre: True
	  Post: Return the number of rows of board for a game mode*/
	public Integer getnRows() {
		return nRows;
	}
	/*Pre: True
	  Post: Return the number of cols of board for a game mode*/
	public Integer getnCols() {
		return nCols;
	}
}
