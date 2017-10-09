package org.gorillacorp.sorted_collections;

public class Grocery implements Comparable<Grocery> {
	private final String name;
	private double price;
	private int quantityInStock;

	// constructors
	public Grocery(String name, double price) {
		this.name = name;
		this.price = price;
		this.quantityInStock = 0;
	}

	public Grocery(String name, double price, int quantityInStock) {
		this(name, price);
		this.quantityInStock = quantityInStock;
	}

	// getters/setters
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		if (price > 0.0) {
			this.price = price;
		}
	}

	public int getQuantityInStock() {
		return quantityInStock;
	}

	public String getName() {
		return name;
	}

	public void refurnishStock(int quantity) {
		// let's first validate the quantity...
		int newQuantity = this.quantityInStock + quantity;
		if (newQuantity >= 0) {
			this.quantityInStock = newQuantity;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj == null || obj.getClass() != this.getClass()) {
			return false;
		}
		String objName = ((Grocery) obj).getName();
		return this.name.equals(objName);
	}

	@Override
	public int hashCode() {
		return this.name.hashCode() + 57;
	}

	@Override
	public int compareTo(Grocery o) {
		if (this == o) {
			return 0;
		}
		if (o != null) {
			// use the pre-existing String compareTo() method
			return this.name.compareTo(o.getName());
		}
		// else "o" is null. Die! Turn into dust, monster!
		throw new NullPointerException();
	}

	@Override
	public String toString() {
		return this.name + " : price " + this.price;
	}

}
