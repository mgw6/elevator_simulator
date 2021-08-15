/**
* The Elevator class implements an elevator object that contains a floor
* the elevaotr is on, the state the elevator is in, and the request object that is in it
*
* @author MacGregor Winegard
* 	email: macgregor.winegard@stonybrook.edu
*	Stony Brook ID: 114152787
*
* @version 1 build 1 July 27 2020
**/
public class Elevator
{
	private int currentFloor;
	private int elevatorState;
	private Request request;
	
	//invariants:
	//currentFloor is the floor the elevator is on
	// elevatorState is the state the elevator is in (see below)
	// request is the current request in the elevator
	
	/*
		Alright, so if I am understanding this correctly (and I very well may not be) I just need to say what 
		my values are for the three states. So they are as follows:
		0 - IDLE
		1 - TO_SOURCE
		2 - TO_DESTINATION
	*/
	
	/**
	* the Elevator constructor returns an instance of an elevator in the initial state of IDLE, 
	* at the first floor with no request
	**/
	public Elevator()
	{
		this.currentFloor = 1;
		this.elevatorState = 0;
		this.request = null;
	}
	
	/**
	* returns the floor the elevator is currently on
	*
	* @returns the currentFloor of the elevator
	**/
	public int getCurrentFloor()
	{
		return this.currentFloor;
	}
	
	/**
	* Sets the current floor to the desired floor
	*
	* @param
	* 	the desired floor
	**/
	public void setCurrentFloor (int inCurrent)
	{
		this.currentFloor = inCurrent;
	}
	
	
	/**
	* @returns 
	* 	the state of the elevator
	**/
	public int getElevatorState()
	{
		return this.elevatorState;
	}
	
	/**
	*sets the state of the elevator
	*
	* @param inState
	* 	the state of the elevator
	**/
	public void setElevatorState(int inState)
	{
		this.elevatorState = inState;
	}
	
	/**
	* Sets the request of the Elevator
	*
	* @param inRequest
	* 	the request being assigned to the elevator
	**/
	public void setRequest(Request inRequest)
	{
		this.request = inRequest;
	}
	
	/**
	* Gets the request object of the elevator
	*
	* @return
	*	this request
	**/
	public Request getRequest()
	{
		return this.request;
	}
	
	/**
	* This is an experimental method that may never get used
	* but the idea is have it move the elevator one step closer to wherever it needs to go
	**/
	public boolean toDestination()
	{
		boolean reachedSource = false;
		if (this.elevatorState == 0)
		{
			//System.out.println("Elevator is idle!");
		} else if (this.elevatorState == 1) { // toSource	
			if (this.request.getSource() >  this.currentFloor)
			{
				this.currentFloor++;
			} else if (this.request.getSource() < this.currentFloor) {
				this.currentFloor--;
			}
			
			if (this.request.getSource() == this.currentFloor)
			{
				reachedSource = true;
				this.elevatorState = 2;
			}
		} else if (this.elevatorState == 2) { // toDestination
			if (this.request.getDestination() >  this.currentFloor)
			{
				this.currentFloor++;
			} else if (this.request.getDestination() < this.currentFloor) {
				this.currentFloor--;
			}	
			if (this.request.getDestination() == this.currentFloor)
			{
				this.request = null;
				this.elevatorState = 0;
			}		
		} else {
			System.out.println("The state is invalid");
			System.out.println("Printed from the toDestination method");
		}
		return reachedSource;
	}	
} //end class