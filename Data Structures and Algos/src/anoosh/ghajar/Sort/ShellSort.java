package anoosh.ghajar.Sort;
import java.util.*;

public class ShellSort {

	/**
	 * @param args
	 */
	public static int nElems; // declared as a class instance to be seen by all methods
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		System.out.println("What is the size of the array of random integers?");
         nElems = s.nextInt();
        int in[] = new int[nElems];
        //Populate the array with random int numbers
        for(int i=0;i<in.length;i++)
        {in[i] = (int)(Math.random()*nElems);}
        System.out.println("The random array generated for you of size " +nElems + 
        		" is " + Arrays.toString(in));
        ShellSort(in);
        System.out.println("The sorted array  of size " +nElems + 
        		" is " + Arrays.toString(in));
	}

	public static int[] ShellSort(int[] a)
	{
		/**
		 * 1- 1st set your increment h to 1 and then use a while loop to calculate 
		 *    your starting increment depending on the input array's size using Knuth h = 3*h + 1
		 *    to increment your h from 1 to the final increment
		 * 2- In insertion sort we had 2 loops(outer and inner) in shell sort we add another
		 *    loop dealing with increment h outside the outer loop of insertion sort
		 *    so now start your most outer loop checking with h>0
		 * 3- Insertion sort's outer loop and inner loops dealt with 1, in shell sort
		 *    we substitute h for 1 in the loops and inside the logic
		 * 4- The last value of h should always be = 1, so the last pass is a regular insertion sort
		 */
		int outer, inner; //loop indexes for outer and inner
		int temp; // to save the unsorted element to be inserted into sorted group
		int h = 1; // the increment for Shell Sort always starts at 1 so we can 
		           // calculate initial increment using the knuth formula for this array size
		
		         //********** PAY ATTENTION TO while LOOP CONDITION h <= nElems/3***********
		while(h <= nElems/3) h = (3 * h) + 1;   //use Knuth's formula to find the largest
		                                        // initial increment given the size of array
		// e.g indexes at 1, 4, 13,40,121,etc
	while (h > 0 )
	{
		//Outer loop is a for loop, represents all unsorted members
		//so we start at h, going to the end of the array
		//************ h-sort the array in each pass
		for ( outer = h; outer < nElems; outer++)
		{
			//save the unsorted element at index pass
			temp = a[outer];
			inner = outer; // set the index of inner loop to index of outer loop
                            //before starting inner loop
			
			//one subpass, ex indexes 0, 4, 8,... when h=4
			while (inner > h - 1 &&
					a[inner - h] >= temp)//we are shifting right, so loop starts at right end
			{
				a[inner]= a[inner - h];
				inner = inner - h; 
								
			} //end of inner while loop to shift right
			a[inner]=temp; //insert the unsorted temp member in the correct index position
		}//end of outer for loop
		
	// before going back to the top of while(h>0) decrement h
		h = (h-1)/3;
	}//end of while
	return a;
	}//end of ShellSort()
}//end of class
