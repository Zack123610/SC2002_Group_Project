package input;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class StringHandler{
	private static Scanner sc = new Scanner(System.in);
	
	// Takes in any string input except empty string / whitespace
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
	
	// Takes in a string input specified in args
	public static String readString(String ... args) {
		List<String> valid = Arrays.asList(args);
		
		String next;
		while (!valid.contains(next = readString()))
			System.out.println("Invalid option. Try again.");
		
		return next;
	}
	
	// Takes in a character
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
