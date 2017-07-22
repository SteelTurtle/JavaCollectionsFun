package org.gorillacorp.comparator_example;

public class Element implements Comparable<Element> {

	private final String elementPosition;
	private double weight;
	private boolean isLocked;

	// Constructor
	public Element(String elementPosition, double weight) {
		this.elementPosition = elementPosition;
		this.weight = weight;
	}
	

	@Override
	public int compareTo(Element otherElement) {
		return this.elementPosition.compareToIgnoreCase(otherElement.getElementPosition());
	}
	
	//getters
	public String getElementPosition() {
		return elementPosition;
	}
	
	public double getWeight() {
		return this.weight;
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