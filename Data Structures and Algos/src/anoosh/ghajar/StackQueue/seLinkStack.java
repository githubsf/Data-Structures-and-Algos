package anoosh.ghajar.StackQueue;

import anoosh.ghajar.LinkList.doubleLink;
import anoosh.ghajar.LinkList.singleEndedLinkedList;

public class seLinkStack {
public singleEndedLinkedList LL;  //composition ; used for delegation to the implementation class LinkedList

	
	//constructor
	public seLinkStack(singleEndedLinkedList ll){LL=ll;}
	
	public doubleLink pop(){return LL.deleteFirst();}     //can be used to simulate both Stacks and Queue, since it simulates First Out
	public void push(Object o ){ LL.insertFirst(o);} // simulates stack since it uses insertFirst--->Last in will be at First position
	//public void qpush(Object o ){ LL.insertLast(o);} // simulates Q since it uses insertLast--->First in will be at First position
	public void displayStack(){LL.displaySELinkedList();}
	
	
	public static void main(String[] args)
	{
		//lets test our ADT queue which is implemented by a Double Ended linked list
		singleEndedLinkedList ll = new singleEndedLinkedList(); //implementing Linked list
		seLinkStack s = new seLinkStack(ll);
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
		
	}//end of main
	
	public  static void sopln(Object s){System.out.println(s);}
	public static void  sop(Object s){System.out.print(s);}

}
