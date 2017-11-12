package Drivers;

import java.util.ArrayList;
import java.util.Scanner;
import mcubetema.domain.Ranking;

public class RankingDriver {
	public static void write_options() {
		System.out.println("Methods of Ranking");
		System.out.println("Choose the method to try:");
		System.out.println("1. Try findUser(user,row)");
		System.out.println("2. Try Ranking(rankName,cols)");
		System.out.println("3. Try Ranking(rankName,cols, diff)");
		System.out.println("4. Try all getters");
		System.out.println("5. Try addRow()");
		System.out.println("6. FinishTest");
	}
	public static void main(String[] args) {
		Ranking ranking = new Ranking();
		boolean created = false;
		write_options();
		Scanner input = new Scanner(System.in);
		int option = input.nextInt();
		while (option != 6) {
			if (option == 1) {
					if (created) {
						System.out.println("Try findUser(user,row) selected");
						System.out.println("If the user exist, findUser will return true and the userRow in row");
						System.out.println("Else return false");
						System.out.println("In Ranking by Difficulty, the user can be repeated.");
						System.out.println("In this case, row contains the user with de best score");
						System.out.println("Enter the user you want to search:");
						String user = input.next();
						Pair<RankingRow, RankingRow> r;
						r = new Pair<RankingRow,RankingRow>();
						boolean exists = ranking.findUser(user, r);
						if (exists) {
							System.out.println("The user you are looking for exist");
							System.out.println("The username is: " + r.second.getUser() + " and his score is: " +  r.second.getScore());
						}
						else System.out.println("The user you are looking for does not exist");
					}
					else System.out.println("First create a Ranking with option 2 or 3"); 
					System.out.println("\n");
			}
			else if (option == 2) {
				System.out.println("Try Ranking(rankName,cols) selected");
				System.out.println("This constructor creates a 'General Ranking' or 'Ranking by Match'");
				System.out.println("Choose option 1. to create a 'General Ranking'");
				System.out.println("Choose option 2. to create a 'Ranking by Match");
				int op = input.nextInt();
				if (op == 1) {
					System.out.println("RankName will be 'General Ranking'");
					System.out.println("In this ranking the col_names will be Position, PlayerName, Score");
					System.out.println("Difficulty will be '---'");
					ArrayList<String> col_names = new ArrayList<>();
					col_names.add("Position");
					col_names.add("PlayerName");
					col_names.add("Score");
					ranking = new Ranking("General Ranking", col_names);
				}
				else if (op == 2) {
					System.out.println("RankName will be 'Ranking by  Match'");
					System.out.println("In this ranking the col_names will be Position, PlayerName, Score");
					System.out.println("Difficulty will be '---'");
					ArrayList<String> col_names = new ArrayList<>();
					col_names.add("Position");
					col_names.add("PlayerName");
					col_names.add("Score");
					ranking = new Ranking("Ranking by Match", col_names);
				}
				System.out.println("Ranking successfully created");
				System.out.println("Choose options 1 or 4 to test this Ranking");
				System.out.println("\n");
				created = true;	
			}
			else if (option == 3) {
				System.out.println("Try Ranking(rankName,cols, diff) selected");
				System.out.println("RankName will be 'Ranking by  Difficulty'");
				System.out.println("In this ranking the col_names will be Position, PlayerName, Score");
				System.out.println("Write the Difficulty:");
				System.out.println("Can be Easy, Medium or Difficult.");
				String diff = input.next();
				ArrayList<String> col_names = new ArrayList<>();
				col_names.add("Position");
				col_names.add("PlayerName");
				col_names.add("Score");
				ranking = new Ranking("Ranking by Difficulty", col_names, diff);
				System.out.println("Ranking successfully created");
				System.out.println("Choose option 1 or 4 to test this Ranking");
				System.out.println("\n");
				created = true;	
			}
			else if (option == 4) {
				if (!created) {
					System.out.println("First create a Ranking with option 2 or 3");
				}
				else {
					System.out.println("Try all getters selected");
					System.out.println("getRankName: " + ranking.getRankName());
					System.out.println("getdifficulty: " + ranking.getdifficulty());
					System.out.println("getColNames: ");
					for (String it : ranking.getColNames()) {
						System.out.print(it + " ");
					}
					System.out.print("\n");
					System.out.println("getnRows: ");
					if (ranking.getRows().size() == 0) System.out.println("This ranking has no rows");
					for (RankingRow it : ranking.getRows()) {
						System.out.println(it.getUser() + " " + it.getScore());
					}
				}

				System.out.println("\n");
			}
			
			else if (option == 5) {
				if (!created) {
					System.out.println("First create a Ranking with option 2 or 3");
				}
				else {
					System.out.println("Try addRow() selected");
					System.out.println("First create a row");
					System.out.println("Write a PlayerName: ");
					String user = input.next();
					System.out.println("Write his Score: ");
					int score = input.nextInt();
					RankingRow row = new RankingRow(user, score);
					System.out.println("If this is a General Ranking:");
					System.out.println("	If the user exists, the score in row created is added to the score in this Ranking");
					System.out.println("	Else the row is added");
					System.out.println("\n");
					System.out.println("If this is a Ranking by Match:");
					System.out.println("	If the user exists, the score in row created replaces the score in this Ranking");
					System.out.println("	Else the row is added");
					System.out.println("\n");
					System.out.println("If this is a Ranking by Difficulty:");
					System.out.println("	The row is added, no matter if the player exists before");
					ranking.addRow(row);
					System.out.println("\n");
					System.out.println("Row successfully added");
					System.out.println("Choose the option 1 or 4 to test this Ranking");
				}
				System.out.println("\n");
			}
			write_options();
			option = input.nextInt();
		}
		input.close();
	}
}
