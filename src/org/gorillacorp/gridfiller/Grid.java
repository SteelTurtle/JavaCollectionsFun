package org.gorillacorp.gridfiller;

import java.util.ArrayList;
import java.util.Collection;

public class Grid {

	private final String gridName;
	private final Collection<Element> elements = new ArrayList<>();

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
		Element chosenElement = null;
		for (Element element : elements) {
			if (element.getElementPosition().equals(desiredElementPosition)) {
				chosenElement = element;
				break;
			}
		}
		if (chosenElement == null) {
			System.out.println(
					"Sorry, it looks there is not any element in the grid at position " + desiredElementPosition);
			return false;
		}

		return chosenElement.lockElementInGrid();
	}

	// test method for getting all the elements in the Grid
	public void getAllElements() {
		for (Element element : elements) {
			System.out.println(element.getElementPosition());
		}
	}

}
