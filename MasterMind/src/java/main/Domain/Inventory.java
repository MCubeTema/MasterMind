package java.main.Domain;

import java.util.ArrayList;
import java.main.Auxiliar.Pair;

public class Inventory {

	private int numberOfCoins;
	private ArrayList<Pair<Integer, Article>> listOfArticles; /* Only two items, what changes is the
																 quantity */
	Shop shop;
	
	
	public Inventory() {
		numberOfCoins = 0;
		listOfArticles = new ArrayList<Pair<Integer, Article>>();
		shop = new Shop();
	}
	
	public Inventory(int numberOfCoins, ArrayList<Pair<Integer, Article>> listOfArticles) {
		this.numberOfCoins = numberOfCoins;
		this.listOfArticles = listOfArticles; //May aliasing be a problem?
		shop = new Shop();
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
	
	public void buyItemByNum(int articleNum) {
		Article a = shop.getArticleByNum(articleNum);
		int price = a.getBuyingPrice();
		this.numberOfCoins -= price;
		//Add item
	}
	
	public void buyItemByName(String articleName) {
		//Buy item by name
	}
	
}
