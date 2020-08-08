// Justin Calma | CECS 277 - 13 | MW 11AM - 1:15PM

import java.util.*;

public class hashmap {
	
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		HashMap<String, List<Integer>> hashmap = new HashMap<>();
		
		System.out.println("Enter a block of text: "); // Ask the user to enter a text to index
		String userStr; 
		int idx = 1;
		List<Integer> positions;
		
		while(scnr.hasNext()) { // While loop to iterate through whole inputted text
			userStr = scnr.next(); // Get next word from the text
			if (userStr.equals("!!quit!!")) { // If userStr equals exit case then exit out of loop
				break;
			}
			userStr = userStr.toLowerCase(); // Converting whole text into lowercase
			
			// Normalize the string input
			if (userStr.contains("?") || userStr.contains("!") || userStr.contains(",") || userStr.contains(";") || userStr.contains("'") 
				|| userStr.contains("(") || userStr.contains(")") || userStr.contains("\"") || userStr.contains("-")) { // Checks for punctuation characters and removes them
					userStr = userStr.replace("?", "");
					userStr = userStr.replace("!", "");
					userStr = userStr.replace(",", "");
					userStr = userStr.replace(";", "");
					userStr = userStr.replace("'", "");
					userStr = userStr.replace("(", "");
					userStr = userStr.replace(")", "");
					userStr = userStr.replace("\"", "");
					userStr = userStr.replace("-", "");
			}
			
			positions = hashmap.get(userStr);
			if (hashmap.containsKey(userStr)) { // Checks if key already exists in hashmap
				positions.add(idx);
				hashmap.replace(userStr, positions);
			} else { // Else create new ArrayList and add key + position into hashmap
				positions = new ArrayList<Integer>();
				positions.add(idx);
				hashmap.put(userStr, positions);
			}
			idx++; // Increment idx to find each position in text
		}
		
		System.out.println("Enter a single world to find how much it occurred in the text: "); // Ask user to input the word they wish to find
		String key = scnr.next();
		key = key.toLowerCase(); // Converting whole text into lowercase
		if (key.contains("?") || key.contains("!") || key.contains(",") || key.contains(";") || key.contains("'") 
				|| key.contains("(") || key.contains(")") || key.contains("\"") || key.contains("-")) { // Checks for punctuation characters and removes them
			key = key.replace("?", "");
			key = key.replace("!", "");
			key = key.replace(",", "");
			key = key.replace(";", "");
			key = key.replace("'", "");
			key = key.replace("(", "");
			key = key.replace(")", "");
			key = key.replace("\"", "");
			key = key.replace("-", "");
		}
		if (hashmap.containsKey(key)) { // If key exists in hashmap
			System.out.println("The desired key: " + key + " has been found " + hashmap.get(key) + " at these positions ");
		} else { // If key does not exist in hashmap
			System.out.println("The desired key: " + key + " was not found in the inputted text");
		}
	}
}
