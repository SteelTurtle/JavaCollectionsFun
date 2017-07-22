package org.gorillacorp.comparator_example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Grid {

	private final String gridName;
	private final List<Element> elements = new ArrayList<>();

	// Constructor
	public Grid(String gridName, int numberOfRows, int elementsPerRow) {
		this.gridName = gridName;
		int lastRow = 'A' + (numberOfRows - 1);
		for (char currentRow = 'A'; currentRow <= lastRow; currentRow++) {
			for (int currentElementNumber = 1; currentElementNumber <= elementsPerRow; currentElementNumber++) {
				// let's assign a different weight to the grid elements depending on their
				// position inside the grid;
				// the closer they are to the center, the bigger is their weight
				double weight = 1.00d;
				if ((currentRow < 'D') && (currentElementNumber >= 4 && currentElementNumber <= 9)) {
					weight = 1.50d;
				} else if ((currentRow > 'F') || (currentElementNumber < 4 || currentElementNumber > 9)) {
					weight = 0.50d;
				}
				Element element = new Element(currentRow + String.format("%02d", currentElementNumber), weight);
				elements.add(element);
			}
		}
	}

	// getters
	public String getGridName() {
		return gridName;
	}

	public Collection<Element> getElements() {
		return this.elements;
	}

	public boolean fillEmptyElementInGrid(String desiredElementPosition) {
		Element chosenElement = new Element(desiredElementPosition, 0);
		int foundElement = Collections.binarySearch(elements, chosenElement, null);
		if (foundElement >= 0) {
			return elements.get(foundElement).lockElementInGrid();
		} else {
			System.out.println("I could not find any element at " + desiredElementPosition + "in the Grid.");
			return false;
		}

	}

	// test method for getting all the elements in the Grid
	public void printAllElements() {
		for (Element element : elements) {
			System.out.println(element.getElementPosition() + " " + element.getWeight());
		}
	}

}