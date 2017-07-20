package org.gorillacorp.gridfiller;

public class MainApp {

	public static void main(String[] args) {

		Grid grid = new Grid("Custom Grid", 7, 5);
		// grid.getAllElements();
		if (grid.fillEmptyElementInGrid("B05")) {
			System.out.println("Success: the element has been inserted in the grid");
		} else {
			System.out.println("Failure: The element in the grid has already been filled");
		}
		if (grid.fillEmptyElementInGrid("B05")) {
			System.out.println("Success: the element has been inserted in the grid");
		} else {
			System.out.println("Failure: The element in the grid has already been filled");
		}

	}

}
