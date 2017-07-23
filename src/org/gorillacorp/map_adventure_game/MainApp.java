package org.gorillacorp.map_adventure_game;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainApp {

	private static Map<Integer, Location> locations = new HashMap<>();

	public static void main(String[] args) {

		// user input
		Scanner scanner = new Scanner(System.in);
		locations.put(0, new Location(0, "The alarm abruptly awakes you. It is raining outside."));
		locations.put(1, new Location(1,
				"You find yourself at the entrance of a dark dungeon. How in the world did you end up here?!"));
		locations.put(2, new Location(2, "You are walking inside a straight corridor inside this strange cave. "
				+ "\nIt is too dark too see what lies around you, but you can see a dim light far ahead in front of you."
				+ "\nYou decide to keep walking..."));
		locations.put(3, new Location(3, "You reached the exit of the dark cave corridor. "
				+ "\nThere is a huge forest standing in front of you, so huge you cannot see the end of it on the horizon line"));
		locations.put(4,
				new Location(4, "You keep walking inside the forest along what you think is the North direction."
						+ "\n If only you would have paid more attention during your Geography class at the secondary school,"
						+ " you would not be wondering by now if are you really ARE heading toward North..."
						+ "\n While walking and blaming yourself without paying attention to the surroundings, you suddenly realize that you"
						+ " have reached a large oval-shaped meadow in the middle of the forest. "
						+ "\nA wood cabin lies exactly "
						+ "in the centre of the meadow. Do you think you want to take a look there?"));
		locations.put(5, new Location(5, "It turned out your dream works like a B-series Hollywood horror movie. "
				+ "\nAs you enter the cabin, an undead creature attacks you and eats you alive. Bad luck..."
				+ "\n Who were you expecting to find in an abandoned cabin within a forest, King Edward VIII playing"
				+ "\n Solitaire on Windows 95?!" + "\nWell, you are dead now, champion. Press 'Q' to quit."));
		locations.put(6, new Location(6,
				"May it be just a dream? While walking inside this endless forest, you meet a red flamingo."
						+ "\n Getting closer to the animal causes him to start talking! 'Ruu-gaaa-tyhf-sss-wekvnsn-joiwwwe', these are the  sounds emitted"
						+ "by the strange flamingo. You stand still on your feet, petrified by fear and uncapable of saying anything."
						+ "\nAnd then the flamingo speaks again. As you faint and lose your senses, the flamingo smiles at you."
						+ "\n Later on, the only thing you will remember after coming back from the darkness is that you were extremely impressed the"
						+ "\n first time you played Max Payne back in 2000..."));

		// now, the painful part: map each location with its permitted passages to/from
		// other locations ('Q' is for quit) Java9 solves this problem with new Map
		// factory methods
		// but, hey, this is Java8....
		locations.get(1).addNewPassage("E", 2);
		locations.get(1).addNewPassage("Q", 0);

		locations.get(2).addNewPassage("E", 3);
		locations.get(2).addNewPassage("Q", 0);

		locations.get(3).addNewPassage("N", 4);
		locations.get(3).addNewPassage("W", 6);
		locations.get(3).addNewPassage("Q", 0);

		locations.get(4).addNewPassage("N", 5);
		locations.get(4).addNewPassage("E", 6);
		locations.get(4).addNewPassage("Q", 0);

		locations.get(5).addNewPassage("Q", 0);

		locations.get(6).addNewPassage("E", 2);
		locations.get(6).addNewPassage("W", 3);
		locations.get(6).addNewPassage("N", 3);
		locations.get(6).addNewPassage("S", 2);
		locations.get(6).addNewPassage("Q", 0);

		// track user position
		int positionOnMap = 1;

		// main game loop
		while (true) {
			System.out.println(locations.get(positionOnMap).getDescription());
			if (positionOnMap == 0) {
				System.out.println(
						"Alas, it was just a dream. You wake up to go to work as you do every day, hoping that a different,"
								+ " much better life is awaiting for you somewhere else. "
								+ "\nMaybe it's only matter of time until you'll get there...");
				scanner.close();
				break;
			}
			// build a map consisting in a sub-set of all the possible directions that we
			// could head to, given the position we currently are.
			Map<String, Integer> locationExits = locations.get(positionOnMap).getPassages();
			System.out.println("The available passages from this position are: ");
			for (String exit : locationExits.keySet()) {
				System.out.print(exit + ", ");
			}
			System.out.println();

			// ...Then, read the direction chosen by the player and update the position on
			// the map
			// (if possible)
			String direction = scanner.nextLine().toUpperCase();
			if (locationExits.containsKey(direction)) {
				positionOnMap = locationExits.get(direction);
			} else {
				System.out
						.println("There isn't anything worth your attention here. You stop and think what to do next.");
			}
		}

	}

}
