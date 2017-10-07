package org.gorillacorp.sets_and_hashsets;

public class DwarfPlanet extends HeavenlyBody {

	public DwarfPlanet(String name, double revolutionPeriod) {
		super(name, revolutionPeriod, BodyTypes.DWARF_PLANET);
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
