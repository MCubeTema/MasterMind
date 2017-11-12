package java.main.Domain;

public class Score {
	
	private int numWhites; 
	private int numBlacks; 
	
	public Score() {
		numWhites = 0; 
		numBlacks = 0; 
	}
	
	public Score(int whites, int blacks) {
		numWhites = whites; 
		numBlacks = blacks; 
	}
	
	public int getWhites () {
		return numWhites; 
	}
	
	public int getBlacks () {
		return numBlacks; 
	}
	
	public void setWhites (int whites) {
		numWhites = whites; 
	}
	
	public void setBlacks (int blacks) {
		numBlacks = blacks; 
	}
	
	public boolean equalScore (int whites, int blacks) {
		return (whites == numWhites && blacks == numBlacks);
	}
}
