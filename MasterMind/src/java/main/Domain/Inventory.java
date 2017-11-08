package java.main.Domain;

import java.util.ArrayList;

public class Inventory {

	private int numberOfCoins;
	private ArrayList<Article> listOfArticles;
	
	
	public Inventory() {
		numberOfCoins = 0;
		listOfArticles = new ArrayList<Article>();
	}
	
	public Inventory(int numberOfCoins, ArrayList<Article> listOfArticles) {
		this.numberOfCoins = numberOfCoins;
		this.listOfArticles = listOfArticles; //May aliasing be a problem?
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
		//Buy by item number
	}
	
	public void buyItemByName(String articleName) {
		//Buy item by name
	}
	
}
