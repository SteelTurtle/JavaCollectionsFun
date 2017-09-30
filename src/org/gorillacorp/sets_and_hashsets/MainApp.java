package org.gorillacorp.sets_and_hashsets;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MainApp {

	/*
	 * Dead-Simple example of concurrent use of Sets and Maps
	 */
	private static Map<String, HeavenlyBody> solarSystem = new HashMap<>();
	private static Set<HeavenlyBody> planets = new HashSet<>();

	public static void main(String[] args) {

		HeavenlyBody mercury = new HeavenlyBody("Mercury", 88);
		solarSystem.put(mercury.getName(), mercury);
		planets.add(mercury);

		HeavenlyBody earth = new HeavenlyBody("Earth", 365);
		solarSystem.put(earth.getName(), earth);
		planets.add(earth);

		HeavenlyBody venus = new HeavenlyBody("Venus", 225);
		solarSystem.put(venus.getName(), venus);
		planets.add(venus);

		HeavenlyBody mars = new HeavenlyBody("Mars", 225);
		solarSystem.put(mars.getName(), mars);
		planets.add(mars);

		// add moons to planets
		HeavenlyBody earthMoon = new HeavenlyBody("Moon", 27);
		solarSystem.put(earthMoon.getName(), earthMoon);
		earth.addMoon(earthMoon);

		HeavenlyBody deimos = new HeavenlyBody("Deimos", 67);
		HeavenlyBody phobos = new HeavenlyBody("Phobos", 45);
		solarSystem.put(deimos.getName(), deimos);
		solarSystem.put(phobos.getName(), phobos);
		mars.addMoon(deimos);
		mars.addMoon(phobos);

		System.out.println("Planets: ");
		for (HeavenlyBody planet : planets) {
			System.out.println("\t" + planet.getName());
		}

		HeavenlyBody body1 = solarSystem.get("Earth");
		System.out.println("Moons of " + body1.getName());
		for (HeavenlyBody moon : body1.getSatellites()) {
			System.out.println("\t" + moon.getName());
		}

		// Sets Union
		Set<HeavenlyBody> moonsUnion = new HashSet<>();
		for (HeavenlyBody planet : planets) {
			moonsUnion.addAll(planet.getSatellites());
		}
		System.out.println(
				"List of all moons in the (lazy version) of the solar system:");
		for (HeavenlyBody moon : moonsUnion) {
			System.out.println("\t" + moon.getName());
		}

	}

}
