package mcubetema.domain;

import java.util.*;

public class RankingChrono extends Ranking{
	private TreeSet<RankingChronoRow> chronoRows;
	/*Create a new RankingChrono with rank_name = name, col_names = colums, difficuly = diff and an empty chronoRows*/
 	public RankingChrono(String name,  ArrayList<String> colums, String diff) {
		super(name,colums, diff);
		chronoRows = new TreeSet<RankingChronoRow>();
	}
 	public TreeSet<RankingChronoRow> getChronoRow() {
 		return chronoRows;
 	}
 	public boolean addChronoRow(RankingChronoRow r) {
 		chronoRows.add(r);
 		return true;
 	}
}
