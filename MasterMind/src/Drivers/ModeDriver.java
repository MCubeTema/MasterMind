package Domain;

import java.util.Scanner;
import mcubetema.domain.Mode;

public class ModeDriver {
	public static void write_options() {
		System.out.println("Methods of Mode");
		System.out.println("Choose the method to try:");
		System.out.println("1. Try Mode(type)");
		System.out.println("2. Try setDifficult(user,score)");
		System.out.println("3. Try setMedium()");
		System.out.println("4. Try setEasy()");
		System.out.println("5. Try all getters");
		System.out.println("6. FinishTest");
	}
	
	public static void main(String[] args) {
		Mode mode = new Mode();
		boolean created = false;
		write_options();
		Scanner input = new Scanner(System.in);
		int option = input.nextInt();
		while (option != 6) {
			
			if (option == 1) {
				System.out.println("Try Mode(type) selected");
				System.out.println("Write an difficulty(Easy, Medium or Difficult): ");
				String type = input.next();
				mode = new Mode(type);
				System.out.println("Mode successfully created");
				System.out.println("Choose option 5. to see the values of difficult mode");
				created = true;
			}
			if (option == 2) {
					System.out.println("Try setDifficult() selected");
					mode.setDifficult();
					System.out.println("Choose option 5. to see the values of difficult mode");
					System.out.println("\n");
			}
			else if (option == 3) {
				System.out.println("Try setMedium() selected");
				mode.setMedium();
				System.out.println("Choose option 5. to see the values of medium mode");
				System.out.println("\n");
			}
			else if (option == 4) {
				System.out.println("Try setEasy() selected");
				mode.setEasy();
				System.out.println("Choose option 5. to see the values of easy mode");
				System.out.println("\n");
			}
			else if (option == 5) {
				if (!created) {
					System.out.println("First create one mode");
					System.out.println("\n");
				}
				else {
					System.out.println("Try all getters selected");
					System.out.println("getType: " + mode.getType());
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
