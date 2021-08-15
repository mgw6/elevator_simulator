/**
*The Request class implements an object that contains information on a specific request
*
* @author MacGregor Winegard
*	email: macgregor.winegard@stonybrook.edu
* 	Stony Brook ID: 114152787
*
* @version 1 Build 1 July 26, 2020
**/
import java.util.Random;

public class Request
{
	private int sourceFloor;
	private int destinationFloor;
	private int timeEntered;
	
	// invariants
	// sourceFloor is the floor that the request is initiated at
	// destinationFloor is the floor the rider wants to end up at
	// timeEntered is the time the request is placed in the queue
	// all invariants
	
	Random rand = new Random();
	
	/**
	*Returns an instance of a Request
	*
	* @param s
	*	the floor the request was initiated on, int
	*
	* @param d
	*	the floor the request wants to end at, int
	**/
	public Request(int f)
	{
		this.sourceFloor = rand.nextInt(f) + 1;
		this.destinationFloor = rand.nextInt(f) + 1;
		while(this.sourceFloor == this.destinationFloor)
		{ // It doesn't make sense for them to be the same
			this.destinationFloor = rand.nextInt(f) + 1;
		}
		this.timeEntered = -1;
	}
	
	
	/**
	* returns the sourceFloor of the Reqest
	*
	* @returns
	*	this.sourceFloor
	**/
	public int getSource()
	{
		return this.sourceFloor;
	}
	
	/**
	* sets the source floor of this Request
	*
	* @param inSource
	*	the desired Source Floor
	**/
	
	public void setSource(int inSource)
	{
		this.sourceFloor = inSource;
	}
	
	/**
	* returns the destinationFloor of this Request
	*
	* @param inDest
	* the desired destinationFloor
	**/

	public int getDestination()
	{
		return this.destinationFloor;		
	}
	
	
	/**
	* sets the destinationFloor to the desired floor
	*
	* @param inDest
	* 	the desired destination floor
	**/
	public void setDestination(int inDest)
	{
		this.destinationFloor = inDest;
	} 
	
	
	/**
	* returns the time the rider entered the request
	*
	* @returns 
	* 	this.timeEntered
	**/
	public int getTimeEntered()
	{
		return this.timeEntered;
	}
	
	/**
	* sets the desired timeEntered
	*
	* @param inTime
	*	 the desired timeEntered
	**/
	public void setTime(int inTime)
	{
		this.timeEntered = inTime;
	}
	
	
} //  end class