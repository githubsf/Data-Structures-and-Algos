package anoosh.ghajar.Mth_To_Last_seLinkedList;

import anoosh.ghajar.Mth_To_Last_seLinkedList.SingleEndedSinglyLinkedList;
import anoosh.ghajar.Mth_To_Last_seLinkedList.SE_Link;

public class Mth_To_Last_seLinkedList {
	
	SingleEndedSinglyLinkedList list;
	
	//Constructor takes a SingleEndedSinglyLinkedList as arg
	public Mth_To_Last_seLinkedList(){this.list=null;}
	
	public  SE_Link Find(SingleEndedSinglyLinkedList l, int m){
		// First via for loop go through the list so that your current is m away from first
		// if there are not at least m elements in the list then print error
		SE_Link current, mBehind;
		current = l.first; // set the current to the beginning of the list before the loop starts
		mBehind = l.first;
		for(int i =0; i < m;i++){ 
			if(current != null) current = current.next; // only move forward, if you have not reached the end of the list
		else {System.out.println("There are less than " + m + " elements in the list.");
		     return null;}
		                     
		
		} // end of loop, now we have a distance of m between current and mBehind
		
		System.out.println("\n After the m for loop current value is : " + current.getObject().toString());
		
		// Now start the while loop and move both current and mBehind at the same pace
		while(current.next != null){//go until you hit null, meaning you reached last element
			current = current.next;
			mBehind= mBehind.next;
			
		}//end of while loop
		return mBehind;
	}// end of Find
	
	public static void main(String[] args) {
		// Create a list and populate it
		int m = 2;
		SingleEndedSinglyLinkedList list = new SingleEndedSinglyLinkedList();
		for(int i =0;i<10;i++){list.insertFirst(new Integer(i));}
		
		list.displaySESinglyLinkedList();
		
		
		Mth_To_Last_seLinkedList mtl = new Mth_To_Last_seLinkedList();
		SE_Link node=mtl.Find(list, m);
		System.out.println("For m= " + m + " The Mth to last link is "+ node.getObject().toString());
		
	}
	
	
	

}
