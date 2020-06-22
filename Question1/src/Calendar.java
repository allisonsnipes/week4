
/*
 * Allison Snipes
 * Course 605.201.81 Summer 2020
 * Module 4 Question 1
 * 
 * Application Requirements:
 * Write a program that prompts the user to enter a month (1-12) and a year (e.g., 2012),
 * and then displays a calendar for that month and year as illustrated like the mock-up given. 
 * Code for the getStartDay() method can be downloaded from the course website. You must write 
 * the code for the remaining methods. Be sure to clearly document your code and your methods.
*/
import java.time.Month;
import java.util.Scanner;

public class Calendar {

	/**
	 * In this main block of code, I am going to initialize my global variables and set up the 
	 * control flow of my program. Here is where the bulk of the application logic will reside 
	 * in my code. To get started reference the office hour notes and earlier code written if 
	 * I hit a road-block.
	 */
	public static void main(String[] args) {

		int year, month, day, dayNum = 0;
		String displayMonth; 
		
		boolean leapYear = false;

		StartMsg();
		Scanner input = new Scanner(System.in);

		// prompt user to enter month
		System.out.println("Enter a month: \n");
		month = input.nextInt();

		// prompt user to enter year
		System.out.println("Enter a year: \n");
		year = input.nextInt();

		// print calendar for the MONTH of the YEAR
		printMonthCalendar(month, year);

	}

	/**
	 * This method will displays a calendar similar to the mock up given, however
	 * it will show the specific month and year to the user.
	 * 
	 * 1. startDay: grabs the first day for the start of the month (method is already given)
	 * 2. numOfDaysInMonth: will grab the number of days in the month (take 2 parameters)
	 * 3. printMonthHeader: grabs the the headers
	 * 4. printMonthBody: grabs the body layout
	 */
	public static void printMonthCalendar(int month, int year) {
		int day = 1;

		int startDay = getStartDay(month, day, year);

		int numOfDaysInMonth = getNumDaysInMonth(month, year);

		printMonthHeader(month, year);

		printMonthBody(startDay, numOfDaysInMonth);

	}

	/**
	 * Returns the number of days in a specified month and year. Leap years are accounted for. 
	 */
	public static int getNumDaysInMonth(int month, int year) {
		int days = 0;
		
		if (month == 2) {
			days = (year % 4 == 0) ? 29 : 28;
			
		} else if ((month == 1) || (month == 3) || (month == 5) || (month == 7) || (month == 8) || (month == 10) || (month == 12)) {
			days = 31;
			
		} else if ((month == 4) || (month == 6) || (month == 9) || (month == 11)) {
			days = 30;
			
		} else {
			System.out.println("An unknown error has occured. Please try again.");
		}

		return days;
	}

	/**
	 * Displays the header information similar to the mock-up given. Try and use the escape keys to
	 * space the calendar columns evenly.
	 */
	public static void printMonthHeader(int month, int year) {
		System.out.println("\t" + getMonthName(month) + "    " + year);
		System.out.println("---------------------------------");
		System.out.println("Sun" + " " + "Mon" + " " + "Tue" + " " + "Wed" + " " + "Thu" + " " + "Fri" + " " + "Sat");
	}

	/**
	 * Displays the days in the calendar associated with the corresponding days of the week (similar to 
	 * the mock-up given). Need to gather startDay and getNumDaysInMonth. I will need to use a for loop of
	 * some kind to set up the calendar body and account for spacing as above. Possibly will need to account
	 * for spacing based on when the month starts, and the digit of the day.
	 * Struggled ask about this part.
	 */
	public static void printMonthBody(int month, int year) {
		int day = 0;
		
		int startDay = getStartDay(month, day, year);
		
		int numDays = getNumDaysInMonth(month, year);
		
		// makes a new space when the month starts when the startDay is 0.
		for (int i = 0; i < startDay; i++ ) {
			System.out.print("   ");
		}
		
		// need to account for spacing based on the the digit of the day start at 1.
		for ( int i = 1; i <= numDays; i++) {
			if (i < 10) {
				System.out.print("   " + i);
				
			} else {
				System.out.print("  " + i);
	
			}
			//print a whole new line once its out of the days of the week
			if ((i + startDay) % 7 == 0) {
				System.out.println();
			}
			System.out.println();
		}
	}

	/**
	 * Returns the name of the month for a specified month number. Use switchcase to account for the 
	 * month that is typed in. Use a return statement since the header method will need this information.
	 */
	public static String getMonthName(int month) {
		String displayMonth = null;
		
		switch (month) {
			case 1:
				displayMonth = "January";
				break;
				
			case 2:
				displayMonth = "February";
				break;
				
			case 3:
				displayMonth = "March";
				break;
				
			case 4:
				displayMonth = "April";
				break;
				
			case 5:
				displayMonth = "May";
				break;
				
			case 6:
				displayMonth = "June";
				break;
				
			case 7:
				displayMonth = "July";
				break;
				
			case 8:
				displayMonth = "August";
				break;
				
			case 9:
				displayMonth = "September";
				break;
				
			case 10:
				displayMonth = "October";
				break;
				
			case 11:
				displayMonth = "November";
				break;
				
			case 12:
				displayMonth = "December";
				break;
				
			default:
				System.out.println("An unknown error has occured, please try again.");
		}
		
		return displayMonth;
	}

	/**
	 * Returns true if the specified year is a leap year, and returns false otherwise. Make sure
	 * to ask about this part.
	 */
	public static boolean isLeapYear(int year) {
		return ((year % 400 == 0) || (year % 100 == 0) || (year % 4 == 0));
	}

	/**
	 * The method getStartDay() implements Zeller's Algorithm for determining the day of the week the 
	 * first day of a month is. The method adjusts Zeller's numbering scheme for day of week 
	 * ( 0=Saturday, ..., 6=Friday ) to conform to a day of week number that corresponds to 
	 * ISO conventions (i.e., 1=Monday, ..., 7=Sunday)
	 * 
	 * Pre-Conditions: The month value, m, is 1-12 The day value, d, is 1-31, or
	 * 1-28, 1-29 for February. The year value, y, is the full year (e.g., 2012)
	 * 
	 * Post-Conditions: A value of 1-7 is returned, representing the first day of
	 * the month 1 = Monday, ..., 7 = Sunday
	 */

	public static int getStartDay(int month, int day, int year) {
		// Adjust month number & year to fit Zeller's numbering system
		if (month < 3) {
			month = month + 12;
			year = year - 1;
		}

		int k = year % 100; // Calculate year within century
		int j = year / 100; // Calculate century term
		int h = 0; // Day number of first day in month 'm'

		h = (day + (13 * (month + 1) / 5) + k + (k / 4) + (j / 4) + (5 * j)) % 7;

		// Convert Zeller's value to ISO value (1 = Mon, ... , 7 = Sun )
		int dayNum = ((h + 5) % 7) + 1;

		return dayNum;
	}

	/**
	 * This will display my welcome message to my users. This should be the first
	 * thing that the user should see when they run the application.
	 */
	public static void StartMsg() {
		System.out.println("\n");
		System.out.println("+----------------------------------------------------+");
		System.out.println("|                     Hello User!                     |");
		System.out.println("|   Please start by entering a number either 1 - 12   |");
		System.out.println("|    to display a month. Next, enter a four number    |");
		System.out.println("|        year (i.e. 2014). You must always make       |");
		System.out.println("|     sure you are typing in a valid selection.       |");
		System.out.println("|             Are you ready? Let's begin!             |");
		System.out.println("+----------------------------------------------------+");
		System.out.println("\n");
	}
}
