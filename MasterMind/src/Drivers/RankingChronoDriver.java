package Drivers;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Scanner;
import mcubetema.domain.RankingChrono;

public class RankingChronoDriver {
	public static void write_options() {
		System.out.println("Methods of RankingChrono");
		System.out.println("Choose the method to try:");
		System.out.println("1. Try RankingChrono(rankName,col_names, diff)");
		System.out.println("2. Try getChronoRows()");
		System.out.println("3. Try addChronoRow(chronoRow)");
		System.out.println("4. FinishTest");
	}
	
	public static void main(String[] args) {
		RankingChrono rankChrono = new RankingChrono();
		boolean created = false;
		write_options();
		Scanner input = new Scanner(System.in);
		int option = input.nextInt();
		while (option != 4) {
			if (option == 1) {
					System.out.println("Try RankingChrono(rankName, col_names, diff) selected");
					System.out.println("Write the rankName:");
					String name = input.next();
					System.out.println("In this ranking the col_names will be Position, PlayerName, Score, Time");
					ArrayList<String> col_names = new ArrayList<>();
					col_names.add("Position");
					col_names.add("PlayerName");
					col_names.add("Score");
					col_names.add("Time");
					System.out.println("Write the difficulty:");
					String diff = input.next();
					rankChrono = new RankingChrono(name,col_names,diff);
					System.out.println("RankingChrono successfully created");
					System.out.println("Choose option 2. or 3. addChronoRows or see this rows");
					System.out.println("\n");
					created = true;	
			}
			else if (option == 2) {
				if (!created) {
					System.out.println("First create a RankingChrono with option 1");
				}
				else {
					System.out.println("Try getChronoRows() selected");
					if (rankChrono.getChronoRows().size() == 0) System.out.println("This RankingChrono has no rows");
					for (RankingChronoRow it : rankChrono.getChronoRows()) {
						System.out.println("User: " + it.getUser() + " Score: " + it.getScore() + " Time: " + it.getTime());
					}
					System.out.println("\n");
				}
			}
			else if (option == 3) {
				if (!created) {
					System.out.println("First create a RankingChrono with option 1");
				}
				else {
					System.out.println("Try addChronoRows(chronoRow) selected");
					System.out.println("First create a chronoRow");
					System.out.println("Write a PlayerName: ");
					String user = input.next();
					System.out.println("Write his Score: ");
					int score = input.nextInt();
					System.out.println("Write his Time(only in seconds or in hh:mm:ss format: ");
					Time time;
					String format;
					int seconds;
					if (input.hasNextInt()) {
						seconds = input.nextInt();
						int h, m, s;
						h = seconds/ 3600;
						seconds = seconds % 3600;
						m = seconds/60;
						seconds = seconds % 60;
						s = seconds;
						time = new Time(h,m,s);
					}
					else {
						format = input.next();
						time = Time.valueOf(format);
					}
					
					RankingChronoRow row = new RankingChronoRow(user, score, time);
					rankChrono.addChronoRow(row);
					System.out.println("ChronoRow successfully added");
					System.out.println("Choose the option 2. to see the ChronoRows");
					System.out.println("\n");
				}
			}

			write_options();
			option = input.nextInt();
		}
		input.close();
	}
	
}
