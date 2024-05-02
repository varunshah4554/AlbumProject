import java.util.Calendar;

/**
 * 
 * @author Varun Shah
 *
 */
public class Date implements Comparable<Date> {
	private int year;
	private int month;
	private int day;

	// get date from input
	public Date(String date) {
		String[] date1 = date.split("/");
		year = Integer.parseInt(date1[2]);
		month = Integer.parseInt(date1[0]);
		day = Integer.parseInt(date1[1]);
	}

	// create an object with today’s date (see Calendar class)
	public Date() {
		Calendar today = Calendar.getInstance();
		today.set(Calendar.HOUR_OF_DAY, 0);
		today.getTime();
	}

	// see if entered date is valid
	public boolean isValid() {
		final int THE_EIGHTYS = 1980;
		if (this.year < THE_EIGHTYS) {
			return false;
		}
		if ((this.year == Calendar.getInstance().get(Calendar.YEAR))
				&& (this.month > Calendar.getInstance().get(Calendar.MONTH) + 1)) {
			return false;
		}
		if ((this.year == Calendar.getInstance().get(Calendar.YEAR))
				&& (this.month == Calendar.getInstance().get(Calendar.MONTH) + 1)
				&& (this.day > Calendar.getInstance().get(Calendar.DATE))) {
			return false;
		}
		if (this.year > Calendar.getInstance().get(Calendar.YEAR)) {
			return false;
		}
		// checks if the year is a leapyear
		boolean leapyear = true;
		final int QUADRENNIAL = 4;
		final int CENTENNIAL = 100;
		final int QUATERCENTENNIAL = 400;

		if (this.year % QUADRENNIAL != 0) {
			leapyear = false;
		}
		if (this.year % CENTENNIAL != 0 && leapyear == true) {
			leapyear = false;
		}
		if (this.year % QUATERCENTENNIAL != 0 && leapyear == true) {
			leapyear = false;
		}
		// ensures the number of days does not exceed the max days in month
		final int JAN = 1;
		final int FEB = 2;
		final int MAR = 3;
		final int APR = 4;
		final int MAY = 5;
		final int JUN = 6;
		final int JUL = 7;
		final int AUG = 8;
		final int SEP = 9;
		final int OCT = 10;
		final int NOV = 11;
		final int DEC = 12;
		final int mindaysinmonth = 1;
		final int maxdaysin31daymonth = 31;
		final int maxdaysin30daymonth = 30;
		final int maxdaysinfebwithleapyear = 29;
		final int maxdaysinfebwithoutleapyear = 28;
		if ((month > DEC) || (month < JAN) || (day < mindaysinmonth)) {
			return false;
		}
		if (month == FEB && leapyear == false) {
			if (day > maxdaysinfebwithoutleapyear) {
				return false;
			}
		}
		if (month == FEB && leapyear == true) {
			if (day > maxdaysinfebwithleapyear) {
				return false;
			}
		}
		if (month == APR || month == JUN || month == SEP || month == NOV) {
			if (day > maxdaysin30daymonth) {
				return false;
			}
		}
		if (month == JAN || month == FEB || month == MAR || month == MAY || month == JUL || month == AUG || month == OCT
				|| month == DEC) {
			if (day > maxdaysin31daymonth) {
				return false;
			}
		}
		return true;
	}

	// compare dates
	@Override
	public int compareTo(Date date) {
		return day;
	}

	// testbed main
	public static void main(String[] args) {
		// test case #1, a date with the year before 1980 should be invalid.
		Date date = new Date("11/1/1979");
		boolean expectedResult = false;
		boolean result = date.isValid();
		System.out.print("Test case #1: ");
		if (result == expectedResult) {
			System.out.println("Pass.");
		} else {
			System.out.println("Fail.");
		}

		// test case #2, a date with an invalid month.
		expectedResult = false;
		date = new Date("13/21/1999");
		result = date.isValid();
		System.out.print("Test case #2: ");
		if (result == expectedResult) {
			System.out.println("Pass.");
		} else {
			System.out.println("Fail.");
		}

		// test case #3, a correct date
		expectedResult = true;
		date = new Date("7/23/2021");
		result = date.isValid();
		System.out.print("Test case #3: ");
		if (result == expectedResult) {
			System.out.println("Pass.");
		} else {
			System.out.println("Fail.");
		}

		// test case #4, a date with an invalid month.
		expectedResult = false;
		date = new Date("-1/2/2000");
		result = date.isValid();
		System.out.print("Test case #4: ");
		if (result == expectedResult) {
			System.out.println("Pass.");
		} else {
			System.out.println("Fail.");
		}

		// test case #5, a date with 29 days in february when not a leap year
		expectedResult = false;
		date = new Date("2/29/2021");
		result = date.isValid();
		System.out.print("Test case #5: ");
		if (result == expectedResult) {
			System.out.println("Pass.");
		} else {
			System.out.println("Fail.");
		}

		// test case #6, a month with 30 days given with an input showing 31
		expectedResult = false;
		date = new Date("4/31/2009");
		result = date.isValid();
		System.out.print("Test case #6: ");
		if (result == expectedResult) {
			System.out.println("Pass.");
		} else {
			System.out.println("Fail.");
		}

		// test case #7, a month with 31 days given with an input showing 32
		expectedResult = false;
		date = new Date("3/32/2009");
		result = date.isValid();
		System.out.print("Test case #7: ");
		if (result == expectedResult) {
			System.out.println("Pass.");
		} else {
			System.out.println("Fail.");
		}

		// test case #8, a year much earlier than 1980
		expectedResult = false;
		date = new Date("3/31/1800");
		result = date.isValid();
		System.out.print("Test case #8: ");
		if (result == expectedResult) {
			System.out.println("Pass.");
		} else {
			System.out.println("Fail.");
		}

		// test case #9, a year in the future
		expectedResult = false;
		date = new Date("10/30/2022");
		result = date.isValid();
		System.out.print("Test case #9: ");
		if (result == expectedResult) {
			System.out.println("Pass.");
		} else {
			System.out.println("Fail.");
		}

		// test case #10, a month that is in the future but current year
		expectedResult = false;
		date = new Date("11/30/2021");
		result = date.isValid();
		System.out.print("Test case #10: ");
		if (result == expectedResult) {
			System.out.println("Pass.");
		} else {
			System.out.println("Fail.");
		}

		// test case #11, a day that in the future but current year and month
		expectedResult = false;
		date = new Date("9/30/2021");
		result = date.isValid();
		System.out.print("Test case #11: ");
		if (result == expectedResult) {
			System.out.println("Pass.");
		} else {
			System.out.println("Fail.");
		}
	}
}