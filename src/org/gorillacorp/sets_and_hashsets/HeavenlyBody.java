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
}
