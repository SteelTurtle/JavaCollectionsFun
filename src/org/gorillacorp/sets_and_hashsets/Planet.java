package org.gorillacorp.sets_and_hashsets;

public class Planet extends HeavenlyBody {

	public Planet(String name, double revolutionPeriod) {
		super(name, revolutionPeriod, BodyTypes.PLANET);
	}

	@Override
	public boolean addSatellite(HeavenlyBody moon) {
		if (moon.getKey().getBodyType() == BodyTypes.MOON) {
			return super.addSatellite(moon);
		} else {
			return false;
		}
	}

}
