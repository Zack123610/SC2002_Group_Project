package cineplex.cinema;

import input.IntegerHandler;
import input.StringHandler;

public class CinemaController {
	// Cinema controller no longer needs to preload any data 
	// (The cinema objects are either stored within showtime or cineplex)
	// It now only needs to handle the seat booking when passed in Cinema object as parameter
	public CinemaController() {	}

	// Controller methods
	public Seat bookSeat(Cinema cinema){
		cinema.displaySeatingLayout();
		System.out.println("Select Seat (row col)");
		
		System.out.print("Enter row number: ");
		char row = StringHandler.readCharacter();
		
		System.out.print("Enter col number: ");
		int col = IntegerHandler.readInt();
		
		return cinema.selectSeat(row, col-1);
		
//		if (seat == null)
//			return null;
		
//		System.out.printf("Seat %s selected. \nConfirm selection? (Y/N) ", seat.getSeatCode());
//		if (StringHandler.readString("Y", "N").equals("N"))
//			return null;
//		
//		cinema.bookSeat(seat);
//		return seat;
	}
}
