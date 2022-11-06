package movie.showtime;

import java.time.LocalDate;

import movie.ticket.ITicketAttribute;

/**
 * This Enum represents the different holidays in Singapore
 * @author Tan Say Hong
 *
 */
public enum Holiday implements ITicketAttribute {
	NEW_YEAR(1, 1),
	CHINESE_NEWYEAR1(1, 2),
	CHINESE_NEWYEAR2(2, 2),
	GOOD_FRIDAY(15, 4),
	LABOUR_DAY(1, 5),
	HARI_RAYA(3, 5),
	VESAK_DAY(15, 5),
	HARI_RAYA_HAJI(10, 7),
	NATIONAL_DAY(9, 8),
	DEEPAVALI(24, 10),
	CHRISTMAS(25, 12);

	/**
	 * The multiplier which affects the ticket price.
	 * Initialises the default holiday multiplier of 1.3
	 */
	private static double multiplier = 1.3;
	/**
	 * The month and day of the enum respectively
	 */
	private int month, day;
	
	/**
	 * Constructor to create a new {@code Holiday} enum
	 * @param day the day of the holiday
	 * @param month the month of the holiday
	 */
	Holiday(int day, int month) {
		this.day = day;
		this.month = month;
	}
	
	/**
	 * Checks whether a given date is a holiday. If it is, then returns the corresponding {@code Holiday} enum
	 * @param date the date to check whether it is a holiday
	 * @return the {@code Holiday} enum if the date is a holiday, {@code null} otherwise
	 */
	public static Holiday isHoliday(LocalDate date) {
		int day = date.getDayOfMonth(), month = date.getMonthValue();
		
		for (Holiday holiday : Holiday.values()) 
			if (holiday.getDay() == day && holiday.getMonth() == month)
				return holiday;
		return null;
	}
	
	/**
	 * Gets the multiplier of the Holiday 
	 */
	@Override
	public double getMultiplier() { return multiplier; }
	/**
	 * Gets the month of the {@code Holiday} enum
	 * @return the month of the holiday
	 */
	public int getMonth() { return month; }
	/**
	 * Gets the day of the {@code Holiday} enum
	 * @return the day of the holiday
	 */
	public int getDay() { return day; }

	@Override
	public void setMultiplier(double multiplier) { Holiday.multiplier = multiplier; }
}
