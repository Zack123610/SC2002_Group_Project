package movie.showtime;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

import movie.ticket.IGetTicketAttribute;


public class Day implements IGetTicketAttribute, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2137042328502058023L;
	private LocalDate date;
	private LocalTime time;
	
	public Day(LocalDate date, LocalTime time) {
		this.date = date;
		this.time = time;
	}

	public LocalDate getDate() { return date; }
	public LocalTime getTime() { return time; }

	public void setDate(LocalDate date) { this.date = date; }
	public void setTime(LocalTime time) { this.time = time; }

	@Override
	public String toString() {
		return date.toString() + " " + time.toString();
	}
	
	@Override
	public double getMultiplier() {
		Holiday holiday;
		if ((holiday = Holiday.isHoliday(date)) != null)
			return holiday.getMultiplier();
		if (date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY)
			return 1.2;
		return 1.0;
	}
	
//	public static void main(String[] args) {
//		Day day = new Day(LocalDate.parse("2022-10-22"), LocalTime.parse("18:15"));
//		System.out.println(day.toString());
//	}
}
