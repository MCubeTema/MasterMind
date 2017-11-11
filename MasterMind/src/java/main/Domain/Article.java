package java.main.Domain;

public class Article {
	
	private String name;
	private int buyingPrice;
	private int sellingPrice;
	private String description;
	
	public Article(String name, int buyingPrice, int sellingPrice, String description, boolean unlocked) {
		this.name = name;
		this.buyingPrice = buyingPrice;
		this.sellingPrice = sellingPrice;
		this.description = description;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setBuyingPrice(int buyingPrice) {
		this.buyingPrice = buyingPrice;
	}
	
	public void setSellingPrice(int sellingPrice) {
		this.sellingPrice = sellingPrice;
	}
	
	public void setDescription(String description) {
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
