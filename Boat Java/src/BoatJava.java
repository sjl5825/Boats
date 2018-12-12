/*
 * This program calculates how many boats 
 * It also calculates how much a boat costs
 * Spenser Lehman 12/6/2018
 */

import java.text.*;
import java.util.*;

public class BoatJava {

	static String iString;
	static char iBoat;
	static int cBoatQuantity = 0;
	static String oBoatQuantity;
	static int iAccessoryType; 
	static int cNumberOfSales = 0;
	static String oNumberOfSales;
	static String iString1;
	static String iString2;
	static String iString3;
	static double cBoatCost = 0;
	static String oBoatCost;
	static double cPrepCost = 0;
	static String oPrepCost;
	static char MoreRecs = 'Y';
	static Scanner myScanner;
	static NumberFormat nf;
	static double cMarkupAmount = 0;
	static String oMarkupAmount;
	static double cAccessoryCost = 0;
	static String oAccessoryCost;
	static double cTaxDummy = .06;
	static double cTaxFinal = 0;
	static String oTaxFinal;
	static double cSubTotal = 0;
	static String oSubTotal;
	static double cTotal = 0;
	static String oTotal;
	static double cGrandTotal = 0;
	static String oGrandTotal;
	static double cMarkupPercentage;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//initialization 
		init();
		
		while(MoreRecs == 'Y') {
		
			cNumberOfSales = cNumberOfSales + 1;
			
		//input
		input();
		
		//calculations
		calcs();
		
		//output
		output();
		
		System.out.println("Would you like to add any more boats?");
		MoreRecs = myScanner.next().toUpperCase().charAt(0);
		
		}
		
		//totals
		grandtotals();
		
