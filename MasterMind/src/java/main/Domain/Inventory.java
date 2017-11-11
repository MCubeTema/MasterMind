package java.main.Domain;

import java.util.ArrayList;

public class Inventory {

	private int numberOfCoins;
	private ArrayList<Integer> amountOfArticles; /* Only two items, what changes is the
																 quantity. Same index as the shop */
	
	
	public Inventory() {
		numberOfCoins = 0;
		amountOfArticles = new ArrayList<Integer>();
		amountOfArticles.add(0);
		amountOfArticles.add(0);
	}
	
	public Inventory(int numberOfCoins, ArrayList<Integer> amounts) {
		this.numberOfCoins = numberOfCoins;
		amountOfArticles = amounts; //May aliasing be a problem?
	}
	
	public void setNumberOfCoins(int numberOfCoins) {
		this.numberOfCoins = numberOfCoins;
	}
	
	public void spendCoins(int spentCoins) {
		this.numberOfCoins -= spentCoins;
	}
	
	public void earnCoins(int earnedCoins) {
		this.numberOfCoins += earnedCoins;
	}
	
	public int getCoins() {
		return this.numberOfCoins;
	}
	
	public ArrayList<String> getInventory() {
		ArrayList<String> amountOfArticlesString = new ArrayList<String>();
		for (int i = 0; i < amountOfArticles.size(); ++i) {
			int amount = amountOfArticles.get(i);
			String amountString = String.valueOf(amount);
			amountOfArticlesString.add(amountString);
		}
		return amountOfArticlesString;
	}
	
	public void addArticle (int articleNum) {
		int prevAmount = amountOfArticles.get(articleNum);
		int newAmount = prevAmount + 1;
		amountOfArticles.set(articleNum, newAmount);
	}
	
	public int removeArticle (int articleNum) {
		int prevAmount = amountOfArticles.get(articleNum);
		if (prevAmount > 0) {
			int newAmount = prevAmount - 1;
			amountOfArticles.set(articleNum, newAmount);
			return 0;
		}
		return -1;
	}
	
}
