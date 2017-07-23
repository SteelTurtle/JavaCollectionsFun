package org.gorillacorp.map_adventure_game;

import java.util.HashMap;
import java.util.Map;

public class Location {

	private final int locationId;
	private final String description;
	private final Map<String, Integer> passages;

	// constructors
	public Location(int locationId, String description) {
		this.locationId = locationId;
		this.description = description;
		this.passages = new HashMap<>();
	}

	// getters
	public int getPositionId() {
		return locationId;
	}

	public String getDescription() {
		return description;
	}

	public Map<String, Integer> getPassages() {
		// defensive programming: we do return a COPY of the original map, not the
		// original map itself
		return new HashMap<>(passages);
	}

	public void addNewPassage(String direction, int position) {
		passages.put(direction, position);
	}
}
