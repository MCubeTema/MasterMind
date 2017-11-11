package java.main.Domain;

import java.util.ArrayList;

public class Player {

	private String username;
	private String password;
	private String question;
	private String answer;
	private int score;
	boolean isLoggedIn;
	
	Shop shop;
	
	Inventory inventory;
	
	public Player() {
		isLoggedIn = false;
	}
	
	/*The playerManagementController transforms from the format stated below to
	 * the format here expected */
	/*Original format: User, password, question, answer, score, numberOfCoins array with
	 * the amount of articles, array with booleans (0, 1) indicating whether
	 * an article is unlocked or not */
	public int loadPlayerInfo (String username, String password, String question, String answer,
			int score, int numberOfCoins, ArrayList<Integer> inventoryInfo, ArrayList<Boolean> shopInfo) {
		this.username = username;
		this.password = password;
		this.question = question;
		this.answer = answer;
		this.score = score;
		inventory = new Inventory (numberOfCoins, inventoryInfo);
		shop = new Shop (shopInfo);
		return 0;
	}
	
	public void setNewPassword (String password) {
		this.password = password;
	}
	
	public void setNewQuestion (String question, String answer) {
		this.question = question;
		this.answer = answer;
	}
	
	public boolean isUserLoggedIn() {
		return isLoggedIn;
	}
	
	public ArrayList<String> getPlayerInfo() {
		ArrayList<String> playerInfo= new ArrayList<String>();
		playerInfo.add(username);
		playerInfo.add(password);
		playerInfo.add(question);
		playerInfo.add(answer);
		playerInfo.add(String.valueOf(score));
		return playerInfo;
	}
	
	public String getUsername() {
		return username;
	}
	
	public ArrayList<ArrayList<String>> getShop() {
		return shop.getShop();
	}
	
	public ArrayList<String> getInventory() {
		return inventory.getInventory();
	}
	
	public int buyItemByNum (int articleNum) {
		if (shop.isItemUnlocked(articleNum)) {
			int price = shop.getBuyingPrice(articleNum);
			int numberOfCoins = inventory.getCoins();
			if (price <= numberOfCoins) {
				inventory.spendCoins(price);
				inventory.addArticle(articleNum);
				return 0;
			}
			else return -2;
		}
		else return -1;
	}
	
	public int sellItemByNum (int articleNum) {
		int price = shop.getSellingPrice(articleNum);
		int errorCode = inventory.removeArticle(articleNum);
		if (errorCode == 0) {
			inventory.earnCoins(price);
			return 0;
		}
		else return -1;
	}
	
	public ArrayList<ArrayList<String>> getPlayerData() {
		ArrayList<ArrayList<String>> playerData = new ArrayList<ArrayList<String>>();
		/* FORMAT: ArrayList with the basic primitive info (username, password,
		 * question, answer and score), an array with the amounts of each article
		 * (the inventory) and an array with the booleans (0, 1) indicating whether
		 * an item is unlocked or not */
		ArrayList<String> basicInfo = new ArrayList<String>();
		basicInfo.add(username);
		basicInfo.add(password);
		basicInfo.add(question);
		basicInfo.add(answer);
		basicInfo.add(String.valueOf(score));
		ArrayList<String> inventoryInfo = inventory.getInventory();
		ArrayList<String> shopInfo = shop.getShopForSave();
		playerData.add(basicInfo);
		playerData.add(inventoryInfo);
		playerData.add(shopInfo);
		return playerData;
	}
	
}
