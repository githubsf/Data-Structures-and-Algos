package anoosh.ghajar.StackQueue;

import java.util.Arrays;
import java.util.EmptyStackException;




	public class Stack { //Array implementation
		private Object[] elements;
		private int size = 0;   // represents the number of elem , = arr.lentgth + 1
		private static final int DEFAULT_INITIAL_CAPACITY = 10;
		private static final int CAPACITY_INCREASE_FACTOR = 2;
		private static final double RESERVED_TO_USED_FACTOR = 2.1; 
		//if reserved space of array is bigger than stack.size x this factor, trim array down to stack's size
		public Stack() {
		elements = new Object[DEFAULT_INITIAL_CAPACITY];
		}
		public void push(Object e) {
		ensureCapacity();
		elements[size] = e;
		size=size + 1;
		}
		
		
		private Object peek() {
			if (isEmpty()) throw new EmptyStackException();
			return elements[size - 1];
		}
		
		public Object pop() {
		if (isEmpty())
		throw new EmptyStackException();
		
		Object o = elements[size - 1]; //store top element in o
		elements[size - 1] = null; //clear obsolete reference to avoid memory leak
		size = size - 1;
		trimToSize(); //optimize memory of underlying array for scalability
		return o; //
		}
		/**
		* Ensure space for at least one more element, roughly
		* doubling the capacity each time the array needs to grow.
		*/
		private void ensureCapacity() {
		if (elements.length == size){
		elements = Arrays.copyOf(elements, CAPACITY_INCREASE_FACTOR * size );
		sopln("\n        Underlying Array's Capacity increased by a factor of " + CAPACITY_INCREASE_FACTOR + "; New capacity = " + elements.length);
		}
		} 
	
		private boolean isEmpty(){ return (size == 0); }
		
		private void  empty() { 
			
			size=0;		
			///// When using the following loop the length of the underlying array will be preserved to 
			//// whatever it was before the call to this function
			//for (int i=0; i <=elements.length -1;i++)		     elements[i]=null;	
			
			//When using the following line the length of the underlying array will be set to the
			// the length of the underlying array will be
			elements = new Object[DEFAULT_INITIAL_CAPACITY];
		
		}
		
		private void print() {
			Object[] a = this.elements;
			
			if(!isEmpty())
			{
			for (Object o : a)   sop(o + " " );
			sopln("");
			}
			else sopln("The Stack is Empty");
		}
		//optimization code to avoid a lot of reserved space filled by nulls for array.
		// trims the capacity of array to the actual number of 
		//elements in Stack, which is equal to size of stack,
		//if the length of the array is greater than twice the size of the stack
		// This is to be used for high scalability situations or Cloud deployments
		// where memory usage needs to be optimized.
		public void trimToSize(){ 
			int total_memory_footprint = this.elements.length;
			int memory_used_by_elements = this.size;
			int reserved_space= this.elements.length - this.size;
			
			if (reserved_space >  memory_used_by_elements * RESERVED_TO_USED_FACTOR)
			{
				sopln("++++++++++++++++++ Optimizing Memory +++++++++++");
				sopln("++++++++++++++++++ Underlying Array has too much reserved space!+++++++++++");
				sopln("Underlying implementation array allocated memory space;a.k.a array's length; total_memory_footprint = " + total_memory_footprint);
				sopln("Number of elements in the Stack, stored in underlying array,a.k.a Stack's size; memory_used_by_elements = " + memory_used_by_elements);
				sopln("Number of cells, containing nulls, zeros,etc(depends on data type the array stores), reserved_space = "+reserved_space);
				sopln("The RESERVED_TO_USED_FACTOR (measures the threashold for triggering the trimming the array to stack's size) = " +RESERVED_TO_USED_FACTOR);
				sop("Before trimming the array to stack's size, Array's content is : ");
				print();
				this.elements = Arrays.copyOf(elements, size);
				sop("After trimming the array to stack's size, Array's content is : ");
				print();
				//this.elements = new Object [size];   //you will lose all content of your stack
			}
		}
			
		public static void main(String[] args){
			int max_push = 11;
			Stack s = new Stack();
			sop("Stack size is  : " + s.size + "     Implementing array's length is : "+ s.elements.length + " ");
			s.print(); //simply prints Stack is Empty
			// The next 3 lines are needed to actually see the array's content for the empty stack
			sop("Array's content: ");
			for (Object o : s.elements)   sop(o + " " );
			sopln("");
			
			for (int i=1; i <= max_push; i++) 
			{
				sop("push(" + i + ")" );
				s.push(new Integer(i)); 
			sop(" stack size = " + s.size + "      Array's content: ");
			s.print();
			
			
			}
			//sopln("S=" + s);//just prints memory address, If I rename my print() to toString() this would print the content 
			sopln("Top element="+  s.peek());
			////////////////////////////////////////////////////
			//// Depending on max_push, which pushes elements(and also the length of array), and the upper boundary
			//// of the following loop which pops elements, you will see the trimToSize getting called
			//// It works for max_push=22 and max_pop=7
			int max_pop=7;
			for (int i=0;i<=max_pop;i++)
			{			sop("Poping: " + s.pop() + " stack size = " + s.size + "      Array's content: ");
			s.print();
			}
			////////////////////////////////////////////////////
			sopln("Top element="+  s.peek());
			sop("Before Emptying the stack using the empty() method the content of the array is: ");s.print();
			sopln("Now emptying Stack");
			s.empty();
			//s.print();
			sopln("After emptying the s.size (Number of elements) = " + s.size);
			s.print();//simply prints The stack is Empty
			sop("After Emptying the stack using the empty() method the content of the array is: ");
			for (Object o : s.elements)  sop(o + " " );
			
			
			
		}
		public  static void sopln(Object s){System.out.println(s);}
		public static void  sop(Object s){System.out.print(s);}

}
