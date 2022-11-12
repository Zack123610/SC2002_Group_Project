package input;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * The StringHandler class handles string inputs and does error handling
 */
public class StringHandler{
	/**
	 * Initialize a scanner object
	 */
	private static Scanner sc = new Scanner(System.in);
	
	/**
	 * Reads a string input.
	 * Displays an error message if the input is empty
	 * @return a non-empty string
	 */
	public static String readString() {
		boolean done = false;
		String next = "";
		
		while (!done) {
			next = sc.nextLine().trim();
			if (next.isEmpty()) 
				System.out.println("Input cannot be empty.");
			else
				done = true;
		}
		return next;
	}
	
	/**
	 * Takes a string input specified in args
	 * @param args are the valid string inputs to check 
	 * @return a valid string
	 */
	public static String readString(String ... args) {
		List<String> valid = Arrays.asList(args);
		
		String next;
		while (!valid.contains(next = readString()))
			System.out.println("Invalid option. Try again.");
		
		return next;
	}
	
	/**
	 * Reads a character input. Displays error message if input is not a character
	 * @return a character
	 */
	public static Character readCharacter() {
		boolean done = false;
		String next = "";
		
		while (!done) {
			next = readString();
			if (next.length() > 1)
				System.out.println("Input should only contain a single character");
			else
				done = true;
		}
		return next.charAt(0);
	}
}
