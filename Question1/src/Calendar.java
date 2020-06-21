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
public class Calendar {

	/**
	 * In this main block of code, I am going to intialize my global variables and
	 * set up the control flow of my program. Here is where the bulk of the
	 * application logic will reside in my code.
	 */
	public static void main(String[] args) {

		int year, month, day = 0;

		StartMsg();
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
		System.out.println("|                     Let's begin!                    |");
		System.out.println("+----------------------------------------------------+");
		System.out.println("\n");
	}

	/**
	 * This method will displays a calendar similiar to the mock up given, however
	 * it will show the specific month and year to the user.
	 */
	public static void 

	/**
	 * The method getStartDay() implements Zeller's Algorithm for determining the
	 * day of the week the first day of a month is. The method adjusts Zeller's
	 * numbering scheme for day of week ( 0=Saturday, ..., 6=Friday ) to conform to
	 * a day of week number that corresponds to ISO conventions (i.e., 1=Monday,
	 * ..., 7=Sunday)
	 * 
	 * Pre-Conditions: The month value, m, is 1-12 The day value, d, is 1-31, or
	 * 1-28, 1-29 for February. The year value, y, is the full year (e.g., 2012)
	 * 
	 * Post-Conditions: A value of 1-7 is returned, representing the first day of
	 * the month 1 = Monday, ..., 7 = Sunday
	 */

	public static int getStartDay(int m, int d, int y) {
		// Adjust month number & year to fit Zeller's numbering system
		if (m < 3) {
			m = m + 12;
			y = y - 1;
		}

		int k = y % 100; // Calculate year within century
		int j = y / 100; // Calculate century term
		int h = 0; // Day number of first day in month 'm'

		h = (d + (13 * (m + 1) / 5) + k + (k / 4) + (j / 4) + (5 * j)) % 7;

		// Convert Zeller's value to ISO value (1 = Mon, ... , 7 = Sun )
		int dayNum = ((h + 5) % 7) + 1;

		return dayNum;
	}
}
