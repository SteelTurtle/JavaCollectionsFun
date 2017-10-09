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
		// REMEMBER, that the collection is unmodifiable, not the objects it
		// references
		return Collections.unmodifiableMap(groceries);
	}

	// What if we want part of the element(s) in the map to be unmodifiable?
	// (Consider for example a thread-safe scenario, or security enforcement for
	// the object access, etc.).
	// In that case, we can encapsulate the data we want to "protect" into an
	// ad-hoc Map.
	// Suppose -as an example- we want to avoid the caller in the MainApp to get
	// a grocery list (getGroceries().getGroceryInList(g)) and then assign an
	// arbitrary price
	// to the returned grocery...
	/*public Map<String, Double> getGroceryPriceList() {
		Map<String, Double> pricesMap = new LinkedHashMap<>();
		for (Map.Entry<String, Grocery> p : groceries.entrySet()) {
			pricesMap.put(p.getKey(), p.getValue().getPrice());
		}
		return Collections.unmodifiableMap(pricesMap);
	}*/
	// Then, in the caller class (MainApp) we could iterate the grocery list this way:
	/*for(Map.Entry<String, Double> price : groceries.getGroceryPriceList().entrySet()) {
		System.out.println(price.getKey() + " has a nominal cost of " + price.getValue());
	}*/
	

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
