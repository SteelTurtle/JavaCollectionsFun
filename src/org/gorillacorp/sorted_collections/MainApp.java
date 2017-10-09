package org.gorillacorp.sorted_collections;

public class MainApp {

	private static GroceryList groceries = new GroceryList();

	public static void main(String[] args) {

		// *****Let's create the Grocery Store! First, create a stock of
		// vegetables to sell.*****
		Grocery temp = new Grocery("carrot", 250, 100);
		groceries.addStock(temp);
		temp = new Grocery("tomato", 400, 76);
		groceries.addStock(temp);
		temp = new Grocery("cauliflower", 56, 154);
		groceries.addStock(temp);
		temp = new Grocery("lettuce", 342, 67);
		groceries.addStock(temp);
		temp = new Grocery("cabbage", 210, 89);
		groceries.addStock(temp);
		temp = new Grocery("potato", 178, 362);
		groceries.addStock(temp);

		// manage duplicates nicely...
		temp = new Grocery("beans", 217, 98);
		groceries.addStock(temp);
		temp = new Grocery("beans", 217, 100);
		groceries.addStock(temp);

		System.out.println(groceries);

		/*
		 * for(String s : groceries.getGroceries().keySet()) {
		 * System.out.println(s); }
		 */

		// ***Oh, a customer has come!. He fills his basket with some
		// groceries***
		ShoppingBasket bubbaShoppingBasket = new ShoppingBasket(
				"Bob McBubba's basket");
		sellGroceries(bubbaShoppingBasket, "tomato", 12);
		sellGroceries(bubbaShoppingBasket, "carrot", 4);
		sellGroceries(bubbaShoppingBasket, "cauliflower", 1);
		sellGroceries(bubbaShoppingBasket, "beans", 12);
		sellGroceries(bubbaShoppingBasket, "potato", 12);
		
		System.out.println(
				"\nOh, a customer has come!. He fills his basket with some groceries!");
		System.out.println(bubbaShoppingBasket);
		
		System.out.println("\nRemaining items in stock: ");
		System.out.println(groceries);

	}

	// THE SUPER DUPER BASKET SERVICE!
	// Sell some groceries. Return the quantity of groceries sold.
	public static int sellGroceries(ShoppingBasket shoppingBasket,
			String groceryName, int quantity) {
		// get the item from the groceries list first...
		Grocery groceryInList = groceries.getGroceryInList(groceryName);
		if (groceryInList == null) {
			System.out.println("The grocery: " + groceryInList.getName()
					+ " is temporarily out of stock. Please try tomorrow.");
			return 0;
		}
		// if the quantity we are trying to sell is not greater than the
		// quantity in stock (0 is an error), deduct the quantity from the
		// stock and add it to the shopping basket...
		if (groceries.sellStock(groceryName, quantity) != 0) {
			shoppingBasket.addGroceryToBasket(groceryInList, quantity);
			return quantity;
		}
		// default
		return 0;
	}

}
