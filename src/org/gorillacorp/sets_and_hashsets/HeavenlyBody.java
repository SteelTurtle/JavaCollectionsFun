package org.gorillacorp.sets_and_hashsets;

import java.util.HashSet;
import java.util.Set;

public abstract class HeavenlyBody {

	// Multi-valued Key to be used as a Map key
	private final Key key;
	private final double revolutionPeriod;
	private final Set<HeavenlyBody> satellites;

	// Enum to classify the different body types.
	// Remember that an inner enum is automatically static, so we could also
	// avoid the "static" keyword...
	public static enum BodyTypes {
		STAR, PLANET, DWARF_PLANET, MOON, COMET, ASTEROID
	}

	public HeavenlyBody(String name, double revolutionPeriod,
			BodyTypes bodyTypes) {
		this.satellites = new HashSet<>();
		this.revolutionPeriod = revolutionPeriod;
		this.key = new Key(name, bodyTypes);
	}

	public double getRevolutionPeriod() {
		return revolutionPeriod;
	}

	public Key getKey() {
		return this.key;
	}

	public static Key makeKey(String name, BodyTypes bodyType) {
		return new Key(name, bodyType);
	}

	public Set<HeavenlyBody> getSatellites() {
		return new HashSet<>(this.satellites);
	}

	public boolean addSatellite(HeavenlyBody satellite) {
		return this.satellites.add(satellite);
	}

	@Override
	public int hashCode() {
		return this.key.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		// Notice the specific check & cast needed to compare the different
		// objects, once we decide to implement the main identifiers to be used
		// for each HevenlyBody object not in this class, but in the inner
		// static
		// class "Key"
		if (obj instanceof HeavenlyBody) {
			HeavenlyBody body = (HeavenlyBody) obj;
			return this.key.equals(body.getKey());
		}
		return false;
	}

	@Override
	public String toString() {
		return "HeavenlyBody [key=" + key.name + ", body type=" + key.bodyType
				+ ", revolutionPeriod=" + revolutionPeriod + ", satellites="
				+ satellites + "]";
	}

	// We want to use a more viable approach to identify the single planets of
	// the "solarSystem" Map
	// in the main class. Yes, a string is ok most of the time, but having a
	// "Key" inner class in HeavenlyBody
	// is even better... Of course, using an object instead of a String as a
	// Map key
	// means that we must provide both equal() and hash() methods on the class
	public static final class Key {
		private String name;
		private BodyTypes bodyType;

		// even if this is defined as a private constructor, this will still be
		// called when
		// a Key() instance is initialized
		private Key(String name, BodyTypes bodyType) {
			this.name = name;
			this.bodyType = bodyType;
		}

		public String getName() {
			return name;
		}

		public BodyTypes getBodyType() {
			return bodyType;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result
					+ ((bodyType == null) ? 0 : bodyType.hashCode());
			result = prime * result + ((name == null) ? 0 : name.hashCode());
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
			Key other = (Key) obj;
			if (bodyType != other.bodyType)
				return false;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Key [name=" + name + ", bodyType=" + bodyType + "]";
		}

	}

}
