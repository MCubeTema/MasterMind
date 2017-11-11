package Drivers;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import mcubetema.domain.*;

public class PlayerDriver {
	
	private static void showMenu() {
		System.out.println("0 - Create a default empty player");
		System.out.println("1 - Log in");
		System.out.println("2 - Set new question");
		System.out.println("3 - Set new password");
		System.out.println("4 - Check whether there is a user logged in");
		System.out.println("5 - Get basic player info");
		System.out.println("6 - Get username");
		System.out.println("7 - Get shop");
		System.out.println("8 - Get inventory");
		System.out.println("9 - Buy an item");
		System.out.println("10 - Sell an item");
		System.out.println("11 - Add score");
		System.out.println("12 - Get player data (as if it were about to be saved in disk");
		System.out.println("13 - Exit");
	}
	
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Welcome to the driver to test the class Player, plese choose an option:");
		showMenu();
		Player player = null;
		int numArticles = 2; //This may change in the future
		Scanner scanner = new Scanner(System.in);
		int option;
		while (scanner.hasNext()) {
			option = scanner.nextInt();
			if (option == 0) {
				player = new Player();
				System.out.println("Player created successfully");
			}
			if (option == 1) {
				if (player != null) {
					System.out.println("Please, enter the username, password, question, answer, score "
							+ "and number of coins separated by blank spaces:");
					String username, password, question, answer;
					int score, numberOfCoins;
					scanner.hasNext();
					username = scanner.next();
					scanner.hasNext();
					password = scanner.next();
					scanner.hasNext();
					question = scanner.next();
					scanner.hasNext();
					answer = scanner.next();
					scanner.hasNext();
					score = scanner.nextInt();
					scanner.hasNext();
					numberOfCoins = scanner.nextInt();
					System.out.println("Please, enter " + String.valueOf(numArticles) + " integers "
							+ "specifying the amount of each article in the player inventory:");
					ArrayList<Integer> inventory = new ArrayList<Integer>();
					for (int i = 0; i < numArticles; ++i) {
						scanner.hasNext();
						int amount = scanner.nextInt();
						inventory.add(amount);
					}
					System.out.println("Please, enter " + String.valueOf(numArticles) + " 0s or 1s "
							+ "indicating whether the article is unlocked or not:");
					ArrayList<Boolean> shop = new ArrayList<Boolean>();
					for (int i = 0; i < numArticles; ++i) {
						scanner.hasNext();
						int unlocked = scanner.nextInt();
						if (unlocked == 0) shop.add(false);
						else shop.add(true);
					}
					player.loadPlayerInfo(username, password, question, answer, score, numberOfCoins, inventory, shop);
					System.out.println("Player information loaded successfully");
				}
				else System.out.println("Please, create the player first");
			}
			if (option == 2) {
				if (player != null) {
					System.out.println("Please, enter the new question:");
					scanner.hasNext();
					String question = scanner.next();
					System.out.println("Please, enter the new answer:");
					scanner.hasNext();
					String answer = scanner.next();
					player.setNewQuestion(question, answer);
					System.out.println("Question changed successfully");
				}
				else System.out.println("Please, create the player first");
			}
			if (option == 3) {
				if (player != null) {
					System.out.println("Please, enter the new password:");
					scanner.hasNext();
					String password = scanner.next();
					player.setNewPassword(password);
					System.out.println("Password changed successfully");
				}
				else System.out.println("Please, create the player first");
			}
			if (option == 4) {
				if (player != null) {
					if (player.isUserLoggedIn()) System.out.println("There is a user logged in");
					else System.out.println("There is no user logged in");
				}
				else System.out.println("Please, create the player first");
			}
			if (option == 5) {
				if (player != null) {
					ArrayList<String> playerInfo = player.getPlayerInfo();
					String username = playerInfo.get(0);
					String password = playerInfo.get(1);
					String question = playerInfo.get(2);
					String answer = playerInfo.get(3);
					String score = playerInfo.get(4);
					System.out.println("Username: " + username);
					System.out.println("Password: " + password);
					System.out.println("Question: " + question);
					System.out.println("Answer: " + answer);
					System.out.println("Score: " + score);
				}
				else System.out.println("Please, create the player first");
			}
			if (option == 6) {
				if (player != null) {
					String username = player.getUsername();
					System.out.println("Username: " + username);
				}
				else System.out.println("Please, create the player first");
			}
			if (option == 7) {
				if (player != null) {
					ArrayList<ArrayList<String>> shopInfo = player.getShop();
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
				else System.out.println("Please, create the player first");
			}
			if (option == 8) {
				if (player != null) {
					ArrayList<String> inventoryInfo = player.getInventory();
					int numberOfCoins = Integer.parseInt(inventoryInfo.get(0));
					System.out.println("Coins: " + numberOfCoins);
					System.out.println("Amount of articles:");
					for (int i = 1; i < inventoryInfo.size(); ++i) {
						System.out.println("Article " + i + ": " + inventoryInfo.get(i));
					}
				}
				else System.out.println("Please, create the player first");
			}
			if (option == 9) {
				if (player != null) {
					if (player != null) {
						System.out.println("Please enter the number (0 - " + String.valueOf(numArticles - 1) + 
								") of the article you would like to buy");
						scanner.hasNext();
						int articleNum = scanner.nextInt();
						int errorCode = player.buyItemByNum(articleNum);
						if (errorCode == 0) System.out.println("Item bought successfully");
						else if (errorCode == -1) System.out.println("The item is not unlocked");
						else if (errorCode == -2) System.out.println("There are not enough coins");
					}
				}
				else System.out.println("Please, create the player first");
			}
			if (option == 10) {
				if (player != null) {
					System.out.println("Please enter the number (0 - " + String.valueOf(numArticles - 1) + 
							") of the article you would like to sell");
					scanner.hasNext();
					int articleNum = scanner.nextInt();
					int errorCode = player.sellItemByNum(articleNum);
					if (errorCode == 0) System.out.println("Item bought successfully");
					else if (errorCode == -1) System.out.println("There is no article to sell");
				}
				else System.out.println("Please, create the player first");
			}
			if (option == 11) {
				if (player != null) {
					System.out.println("Please, enter the score you would like to add to the player:");
					scanner.hasNext();
					int score = scanner.nextInt();
					player.addScore(score);
					System.out.println("Score added successfully");
				}
				else System.out.println("Please, create the player first");
			}
			if (option == 12) {
				ArrayList<ArrayList<String>> playerData = player.getPlayerData();
				ArrayList<String> basicInfo = playerData.get(0);
				String username = basicInfo.get(0);
				String password = basicInfo.get(1);
				String question = basicInfo.get(2);
				String answer = basicInfo.get(3);
				String score = basicInfo.get(4);
				System.out.println("Username: " + username);
				System.out.println("Password: " + password);
				System.out.println("Question: " + question);
				System.out.println("Answer: " + answer);
				System.out.println("Score: " + score);
				ArrayList<String> inventory = playerData.get(1);
				String numOfCoins = inventory.get(0);
				System.out.println("Coins: " + numOfCoins);
				for (int i = 1; i < inventory.size(); ++i) {
					System.out.println("There are " + inventory.get(i) + " units of article " + i);
				}
				ArrayList<String> shop = playerData.get(2);
				for (int i = 0; i < shop.size(); ++i) {
					System.out.println("The article " + i + " is ");
					if (shop.get(i) == "1") System.out.println("unlocked");
					else if (shop.get(i) == "0") System.out.println("locked");
				}
			}
			if (option == 13) {
				break;
			}
			TimeUnit.SECONDS.sleep(2);
			showMenu();
		}
		scanner.close();
		System.out.println("Now leaving");
	}
}
