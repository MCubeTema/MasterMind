package Drivers;
import java.util.*;
import mcubetema.domain.RankingRow;

public class RankingRowDriver {
	public static void write_options() {
		System.out.println("Methods of RankingRow");
		System.out.println("Choose the method to try:");
		System.out.println("1. Try RankingRow(user,score)");
		System.out.println("2. Try getUser()");
		System.out.println("3. Try getScore()");
		System.out.println("4. Try setScore(score)");
		System.out.println("5. Try compareTo(row)");
		System.out.println("6. FinishTest");
	}
	public static void main(String[] args) {
		RankingRow row = new RankingRow();
		boolean created = false;
		write_options();
		Scanner input = new Scanner(System.in);
		int option = input.nextInt();
		while (option != 6) {
			if (option == 1) {
				String user;
				int score;
				System.out.println("Try RankingRow(user,score) selected");
				System.out.println("Write an User:");
				user = input.next();
				System.out.println("Write a Score:");
				score = input.nextInt();
				row = new RankingRow(user,score);
				
				System.out.println("RankingRow successfully created");
				System.out.println("Choose options 2, 3 or 4 to test this row");
				System.out.println("\n");
				created = true;
				
			}
			else if (option == 2) {
				if (!created) {
					System.out.println("First create a row with option 1");
					System.out.println("\n");
				}
				else {
					System.out.println("Try getUser() selected");
					System.out.println("The User is: " + row.getUser());
					System.out.println("\n");
				}
			}
			else if (option == 3) {
				if (!created) {
					System.out.println("First create a row with option 1");
					System.out.println("\n");
				}
				else {
					System.out.println("Try getScore() selected");
					System.out.println("The Score is: " + row.getScore());
					System.out.println("\n");
				}
			}
			else if (option == 4) {
				if (!created) {
					System.out.println("First create a row with option 1");
					System.out.println("\n");
				}
				else {
					System.out.println("Try setScore(score) selected");
					System.out.println("The row has the values: ");
					System.out.println("User: "+ row.getUser() + " " + "Score: "+ row.getScore());
					System.out.println("Enter the new Score: ");
					int s = input.nextInt();
					row.setScore(s);
					System.out.println("The values are now: ");
					System.out.println("User: "+ row.getUser() + " " + "Score: " + row.getScore());
					System.out.println("\n");
					
				}
			}
			else if (option == 5) {
					System.out.println("Try compareTo(r) selected");
					System.out.println("This method compare two rows by score");
					System.out.println("Create two rows to test");
					System.out.println("Create row1: ");
					System.out.println("User1: "); 
					String user1 = input.next();
					System.out.println("Score1: "); 
					int score1 = input.nextInt();
					RankingRow r1 = new RankingRow(user1, score1);
					
					System.out.println("Create row2: ");
					System.out.println("User2: "); 
					String user2 = input.next();
					System.out.println("Score2: "); 
					int score2 = input.nextInt();
					RankingRow r2 = new RankingRow(user2, score2);
					
					System.out.println("Compare r1 with r2:");
				    if (r1.compareTo(r2) == -1) System.out.println("r1 is greater than r2");
				    else if (r1.compareTo(r2) == 1) System.out.println("r1 is greater than r2");
				    else System.out.println("r1 and r2 are equals");
			}
			write_options();
			option = input.nextInt();
			option =input.nextInt();
		}
		input.close();
	}
}
