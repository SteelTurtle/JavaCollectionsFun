package org.gorillacorp.sorted_collections;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class ShoppingBasket {
	private final String name;
	// shopping list containing the groceries and grocery quantities to be
	// bought
	private final Map<Grocery, Integer> shoppingList;

	public ShoppingBasket(String name) {
		this.name = name;
		this.shoppingList = new TreeMap<>();
	}

	public int addGroceryToBasket(Grocery grocery, int quantity) {
		if ((grocery != null) && quantity > 0) {
			// return the number of specific groceries in the basket, otherwise
			// return 0.
			int numberOfGroceriesInBasket = shoppingList.getOrDefault(grocery, 0);
			shoppingList.put(grocery, numberOfGroceriesInBasket + quantity);
		}
		return 0;
	}

	public Map<Grocery, Integer> getGroceries() {
		return Collections.unmodifiableMap(shoppingList);
	}

	@Override
	public String toString() {
		String s = "ShoppingBasket " + name + " has " + shoppingList.size()
				+ ((shoppingList.size() == 1) ? " grocery" : " groceries")
				+ "\n";
		double totalCost = 0.0;
		for (Map.Entry<Grocery, Integer> i : shoppingList.entrySet()) {
			s = s + i.getKey() + ". " + i.getValue() + " purchased.\n";
			totalCost += i.getKey().getPrice() * i.getValue();
		}
		return s + "Total cost: " + totalCost;
	}

}
