package anoosh.ghajar.StackQueue;

import anoosh.ghajar.LinkList.Link;
import anoosh.ghajar.LinkList.DoubleEndedLinkedList;

public class StackUsingQ {//Stack ADT, implemented using a Queue ADT which is in turn implemented with a D.Ended Linked list
	LinkQueue q ;  // composition ; used for delegation to the implementation class; it would be better 
	               //if i define a Queue interface and define Queue q ;
	
	public StackUsingQ(LinkQueue queue) { q=queue;} //constructor 
	
	public Link pop(){return q.dequeue();}     //delegates to LL.deleteFirst() which can be used to simulate both Stacks and Queue, since it simulates First Out
	public void push(Object o ){q.stackenqueue( o ); } //delegates to LL.insertFirst(o); simulates stack since it 
	                                                  // uses insertFirst--->Last in will be at First position(ready for first out)
	
	public void displayStack(){q.displayQueue();}
	
	public static void main(String[] args)
	{
		//lets test our ADT Stack which is implemented by a ADT Queue which is implemented using Double Ended linked list
		LinkQueue q = new LinkQueue(new DoubleEndedLinkedList()); //implementing Linked list
		 //Stack ADT , which is implemented using a  Linked list
		StackUsingQ s = new StackUsingQ(q);
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
		
	}//end of main
	
	public  static void sopln(Object s){System.out.println(s);}
	public static void  sop(Object s){System.out.print(s);}


}
