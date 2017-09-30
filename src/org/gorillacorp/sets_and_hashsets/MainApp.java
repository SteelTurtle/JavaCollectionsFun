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

		HeavenlyBody earthMoon = new HeavenlyBody("Moon", 27);
		solarSystem.put(earthMoon.getName(), earthMoon);
		earth.addMoon(earthMoon);

		System.out.println("Planets: ");
		for (HeavenlyBody planet : planets) {
			System.out.println("\t" + planet.getName());
		}

		HeavenlyBody body = solarSystem.get("Earth");
		System.out.println("Moons of " + body.getName());
		for (HeavenlyBody moon : body.getSatellites()) {
			System.out.println("\t" + moon.getName());
		}

	}

}
