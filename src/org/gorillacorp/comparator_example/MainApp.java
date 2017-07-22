package org.gorillacorp.comparator_example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainApp {

	public static void main(String[] args) {
		Grid grid = new Grid("Custom Grid", 26, 12);
		// Just for debug purposes....
		// grid.printAllElements();
		if (grid.fillEmptyElementInGrid("B05")) {
			System.out.println("Success: the element has been inserted in the grid");
		} else {
			System.out.println("Failure: The element in the grid has already been filled");
		}

		System.out.println("**********************************");

		// Let's use the Comparator<Element> defined in the Grid class... We start
		// building a copy
		// of the ArrayList created by the Grid constructor at the beginning of this
		// main function up here...
		List<Element> elementsComparedByWeight = new ArrayList<>(grid.getElements());
		elementsComparedByWeight.add(new Element("F09", 14.00d));
		elementsComparedByWeight.add(new Element("I08", 4.00d));
		elementsComparedByWeight.add(new Element("E10", 9.00d));
		elementsComparedByWeight.add(new Element("S07", 35.00d));

		Collections.sort(elementsComparedByWeight, Grid.WEIGHT_ORDER);
		grid.printAllElements();
	}

}
