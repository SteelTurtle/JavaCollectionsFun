package org.gorillacorp.comparator_example;

public class MainApp {

	public static void main(String[] args) {
		Grid grid = new Grid("Custom Grid", 26, 12);
		// Just for debug purposes....
		grid.printAllElements();
		if (grid.fillEmptyElementInGrid("B05")) {
			System.out.println("Success: the element has been inserted in the grid");
		} else {
			System.out.println("Failure: The element in the grid has already been filled");
		}

	}

}
