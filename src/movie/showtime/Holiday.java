package movie.showtime;

import java.time.LocalDate;
import java.util.Arrays;

import movie.ticket.ITicketAttribute;

public enum Holiday implements ITicketAttribute {
	NEW_YEAR(1, 1),
	CHINESE_NEWYEAR(2, 2),
	GOOD_FRIDAY(15, 4),
	LABOUR_DAY(1, 5),
	HARI_RAYA(3, 5),
	VESAK_DAY(15, 5),
	HARI_RAYA_HAJI(10, 7),
	NATIONAL_DAY(9, 8),
	DEEPAVALI(24, 10),
	CHRISTMAS(25, 12);

	// Initialise holiday multiplier
	private static double multiplier = 1.3;
	private int month, day;
	
	Holiday(int day, int month) {
		this.day = day;
		this.month = month;
	}
	
	public static Holiday isHoliday(LocalDate date) {
		int day = date.getDayOfMonth(), month = date.getMonthValue();
		
		for (Holiday holiday : Holiday.values()) 
			if (holiday.getDay() == day && holiday.getMonth() == month)
				return holiday;
		return null;
	}
	
	public void changeDate(int day, int month) {
		this.day = day;
		this.month = month;
	}

	@Override
	public double getMultiplier() { return multiplier; }
	public int getMonth() { return month; }
	public int getDay() { return day; }

	@Override
	public void setMultiplier(double multiplier) { Holiday.multiplier = multiplier; }
}
