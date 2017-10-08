package org.gorillacorp.sorted_collections;

import java.util.HashMap;
import java.util.Map;

public class GroceryList {

	private final Map<String, Grocery> groceries;

	public GroceryList() {
		this.groceries = new HashMap<>();
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
}
