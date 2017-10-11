package org.gorillacorp.sorted_collections;

public class Grocery implements Comparable<Grocery> {
	private final String name;
	private double price;
	private int quantityInStock;
	private int quantityReserved = 0;

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

	// setPrice could actually be removed for this program, as it is not used
	public void setPrice(double price) {
		if (price > 0.0) {
			this.price = price;
		}
	}

	// customers should not be able to reserve more groceries than those
	// available in stock
	public int getQuantityInStock() {
		return quantityInStock - quantityReserved;
	}

	public int reserveGroceries(int groceriesToReserve) {
		if (groceriesToReserve <= getQuantityInStock()) {
			this.quantityReserved += groceriesToReserve;
			return groceriesToReserve;
		}
		return 0;
	}

	public int unreserveGroceries(int quantityToUnreserve) {
		if (quantityToUnreserve <= quantityReserved) {
			this.quantityReserved -= quantityToUnreserve;
			return quantityToUnreserve;
		}
		return 0;
	}

	// checkout quantities in the shopping basket and adjust the groceries'
	// quantity in stock (and clear the shopping basket of course)
	public int checkOutReservedGroceries(int quantityCheckedOut) {
		if (quantityCheckedOut <= quantityReserved) {
			this.quantityInStock -= quantityCheckedOut;
			this.quantityReserved -= quantityCheckedOut;
			return quantityCheckedOut;
		}
		return 0;
	}

	public String getName() {
		return name;
	}

	public void adjustStock(int quantity) {
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
		return this.name + " : price " + this.price
				+ ". Reserved grocery items in the shopping basket: "
				+ this.quantityReserved;
	}

}
