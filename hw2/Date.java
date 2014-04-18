/* Date.java */

import java.io.*;





class Date {

  /* Put your private data fields here. */
   private int month;
   private int day;
   private int year;
  /** Constructs a date with the given month, day and year.   If the date is
 *    *  not valid, the entire program will halt with an error message.
 *       *  @param month is a month, numbered in the range 1...12.
 *          *  @param day is between 1 and the number of days in the given month.
 *             *  @param year is the year in question, with no digits omitted.
 *                */
  public Date(int month, int day, int year) {
	this.month = month;
	this.day = day;
	this.year = year;
	
  }

  /** Constructs a Date object corresponding to the given string.
 *    *  @param s should be a string of the form "month/day/year" where month must
 *       *  be one or two digits, day must be one or two digits, and year must be
 *          *  between 1 and 4 digits.  If s does not match these requirements or is not
 *             *  a valid date, the program halts with an error message.
 *                */
  public Date(String s) {

	String date = s;
	String[] splitDate = date.split("/");
	String testday = splitDate[1];
	String testmon = splitDate[0];
	String testyear = splitDate[2];
	
	if(testday.length() > 2 || testday.length() < 1) return;
	if(testmon.length() > 2 || testmon.length() < 1) return;
	if(testyear.length() > 4 || testyear.length() < 1) return;

	this.month = Integer.parseInt(testmon);
	this.day = Integer.parseInt(testday);
	this.year = Integer.parseInt(testyear);

  }

  /** Checks whether the given year is a leap year.
 *    *  @return true if and only if the input year is a leap year.
 *       */
  public static boolean isLeapYear(int year) {
	if(year<=0) return false;
	if((year % 100) == 0)
		if((year % 400) != 0)  return false;
	if((year % 4) == 0) return true;
	else return false;
  }

  /** Returns the number of days in a given month.
 *    *  @param month is a month, numbered in the range 1...12.
 *       *  @param year is the year in question, with no digits omitted.
 *          *  @return the number of days in the given month.
 *             */
  public static int daysInMonth(int month, int year) {
    if(month<=0 || year<=0) return 0;
    if(month == 2 && isLeapYear(year) == true) return 29;                           // replace this line with your solution
    
    switch(month){
	case 1:
	case 3:
	case 5:
	case 7:
	case 8:
	case 10:
	case 12: return 31;
	case 2: return 28;
	case 4:
	case 6:
	case 9:
	case 11: return 30;
	default:
		return 0;
    }
	
  }

  /** Checks whether the given date is valid.
 *    *  @return true if and only if month/day/year constitute a valid date.
 *       *
 *          *  Years prior to A.D. 1 are NOT valid.
 *             */
  public static boolean isValidDate(int month, int day, int year) {
     if(month<=0 || year<=0) return false;
     if(day > daysInMonth(month,year)) return false;
     else	return true;                        // replace this line with your solution
  }

  /** Returns a string representation of this date in the form month/day/year.
 *    *  The month, day, and year are expressed in full as integers; for example,
 *       *  12/7/2006 or 3/21/407.
 *          *  @return a String representation of this date.
 *             */
  public String toString() {

    String datestring = ""+this.month + "/" + this.day + "/" + this.year;
    return datestring;
 //   return "stuff";                     // replace this line with your solution
  }

  /** Determines whether this Date is before the Date d.
 *    *  @return true if and only if this Date is before d. 
 *       */
  public boolean isBefore(Date d) {
    if(this.year < d.year)   return true;                      // replace this line with your solution
    if(this.month < d.month && this.year == d.year) return true;
    if(this.day < d.day && this.year == d.year && this.month == d.month) return true;
    else return false;
  }

  /** Determines whether this Date is after the Date d.
 *    *  @return true if and only if this Date is after d. 
 *       */
  public boolean isAfter(Date d) {
    
    if(this.year == d.year && this.month == d.month && this.day == d.day) return false;
    else {return (!isBefore(d));}
 }

  /** Returns the number of this Date in the year.
 *    *  @return a number n in the range 1...366, inclusive, such that this Date
 *       *  is the nth day of its year.  (366 is used only for December 31 in a leap
 *          *  year.)
 *             */
  public int dayInYear() {
    int numforFeb = 28;
    if(isLeapYear(this.year)) numforFeb = 29;
   
    switch(this.month - 1){
	case 0: return this.day;
	case 1: return (31 + this.day);
	case 2: return (numforFeb + 31 + this.day);
	case 3: return (numforFeb + 62 + this.day);
	case 4: return (numforFeb + 92 + this.day);
	case 5: return (numforFeb + 123 + this.day);
	case 6: return (numforFeb + 153 + this.day);
	case 7: return (numforFeb + 184 + this.day);
	case 8: return (numforFeb + 215 + this.day);
	case 9: return (numforFeb + 245 + this.day);
	case 10: return (numforFeb + 276 + this.day);
	case 11: return (numforFeb + 306 + this.day);
	default: return 0;
	}
                           // replace this line with your solution
  }

