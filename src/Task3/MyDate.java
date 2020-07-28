/*
 * ID: 316522341
 * NAME: Dvir Tayeb
 */
package Task3;

import java.time.LocalDate;
import java.time.Period;

public class MyDate {
	private int day, month, year;
	private final static int[] DAYS_MONTHS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public MyDate() {
		day = 1;
		month = 1;
		year = 2020;
	}

	public MyDate(int day, int month, int year) {
		this.day = setDay(day);
		this.month = setMonth(month);
		this.year = setYear(year);
	}

	public int getDay() {
		return day;
	}

	public int setDay(int day) {
		while (day < 1 || day > 31) {
			if (month == 2 && (day > 28 || day < 1)) {
				day = 1;
			}
			day = 1;
		}
		return day;
	}

	public int setMonth(int month) {
		while (month < 1 || month > 12) {
			month = 1;
		}
		return month;
	}

	public int setYear(int year) {
		while (year < 2000 || year > 2020) {
			year = 2020;
		}
		return year;
	}

	public int daysCount(MyDate d) {
		LocalDate enter = LocalDate.of(year, month, day);
		LocalDate out = LocalDate.of(year, d.month, d.day);
		Period period = Period.between(enter, out);
		int diff = Math.abs(period.getDays() + period.getMonths() * DAYS_MONTHS[month - 1] + period.getYears() * 365);
		return diff;
	}

	public String toString() {
		String date = day + "/" + month + "/" + year;
		return date;
	}
}
