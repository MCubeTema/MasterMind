package mcubetema.domain;
import java.sql.Time;

public class RankingChronoRow extends RankingRow {
	
	private Time time;
	
	public RankingChronoRow() {
	}
	/*Create a new RankingChronoRow with super.user = user, super.score = score and the time used in the game by user*/
	public RankingChronoRow(String user, int score, Time time) {
		super(user,score);
		this.time = time;
	}
	/*Pre: True
	  Post: Return the time of a RankingChronoRow*/
	public Time getTime() {
		return time;
	}
	/*Pre: True
	  Post: Set time in Time of a RankingChronoRow*/
	public boolean setTime(Time time) {
		this.time = time;
		return true;
	}
}
