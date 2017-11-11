package Drivers;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import mcubetema.domain.*;

public class ShopDriver {
	
	private static void showMenu() {
		System.out.println("0 - Create a default shop");
		System.out.println("1 - Create a shop as if it were loaded from disk");
		System.out.println("2 - Get the shop");
		System.out.println("3 - Get the shop in a format as if it were about to be saved in disk");
		System.out.println("4 - Check whether an item is unlocked or not");
		System.out.println("5 - Get the buying price of an article");
		System.out.println("6 - Get the selling price of an article");
		System.out.println("7 - Update the unlocked articles according to a score");
		System.out.println("8 - Exit");
	}
	
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Welcome to the driver to test the class Shop, plese choose an option:");
		showMenu();
		Shop shop = null;
		int numArticles = 2; //This may change in the future
		Scanner scanner = new Scanner(System.in);
		int option;
		while (scanner.hasNext()) {
			option = scanner.nextInt();
			if (option == 0) {
				shop = new Shop();
				System.out.println("Shop created successfully");
			}
			else if (option == 1) {
				System.out.println("Please, enter " + numArticles + " 0s or 1s according to"
						+ " if the item in that position should be locked or unlocked:");
				ArrayList<Boolean> unlockedInfo = new ArrayList<Boolean>();
				for (int i = 0; i < numArticles; ++i) {
					scanner.hasNext();
					int unlocked = scanner.nextInt();
					if (unlocked == 0) unlockedInfo.add(false);
					else unlockedInfo.add(true);
				}
				shop = new Shop(unlockedInfo);
				System.out.println("Shop created successfully");
			}
			else if (option == 2) {
				if (shop != null) {
					ArrayList<ArrayList<String>> shopInfo = shop.getShop();
					System.out.println("Here is the shop, with the available articles:");
					for (int i = 0; i < shopInfo.size(); ++i) {
						System.out.println("Information about the article " + i);
						ArrayList<String> articleInfo = shopInfo.get(i);
						String name = articleInfo.get(0);
						String buyingPrice = articleInfo.get(1);
						String sellingPrice = articleInfo.get(2);
						String description = articleInfo.get(3);
						System.out.println("Name: " + name);
						System.out.println("Description: " + description);
						System.out.println("Buying price: " + buyingPrice);
						System.out.println("Selling price: " + sellingPrice);
					}
				}
				else System.out.println("Please, create the shop first");
			}
			else if (option == 3) {
				if (shop != null) {
					System.out.println("Raw data of the shop (booleans "
							+ "indicating whether the article in its position "
							+ "is unlocked or not):");
					ArrayList<String> shopInfo = shop.getShopForSave();
					for (int i = 0; i < shopInfo.size(); ++i) {
						System.out.println(shopInfo.get(i));
					}
				}
				else System.out.println("Please, create the shop first");
			}
			else if (option == 4) {
				if (shop != null) {
					System.out.println("Please, enter the number of the article (0 - " + String.valueOf(numArticles - 1)
							+ ") you would like to check:");
					scanner.hasNext();
					int articleNum = scanner.nextInt();
					boolean unlocked = shop.isItemUnlocked(articleNum);
					if (unlocked) System.out.println("The article " + articleNum + " is unlocked");
					else System.out.println("The article " + articleNum + " is locked");
				}
				else System.out.println("Please, create the shop first");
			}
			else if (option == 5) {
				if (shop != null) {
					System.out.println("Please, enter the number of the article (0 - " + String.valueOf(numArticles - 1)
					+ ") you would like to know the buying price of:");
					scanner.hasNext();
					int articleNum = scanner.nextInt();
					int buyingPrice = shop.getBuyingPrice(articleNum);
					System.out.println("The buying price of the article " + articleNum + " is " + buyingPrice);
				}
				else System.out.println("Please, create the shop first");
			}
			else if (option == 6) {
				if (shop != null) {
					System.out.println("Please, enter the number of the article (0 - " + String.valueOf(numArticles - 1)
					+ ") you would like to know the selling price of:");
					scanner.hasNext();
					int articleNum = scanner.nextInt();
					int sellingPrice = shop.getSellingPrice(articleNum);
					System.out.println("The selling price of the article " + articleNum + " is " + sellingPrice);
				}
				else System.out.println("Please, create the shop first");
			}
			else if (option == 7) {
				System.out.println("Please, introduce the total score the user would have "
						+ "in order to update the unlocked articles");
				scanner.hasNext();
				int score = scanner.nextInt();
				shop.updateUnlocks(score);
				System.out.println("Articles updated successfully");
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
