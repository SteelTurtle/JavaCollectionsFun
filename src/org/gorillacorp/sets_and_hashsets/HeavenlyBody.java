package org.gorillacorp.sets_and_hashsets;

import java.util.HashSet;
import java.util.Set;

public final class HeavenlyBody {

	private final String name;
	private final double revolutionPeriod;
	private final Set<HeavenlyBody> satellites;

	public HeavenlyBody(String name, double revolutionPeriod) {
		this.satellites = new HashSet<>();
		this.name = name;
		this.revolutionPeriod = revolutionPeriod;
	}

	public String getName() {
		return name;
	}

	public double getRevolutionPeriod() {
		return revolutionPeriod;
	}

	public Set<HeavenlyBody> getSatellites() {
		return new HashSet<>(this.satellites);
	}

	public boolean addMoon(HeavenlyBody moon) {
		return this.satellites.add(moon);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(revolutionPeriod);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result
				+ ((satellites == null) ? 0 : satellites.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HeavenlyBody other = (HeavenlyBody) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(revolutionPeriod) != Double
				.doubleToLongBits(other.revolutionPeriod))
			return false;
		if (satellites == null) {
			if (other.satellites != null)
				return false;
		} else if (!satellites.equals(other.satellites))
			return false;
		return true;
	}
	
	
}
