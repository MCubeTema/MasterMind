package mcubetema.domain;
import java.util.*;
package java.Auxiliar.Pair;
public class Ranking {

	private String rank_name;
	private String difficulty;
	private ArrayList<String> col_names;
	private TreeSet<RankingRow> rows;
	
	/*Pre: True
	  Post: Return if exists the RankingRow in row with the user passed as a paremeter.
	  	If exists RankingRows with the user passed, row will have the RankingRow with the best score in row.second*/
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
	/*Create a new General Ranking or new Ranking by Match with rank_name = name, col_names = cols, an empty rows and without difficulty*/
	public Ranking(String name, ArrayList<String> cols) {
		rank_name = name;
		col_names = cols;
		rows = new TreeSet<RankingRow>(new MyComparator());
		difficulty = "---";
	}
	/*Create a new Ranking by Difficulty with rank_name = name, col_names = cols, difficulty = diff and an empty rows*/
	public Ranking(String name, ArrayList<String> cols, String dif) {
		rank_name = name;
		col_names = cols;
		difficulty = dif;
		rows = new TreeSet<RankingRow>(new MyComparator());
	}
	/*Pre: True
	 Post: Return rank_name*/
	public String getRankName() {
		return rank_name;
	}
	/*Pre: True
	 Post: Return the difficulty of Ranking */
	public String getdifficulty() {
		return difficulty;
	}
	/*Pre: True
	 Post: Return the name of the cols of this Ranking*/
	public ArrayList<String> getColNames() {
		return col_names;
	}
	/*Pre: True
	 Post: Return the RankingRows of this Ranking*/
	public TreeSet<RankingRow> getRows() {
		return rows;
	}
	
	/*Pre: True
	  Post: If Ranking is a General Ranking
	  		if user of row exists, addRows sum the last score of user in rows with the score in row
			else only add row in rows
	  	else if Ranking is a Ranking by Match 
			if user of row exists, set the RankingRow row in rows if score of row has a better score
			else only add row in rows
		else if Ranking is a Ranking by difficulty addRow add RankingRow row in rows*/
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
