public class Date {

	/* Data fields */
	private int year;
	private int month;
	private int day;

	/* String correspondent used for displaying months */
	String[] monthNames = {
		"January", "February", "March",
		"April", "May", "June",
		"July", "August", "September",
		"October", "November", "December"
	};

	//
	// CONSTRUCTOR
	//
	public Date(int year, int month, int day) {
		setYear(year);
		setMonth(month);
		setDay(day);
	}

	public int getYear() {
		return year;
	}

	public int getMonth() {
		return month;
	}

	public int getDay() {
		return day;
	}

	/**
	 * Check validity of the day when creating a new Date.
	 * day must be greater or equal to 1 and
	 *   - less or equal to 31 for months with 31 days
	 *   - less or equal to 30 for months with 30 days,
	 *   - less or equal to 29 for February if year is leap
	 *   - less or equal to 30 for February if year is non-leap
	 */
	private void setDay(int day) {
		if (day < 1) {
			throw new IllegalArgumentException("day must greater or equal to 1.");
		}
		if (day > 31){
			throw new IllegalArgumentException("day must less or equal to 31.");
		}
		if (isThirtyDayMonth() && day > 30) {
			throw new IllegalArgumentException("day must less than 30 for month " + monthName());
		}
		if (isFebruary() && isLeapYear() && day > 29) {
			throw new IllegalArgumentException("day must less than 29 for month " + monthName() + " on a leap year.");
		}
		if (isFebruary() && !isLeapYear() && day > 28) {
			throw new IllegalArgumentException("day must less than 28 for month " + monthName() + " on a non leap year.");
		}
		this.day = day;
	}

	/**
	 * Check validity of the month when creating a new Date. month must be between 1 and 12.
	 */
	private void setMonth(int month) {
		if (month < 1 || month > 12) {
			throw new IllegalArgumentException("month must be between 1 and 12.");
		}
		this.month = month;
	}

	/**
	 * Check validity of the year when creating a new Date. year must be greater than 0
	 */
	private void setYear(int year) {
		if (year < 0) {
			throw new IllegalArgumentException("year must be greater or equal to 0.");
		}
		this.year = year;
	}

	// Class methods
	/**
	 * Returns the date of the day following that date.
	 *
	 */
	public Date nextDate() {
		int nextYear = year, nextMonth = month, nextDay = day + 1;
		if (isEndOfMonth()) {
			nextDay = 1;
			if (month == 12) {
				nextYear++;
				nextMonth = 1;
			} else {
				nextMonth++;
			}
		}
		return new Date(nextYear, nextMonth, nextDay);
	}

	/**
	 *
	 * Check if the date is a end of a month.
	 */
	private boolean isEndOfMonth() {
		boolean leap = isLeapYear();
		if (day == 31 || (day == 30 && isThirtyDayMonth()) ||
				(isFebruary() && ((day == 29 && leap) || (day == 28 && !leap))))
			return true;
		else return false;
	}


	/**
	 * returns true if month is February.
	 */
	private boolean isFebruary() {
		return this.month == 2;
	}

	/**
	 * returns true if month has 30 days.
	 */
	private boolean isThirtyDayMonth() {
		if (this.month == 4 || this.month == 6 || this.month == 9 || this.month == 11)
			return true;
		else return false;
	}

	/**
	 * returns true if year is leap.
	 * A leap year is divisible by 4 unless it is a century year. In that case, it must be divisible by 400.
	 */
	public boolean isLeapYear() {
		if (year % 100 == 0) {
			return year % 400 == 0;
		}
		return year % 4 == 0;
	}

	/**
	 * Returns the name of month
	 */
	private String monthName() {
		return monthNames[month-1];
	}

	public String toString() {
		return year + "/" + monthName() + "/" + day;
	}

	public boolean equals(Object obj) {
		if (! (obj instanceof Date)) return false;
		Date od = (Date)obj;
		return year == od.getYear() && month == od.getMonth()  && day == od.getDay();
	}

}
