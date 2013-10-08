package anoosh.ghajar.StackQueue;

import java.util.Stack;       // Implementation class , its push() adds to the top/first position of stack, 
                              // and is equivalent of Deque's addFirst(); Stack API does not have an equivalent to 
                              // Deque's addLast(); to simulate Q, and the Java API documentation states
// "A more complete and consistent set of LIFO stack operations is provided by the Deque interface and its implementations, 
// which should be used in preference to this class. For example:

    // Deque<Integer> stack = new ArrayDeque<Integer>();

//////////////*******************************************************************
//***************** Since the push() on the Stack class always adds in first position it will only be able to simulate LIFO(Stack)
//// and it does not provide the equivalent of addLast() that Deque interface of java collections provide to simulate the FIFO(Queue)
//// So if you are forced to only use the stack class then you will need 2 stacks one for inbox(pushing into it) and one outbox(for popping)
/*The solution involves using one of the stacks as inbox stack. 
Incoming items are pushed onto this stack. The other stack is used as an outbox. 
When items need to be dequeued from the Queue and the outbox stack is empty, all the items from the inbox stack are popped 
and pushed on to the outbox stack. From there they can be popped until the outbox stack is empty. 
If the outbox is not empty then Dequeue operation is just a simple Pop() on the outbox stack. 
*/    // ALSO NOTE THAT WE NEED TO display both stacks when dealing with displayQueue
////////////// *******************************************************************
public class QusingJavaAPIofStack {
	Stack<Object> inboxStack, outboxStack;    // we need 2 to simulate Q
	
	
	//constructor
	public QusingJavaAPIofStack() { 
		inboxStack = new Stack<Object>();
		outboxStack = new Stack<Object>();
		}
	
	
	public void enqueue(Object item)
	{ 
	  // all incoming items go on to the inboxStack
	  inboxStack.push(item);
	}

	public Object dequeue()
	{
		Object result= null;
	  //if the outbox stack has items in it just pop it from there and return
	  if(!outboxStack.empty())
	  {
	     result= outboxStack.pop();
	  }
	  else
	  {
	     // move all items from the inbox stack to the outbox stack
	     while(!inboxStack.empty())
	     {
	        outboxStack.push(inboxStack.pop());
	     }
	     if(!outboxStack.empty())
	     {
	        result= outboxStack.pop();
	     }
	  }
	  return result;
	}
	
	public void displayQueue(Stack<Object> s){
    	sop("Data Structure Content, first(front)-->last(back): ");
    	for(Object o: s)
    	{
    		    		sop( o.toString() + " ");
       	}
    	sopln("");
    }//end of displayQueue
	public  static void sopln(Object s){System.out.println(s);}
	public static void  sop(Object s){System.out.print(s);}
	public static void main(String[] args)
	{
		//lets test our ADT queue which is implemented by a java collections Deque
		
		QusingJavaAPIofStack q = new QusingJavaAPIofStack(); //implementation uses Stack class of java.util (see constructor above)
		
		sopln("Now inserting 10 into inboxStack ");
		q.enqueue(new Integer(10));
		sop("inbox stack: ");
		q.displayQueue(q.inboxStack);
		sop("outbox stack: ");
		q.displayQueue(q.outboxStack);
		sopln("Now inserting 20 into inboxStack");
		q.enqueue(new Integer(20));
		sop("inbox stack: ");
		q.displayQueue(q.inboxStack);
		sop("outbox stack: ");
		q.displayQueue(q.outboxStack);
		sopln("Now inserting 30 into inboxStack ");
		q.enqueue(new Integer(30));
		sop("inbox stack:  ");
		q.displayQueue(q.inboxStack);
		sop("outbox stack: ");
		q.displayQueue(q.outboxStack);
		sopln("Now inserting 40 into inboxStack ");
		q.enqueue(new Integer(40));
		sop("inbox stack: ");
		q.displayQueue(q.inboxStack);
		sop("outbox stack: ");
		q.displayQueue(q.outboxStack);
		sopln("Now inserting 50 into inboxStack ");
		q.enqueue(new Integer(50));
		sop("inbox stack: ");
		q.displayQueue(q.inboxStack);
		sop("outbox stack: ");
		q.displayQueue(q.outboxStack);
		sopln("Now removing from outboxStack. FO = " + (Integer)q.dequeue());
		sop("inbox stack: ");
		q.displayQueue(q.inboxStack);
		sop("outbox stack: ");
		q.displayQueue(q.outboxStack);
		sopln("Now removing from outboxStack. FO = " + (Integer)q.dequeue());
		sop("inbox stack: ");
		q.displayQueue(q.inboxStack);
		sop("outbox stack: ");
		q.displayQueue(q.outboxStack);
		sopln("Now removing from outboxStack. FO = " + (Integer)q.dequeue());
		sop("inbox stack: ");
		q.displayQueue(q.inboxStack);
		sop("outbox stack: ");
		q.displayQueue(q.outboxStack);
		sopln("Now inserting 60 into inboxStack ");
		q.enqueue(new Integer(60));
		sop("inbox stack: ");
		q.displayQueue(q.inboxStack);
		sop("outbox stack: ");
		q.displayQueue(q.outboxStack);
		
	}//end of main
}
