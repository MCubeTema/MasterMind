package Domain;

public class RankingChronoRow extends RankingRow {
	
	private double time;
	
	public RankingChronoRow() {
	}
	
	public RankingChronoRow(String user, int score, double time) {
		super(user,score);
		this.time = time;
	}
	
	public double getTime() {
		return time;
	}
	public boolean setTime(double time) {
		this.time = time;
		return true;
	}
}
