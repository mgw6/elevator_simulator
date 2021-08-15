/**
* The Simulator class contains a single method that takes the requirements
* as inputs, carries out the simulation, and prints the results
*
* @author MacGregor Winegard
*	email: MacGregor Winegard
*	Stony Brook ID: 114152787
*
* @version 1 build 1 July 27 2020
**/

import java.util.ArrayList;
public class Simulator
{
	public static void Simulator(double inProb, int numFloors, int numElevators, int simLength)
	{
		int totalWaitTime = 0; // total of all the request wait times
		int rideCount= 0; // count of how many rides are completed
		BooleanSource probOfRequest = new BooleanSource(inProb); // initialize BooleanSource
		RequestQueue  requestQueue = new RequestQueue(); // initialize the ReqeustQueue
		
		
		// make the list containing the number of elevators
		ArrayList<Elevator> ElevatorList = new ArrayList<Elevator>();
		for (int a = 0; a< numElevators; a++)
		{
			ElevatorList.add(new Elevator());
			//System.out.println(a+1); // number of elevators initialized
		}
		
		
		// everything is setup
		// now do a for loop to go through the simLength	
		for (int time = 1; time <=simLength; time++)
		{
			//System.out.println("Time Step: " + time);
			if (probOfRequest.requestArrived())
			{ //  potentially initiates a new request
				requestQueue.enqueue(new Request(numFloors));
				//System.out.println("Request Arrived!+++++++++++++++++++++++++++++++++++++");
			}
			
			for (int b = 0; b< numElevators; b++)
			{ // does one time step on all the elevators
				//System.out.println(b + " time doing the toDestination.");
				if (ElevatorList.get(b).toDestination() == true)
				{
					//System.out.println("Reached Destination");
					totalWaitTime = totalWaitTime + (time - ElevatorList.get(b).getRequest().getTimeEntered());
					rideCount++;
				}
			}
			for (int c = 0; c< numElevators; c++)
			{
				//System.out.println("Going through elevators");
				if (ElevatorList.get(c).getElevatorState() == 0) // if the elevator is idle
				{
					//System.out.println("We got an idle elevator");	
					if (!requestQueue.isEmpty()) // if there are pending requests
					{	
						ElevatorList.get(c).setElevatorState(1);  // change the state 
						//System.out.println("Dequing");
						ElevatorList.get(c).setRequest(requestQueue.dequeue());   // give it a reqeust	
						ElevatorList.get(c).getRequest().setTime(time);
					}
				}					
			}
			//System.out.println("End time step " + time);
		} // end the simLength for loop
	
		System.out.println("\nTotal wait time: " + totalWaitTime + " unis of time.");
		System.out.println("Total requests completed: "+ rideCount);
		double averageWait = ((double) totalWaitTime )/ rideCount; // https://stackoverflow.com/questions/3144610/integer-division-how-do-you-produce-a-double
		System.out.printf("Average wait time: %.2f time units.\n", averageWait);
	} // end simulator

} // end class
