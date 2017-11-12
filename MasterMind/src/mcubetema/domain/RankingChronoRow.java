package mcubetema.domain;
import java.sql.Time;

public class RankingChronoRow extends RankingRow {
	
	private Time time;
	
	public RankingChronoRow() {
	}
	
	public RankingChronoRow(String user, int score, Time time) {
		super(user,score);
		this.time = time;
	}
	
	public Time getTime() {
		return time;
	}
	public boolean setTime(Time time) {
		this.time = time;
		return true;
	}
}
