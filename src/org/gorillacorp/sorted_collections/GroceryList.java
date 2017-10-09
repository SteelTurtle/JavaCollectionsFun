package org.gorillacorp.sorted_collections;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class GroceryList {

	private final Map<String, Grocery> groceries;

	public GroceryList() {
		// we use a LinkedHashMap to keep the groceries in the exact order they
		// are inserted into the map.
		this.groceries = new LinkedHashMap<>();
	}

	public Grocery getGroceryInList(String groceryName) {
		return groceries.get(groceryName);
	}

	public Map<String, Grocery> getGroceries() {
		// return an unmodifiable view of the Map<K, V> of groceries
		return Collections.unmodifiableMap(groceries);
	}

	public int addStock(Grocery grocery) {
		if (grocery != null) {
			// either get an existing grocery already in stock or the grocery
			// passed as
			// this method's argument
			Grocery groceryInStock = groceries.getOrDefault(grocery.getName(),
					grocery);
			// if the grocery is already in stock, adjust the quantity. As per
			// the Grocery equals() method,
			// groceries are compared by heir name.
			if (groceryInStock != grocery) {
				grocery.refurnishStock(groceryInStock.getQuantityInStock());
			}
			// put the grocery in the list (overwrite the grocery if it already
			// exists).
			groceries.put(grocery.getName(), grocery);
			return grocery.getQuantityInStock();
		}
		// default
		return 0;
	}

	public int sellStock(String grocery, int quantityToSell) {
		// get the grocery to sell from the groceries map, or null otherwise
		Grocery groceryInStock = groceries.getOrDefault(grocery, null);
		if ((groceryInStock != null)
				&& (groceryInStock.getQuantityInStock() >= quantityToSell)
				&& (quantityToSell > 0)) {
			groceryInStock.refurnishStock(-quantityToSell);
			return quantityToSell;
		}
		// default: one or more of the tests above did not pass
		return 0;
	}

	@Override
	public String toString() {
		String returnedString = "\nGrocery List\n";
		double totalCost = 0;
		for (Map.Entry<String, Grocery> g : groceries.entrySet()) {
			Grocery groceryItem = g.getValue();
			double groceryValue = groceryItem.getPrice()
					* groceryItem.getQuantityInStock();
			returnedString = returnedString + groceryItem + ", there are "
					+ groceryItem.getQuantityInStock() + " in stock.\n"
					+ "Partial value of groceries is: " + groceryValue + ".\n";
			totalCost += groceryValue;
		}
		return returnedString + "Total stock value: " + totalCost;
	}
}
