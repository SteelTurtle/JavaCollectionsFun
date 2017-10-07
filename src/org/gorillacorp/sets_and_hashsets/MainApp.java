package org.gorillacorp.sets_and_hashsets;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MainApp {

	/*
	 * Example of use of Sets and Maps
	 */
	private static Map<HeavenlyBody.Key, HeavenlyBody> solarSystem = new HashMap<>();
	private static Set<HeavenlyBody> planets = new HashSet<>();

	public static void main(String[] args) {

		HeavenlyBody mercury = new Planet("Mercury", 88);
		solarSystem.put(mercury.getKey(), mercury);
		planets.add(mercury);

		HeavenlyBody earth = new Planet("Earth", 365);
		solarSystem.put(earth.getKey(), earth);
		planets.add(earth);

		HeavenlyBody venus = new Planet("Venus", 225);
		solarSystem.put(venus.getKey(), venus);
		planets.add(venus);

		HeavenlyBody mars = new Planet("Mars", 225);
		solarSystem.put(mars.getKey(), mars);
		planets.add(mars);

		// add moons to planets
		HeavenlyBody earthMoon = new Moon("Moon", 27);
		solarSystem.put(earthMoon.getKey(), earthMoon);
		earth.addSatellite(earthMoon);

		HeavenlyBody deimos = new Moon("Deimos", 67);
		HeavenlyBody phobos = new Moon("Phobos", 45);
		solarSystem.put(deimos.getKey(), deimos);
		solarSystem.put(phobos.getKey(), phobos);
		mars.addSatellite(deimos);
		mars.addSatellite(phobos);

		System.out.println("Planets: ");
		for (HeavenlyBody planet : planets) {
			System.out.println("\t" + planet.getKey());
		}
		
		HeavenlyBody body1 = solarSystem.get(HeavenlyBody.makeKey("Mars", HeavenlyBody.BodyTypes.PLANET));
		System.out.println("Moons of " + body1.getKey());
		for (HeavenlyBody moon : body1.getSatellites()) {
			System.out.println("\t" + moon.getKey());
		}

		// Union of Sets
		Set<HeavenlyBody> moonsUnion = new HashSet<>();
		for (HeavenlyBody planet : planets) {
			moonsUnion.addAll(planet.getSatellites());
		}
		System.out.println(
				"List of all moons in the (lazy version) of the solar system:");
		for (HeavenlyBody moon : moonsUnion) {
			System.out.println("\t" + moon.getKey());
		}

	}

}
