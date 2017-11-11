package Drivers;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import mcubetema.domain.*;

public class InventoryDriver {

	private static void showMenu() {
		System.out.println("0 - Create a default inventory");
		System.out.println("1 - Create an inventory as if it was loaded from disk");
		System.out.println("2 - Spend coins");
		System.out.println("3 - Earn coins");
		System.out.println("4 - Get the number of coins");
		System.out.println("5 - Get the inventory");
		System.out.println("6 - Add an article to the inventory");
		System.out.println("7 - Remove an article from the inventory");
		System.out.println("8 - Exit");
	}
	
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Welcome to the driver to test the class Inventory, plese choose an option:");
		showMenu();
		Inventory inventory = null;
		int numArticles = 2; //This may change in the future
		Scanner scanner = new Scanner(System.in);
		int option;
		while (scanner.hasNext()) {
			option = scanner.nextInt();
			if (option == 0) {
				inventory = new Inventory();
				System.out.print("Inventory created successfully");
			}
			else if (option == 1) {
				System.out.println("Please, enter the number of coins and the amount of"
						+ " each article (" + numArticles + " numbers), all separated by blank spaces:");
				scanner.hasNext();
				int numberOfCoins = scanner.nextInt();
				ArrayList<Integer> amounts = new ArrayList<Integer>();
				for (int i = 0; i < numArticles; ++i) {
					scanner.hasNext();
					int amount = scanner.nextInt();
					amounts.add(amount);
				}
				inventory = new Inventory(numberOfCoins, amounts);
				System.out.print("Inventory created successfully");
			}
			else if (option == 2) {
				if (inventory != null) {
					System.out.println("Please, enter the amount of coins you would like to spend:");
					scanner.hasNext();
					int numberOfCoins = scanner.nextInt();
					inventory.spendCoins(numberOfCoins);
					System.out.print("Coins spent successfully");
				}
				else System.out.println("Please, create the inventory first");
			}
			else if (option == 3) {
				if (inventory != null) {
					System.out.println("Please, enter the amount of coins you would like to earn:");
					scanner.hasNext();
					int numberOfCoins = scanner.nextInt();
					inventory.earnCoins(numberOfCoins);
					System.out.print("Coins earned successfully");
				}
				else System.out.println("Please, create the inventory first");
			}
			else if (option == 4) {
				if (inventory != null) {
					int numberOfCoins = inventory.getCoins();
					System.out.println("The current number of coins is " + numberOfCoins);
				}
				else System.out.println("Please, create the inventory first");
			}
			else if (option == 5) {
				if (inventory != null) {
					ArrayList<String> inventoryInfo = inventory.getInventory();
					int numberOfCoins = Integer.parseInt(inventoryInfo.get(0));
					System.out.println("Coins: " + numberOfCoins);
					System.out.println("Amount of articles:");
					for (int i = 1; i < inventoryInfo.size(); ++i) {
						System.out.println("Article " + i + ": " + inventoryInfo.get(i));
					}
				}
				else System.out.println("Please, create the inventory first");
			}
			else if (option == 6) {
				if (inventory != null) {
					System.out.println("Please, enter the number of the article you would "
							+ "like to be added to the inventory (0 - " + String.valueOf(numArticles - 1) + "):");
					scanner.hasNext();
					int articleNum = scanner.nextInt();
					inventory.addArticle(articleNum);
					System.out.print("Article added successfully");
				}
				else System.out.println("Please, create the inventory first");
			}
			else if (option == 7) {
				if (inventory != null) {
					System.out.println("Please, enter the number of the article you would "
							+ "like to be removed from the inventory (0 - " + String.valueOf(numArticles - 1) + "):");
					scanner.hasNext();
					int articleNum = scanner.nextInt();
					int errorCode = inventory.removeArticle(articleNum);
					if (errorCode == 0) System.out.println("Item removed successfully");
					else System.out.println("There were no article to be removed");
				}
				else System.out.println("Please, create the inventory first");
			}
			else if (option == 8) {
				break;
			}
			TimeUnit.SECONDS.sleep(2);
			showMenu();
		}
		scanner.close();
		System.out.println("Now leaving");
	}
}
