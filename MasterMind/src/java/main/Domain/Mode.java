package Domain;

public class Mode {
	
	private Double difFactor;
	private Double clueFactor;
	private Double rowBon;
	private Integer numberColors;
	private Double nRows;
	private Integer nCols;
	
	public Mode() {
	}
	public void setDifficult() {
		difFactor = 1.25;
		clueFactor = 50.0;
		rowBon = 125.0;
		numberColors = 8;
		nRows = 12.;
		nCols = 5;
	}
	public void setMedium() {
		difFactor = 1.0;
		clueFactor = 35.0;
		rowBon = 100.0;
		numberColors = 5;
		nRows = 10.;
		nCols = 4; 
	}
	public void setEasy() {
		difFactor = 0.75;
		clueFactor = 20.0;
		rowBon = 100.0;
		numberColors = 5;
		nRows = 8.;
		nCols = 4;
	}
	
	public Double getdifFactor() {
		return difFactor;
	}
	
	public Double getclueFactor() {
		return clueFactor;
	}
	
	public Double getrowBon() {
		return rowBon;
	}
	
	public Integer getnumberColors() {
		return numberColors;
	}
	
	public Double getnRows() {
		return nRows;
	}
	
	public Integer getnCols() {
		return nCols;
	}
}
