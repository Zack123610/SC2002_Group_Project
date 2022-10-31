package cineplex.cinema;

import java.util.Scanner;

public class CinemaController {
	// Cinema controller no longer needs to preload any data 
	// (The cinema objects are either stored within showtime or cineplex)
	// It now only needs to handle the seat booking when passed in Cinema object as parameter
	public CinemaController() {	}
	public Seat selectSeat(Cinema cinema){
		cinema.displaySeatingLayout();
		System.out.println("Select Seat (row col)");
		Scanner sc = new Scanner(System.in);
		char row = sc.next().charAt(0);
		int col= sc.nextInt();
		Seat seat = cinema.bookSeat(row,col-1);
		return seat;
	}
	

	
	
	
}
