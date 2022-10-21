package input;

import java.util.Scanner;

public class StringHandler{
	private static Scanner sc = new Scanner(System.in);
	
	// Takes in any string input except empty string / whitespace
	public static String readString() {
		boolean done = false;
		String next = "";
		
		while (!done) {
			next = sc.nextLine().trim();
			if (next.isEmpty()) {
				System.out.println("Input cannot be empty.");
			} else
				done = true;
		}
		return next;
	}

}
