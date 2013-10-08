package anoosh.ghajar.StackQueue;

import anoosh.ghajar.LinkList.Link;
import anoosh.ghajar.LinkList.DoubleEndedLinkedList;

public class LinkStack {// Stack ADT implemented using Linked List
	public DoubleEndedLinkedList LL;  //composition ; used for delegation to the implementation class LinkedList

	
	//constructor
	public LinkStack(DoubleEndedLinkedList ll){LL=ll;}
	
	public Link pop(){return LL.deleteFirst();}     //can be used to simulate both Stacks and Queue, since it simulates First Out
	public void push(Object o ){ LL.insertFirst(o);} // simulates stack since it uses insertFirst--->Last in will be at First position
	public void qpush(Object o ){ LL.insertLast(o);} // simulates Q since it uses insertLast--->First in will be at First position
	public void displayStack(){LL.displayDELinkedList();}
	
	
	public static void main(String[] args)
	{
		//lets test our ADT queue which is implemented by a Double Ended linked list
		DoubleEndedLinkedList ll = new DoubleEndedLinkedList(); //implementing Linked list
		LinkStack s = new LinkStack(ll);
		sopln("Now inserting 10 from the first/front end ");
		s.push(new Integer(10));
		s.displayStack();
		sopln("Now inserting 20 from the first/front end ");
		s.push(new Integer(20));
		s.displayStack();
		sopln("Now inserting 30 from the first/front end ");
		s.push(new Integer(30));
		s.displayStack();
		sopln("Now inserting 40 from the first/front end ");
		s.push(new Integer(40));
		s.displayStack();
		sopln("Now inserting 50 from the first/front end ");
		s.push(new Integer(50));
		s.displayStack();
		sopln("Now removing from the first position. FO = " + (Integer)s.pop().getObject());
		sopln("Now removing from the first position. FO = " + (Integer)s.pop().getObject());
		sopln("Now removing from the first position. FO = " + (Integer)s.pop().getObject());
		
		s.displayStack();
		sopln("Now inserting 100 from the last/back end ");
		s.qpush(new Integer(100));//inserts into back/last end of stack
		s.displayStack();
	}//end of main
	
	public  static void sopln(Object s){System.out.println(s);}
	public static void  sop(Object s){System.out.print(s);}
}
