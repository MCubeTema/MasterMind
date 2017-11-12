package mcubetema.domain;

import java.util.*;

public class RankingChrono extends Ranking{
	private TreeSet<RankingChronoRow> chronoRows;
	
 	public RankingChrono(String name,  ArrayList<String> colums) {
		super(name,colums);
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
