package cineplex;

import java.util.ArrayList;
import java.util.Arrays; //added
import java.util.List;
import java.util.UUID; //added


// import cineplex.cinema.Cinema; //Not using cinema directly anymore
import showtime.Showtime; //added
import globals.Writable;
import input.FileController; //added


// @SuppressWarnings("serial")
public class Cineplex extends Writable {

	// Attributes
	// private static final long serialVersionUID = -8543460754888135256L; //To be filled
	private String name;
	private List<UUID> showTimeIDList; // For showTime IDs
	private List<Showtime> showTimes; // ArrayList for showTime
	// public List<Cinema> cinemas; //Not using cinemas directly anymore
	
	// Constructor
	public Cineplex(String name) {
		this.name = name;
		showTimes = new ArrayList<>(); //edited
		showTimeIDList = new ArrayList<>(); //added
	}
	
	// Methods
	public String getName() { return name; }
	public List<UUID> getShowTimeIDList() { return showTimeIDList; }
	public List<Showtime> getShowTimes() { return showTimes; }
	
	public void addShowTime(Showtime showTime) {
		showTimes.add(showTime);
	}

	
//	public static void main(String[] args) {
//		Cineplex DE = new Cineplex("Downtown East");
//		Cineplex JE = new Cineplex("JEM");
//		Cineplex WM = new Cineplex("West Mall");
//		
//		DE.cinemaIDList.add(UUID.fromString("a364c40a-8056-4867-a422-a77d48f4800f"));
//		DE.cinemaIDList.add(UUID.fromString("a7cf3877-fa2c-4d82-b1bf-1526765f44ed"));
//		DE.cinemaIDList.add(UUID.fromString("5937e4a4-3db1-4585-8b1c-6d5392754cc1"));
//		                    
//		JE.cinemaIDList.add(UUID.fromString("aebc7a1a-fb38-4ff2-8376-35fb959ac32f"));
//		JE.cinemaIDList.add(UUID.fromString("7f70e14c-60a8-4f7d-a01e-fbe5ef968492"));
//		JE.cinemaIDList.add(UUID.fromString("a420fa56-2256-4418-9abc-faa77767f0c6"));
//		                    
//		WM.cinemaIDList.add(UUID.fromString("1de6703c-94d4-48fa-947a-e21116eb8cfb"));
//		WM.cinemaIDList.add(UUID.fromString("0f196e3f-83e2-41ba-bb4a-1931427cc759"));
//		WM.cinemaIDList.add(UUID.fromString("38ecbe2f-86de-4a6f-99ee-8aa7b03c106c"));
//	
//		List<Cineplex> toSer = Arrays.asList(WM, JE, DE);
//		
//		for (var element: toSer)
//			System.out.printf("Name: %-15s | ID: %s\n", element.name, element.getID().toString());
//	
//		FileController.write(toSer, System.getProperty("user.dir") + "\\data\\cineplex\\");
//	}
}
