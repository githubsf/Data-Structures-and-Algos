package anoosh.ghajar.StackQueue;

import anoosh.ghajar.LinkList.Link;
import anoosh.ghajar.LinkList.DoubleEndedLinkedList;

public class LinkQueue {// Queue ADT implemented using Linked List
	public DoubleEndedLinkedList LL;  //composition ; used for delegation to the implementation class LinkedList(Double Ended Linked list;has first,last)

	
	//constructor
	public LinkQueue(DoubleEndedLinkedList ll){LL=ll;}
	
	public Link dequeue(){return LL.deleteFirst();}     //can be used to simulate both Stacks and Queue, since it simulates First Out
	public void stackenqueue(Object o ){ LL.insertFirst(o);} // simulates stack since it uses insertFirst--->Last in will be at First position
	public void enqueue(Object o ){ LL.insertLast(o);} // simulates Q since it uses insertLast--->First in will be at First position
	public void displayQueue(){LL.displayDELinkedList();}
	
	
	public static void main(String[] args)
	{
		//lets test our ADT queue which is implemented by a Double Ended linked list
		DoubleEndedLinkedList ll = new DoubleEndedLinkedList(); //implementing Linked list
		LinkQueue q = new LinkQueue(ll);
		sopln("Now inserting 10 from the last/back end ");
		q.enqueue(new Integer(10));
		q.displayQueue();
		sopln("Now inserting 20 from the last/back end ");
		q.enqueue(new Integer(20));
		q.displayQueue();
		sopln("Now inserting 30 from the last/back end ");
		q.enqueue(new Integer(30));
		q.displayQueue();
		sopln("Now inserting 40 from the last/back end ");
		q.enqueue(new Integer(40));
		q.displayQueue();
		sopln("Now inserting 50 from the last/back end ");
		q.enqueue(new Integer(50));
		q.displayQueue();
		sopln("Now removing from the first position. FO = " + (Integer)q.dequeue().getObject());
		sopln("Now removing from the first position. FO = " + (Integer)q.dequeue().getObject());
		sopln("Now removing from the first position. FO = " + (Integer)q.dequeue().getObject());
		
		q.displayQueue();
		q.stackenqueue(new Integer(100));//inserts into front of queue
		q.displayQueue();
	}//end of main
	
	public  static void sopln(Object s){System.out.println(s);}
	public static void  sop(Object s){System.out.print(s);}
}
