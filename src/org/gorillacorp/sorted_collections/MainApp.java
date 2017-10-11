package org.gorillacorp.sorted_collections;

import java.util.Map;

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

		// ***And...another customer!***
		ShoppingBasket goombaShoppingBasket = new ShoppingBasket(
				"Mr. Gob Goomba's basket");
		sellGroceries(goombaShoppingBasket, "lettuce", 34);
		sellGroceries(goombaShoppingBasket, "carrot", 78);
		sellGroceries(goombaShoppingBasket, "cauliflower", 3);
		sellGroceries(goombaShoppingBasket, "beans", 33);
		// Mr.Goomba suddenly remember he hates having to eat too much lettuce
		// and beans...
		removeGroceriesfromBasket(goombaShoppingBasket, "lettuce", 30);
		removeGroceriesfromBasket(goombaShoppingBasket, "beans", 28);

		// Ideally, we should always check that we aren't out of stock already,
		// when trying to sell a grocery. For example:
		/*
		 * if(sellGroceries(bubbaShoppingBasket, "potato", 1) != 1) {
		 * System.out.println("No more potatoes in stock."); }
		 */
		// Also, a potential problem may happen when the Groceries stock is
		// empty and
		// we would try to modify some field of a grocery, without first if the
		// grocery actually
		// actually IS in Stock. To prevent a null pointer exception we should
		// first test
		// for null before trying to do anything else:
		/*Grocery someGrocery = groceries.getGroceries().get("someGrocery");
		if (someGrocery != null) {
			someGrocery.adjustStock(200);
		}
		if (someGrocery != null) {
			groceries.getGroceryInList("someGrocery").adjustStock(-50);
		}*/

		System.out.println(
				"\nOh, a customer has come!. He fills his basket with some groceries!");
		System.out.println(bubbaShoppingBasket);
		System.out.println(
				"\nOh, ANOTHER customer has come!. He fills his basket with some groceries!");
		System.out.println(goombaShoppingBasket);
		// Bob Bubba pays for the groceries
		checkOut(bubbaShoppingBasket);
		// Mr. Goomba pays as well
		checkOut(goombaShoppingBasket);
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
		// if the quantity we are trying to reserve in the shopping basket is
		// not greater than the
		// quantity in stock (0 is an error), deduct the quantity from the
		// stock...
		if (groceries.reserveStock(groceryName, quantity) != 0) {
			return shoppingBasket.addGroceryToBasket(groceryInList, quantity);
		}
		// default
		return 0;
	}

	public static int removeGroceriesfromBasket(ShoppingBasket shoppingBasket,
			String groceryName, int quantityToRemove) {
		// get the item from the groceries list first...
		Grocery groceryInList = groceries.getGroceryInList(groceryName);
		if (groceryInList == null) {
			System.out.println("The grocery: " + groceryInList.getName()
					+ " is temporarily out of stock. Please try tomorrow.");
			return 0;
		}
		// if the quantity we are trying to reserve in the shopping basket is
		// not greater than the
		// quantity in stock (0 is an error), deduct the quantity from the
		// stock...
		if (shoppingBasket.removeGroceryFromBasket(groceryInList,
				quantityToRemove) == quantityToRemove) {

			return groceries.unreserveStock(groceryName, quantityToRemove);
		}
		// default
		return 0;
	}

	// At checkOut, we must iterate all the groceries in the shopping basket and
	// deduct their quantities from the available stock
	public static void checkOut(ShoppingBasket shoppingBasket) {
		for (Map.Entry<Grocery, Integer> g : shoppingBasket.getGroceries()
				.entrySet()) {
			groceries.sellStock(g.getKey().getName(), g.getValue());
		}
		// the shopping transaction has been completed, so let's clear the
		// shopping basket!
		shoppingBasket.emptyBasket();
	}

}
