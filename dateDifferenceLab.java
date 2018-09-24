package com.partTwo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class dateDifferenceLab {

	/*
	 * Here I introduce the main() method. This triggers an instance of the JVM
	 * and begins the execution of the method dateDifferenceCalculator().
	 */
	
	public static void main (String [] args) {
		
		dateDifferenceCalculator();
		
	}
	
	/*
	 * I have written the task of my program in a separate method from the
	 * main() method, which I have defined as dateDifferenceCalculator().
	 */
	
	public static void dateDifferenceCalculator() {
		
        //I create a Scanner in order to receive user input.
		
		Scanner scnr = new Scanner(System.in);

		/* 
		 * Here I define the specific format in which I want the user to input 
		 * the requested dates. I use the imported SimpleDateFormat class to do so.
		 * I initialize the checkDateValidity variable, as it will be needed to validate the user input.
		 * I prompt the user to enter the first date.
		 */
		
		SimpleDateFormat myPreferredDateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date checkDateValidity = null;
		System.out.println("Welcome to the Date Difference Calculator"
				+ "\nExecutive Premium Edition"
				+ "\n"
				+ "\nThis tool calculates the duration between two dates."
				+ "\nPretty cool, right? Well, it's cool to this humble programmer."
				+ "\n"
				+ "\nIf your second date precedes the first chronologically, the"
				+ "\nduration between them will be represented by a negative number."
				+ "\n"
				+ "\nPlease enter your first date in the format of MM/DD/YYYY: ");
		String userInputDate1 = scnr.next();
		
		/*
		 * The following blocks validate the userInputDate1 to make sure that the
		 * formatting is consistent with the instructions provided to the user.
		 * 
		 * The try- block checks if the user input is a valid date. If not, an
		 * error message is printed and an exception is thrown.
		 * 
		 * The if-else statement then verifies that the date entered follows the correct format.
		 */
		
		try{
		    checkDateValidity = myPreferredDateFormat.parse(userInputDate1);
		} catch (ParseException e){ System.out.println("Whoops! Make sure you enter a valid date"
				+ " in the format of MM/DD/YYYY."
	    		+ "\nNo letters, special characters, dots, or dashes allowed."
	    		+ "\nPlease restart the program. ");
			System.exit(0);
		}
		 
		if (!myPreferredDateFormat.format(checkDateValidity).equals(userInputDate1)){
		    System.out.println("Whoops! Make sure you enter a valid date in the format of MM/DD/YYYY."
		    		+ "\nNo letters, special characters, dots, or dashes allowed."
		    		+ "\nPlease restart the program.");
		    System.exit(0);
		} 
		else {
		    System.out.println(userInputDate1 + " is a great choice!"
		    		+ "\n");
		}

		//Here userInputDate2 is validated in the same manner.

		System.out.println("Please enter your second date in the format of MM/DD/YYYY: ");
		String userInputDate2 = scnr.next();
		try{
		    checkDateValidity = myPreferredDateFormat.parse(userInputDate2);
		} catch (ParseException e){ System.out.println("Whoops! Make sure you enter a valid date"
				+ " in the format of MM/DD/YYYY."
	    		+ "\nNo letters, special characters, dots, or dashes allowed."
	    		+ "\nPlease restart the program. ");
			System.exit(0);
		}
		 
		if (!myPreferredDateFormat.format(checkDateValidity).equals(userInputDate2)){
		    System.out.println("Whoops! Make sure you enter a valid date in the format of MM/DD/YYYY."
		    		+ "\nNo letters, special characters, dots, or dashes allowed."
		    		+ "\nPlease restart the program.");
		    System.exit(0);
		} 
		else {
		    System.out.println(userInputDate2 + " is another good one. You really pick the best dates!"
		    		+ "\n");
		}

		//I close the scanner to avoid a resource leak, as I no longer require user input.
		
		scnr.close();
		
		/*
		 * Here I use the imported DateTimeFormatter class to parse the two dates into 2
		 * LocalDate objects. I then use the Period.between() method to find the duration
		 * between both dates. I then print the resulting difference.
		 */
		
		DateTimeFormatter differenceFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		LocalDate userInputLocalDate1 = LocalDate.parse(userInputDate1, differenceFormatter);
		LocalDate userInputLocalDate2 = LocalDate.parse(userInputDate2, differenceFormatter);
		 
		Period diff = Period.between(userInputLocalDate1, userInputLocalDate2);
		 
		System.out.printf("The duration between your dates is %d years, %d months and %d days.",
		                    diff.getYears(), diff.getMonths(), diff.getDays());                    
		System.out.println("\n\nSince you're such a skilled date picker, there's no need to bother"
                +"\nwith OKCupid or PlentyOfFish. If you're single, go out and get 'em, tiger!");
		
		System.exit(0);
		
	}
	

}
