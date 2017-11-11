package Domain;
import java.util.*;

public class Ranking {

	private String rank_name;
	private ArrayList<String> col_names;
	private TreeSet<RankingRow> rows;
	
	private boolean findUser(String user, RankingRow row) {
		boolean exists = false;
		for (RankingRow it : rows) {
			if (it.getUser() == user) {
				exists = true;
				row = it;
				break;
			}
		}
		return exists;
	}
	
	
	public Ranking() {
		col_names = new ArrayList<String>();
		rows = new TreeSet<RankingRow>();
	}
	
	public Ranking(String name, ArrayList<String> cols) {
		rank_name = name;
		col_names = cols;
		rows = new TreeSet<RankingRow>();
	}
	
	public String getRankName() {
		return rank_name;
	}
	
	public ArrayList<String> getColNames() {
		return col_names;
	}
	
	public TreeSet<RankingRow> getRows() {
		return rows;
	}
	
	public boolean addRow(RankingRow row) {
		RankingRow r = new RankingRow();
		boolean exists = findUser(row.getUser(), r);
		if (exists) {
			if (rank_name == "General Ranking") {
				r.setScore(r.getScore() + row.getScore());
			}
			else if (rank_name == "Ranking by Match") {
				r.setScore(row.getScore());
			}
			else if (rank_name == "Ranking by Difficulty") {
				rows.add(row);
			}
		}
		else rows.add(row);
		return true;
	}
	
	public boolean setRankName(String name) {
		rank_name = name;
		return true;
	}
	
	public boolean setColnames(ArrayList<String> cols) {
		col_names = cols;
		return true;
	}
	public boolean setRows(TreeSet<RankingRow> rows) {
		this.rows = rows;
		return true;
	}

}
