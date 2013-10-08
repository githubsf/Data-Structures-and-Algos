package anoosh.ghajar.Mth_To_Last_seLinkedList;

import anoosh.ghajar.Mth_To_Last_seLinkedList.SE_Link;;

public class SingleEndedSinglyLinkedList {
	SE_Link first;   // only has a head pointer no tail,SingleEnded
	int size;
	
	//empty constructor
	public SingleEndedSinglyLinkedList()
	{

		first  = null;
		size =0;
	}
	
		
	public boolean isEmpty(){return (size==0);}
	
	public int size() {return size;}
	
	public void displaySESinglyLinkedList(){
		if (isEmpty()){System.out.println("Linked List is Empty!");	return;	}  //special case 
		SE_Link current = new SE_Link(null);
		current = this.first;
		System.out.print("Data Structure Content, first(front)-->last(back): ");
		while(current != null){
			
			current.displayLink();
			current=current.next;
		} 
     }
	
//////WE WILL USE INSERTFIRST() TO INSERT FOR STACK (LIFO) 
	public void insertFirst(Object o){//USE THIS TO IMPLEMENT BOTH STACK AND QUEUE USING THIS LINKED LIST
		SE_Link newLink = new SE_Link(o);   //make a link to contain the object/data
		
		if (isEmpty()){ 	first = newLink; first.next=null;size++; System.out.println("List was Empty");		}  //special case 
		else{
		
		newLink.next = first;    // new link will point to the old first
		 
		first = newLink;         // new link becomes our first link
		System.out.println("Just inserted " + first.getObject().toString()+ " " +
				"and this new element next is " + first.next.getObject().toString());
		size++;
		System.out.println("size = " + size);
		}//end of else
	}
	public static void main(String[] args) {
		// Create a list and populate it
		SingleEndedSinglyLinkedList list = new SingleEndedSinglyLinkedList();
		for(int i =0;i<2;i++){list.insertFirst(new Integer(i));}
		//list.first.displayLink();
		list.displaySESinglyLinkedList();
		//System.exit(0);
		
	}
}
