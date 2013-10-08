package anoosh.ghajar.StackQueue;

import anoosh.ghajar.LinkList.Link;
import anoosh.ghajar.LinkList.DoubleEndedLinkedList;

public class QusingStack {
public LinkStack s;  //composition ; used for delegation to the implementation class 
                     // LinkStack which is an ADT and is implemented using a LinkedList(Double Ended Linked list;has first,last)

	
	//constructor
	public QusingStack(LinkStack stack){s=stack;}
	
	public Link dequeue(){return s.pop(); }     //delegates to LL.deleteFirst(); can be used to simulate both Stacks and Queue, since it simulates First Out
	public void enqueue(Object o ){ s.qpush(o);} //delegates to LL.insertLast(o);NOT insertFirst() like regular stack would;
	                                             //simulates Q since it uses 
	                                             //insertLast()--->First in will be at First position(ready for first out)
	public void displayQueue(){s.displayStack();}      // delegates to LL.displayDELinkedList();
	

	public static void main(String[] args)
	{
		//lets test our ADT queue which is implemented by a Double Ended linked list
		LinkStack s = new LinkStack(new DoubleEndedLinkedList()); //Stack ADT , which is implemented using a  Linked list
		QusingStack q = new QusingStack(s);
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
		
	}//end of main
	
	public  static void sopln(Object s){System.out.println(s);}
	public static void  sop(Object s){System.out.print(s);}
}
