package anoosh.ghajar.StackQueue;

import java.util.Deque;  //interface to double ended Queue Deque
import java.util.LinkedList;  // Implementation class 
import java.util.Stack;       // Implementation class 2, its push() adds to the top/first position of stack, 
                              // and is equivalent of Deque's addFirst(); Stack API does not have an equivalent to 
                              // Deque's addLast(); to simulate Q, and the Java API documentation states
// "A more complete and consistent set of LIFO stack operations is provided by the Deque interface and its implementations, 
// which should be used in preference to this class. For example:

    // Deque<Integer> stack = new ArrayDeque<Integer>();

public class QusingJavaAPIofDeque {
	
	Deque<Object> D ;
	//constructor
	public QusingJavaAPIofDeque() { D =  new LinkedList<Object>();} //the other option for implemention of Deque is ArrayDeque
	
	public Object dequeue(){return D.removeFirst(); }
	public void enqueue(Object o ){D.addLast(o); } 
    public void displayQueue(){
    	sop("Data Structure Content, first(front)-->last(back): ");
    	for(Object o: D)
    	{
    		    		sop( o.toString() + " ");
       	}
    	sopln("");
    }//end of displayQueue
    public static void main(String[] args)
	{
		//lets test our ADT queue which is implemented by a java collections Deque
		
		QusingJavaAPIofDeque q = new QusingJavaAPIofDeque(); //implementation uses LinkedList() class of java.util (see constructor above)
		
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
		sopln("Now removing from the first position. FO = " + (Integer)q.dequeue());
		sopln("Now removing from the first position. FO = " + (Integer)q.dequeue());
		sopln("Now removing from the first position. FO = " + (Integer)q.dequeue());
		
		q.displayQueue();
		
	}//end of main
    
    public  static void sopln(Object s){System.out.println(s);}
	public static void  sop(Object s){System.out.print(s);}
}
