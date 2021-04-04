/***
 * OCCCDate
 * @author William McGovern-Fagg
 *
 */

import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class OCCCDate {
	private int dayOfMonth;
	private int monthOfYear;
	private int year;
	private GregorianCalendar gc;
	private boolean dateFormat = true; //True for US, false for European
	private boolean dateStyle = true; //True for month names, false for not
	private boolean dateDayName = true; //True for day names, false for not
	
	public static final boolean FORMAT_US = true;
	public static final boolean FORMAT_EURO = false;
	public static final boolean STYLE_NAMES = true;
	public static final boolean STYLE_NUMBERS = false;
	public static final boolean SHOW_DAY_NAME = true;
	public static final boolean HIDE_DAY_NAME = false;
	
	public OCCCDate() {
		gc = new GregorianCalendar();
		dayOfMonth = gc.get(Calendar.DAY_OF_MONTH);
		monthOfYear = (gc.get(Calendar.MONTH));
		year = gc.get(Calendar.YEAR);
	}
	
	public OCCCDate(int day, int month, int year) {
		gc = new GregorianCalendar(year, month-1, day);
		dayOfMonth = gc.get(Calendar.DAY_OF_MONTH);
		monthOfYear = gc.get(Calendar.MONTH)+1;
		this.year = gc.get(Calendar.YEAR);
	}
	
	public OCCCDate(GregorianCalendar gc) {
		this.gc = gc;
		dayOfMonth = gc.get(Calendar.DAY_OF_MONTH);
		monthOfYear = gc.get(Calendar.MONTH);
		year = gc.get(Calendar.YEAR);
	}
	
	public OCCCDate(OCCCDate d) {
		dayOfMonth = d.getDayOfMonth();
		monthOfYear = d.getMonthNumber();
		year = d.getYear();
	}
	
	/***
	 * Get day of month
	 * @return day of month as number
	 */
	public int getDayOfMonth() {
		return dayOfMonth;
	}

	/***
	 * get day of week
	 * @return day of week as string
	 */
	public String getDayName() {
		int i = gc.get(Calendar.DAY_OF_WEEK);

		String[] weekdays = new DateFormatSymbols().getWeekdays();
		return weekdays[gc.get(Calendar.DAY_OF_WEEK)];
	}
	
	/***
	 * Get month number
	 * @return month as int
	 */
	public int getMonthNumber() {
		return monthOfYear;
	}
	
	/***
	 * Get month name
	 * @return month name as string
	 */
	public String getMonthName() {
		int i = monthOfYear;
		
		if(i == 1) {
			return "January";
		}
		else if(i == 2) {
			return "February";
		}
		else if(i == 3) {
			return "March";
		}
		else if(i == 4) {
			return "April";
		}
		else if(i == 5) {
			return "May";
		}
		else if(i == 6) {
			return "June";
		}
		else if(i == 7) {
			return "July";
		}
		else if(i == 8) {
			return "August";
		}
		else if(i == 9) {
			return "September";
		}
		else if(i == 10) {
			return "October";
		}
		else if(i == 11) {
			return "November";
		}
		else if(i == 12) {
			return "December";
		}
		
		return "None";
	}
	
	/***
	 * Get year
	 * @return year as int
	 */
	public int getYear() {
		return year;
	}
	
	/***
	 * True for US, false for European
	 * @param df
	 */
	public void setDateFormat(boolean df) {
		dateFormat = df;
	}
	
	/***
	 * Set style of date
	 * @param sf
	 */
	public void setStyleFormat(boolean sf) {
		dateStyle = sf;
	}

	/***
	 * Change if date is shown or not
	 * @param nf
	 */
	public void setDayName(boolean nf) {
		dateDayName = nf;
	}

	/***
	 * Get difference in years
	 * @return
	 */
	public int getDifferenceInYears() {
		GregorianCalendar gc2 = new GregorianCalendar();
		if(gc2.get(Calendar.YEAR)-year < 0) {
			return year-gc2.get(Calendar.YEAR);
		}
		else if(gc2.get(Calendar.YEAR)-year > 0) {
			return gc2.get(Calendar.YEAR)-year;
		}
		 
		return 0;
	}

	/***
	 * Get difference in years with input year
	 * @param d
	 * @return
	 */
	public int getDifferenceInYears(OCCCDate d) {
		if(d.getYear()-year < 0) {
			return year-d.getYear();
		}
		else if(d.getYear()-year > 0) {
			return d.getYear()-year;
		}
		 
		return 0;
	}

	/***
	 * Check if one date is equal to another
	 * @param dob
	 * @return
	 */
	public boolean equals(OCCCDate dob) {
		if(dayOfMonth == dob.getDayOfMonth() && monthOfYear == dob.getMonthNumber() && year == dob.getYear()) {
			return true;
		}
		return false;
	}

	/***
	 * Saves date to a string
	 */
	public String toString() {
		if(dateFormat == true) {
			if(dateStyle == true) {
				if(dateDayName == true) {
					return getMonthName()+"/"+getDayName()+" "+getDayOfMonth()+"/"+String.valueOf(year);
				}
				else {
					return getMonthName()+"/"+String.valueOf(dayOfMonth)+"/"+String.valueOf(year);
				}
			}
			else {
				if(dateDayName == true) {
					return String.valueOf(monthOfYear)+"/"+getDayName()+" "+getDayOfMonth()+"/"+String.valueOf(year);
				}
				else {
					return String.valueOf(monthOfYear)+"/"+String.valueOf(dayOfMonth)+"/"+String.valueOf(year);
				}
			}
		}
		else {
			if(dateStyle == true) {
				if(dateDayName == true) {
					return getDayName()+" "+getDayOfMonth()+"/"+getMonthName()+"/"+String.valueOf(year);
				}
				else {
					return String.valueOf(dayOfMonth)+"/"+getMonthName()+"/"+String.valueOf(year);
				}
			}
			else {
				if(dateDayName == true) {
					return getDayName()+" "+getDayOfMonth()+"/"+String.valueOf(monthOfYear)+"/"+String.valueOf(year);
				}
				else {
					return String.valueOf(dayOfMonth)+"/"+String.valueOf(monthOfYear)+"/"+String.valueOf(year);
				}
			}
		}
	}
	
}

