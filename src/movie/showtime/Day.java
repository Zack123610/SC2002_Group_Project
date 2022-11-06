package movie.showtime;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

import movie.ticket.IGetTicketAttribute;

/**
 * The {@code Day} class stores the date and time
 * @author Tan Say Hong
 *
 */
public class Day implements IGetTicketAttribute, Serializable {

	/**
	 * A static final UUID for serializing {@code Day} objects
	 */
	private static final long serialVersionUID = -2137042328502058023L;
	/**
	 * The date of the {@code Day} object
	 */
	private LocalDate date;
	/**
	 * The time of the {@code Day} object
	 */
	private LocalTime time;
	
	public Day(LocalDate date, LocalTime time) {
		this.date = date;
		this.time = time;
	}

	/**
	 * Gets the date field of the {@code Day} object
	 * @return the date field
	 */
	public LocalDate getDate() { return date; }
	/**
	 * Gets the time field of the {@code Day} object
	 * @return the time field
	 */
	public LocalTime getTime() { return time; }

	/**
	 * Sets the date field of the {@code Day} object
	 * @param date the date to set
	 */
	public void setDate(LocalDate date) { this.date = date; }
	/**
	 * Sets the time field of the {@code Day} object
	 * @param time the time to set
	 */
	public void setTime(LocalTime time) { this.time = time; }
	
	/**
	 * Used to check whether two {@code Day} objects are refering to the same date
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Day) {
			Day day = (Day) obj;
			return this.date.equals(day.date) && this.time.equals(day.time);
		}
		return false;
	}

	/**
	 * Returns the string of the {@code Day} object in the form YYYY-MM-DD HH:MM
	 */
	@Override
	public String toString() {
		return date.toString() + " " + time.toString();
	}
	
	/**
	 * This method calculates the multiplier of the day via a set of rules.
	 * If it is a holiday, then return the multiplier for the holiday price
	 * Else return weekend multiplier of 1.2, or weekday multiplier of 1
	 */
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
