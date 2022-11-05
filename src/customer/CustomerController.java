package customer;

import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;



import customer.Customer;
import booking.Booking;
import input.FileController;
import input.IntegerHandler;
import input.StringHandler;
import main.ICustomerController;
import main.MOBLIMA;
import movie.Movie;
import movie.showtime.Showtime;

public class CustomerController implements ICustomerController{
	
	private Map<Integer, Customer> accounts = new HashMap<>();
	private ArrayList<Customer> customers =new ArrayList<>();

	public CustomerController() {
		
		customers = FileController.read("./data/customer/");
		for(Customer customer: customers){
			accounts.put(Integer.parseInt(customer.getMobileNo()), customer);
		}
		
	}


	public void exit(){
		FileController.write(customers, "./data/customer/");
		System.out.println("Customer Controller exited successfully!");
	}


	private void displayCustomerMenu() {
		System.out.println(
				"======================= Customer Menu =======================\n" +
						"1) List all available movies\n" +
						"2) List top 5 ranking movies\n" +
						"3) View single movie details\n" +
						"4) Leave a movie review\n" +
						"5) Make a booking\n" +
						"6) View booking history\n" +
						"7) Search Movie\n" +
						"8) Quit");
		System.out.print("Please select an option: ");
	}
	Customer customer = null;
	public void run() {
		
		boolean done = false;
		Movie selected = null;
		do {
			displayCustomerMenu();
			
			switch (IntegerHandler.readInt(1, 8)) {
			case 1:
				MOBLIMA.movieController.displayAllAvailableMovies();
				break;
				
			case 2:
				MOBLIMA.movieController.listTopFive();
				break;

			case 3:
				if ((selected = MOBLIMA.movieController.selectMovie(6)) != null)
					selected.displayFullDetails();
				break;
				
			case 4:
				MOBLIMA.reviewController.writeReview();
				break;
				
			case 5:
				getCustomerByMobile();
				if (customer != null)
					MOBLIMA.bookingController.doBooking(customer);
				else
					System.out.println("Unable to perform movie booking. Please sign up for an account first.");
				break;
				
			case 6:
				getCustomerByMobile();
				System.out.println("--- View Booking History ---");
				if (customer == null || customer.getBookings().size() == 0)
					System.out.println("Booking history is empty");
				else {
					customer.displayParticulars();
					customer.getBookings().forEach(Booking::displayBookingInfo);
				}
				break;
				
			case 7:
				if((selected = MOBLIMA.movieController.searchMovie()) != null) 
					handleMovieOptions(selected);
				break;
				
			case 8:
				System.out.println("Exiting Customer Application ...");
				customer = null;
				done = true;
			}

		} while (!done);
	}
	
	public void displayMovieOptions() {
		System.out.println("--- Options ---");
		System.out.println(	"1) Display movie details\n" +
							"2) Book movie\n" + 
							"3) Display showtimes\n" + 
							"4) Back");
		System.out.print("Please select an option: ");
	}
	
	public void handleMovieOptions(Movie movie) {
		while(true) {
			displayMovieOptions();
			switch(IntegerHandler.readInt(1, 4)) {
				case 1:
					movie.displayFullDetails();
					break;
					
				case 2:
					if (movie.isEndofShowing()) {
						System.out.println("Movie is no longer in showing.");
						continue;
					}
					
					getCustomerByMobile();
					if (customer != null)
						MOBLIMA.bookingController.doBooking(customer, movie);
					else
						System.out.println("Unable to perform movie booking. Please sign up for an account first.");
					break;
					
				case 3:
					List<Showtime> list = MOBLIMA.showtimeController.filterShowtimeByMovie(movie);
					MOBLIMA.showtimeController.displayShowtimes(list);
					break;
					
				case 4:
					return;
			}
		}
	}
	
	private void createNewAccount() {
		while (true) {
			System.out.print("Enter Name: ");
			customer = new Customer(StringHandler.readString(), getMobileWithValidation(), getEmailWithValidation());
			
			if (accounts.containsKey(Integer.parseInt(customer.getMobileNo()))) 
				System.out.println("An account with this number already exists.");
			else {
				customer.displayParticulars();
				System.out.print("Please confirm your particulars are correct (Y/N): ");
				if (StringHandler.readString("Y", "N").equals("Y")) {
					customers.add(customer);
					accounts.put(Integer.parseInt(customer.getMobileNo()), customer);
					return;
				}
			}
			
			System.out.print("Would you like to continue with account creation? (Y/N) ");
			if (StringHandler.readString("Y", "N").equals("N")) {
				customer = null;
				return;
			}
		}

	}
	
	private void getCustomerByMobile() {
		if (customer != null)
			return;
		
		String mobileNo = getMobileWithValidation();
		
		if ((customer = accounts.getOrDefault(Integer.parseInt(mobileNo), null)) != null)
			return;
		
		System.out.print("No account found with this number. Would you like to create an account? (Y/N) ");
		if (StringHandler.readString("Y", "N").equals("Y"))
			createNewAccount();
	}
	
	private String getMobileWithValidation() {
		String text;
		Pattern pattern = Pattern.compile("[89]\\d{7}");
		
		System.out.print("Enter mobile: ");
		while (!pattern.matcher(text = StringHandler.readString()).matches()) {
			System.out.println("Invalid mobile number input. Try again");
			System.out.println("Enter mobile: ");
		}
		return text;
	}
	
	private String getEmailWithValidation() {
		String text;
		Pattern pattern = Pattern.compile("^(.+)@(\\S+)$");
		
		System.out.print("Enter email: ");
		while (!pattern.matcher(text = StringHandler.readString()).matches()) {
			System.out.println("Invalid email input. Try again");
			System.out.println("Enter email: ");
		}
		return text;
	}

}

