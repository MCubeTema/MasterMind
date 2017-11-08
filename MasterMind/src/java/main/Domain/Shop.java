package java.main.Domain;

import java.main.Domain.Article;
import java.util.ArrayList;

public class Shop {

	private ArrayList<Article> availableArticles = new ArrayList<Article>();
	
	public Shop() {
		String clueDescription = "A clue which will provide you help during the game.\n"
				+ "You can only use it 3 times per game.";
		Article clue = new Article("Clue", 15, 7, clueDescription, false);
		String jockerDescription = "A ball you can place wherever you want and that\n"
				+ "will either tell be a correct colour in an incorrect position or\n"
				+ "a correct colour in a correct position.";
		Article jocker = new Article("Jocker", 30, 15, jockerDescription, false);
		availableArticles.add(clue);
		availableArticles.add(jocker);
	}
	
	public ArrayList<ArrayList<String>> getShop() {
		ArrayList<ArrayList<String>> shop = new ArrayList<ArrayList<String>>();
		for (int i = 0; i < availableArticles.size(); ++i) {
			Article a = availableArticles.get(i);
			ArrayList<String> articleInfo = new ArrayList<String>();
			String name = a.getName();
			String buyingPrice = String.valueOf(a.getBuyingPrice());
			String sellingPrice = String.valueOf(a.getSellingPrice());
			String description = a.getDescription();
			String unlocked = String.valueOf(a.getUnlocked());
			articleInfo.add(name);
			articleInfo.add(buyingPrice);
			articleInfo.add(sellingPrice);
			articleInfo.add(description);
			articleInfo.add(unlocked);
			shop.add(articleInfo);
		}
		return shop;
	}
	
}
