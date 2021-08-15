/**
* The RequestQueue class extends the ArrayList class and stores a list of
* Request objects
*
* @author MacGregor Winegard
*	email: macgregor.winegard@stonybrook.edu
* 	Stony Brook ID: 114152787
*
* @version 1 build 1 July 26 2020
**/

//Note: I know this compiles "unchecked" but it runs so I am not worried about it
// the reason it is compiling unchecked is somewhere in dequeue, and I cannot figure out why, 
// but again it works so I'm not worried about it.
// If you have any ideas feel free to put it on the notes of the grading sheet
// Also any feedback about my coding in general, just like how to generally improve are 
// always appreciated 

import java.util.ArrayList;

public class RequestQueue extends ArrayList
{
	private ArrayList<Request> requestList = new ArrayList();
	private int front;
	private int rear;
	
	//invariants
	// requestList is the list of requests
	// front is the number of the front of the queue
	// rear is the back of the queue
	
	
	/**
	* Returns an instance of a RequestQueue
	**/
	public RequestQueue()
	{
		this.front = -1;
		this.rear = -1;
		this.requestList = requestList;
	}
	
	
	/**
	* @returns
	*	whether or not the list is empty
	**/
	public boolean isEmpty()
	{
		return (this.front == -1);
	}
	
	/**
	*Adds a request to the queue
	*
	* @param inReq
	*	the Request object that is being added to the queues
	**/
	public void enqueue(Request inReq)
	{
		if (this.front == -1)
		{ // if there is nothing in the queue
			this.front = 0;
			this.rear = 0;
			this.requestList.add(inReq);
		} else { // else add to the back
			this.rear++;
			this.requestList.add(inReq);	
		}
	}
	
	/**
	*Removes the front request in the queue
	*
	* @returns
	*	the Request at the front of the queue
	**/
	
	public Request dequeue()
	{
		Request answer = null;
		if (this.front == -1)
		{ // no one in queue
			System.out.println("There is no one to dequeue!");
		} else if (this.front == this.rear) { //we're at the end of the list
			answer = this.requestList.get(this.front);
			this.front = -1;
			this.rear = -1;
		} else {
			answer = this.requestList.get(this.front);
			this.front++;
		}
		return answer;
	}
	
	/**
	* Returns the size of the queue
	*
	* @returns 
	*	the size of the queue
	**/
	public int size()
	{
		return (this.front - this.rear);
	}
	
	
}