  /** Determines the difference in days between d and this Date.  For example,
 *    *  if this Date is 12/15/2012 and d is 12/14/2012, the difference is 1.
 *       *  If this Date occurs before d, the result is negative.
 *          *  @return the difference in days between d and this date.
 *             */
  public int difference(Date d) {
    int diff = 0;
    if(this.year == d.year){ return (this.dayInYear() - d.dayInYear());}
    else{
	int largeyear = this.year;
	int smallyear = d.year;
	int tempnum = 0;
	Date largedate = this;
	Date smalldate = d;
	if(this.year < d.year)
	 {
		largedate = d;
		smalldate = this;
  		largeyear = d.year;
		smallyear = this.year;
	}

	for(int i = smallyear; i < largeyear; i++)
	{
		if(isLeapYear(i)) tempnum += 366;
		else tempnum += 365;
	}
	tempnum = tempnum - smalldate.dayInYear();
	tempnum += largedate.dayInYear();

	if(smalldate == d) return tempnum;
	else return (-tempnum);
	}                          // replace this line with your solution
  }

  public static void main(String[] argv) {
    System.out.println("\nTesting constructors.");
    Date d1 = new Date(1, 1, 1);
    System.out.println("Date should be 1/1/1: " + d1);
    d1 = new Date("2/4/2");
    System.out.println("Date should be 2/4/2: " + d1);
    d1 = new Date("2/29/2000");
    System.out.println("Date should be 2/29/2000: " + d1);
    d1 = new Date("2/29/1904");
    System.out.println("Date should be 2/29/1904: " + d1);

    d1 = new Date(12, 31, 1975);
    System.out.println("Date should be 12/31/1975: " + d1);
    Date d2 = new Date("1/1/1976");
    System.out.println("Date should be 1/1/1976: " + d2);
    Date d3 = new Date("1/2/1976");
    System.out.println("Date should be 1/2/1976: " + d3);

    Date d4 = new Date("2/27/1977");
    Date d5 = new Date("8/31/2110");

    System.out.println("Date 4's month has how many days: ");
    System.out.println(daysInMonth(d4.month,d4.year));
    /* I recommend you write code to test the isLeapYear function! */
    System.out.println("is valid?");
    System.out.println(isValidDate(d3.month,d3.day,d3.year));

    System.out.println("Is this a leap year?");
    System.out.println(isLeapYear(d5.year));

    System.out.println("\nTesting before and after.");
    System.out.println(d2 + " after " + d2 + " should be true: " + 
                       d2.isAfter(d1));
    System.out.println(d3 + " after " + d2 + " should be true: " + 
                       d3.isAfter(d2));
    System.out.println(d1 + " after " + d1 + " should be false: " + 
                       d1.isAfter(d1));
    System.out.println(d1 + " after " + d2 + " should be false: " + 
                       d1.isAfter(d2));
    System.out.println(d2 + " after " + d3 + " should be false: " + 
                       d2.isAfter(d3));

    System.out.println(d1 + " before " + d2 + " should be true: " + 
                       d1.isBefore(d2));
    System.out.println(d2 + " before " + d3 + " should be true: " + 
                       d2.isBefore(d3));
    System.out.println(d1 + " before " + d1 + " should be false: " + 
                       d1.isBefore(d1));
    System.out.println(d2 + " before " + d1 + " should be false: " + 
                       d2.isBefore(d1));
    System.out.println(d3 + " before " + d2 + " should be false: " + 
                       d3.isBefore(d2));

    System.out.println("\nTesting difference.");
    System.out.println(d1 + " - " + d1  + " should be 0: " + 
                       d1.difference(d1));
    System.out.println(d2 + " - " + d1  + " should be 1: " + 
                       d2.difference(d1));
    System.out.println(d3 + " - " + d1  + " should be 2: " + 
                       d3.difference(d1));
    System.out.println(d3 + " - " + d4  + " should be -422: " + 
                       d3.difference(d4));
    System.out.println(d5 + " - " + d4  + " should be 48762: " + 
                       d5.difference(d4));
  }
}
