package org.gorillacorp.gridfiller;

public class Element {

	private final String elementPosition;
	private boolean isLocked;

	public Element(String elementPosition) {
		this.elementPosition = elementPosition;
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
