package Domain;
import java.util.*;

public class RankingRow implements Comparable<RankingRow>{
	private String user;
	private int score;
	
	public RankingRow() {
	}
	
	public RankingRow(String u, Integer s) {
		user = u;
		score = s;
	}
	
	public String getUser() {
		return user;
	}
	
	public int getScore() {
		return score;
	}
	
	public boolean setScore(Integer s) {
		score = s;
		return true;
	}
	
	@Override
	public int compareTo(RankingRow r) {
		if (score < r.score) {
			return 1;
		}
		if (score > r.score) {
			return -1;
		}
		return 0;
	}
	
}
