package Drivers;

import java.util.Scanner;
import mcubetema.domain.Mode;

public class ModeDriver {
	public static void write_options() {
		System.out.println("Methods of Mode");
		System.out.println("Choose the method to try:");
		System.out.println("1. Try setDifficult(user,score)");
		System.out.println("2. Try setMedium()");
		System.out.println("3. Try setEasy()");
		System.out.println("4. Try all getters");
		System.out.println("5. FinishTest");
	}
	
	public static void main(String[] args) {
		Mode mode = new Mode();
		boolean created = false;
		write_options();
		Scanner input = new Scanner(System.in);
		int option = input.nextInt();
		while (option != 5) {
			if (option == 1) {
					System.out.println("Try setDifficult() selected");
					mode.setDifficult();
					System.out.println("Choose option 4. to see the values of difficult mode");
					System.out.println("\n");
					created = true;	
			}
			else if (option == 2) {
				System.out.println("Try setMedium() selected");
				mode.setMedium();
				System.out.println("Choose option 4. to see the values of medium mode");
				System.out.println("\n");
				created = true;	
			}
			else if (option == 3) {
				System.out.println("Try setEasy() selected");
				mode.setEasy();
				System.out.println("Choose option 4. to see the values of easy mode");
				System.out.println("\n");
				created = true;	
			}
			else if (option == 4) {
				if (!created) {
					System.out.println("First set one mode");
					System.out.println("\n");
				}
				else {
					System.out.println("Try all getters selected");
					System.out.println("getdifFactor: " + mode.getdifFactor());
					System.out.println("getclueFactor: " + mode.getclueFactor());
					System.out.println("getrowBon: " + mode.getrowBon());
					System.out.println("getnumberColors: " + mode.getnumberColors());
					System.out.println("getnRows: " + mode.getnRows());
					System.out.println("getnCols: " + mode.getnCols());
					System.out.println("\n");
				}
			}
			write_options();
			option = input.nextInt();
		}
		input.close();
	}
}
