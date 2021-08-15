/**
* The Analyzer class implements a main method that takes inputs from the user
* and then calls the Simulator method
*
* @author MacGregor Winegard
*	email: macgregor.winegard@stonybrook.edu
* 	Stony Brook ID: 114152787
*
* @version 1 build 1 July 27 2020
**/

import java.util.Scanner;
public class Analyzer
{
	public static void main(String args[])
	{
		System.out.println("\nWelcome to this elevator simulator!");		
		double   userInProb;
		int      userInFloors;
		int      userInElevators;
		int      userInSimLength;
		
		Scanner inScanner = new Scanner (System.in);
		
		//invariants
		//userInProb is the inputted probability of a new request
		//userInFloors is the inputted number of floors
		//userInElevators is the user unputted number of elevators
		//userInSimLength is the length of the simulation the user puts in
		// then we have the scanner used to recieve all of this
		
		System.out.printf("\nPlease input the probability of a request occuring between 0 and 1 inclusive: ");
		userInProb = inScanner.nextDouble();
		while (userInProb <0 || userInProb >1)
		{
			System.out.printf("Please input a probability between 0 and 1 inclusive: ");
			userInProb = inScanner.nextDouble();
		}
			
		System.out.printf("Please input a number of floors greater than one: ");
		userInFloors = inScanner.nextInt();
		while ( userInFloors <2)
		{
			System.out.printf("Please input a number of floors GREATER THAN one: ");
			userInFloors = inScanner.nextInt();
		}			
		
		System.out.printf("Please input a positive number of elevators: ");
		userInElevators = inScanner.nextInt();
		while ( userInElevators <1)
		{
			System.out.printf("Please input a POSITIVE number of elevators: ");
			userInElevators = inScanner.nextInt();
		}	
		
		System.out.printf("Please input a positive number of time units for the simulation to occur: ");
		userInSimLength = inScanner.nextInt();
		while (userInSimLength < 1)
		{
		System.out.printf("Please input a positive number of time units for the simulation to occur: ");
		userInSimLength = inScanner.nextInt();		
		}	
		
		
		
		Simulator.Simulator(userInProb, userInFloors, userInElevators, userInSimLength);		
		System.out.println("\nThanks for riding Winegard Elevators!\n");		
	}
} // end class
