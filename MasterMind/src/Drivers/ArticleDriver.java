package Drivers;

import java.util.Scanner;

import mcubetema.domain.Article;

public class ArticleDriver {
	public static void main(String[] args) {
		System.out.println("Welcome to the driver to test the class Article, plese choose an option:");
		System.out.println("0 - Create an article");
		System.out.println("1 - Get the name of the last created article");
		System.out.println("2 - Get the buying price of the last created article");
		System.out.println("3 - Get the selling price of the last created article");
		System.out.println("4 - Get the description of the last created article");
		System.out.println("5 - Exit");
		Scanner scanner = new Scanner (System.in);
		Article article = null;
		int option;
		while (scanner.hasNext()) {
			option = scanner.nextInt();
			if (option == 0) {
				System.out.println("Enter in order the name, buying price, selling price and description"
						+ " separated by blank spaces");
				String name, description;
				int buyingPrice, sellingPrice;
				scanner.hasNext();
				name = scanner.next();
				scanner.hasNext();
				buyingPrice = scanner.nextInt();
				scanner.hasNext();
				sellingPrice = scanner.nextInt();
				scanner.hasNext();
				description = scanner.next();
				article = new Article(name, buyingPrice, sellingPrice, description);
				System.out.println("Article created successfully");
			}
			else if (option == 1) {
				if (article != null) {
					String name = article.getName();
					System.out.println("The name of the last article created is " + name);
				}
				else System.out.println("Please, create the article first");
			}
			else if (option == 2) {
				if (article != null) {
					int buyingPrice = article.getBuyingPrice();
					System.out.println("The buying price of the last article created is " + buyingPrice);
				}
				else System.out.println("Please, create the article first");
			}
			else if (option == 3) {
				if (article != null) {
					int sellingPrice = article.getSellingPrice();
					System.out.println("The selling price of the last article created is " + sellingPrice);
				}
				else System.out.println("Please, create the article first");
			}
			else if (option == 4) {
				if (article != null) {
					String description = article.getDescription();
					System.out.println("The description of the last article created is " + description);
				}
				else System.out.println("Please, create the article first");
			}
			else break;
		}
		scanner.close();
		System.out.println("Now leaving");
	}
}
