package java.main.Domain;

import java.util.ArrayList;
import java.main.Auxiliar.Pair;

public class Inventory {

	private int numberOfCoins;
	private ArrayList<Pair<Integer, Article>> listOfArticles; /* Only two items, what changes is the
																 quantity. Same index as the shop */
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
		this.numberOfCoins -= spentCoins; //Check if there are enough coins
	}
	
	public void earnCoins(int earnedCoins) {
		this.numberOfCoins += earnedCoins;
	}
	
	public int getCoins() {
		return this.numberOfCoins;
	}
	
	public ArrayList<Pair<Integer, Article>>getInventory() {
		return listOfArticles;
	}
	
	public void buyItemByNum(int articleNum) {
		Article a = shop.getArticleByNum(articleNum);
		int price = a.getBuyingPrice();
		if (price >= numberOfCoins) {
			this.numberOfCoins -= price;
			int quantity = listOfArticles.get(articleNum).first;
			++quantity;
			Pair<Integer, Article> p = new Pair<Integer, Article>(quantity, a);
			listOfArticles.set(articleNum, p);
		}
		else {
			//EXCEPTION: NOT ENOUGH COINS
		}
	}
	
	public void sellItemByNum(int articleNum) {
		Article a = shop.getArticleByNum(articleNum);
		int price = a.getSellingPrice();
		this.numberOfCoins += price;
		int quantity = listOfArticles.get(articleNum).first;
		if (quantity > 0) {
			--quantity;
			Pair<Integer, Article> p = new Pair<Integer, Article>(quantity, a);
			listOfArticles.set(articleNum, p);
		}
		else {
			//EXCEPTION: NOT ENOUGH ARTICLES
		}
	}
	
	public void buyItemByName(String articleName) {
		Pair<Integer, Article> pShop = shop.getArticleByName(articleName);
		int articleNum = pShop.first;
		Article a = pShop.second;
		int price = a.getBuyingPrice();
		if (price >= numberOfCoins) {
			this.numberOfCoins -= price;
			int quantity = listOfArticles.get(articleNum).first;
			++quantity;
			Pair<Integer, Article> pList = new Pair<Integer, Article>(quantity, a);
			listOfArticles.set(articleNum, pList);
		}
		else {
			//EXCEPTION: NOT ENOUGH COINS
		}
	}
	
	public void sellItemByName(String articleName) {
		Pair<Integer, Article> pShop = shop.getArticleByName(articleName);
		int articleNum = pShop.first;
		Article a = pShop.second;
		int price = a.getSellingPrice();
		this.numberOfCoins += price;
		int quantity = listOfArticles.get(articleNum).first;
		if (quantity > 0) {
			--quantity;
			Pair<Integer, Article> pList = new Pair<Integer, Article>(quantity, a);
			listOfArticles.set(articleNum, pList);
		}
		else {
			//EXCEPTION: NOT ENOUGH ARTICLES
		}
	}
	
}
