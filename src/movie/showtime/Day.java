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
	
	// If it is a holiday, then return the multiplier for the holiday price
	// If not holiday, then return weekend multiplier of 1.2, or else default is 1
	@Override
	public double getMultiplier() {
		Holiday holiday;
		if ((holiday = Holiday.isHoliday(date)) != null)
			return holiday.getMultiplier();
		if (date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY)
			return 1.2;
		return 1.0;
	}
}
