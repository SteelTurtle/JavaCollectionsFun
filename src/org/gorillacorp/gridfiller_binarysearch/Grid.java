package org.gorillacorp.gridfiller_binarysearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Grid {

	private final String gridName;
	// Same as the previous example of Grid Filler, but this time using the
	// ArrayList
	// of Elements in conjunction with the Comparable interface, so we can invoke
	// the
	// Collection.binarySearch() method to perform the comparison between the
	// various
	// list elements
	private final List<Element> elements = new ArrayList<>();

	// Constructor
	public Grid(String gridName, int numberOfRows, int elementsPerRow) {
		this.gridName = gridName;
		int lastRow = 'A' + (numberOfRows - 1);
		for (char currentRow = 'A'; currentRow <= lastRow; currentRow++) {
			for (int currentElementNumber = 1; currentElementNumber <= elementsPerRow; currentElementNumber++) {
				Element element = new Element(currentRow + String.format("%02d", currentElementNumber));
				elements.add(element);
			}
		}
	}

	public String getGridName() {
		return gridName;
	}

	public boolean fillEmptyElementInGrid(String desiredElementPosition) {
		// Once we implement the Comparable interface on Element, we can use a different
		// approach to deal with
		// cycling the List elements
		Element chosenElement = new Element(desiredElementPosition);
		// Binary Search is A LOT more efficient way to lookup for elements inside an
		// ordered List (log(n) where n is number of list elements)
		// You can compare the number of lookups operations of this version of the
		// search with the one in the package
		// "gridfiller" to get an idea.
		int foundElement = Collections.binarySearch(elements, chosenElement, null);
		if (foundElement >= 0) {
			return elements.get(foundElement).lockElementInGrid();
		} else {
			System.out.println("I could not find any element at " + desiredElementPosition + "in the Grid.");
			return false;
		}

	}

	// test method for getting all the elements in the Grid
	public void getAllElements() {
		for (Element element : elements) {
			System.out.println(element.getElementPosition());
		}
	}

}
