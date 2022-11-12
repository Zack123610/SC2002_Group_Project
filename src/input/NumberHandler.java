package input;

import java.util.Scanner;

/**
 * The NumberHandle class handles number inputs, and does error handling
 */
public class NumberHandler{
	/**
	 * Initializing a scanner object
	 */
	private static Scanner sc = new Scanner(System.in);
	
	/** Reads an integer input.
	 *  Throws error if it is invalid 
	 * @return an integer between 0-9
	 */
	public static int readInt() {
		int choice = -1;
		boolean done = false;
		
		while (!done) {
			String next = sc.nextLine();
			
			try {
				choice = Integer.parseInt(next);
				
				if (choice >= 0)
					done = true;
				else
					System.out.println("Error. Input cannot be negative.");
			} catch (NumberFormatException e) {
				System.out.println("Error. Invalid integer input. Try again.");
			}
		}
		
		return choice;
	}
	
	/**
	 * Reads an input between 0 to hi, with error checking
	 * @param hi is the upper bound of the input inclusive
	 * @return an integer between 0 to hi
	 */
	public static int readInt(int hi) {
		return readInt(0, hi);
	}
	
	/**
	 * Reads an input between lo and hi, with error checking
	 * @param lo is the lower bound inclusive
	 * @param hi is the upper bound inclusive
	 * @return an integer between lo to hi
	 */
	public static int readInt(int lo, int hi) {
		int choice = -1;
		
		while (!(lo <= choice && choice <= hi)) {
			choice = readInt();
			
			if (!(lo <= choice && choice <= hi))
				System.out.printf("Error. Please enter an integer between %d-%d.\n", lo, hi);
		}
		
		return choice;
	}
	
	/**
	 * Reads a double input, and checks if the value is positive.
	 * Throws error if the value is not positive
	 * @return a positive double value
	 */
	public static double readDouble() {
		double choice = -1.0;
		boolean done = false;
		
		while (!done) {
			String next = sc.nextLine();
			
			try {
				choice = Double.parseDouble(next);
				
				if (choice >= 0)
					done = true;
				else
					System.out.println("Error. Input cannot be negative.");
			} catch (NumberFormatException e) {
				System.out.println("Error. Invalid double input. Try again.");
			}
		}
		
		return choice;
	}
}
