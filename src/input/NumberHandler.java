package input;

import java.util.Scanner;

public class NumberHandler{
	private static Scanner sc = new Scanner(System.in);
	
	// Takes in any non-negative integer ( >= 0)
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
	
	// Takes in any positive integer between 0 and hi
	public static int readInt(int hi) {
		return readInt(0, hi);
	}
	
	// Takes in any positive integer between lo and hi
	public static int readInt(int lo, int hi) {
		int choice = -1;
		
		while (!(lo <= choice && choice <= hi)) {
			choice = readInt();
			
			if (!(lo <= choice && choice <= hi))
				System.out.printf("Error. Please enter an integer between %d-%d.\n", lo, hi);
		}
		
		return choice;
	}
	
	// Takes in any non-negative double ( >= 0.0 )
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
