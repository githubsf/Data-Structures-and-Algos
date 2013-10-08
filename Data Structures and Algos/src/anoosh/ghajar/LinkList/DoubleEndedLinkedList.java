package anoosh.ghajar.LinkList;


public class DoubleEndedLinkedList {  // implementation of a double-ended linked list(has first like single-ended, but also a last)
	Link first;   // points to the first link in the linked list
	Link last;    // points to the last link in the linked list
	
	//constructor
	public DoubleEndedLinkedList() { 
		first = null; 
	    last = null;}    
	
	public boolean isEmpty() {		
		return (first == null);
	}
	
	//************ WE USE A DOUBLE ENDED LINKED LIST(2 reference vars: first, last) SO WE HAVE TWO ENDS TO INSERT INTO OUR LINKED LIST
	// {STACK}    1) insertFirst() : USING THIS METHOD CONSECUTIVELY WILL MAKE SURE THAT THE "LAST IN" IS AT THE FIRST POSITION(reverses the order)
	// {QUEUE}    2) insertLast()  : USING THIS METHOD CONSECUTIVELY WILL MAKE SURE THAT THE "FIRST IN" IS AT THE FIRST POSITION(keeps the order)
	//     SO BY ALWAYS USING THE deleteFirst() WE WILL BE ABLE TO IMPLEMENT BOTH A STACK(LIFO) AND A QUEUE(FIFO)
	
	
	
	//////  WE WILL USE INSERTFIRST() TO INSERT FOR STACK (LIFO) 
	public void insertFirst(Object o){//USE THIS TO IMPLEMENT BOTH STACK AND QUEUE USING THIS LINKED LIST
		Link newLink = new Link(o);   //make a link to contain the object/data
		
		if (isEmpty()){ 	last = newLink;		}  //special case 
		
		newLink.next = first;    // new link will point to the old first
		first = newLink;         // new link becomes our first link
		
	}

	public void insertLast(Object o) { //USE THIS TO IMPLEMENT QUEUE  SINCE the "FIRST IN" WILL BE IN THE FIRST POSITION (Queue=FIFO)
		Link newLink = new Link(o);   //make a link to contain the object/data
		
		if (isEmpty()){    first = newLink; }  //special case 
		else   			last.next=newLink; //old last will now point to newly inserted link
		
		last = newLink;
				
		
			}
	
	public Link deleteFirst(){  //USE THIS TO IMPLEMENT BOTH STACK AND QUEUE,SINCE IT SIMULATES "FIRST OUT" in LIFO(STACK) & FIFO(QUEUE)
		if (isEmpty()){System.out.println("Linked List is Empty!");		}  //special case 
		if (first.next==null){last=null;}   //special case , There was only 1 link in the linked list
		Link temp = first;    // temp is the first link ; that we wish to remove
		first= temp.next;     // the 2nd link should become the new first after we remove the 1st link
		
		return temp;
		
	}
	
	
	
	public void displayDELinkedList(){
		if (isEmpty()){System.out.println("Linked List is Empty!");		}  //special case 
		Link current = first;
		System.out.print("Data Structure Content, first(front)-->last(back): ");
		while(current != null){
			
			current.displayLink();
			current=current.next;
		} 
		System.out.println();
			
		}
		
		
		
	
	
}
