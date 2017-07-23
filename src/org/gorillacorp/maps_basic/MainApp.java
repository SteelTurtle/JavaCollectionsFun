package org.gorillacorp.maps_basic;

import java.util.HashMap;
import java.util.Map;

public class MainApp {

	public static void main(String[] args) {
		// Remember NOT to use duplicate key names for a map. Defining a map entry with
		// a duplicate key name
		// overwrites the pre-existing value of the entry with the same key name
		Map<String, String> stringMap = new HashMap<>();
		stringMap.put("alpha", "description for alpha");
		stringMap.put("beta", "description for beta");
		stringMap.put("gamma", "description for gamma");
		stringMap.put("delta", "description for delta");
		stringMap.put("theta", "description for theta");

		// The following statement will print "null". You cannot stack together the
		// initialization & assignment operations of
		// a map entry AND try to print it at the same time.
		System.out.println(stringMap.put("omega", "description for omega"));
		System.out.println(stringMap.get("gamma"));

		// check if a specific key-value already exists in the map
		if (stringMap.containsKey("gamma")) {
			System.out.println("gamma is already defined in the map");
		} else {
			stringMap.put("gamma", "description for gamma");
			System.out.println("I have added the 'gamma' key-value entry in the map");
		}

		System.out.println("***************************************");

		// You need to extract a Set view from the map before you can iterate through
		// its keys (and values).
		// Such is the purpose of keySet() down here...
		for (String key : stringMap.keySet()) {
			System.out.println(key + " : " + stringMap.get(key));
		}
		
		// Replace a key and its exact value in a map with another value. The value
		// being replaced must of course match the original one. Notice also that in Java
		// a key does not have to be necessarily an immutable object (e.g. a String in this case)
		if(stringMap.replace("theta", "description for theta", "NEW description for theta")) {
			System.out.println("The value of theta has been replaced");
		} else {
			System.out.println("Could not replace the value for theta.");
		}
		
	}

}
