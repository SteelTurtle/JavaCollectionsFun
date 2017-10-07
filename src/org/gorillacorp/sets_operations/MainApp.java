package org.gorillacorp.sets_operations;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MainApp {

	public static void main(String[] args) {

		Set<Integer> squares = new HashSet<>();
		Set<Integer> cubes = new HashSet<>();

		for (int i = 1; i <= 100; i++) {
			squares.add(i * i);
			cubes.add(i * i * i);
		}

		System.out.println("There are " + squares.size()
				+ " squares in the 'squares' set,\n" + "and " + cubes.size()
				+ " cubes in the 'cube' set.");

		// Let us create a Union of the two sets
		Set<Integer> union = new HashSet<>(squares);
		union.addAll(cubes);
		System.out.println("The set 'union' contains " + union.size()
				+ " elements, (both 'cubes' and 'squares' elements MINUS the duplicate values).");

		// Now an Intersection of two sets...
		Set<Integer> intersection = new HashSet<>(squares);
		intersection.retainAll(cubes);
		System.out.println("The set 'intersection' contains "
				+ intersection.size()
				+ " elements, (both 'cubes' and 'squares' COMMON values).");

		// Bonus Stage (because I just wanted to do that: copy the content of an
		// array into a HashSet)
		System.out.println(
				"\nBonus Stage (because I just wanted to do that: copy the content of an array into a HashSet)\n");
		String aString = "Bibody Bob had a bad attitude and and small brain";
		Set<String> wordsSet = new HashSet<>();
		String[] wordsArray = aString.split(" ");
		wordsSet.addAll(Arrays.asList(wordsArray));
		System.out.println(wordsSet);
		System.out.println();

		// Asymmetric difference of sets
		System.out.println(
				"*****Symmetric and asymmetric difference of sets******");
		Set<String> things1 = new HashSet<>();
		Set<String> things2 = new HashSet<>();
		String[] arrayOfThings = { "alpha", "beta", "one", "lift", "scavenge",
				"spaghetti", "Rubbish", "On", "Rails", "code", "Jupiter" };
		String[] anotherArrayOfThings = { "one", "soup", "of", "sailor",
				"scavenge", "spaghetti", "rumble", "in", "the", "jungle",
				"Venus" };
		things1.addAll(Arrays.asList(arrayOfThings));
		things2.addAll(Arrays.asList(anotherArrayOfThings));

		System.out.println("things1 - things 2: ");
		Set<String> diff1 = new HashSet<>(things1);
		diff1.removeAll(things2);
		print(diff1);

		System.out.println("things2 - things 1: ");
		Set<String> diff2 = new HashSet<>(things2);
		diff2.removeAll(things1);
		print(diff2);

		// Symmetric difference: removing the intersection set from the union
		// set
		Set<String> unionTest = new HashSet<>(things1);
		unionTest.addAll(things2);
		Set<String> intersectionTest = new HashSet<>(things1);
		intersectionTest.retainAll(things2);
		System.out.println(
				"\nSymmetric difference of sets, obtained by removing the intersection set from the union set:\n");
		unionTest.removeAll(intersectionTest);
		print(unionTest);

		// Test if a set is a superset of another
		System.out.println("\n*****Test if a set is a superset of another*****\n");
		if (things1.containsAll(things2)) {
			System.out.println("things2 is a subset of things1.");
		}
		if (things1.containsAll(intersectionTest)) {
			System.out.println("intersectionSet is a subset of things1.");
		}
		if (things2.containsAll(intersectionTest)) {
			System.out.println("intersectionSet is a subset of things2.");
		}
	}

	private static void print(Set<String> aSet) {
		System.out.print("\t");
		for (String s : aSet) {
			System.out.print(s + " ");
		}
		System.out.println();

	}

}
