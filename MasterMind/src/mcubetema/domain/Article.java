package mcubetema.domain;

public class Article {
	
	private String name;
	private int buyingPrice;
	private int sellingPrice;
	private String description;
	
	public Article(String name, int buyingPrice, int sellingPrice, String description) {
		this.name = name;
		this.buyingPrice = buyingPrice;
		this.sellingPrice = sellingPrice;
		this.description = description;
	}
	
	public String getName() {
		return name;
	}
	
	public int getBuyingPrice() {
		return buyingPrice;
	}

	public int getSellingPrice() {
		return sellingPrice;
	}
	
	public String getDescription() {
		return description;
	}
}
