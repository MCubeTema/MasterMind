package mcubetema.domain;

import java.util.ArrayList;
import java.main.Auxiliar.Pair;

public class Shop {

	private static ArrayList<Article> availableArticles;
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
		unlockedArticles = new ArrayList<Boolean>();
	}
	
	public Shop() {
		commonShopConstructor();
		unlockedArticles.add(false);
		unlockedArticles.add(false);
	}
	
	public Shop (ArrayList<Boolean> shopInfo) {
		unlockedArticles = shopInfo;
	}
	
	public ArrayList<ArrayList<String>> getShop() {
		ArrayList<ArrayList<String>> shop = new ArrayList<ArrayList<String>>();
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
				shop.add(articleInfo);
			}
		}
		return shop;
	}
	
	public ArrayList<String> getShopForSave() {
		ArrayList<String> shopInfo = new ArrayList<String>();
		for (int i = 0; i < unlockedArticles.size(); ++i) {
			if (unlockedArticles.get(i)) shopInfo.add("1");
			else shopInfo.add("0");
		}
		return shopInfo;
	}
	
	public Article getArticleByNum(int articleNum) {
		return availableArticles.get(articleNum); //May generate an exception if invalid index
	}
	
	public Pair<Integer, Article> getArticleByName(String articleName) {
		for (int i = 0; i < availableArticles.size(); ++i) {
			Article a = availableArticles.get(i);
			String name = a.getName();
			if (name == articleName) {
				Pair<Integer, Article> p = new Pair<Integer, Article>(i, a);
				return p;
			}
		}
		//EXCEPTION: THERE IS NO ARTICLE WITH SUCH A NAME
		return null;
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
	
	public void unlockArticle (int articleNum) {
		unlockedArticles.set(articleNum, true);
	}
}
