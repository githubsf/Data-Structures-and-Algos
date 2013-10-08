package anoosh.ghajar.LinkList;


public class singleEndedLinkedList {//only has a first(head) pointer
	doubleLink first;   // points to the first link in the linked list

	//constructor
	public singleEndedLinkedList() { 
		first = null; 
	    }    
	
	public boolean isEmpty() {		
		return (first == null);
	}
//////WE WILL USE INSERTFIRST() TO INSERT FOR STACK (LIFO) 
	public void insertFirst(Object o){//USE THIS TO IMPLEMENT BOTH STACK AND QUEUE USING THIS LINKED LIST
		doubleLink newLink = new doubleLink(o);   //make a link to contain the object/data
		
		if (isEmpty()){ 	first = newLink;		}  //special case 
		
		first.previous = newLink;
		newLink.next = first;    // new link will point to the old first
		newLink.previous = null; 
		first = newLink;         // new link becomes our first link
		
	}
	
	public doubleLink deleteFirst(){  //USE THIS TO IMPLEMENT BOTH STACK AND QUEUE,SINCE IT SIMULATES "FIRST OUT" in LIFO(STACK) & FIFO(QUEUE)
		if (isEmpty()){System.out.println("Linked List is Empty!");		}  //special case 
		//if (first.next==null){=null;}   //special case , There was only 1 link in the linked list
		doubleLink temp = first;    // temp is the first link ; that we wish to remove
		temp.next.previous = null;   //the previous of the 2nd link is now pointing to null, to become first
		first= temp.next;     // the 2nd link should become the new first after we remove the 1st link
		
		return temp;
		
	}
	
	
	
	public void displaySELinkedList(){
		if (isEmpty()){System.out.println("Linked List is Empty!");		}  //special case 
		doubleLink current = first;
		System.out.print("Data Structure Content, first(front)-->last(back): ");
		while(current != null){
			
			current.displayLink();
			current=current.next;
		} 
     }
}
