/**
* The Boolean Source class is based on the BooleanSource example from class.
* 
* @author MacGregor Winegard
* 	email: macgregor.winegard@stonybrook.edu
*	Stony Brook ID:114152787
*
* @version 1 Build 1 July 26, 2020
**/

import java.util.Random;
import java.util.Scanner;

public class BooleanSource
{
	private double probability;
	// Invariants
	// probability is the likelehood of the event happening
	
	/**
	* The BooleanSource object stores the probability of an event happening
	*
	* @param p
	* 	the likelehood of the event happening
	*
	* @throws IllegalArgumentException
	* 	If the inputted probability is not between 0 and 1 inclusive
	**/
	public BooleanSource (double p)
	{
		Scanner inP = new Scanner(System.in);
		try
		{
			if (p<0 || p>1)
			{
				throw new IllegalArgumentException();
			}
		} catch (IllegalArgumentException k) {
			while (p<0 || p>1)
			{	
				System.out.println("The probabilty you input is invalid.");
				System.out.printf("Please input a probability value between 0 and 1, inclusive: ");
				p = inP.nextDouble();
			}
		}
		this.probability = p;		
	}
	
	
	/**
	* the occurs method determines whether or not an event occurs at a given time
	*
	* @returns 
	*	a boolean of whether or not the event happened
	**/
	public boolean requestArrived()
		{
			return (Math.random() < probability);
		}

}// end class 
