package booking;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import customer.Age;
import movie.ticket.Ticket;

public class Booking {
	private String transactionID, name, mobileNo, email;
	private Age age;
	private List<Ticket> tickets;
	
	public Booking(String cinemaCode) {
		Date date = Calendar.getInstance().getTime();
		DateFormat dateFormat = new SimpleDateFormat("yyyymmddhhmm");
		transactionID = cinemaCode + dateFormat.format(date);
		
		tickets = new ArrayList<>();
	}

	public String getTID() { return transactionID; }
	public String getName() { return name; }
	public String getMobileNo() { return mobileNo; }
	public String getEmail() { return email; }
	public Age getAge() { return age; }
	public List<Ticket> getTickets() { return tickets; }

	public void setName(String name) { this.name = name; }
	public void setMobileNo(String mobileNo) { this.mobileNo = mobileNo; }
	public void setEmail(String email) { this.email = email; }
	public void setAge(Age age) { this.age = age; }
	
	public void addTicket(Ticket ticket) { tickets.add(ticket); }
}
