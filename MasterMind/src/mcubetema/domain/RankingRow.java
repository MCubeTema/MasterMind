package mcubetema.domain;
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
	public int compareTo(RankingRow r1) {
		if (score < r1.score) {
			return 1;
		}
		if (score > r1.score) {
			return -1;
		}
		return user.compareTo(r1.user);
	}
}
