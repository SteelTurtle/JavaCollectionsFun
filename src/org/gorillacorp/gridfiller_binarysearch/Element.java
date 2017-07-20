package org.gorillacorp.gridfiller_binarysearch;

// Implementing the Comparable interface is necessary every time the object class is going to be part of a Set
public class Element implements Comparable<Element> {

	private final String elementPosition;
	private boolean isLocked;

	// Constructor
	public Element(String elementPosition) {
		this.elementPosition = elementPosition;
	}

	@Override
	public int compareTo(Element otherElement) {
		return this.elementPosition.compareToIgnoreCase(otherElement.getElementPosition());
	}

	public String getElementPosition() {
		return elementPosition;
	}

	public boolean lockElementInGrid() {
		if (!this.isLocked) {
			this.isLocked = true;
			System.out.println("An element has been locked at position " + this.elementPosition + " in the Grid");
			return true;
		} else {
			return false;
		}
	}

	public boolean cancelElementFromGrid() {
		if (this.isLocked) {
			this.isLocked = false;
			System.out.println("The element at position " + this.elementPosition + "has been unlocked from the Grid");
			return true;
		} else {
			return false;
		}
	}

}