		System.out.println("PROGRAM TERMINATED: THANK YOU SO MUCH!!");
		
		}
	
	public static void init() {
		
		//set scanner to the Console
		myScanner = new Scanner(System.in);
		//change delimiter from blank space to Enter key
		//to allow spaces in strings
		myScanner.useDelimiter(System.getProperty("line.separator"));
		
		//set formatter to use U.S. currency format
		nf = NumberFormat.getCurrencyInstance(java.util.Locale.US);
	}

	public static void input() {
		
		//Asking for the type of boat and also using a switch for the MarkupPercentage
		System.out.println("Enter the type of boat you would like: ");
		iBoat = myScanner.next().toUpperCase().charAt(0);
		switch (iBoat) {
		
		case 'B':
			cMarkupPercentage = .35;
			break;
			
		case 'P' :
			cMarkupPercentage = .25;
			break;
			
		case 'S' :
			cMarkupPercentage = .425;
			break;
		
		case 'C' :
			cMarkupPercentage = .20;
			break;
		
		default : iBoat = 'B';
			System.out.println("You Picked an Invalid single letter to pick a specific boat type. Please input a correct boat type.");
			cMarkupPercentage = .35;
		}
	
		try {
		//Asking for the pay of the boat and also double parsing it and also using a try catch for the price.
		System.out.println("How much would you like to pay for the boat?");
		iString2 = myScanner.next();
	    cBoatCost = Double.parseDouble(iString2);
		}
		
		catch 
			(Exception e) {
				System.out.println("Answer must be a decimal number. Defaulted to 0");
				cBoatCost = 0;
		}	
		//The if statement for the BoatCost to check if its bellow 2500.00 or greater than 150000.00. If it is either then BoatCost will be defaulted to 0.
		if (cBoatCost < 2500.00  || cBoatCost > 150000.00) {
			System.out.println("The cost of the boat must be between 2500.00 and 150000.00. Defaulted to 0.");
			cBoatCost = 25000.00;
		}
		
		//This is the PrepCost input. This is where i used another try catch and a if statement.
		try {
		System.out.println("Enter your desired prep cost to be.");
		iString3 = myScanner.next();
		cPrepCost = Double.parseDouble(iString3);
		}
		
		catch (Exception e) {
			System.out.println("Answer must be a decimal number. Defaulted to 0");
			cPrepCost = 0;
		}
		if (cPrepCost < 100.00 || cPrepCost > 9999.99) {
			System.out.println("The amount you have entered is less than 100.00 or greater than 9999.99. Defaulted to 5000.00.");
			cPrepCost = 5000.00;
			}
		try {
		//This is where i do the input for the Quantity
		System.out.println("How many boats would you like?");
		iString1 = myScanner.next();
	    cBoatQuantity = Integer.parseInt(iString1);
	    if (cBoatQuantity < 1 || cBoatQuantity > 25) {
	    	System.out.println("Boat Quantity must be between 1 and 25. Defaulted to 1.");
	    	cBoatQuantity = 1;
	    }
		}
		
		catch (Exception e) {
			System.out.println("The amount you have entered is invalid. Defaulted to 1");
			cBoatQuantity = 1;
		}
		
		try {
		//Asking for what type of Accessory and using a switch for the cost of the Accessory using the AccessoryCost
		System.out.println("What Accessories would you like for the boat? (1 = Electronics, 2 =Ski Package, 3 = Fishing Package");
		iString = myScanner.next();
		iAccessoryType = Integer.parseInt(iString);
		}
		
		catch (NumberFormatException e) {
			System.out.println("The Answered you have inputed was consisted of letters and special characters. Defaulted to 4 (No Accesssories)");
			iAccessoryType = 4;
			
		}
		switch (iAccessoryType) {
		
		case 1:
			cAccessoryCost = 5415.30;
			break;
		
		case 2:
			cAccessoryCost = 3980.00;
			break;
			
		case 3:
			cAccessoryCost = 345.45;
			break;
		
		case 4:
			cAccessoryCost = 0;
			break;
		}
		
	}
	
	public static void calcs() {
		
		//calculating the Mark up Amount
		cMarkupAmount = cMarkupPercentage * cBoatCost;
		//Rounding the cMarkupAmount
		cMarkupAmount = Math.round(cMarkupAmount);
		
		//calculating the SubTotal
		cSubTotal = cBoatCost + cAccessoryCost + cPrepCost + (cMarkupAmount * cBoatQuantity);
		
		//calculating the tax
		cTaxFinal = cSubTotal * cTaxDummy;
		//Rounding the Tax
		cTaxFinal = Math.round(cTaxFinal);
		
		//calculating the Total Sales
		cTotal = cTaxFinal + cSubTotal;
		
		//calculating the grand totals for a accumulation for the program termination
		cGrandTotal = cGrandTotal + cTotal;
	}
	
	
	public static void output() {
		System.out.println("Your choice of Boat: " + iBoat);
		System.out.println("Your Boat Accessory: " + iAccessoryType);
		System.out.println("Amount of Boats: " + cBoatQuantity);
		oBoatCost = nf.format(cBoatCost);
		System.out.println("Boat Cost: " + oBoatCost);
		oAccessoryCost = nf.format(cAccessoryCost);
		System.out.println("Accesorry Cost: " + oAccessoryCost);
		oPrepCost = nf.format(cPrepCost);
		System.out.println("Prep Cost: " + oPrepCost);
		oMarkupAmount = nf.format(cMarkupAmount);
		System.out.println("Mark Up Amount: " + oMarkupAmount);
		oSubTotal = nf.format(cSubTotal);
		System.out.println("SubTotal: " + oSubTotal);
		oTaxFinal = nf.format(cTaxFinal);
		System.out.println("Tax: " + oTaxFinal);
		oTotal = nf.format(cTotal);
		System.out.println("Total: " + oTotal);
		
		
	}
	
	public static void grandtotals() {
		
		oGrandTotal = nf.format(cGrandTotal);
		System.out.println("Number of Sales: " + cNumberOfSales);
		System.out.println("Grand Total: " + oGrandTotal);
		
		
	}
}
