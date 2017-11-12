package mcubetema.domain;
import java.util.*;

public class Ranking {

	private String rank_name;
	private String difficulty;
	private ArrayList<String> col_names;
	private TreeSet<RankingRow> rows;
	
	public boolean findUser(String user, Pair<RankingRow,RankingRow> row) {
		boolean exists = false;
		for (RankingRow it : rows) {
			if (it.getUser().equals(user)) {
				exists = true;
				row.second = it;
				break;
			}
		}
		return exists;
	}
	
	
	public Ranking() {
		col_names = new ArrayList<String>();
		rows = new TreeSet<RankingRow>(new MyComparator());
		difficulty = "---";
	}
	
	public Ranking(String name, ArrayList<String> cols) {
		rank_name = name;
		col_names = cols;
		rows = new TreeSet<RankingRow>(new MyComparator());
		difficulty = "---";
	}
	
	public Ranking(String name, ArrayList<String> cols, String dif) {
		rank_name = name;
		col_names = cols;
		difficulty = dif;
		rows = new TreeSet<RankingRow>(new MyComparator());
	}
	
	public String getRankName() {
		return rank_name;
	}
	
	public String getdifficulty() {
		return difficulty;
	}
	
	public ArrayList<String> getColNames() {
		return col_names;
	}
	
	public TreeSet<RankingRow> getRows() {
		return rows;
	}
	
	public boolean addRow(RankingRow row) {
		Pair<RankingRow, RankingRow> r;
		r = new Pair<RankingRow,RankingRow>();
		r.first = new RankingRow();
		boolean exists = findUser(row.getUser(), r);
		if (exists) {
			if (rank_name == "General Ranking") {
				int oldScore = r.second.getScore();
				int newScore = row.getScore();
				rows.remove(r.second);
				row.setScore(oldScore + newScore);
				rows.add(row);
			}
			else if (rank_name == "Ranking by Match") {
				if (r.second.getScore() < row.getScore()) {
					rows.remove(r.second);
					rows.add(row);
				}
			}
			else if (rank_name == "Ranking by Difficulty") {
				rows.add(row);
			}
		}
		else rows.add(row);
		return true;
	}
	

}
