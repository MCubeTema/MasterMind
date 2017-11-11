package mcubetema.domain;

import java.util.ArrayList;

public class Shop {

	private static ArrayList<Article> availableArticles;
	private static ArrayList<Integer> scoreToUnlock;
	private ArrayList<Boolean> unlockedArticles;
	
	private void commonShopConstructor() {
		String clueDescription = "A clue which will provide you help during the game.\n"
				+ "You can only use it 3 times per game.";
		Article clue = new Article("Clue", 15, 7, clueDescription);
		String jockerDescription = "A ball you can place wherever you want and that\n"
				+ "will either tell be a correct colour in an incorrect position or\n"
				+ "a correct colour in a correct position.";
		Article jocker = new Article("Jocker", 30, 15, jockerDescription);
		availableArticles = new ArrayList<Article>();
		availableArticles.add(clue);
		availableArticles.add(jocker);
		scoreToUnlock = new ArrayList<Integer>();
		scoreToUnlock.add(4000);
		scoreToUnlock.add(6000);
		unlockedArticles = new ArrayList<Boolean>();
	}
	
	public Shop() {
		commonShopConstructor();
		unlockedArticles.add(false);
		unlockedArticles.add(false);
	}
	
	public Shop (ArrayList<Boolean> shopInfo) {
		commonShopConstructor();
		unlockedArticles = shopInfo;
	}
	
	public ArrayList<ArrayList<String>> getShop() {
		ArrayList<ArrayList<String>> shopInfo = new ArrayList<ArrayList<String>>();
		for (int i = 0; i < availableArticles.size(); ++i) {
			if (unlockedArticles.get(i)) { //If the article is unlocked, it is available in the shop
				Article a = availableArticles.get(i);
				ArrayList<String> articleInfo = new ArrayList<String>();
				String name = a.getName();
				String buyingPrice = String.valueOf(a.getBuyingPrice());
				String sellingPrice = String.valueOf(a.getSellingPrice());
				String description = a.getDescription();
				articleInfo.add(name);
				articleInfo.add(buyingPrice);
				articleInfo.add(sellingPrice);
				articleInfo.add(description);
				shopInfo.add(articleInfo);
			}
		}
		return shopInfo;
	}
	
	public ArrayList<String> getShopForSave() {
		ArrayList<String> shopInfo = new ArrayList<String>();
		for (int i = 0; i < unlockedArticles.size(); ++i) {
			if (unlockedArticles.get(i)) shopInfo.add("1");
			else shopInfo.add("0");
		}
		return shopInfo;
	}
	
	public boolean isItemUnlocked (int articleNum) {
		return unlockedArticles.get(articleNum);
	}
	
	public int getBuyingPrice (int articleNum) {
		Article a = availableArticles.get(articleNum);
		return a.getBuyingPrice();
	}
	
	public int getSellingPrice (int articleNum) {
		Article a = availableArticles.get(articleNum);
		return a.getSellingPrice();
	}
	
	public void updateUnlocks (int score) {
		for (int i = 0; i < availableArticles.size(); ++i) {
			if (score >= scoreToUnlock.get(i)) {
				unlockedArticles.set(i, true);
			}
		}
	}
}
