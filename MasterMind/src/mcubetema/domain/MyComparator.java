package mcubetema.domain;

import java.util.*;

class MyComparator implements Comparator<RankingRow> {
	/* Compare two RankingRows: First by Score and then by Username*/
	public int compare(RankingRow r1, RankingRow r2) {
		if (r1.getScore() < r2.getScore()) {
			return 1;
		}
		if (r1.getScore() > r2.getScore()) {
			return -1;
		}
		if (r1.getUser().compareTo(r2.getUser()) != 0) {
			return r1.getUser().compareTo(r2.getUser());
		}
		else return -1;
	}
	
}
