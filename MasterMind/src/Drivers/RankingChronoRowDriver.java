package Drivers;

import java.util.Scanner;
import java.sql.*;
import mcubetema.domain.Mode;

public class RankingChronoRowDriver {
	public static void write_options() {
		System.out.println("Methods of RankingChronoRow");
		System.out.println("Choose the method to try:");
		System.out.println("1. Try RankingChronoRow(user, score, time)");
		System.out.println("2. Try getTime()");
		System.out.println("3. Try setTime(time)");
		System.out.println("4. FinishTest");
	}
	public static void main(String[] args) {
		RankingChronoRow rankChronoRow = new RankingChronoRow();
		boolean created = false;
		write_options();
		Scanner input = new Scanner(System.in);
		int option = input.nextInt();
		while (option != 4) {
			if (option == 1) {
					System.out.println("Try RankingChronoRow(user, score, time) selected");
					System.out.println("Write a username: ");
					String user = input.next();
					System.out.println("Write a score: ");
					int score = input.nextInt();
					System.out.println("Write a time (only in seconds or hh:mm:ss format): ");
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
					rankChronoRow = new RankingChronoRow(user, score ,time);
					System.out.println("RankingChronoRow successfully created");
					System.out.println("Choose option 2. or 3. to test this chronoRow");
					System.out.println("\n");
					created = true;	
			}
			else if (option == 2) {
				if (!created) {
					System.out.println("First create a chronoRow with option 1");
					System.out.println("\n");
				}
				else {
					System.out.println("Try getTime() selected");
					System.out.println("The Time is: " + rankChronoRow.getTime());
					System.out.println("\n");
				}
			}
			else if (option == 3) {
				if (!created) {
					System.out.println("First create a chronoRow with option 1");
					System.out.println("\n");
				}
				else {
					System.out.println("Try setTime() selected");
					System.out.println("The chronoRow has the values: ");
					System.out.println("User: "+ rankChronoRow.getUser() + " " + "Score: "+ rankChronoRow.getScore() + " " + "Time: " + rankChronoRow.getTime().toString());
					System.out.println("Enter the new time(only in seconds or hh:mm:ss format): ");
					String format;
					int seconds;
					Time time;
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
					rankChronoRow.setTime(time);
					System.out.println("The values are now: ");
					System.out.println("User: "+ rankChronoRow.getUser() + " " + "Score: " + rankChronoRow.getScore() + " " + "Time: " + rankChronoRow.getTime());
					System.out.println("\n");
					
				}
			}
			write_options();
			option = input.nextInt();
		}
		input.close();
	}
	
}
