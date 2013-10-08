package anoosh.ghajar.Sort;

import java.util.Scanner;

public class insertionSort {

	public static void printArray(int[] a ){
		int len = a.length;
		for (int i = 0; i < len;i++){
			System.out.print(" " + a[i]);
		}
		System.out.println("");
	}
	
	public static int[] insertionSort(int[] in ){
		// The insertion sort uses partial sorting. At any time in the middle of the sort the elements to the
		//left of the marked item(item to be inserted) are all sorted among themselves, but still 
		// not at their final position. There are two groups: Sorted and Unsorted. Sorted cells are
		// to the left side of the array, unsorted ones to the right side.
		// During each iteration of the outer loop which starts at 0 and ends at 
		// the end of the input array, we will take the "Marked element" from the unsorted group, save it in temp,
		// then check it against all members of the already sorted group to find its insert position
		// and then we push the elements of the sorted group to the right to open a slot for insertion
		// the last statement of the outer loop is to set the element at the insertion index to 
		// to the element (saved in temp) to be inserted. The inner loop is a WHILE loop with 2 conditions
		// 1st it makes sure that the iteration index is greater than 0, IT ALSO USES &&, 2nd
		// that the insertion value of the temp is greater than the element in sorted group.
		// the index of the inner loop gets changed inside the while loop as the last statement
		// The inner loop finds the index of the insertion point when finished.
		// by using only an int temp variable we do the sorting "in-place"
		// without needing another data structure/Array for keeping the sorted
		// numbers
		int len= in.length;
		int temp = -123456;
		int numberOfShifts ;//keeps how many shift rights for each PASS
		int current=0;
		//outer loop is for each PASS, only one element will 
		//be inserted into the sorted group to its rightful position at the end of 
		//each pass. So it must be done for all elements
		//outer loop(for): represents the unsorted group
		//inner loop(while+comparison to temp+shift right): represents the partially sorted group
		for (int pass = 1;pass <len; pass++){//represents traversal through member of unsorted group
			numberOfShifts =0;
			temp = in[pass]; //save the leftmost element of unsorted group, this is to be inserted into sorted group
			// The inner WHILE loop is for COMPARISON of 
			// each element in the sorted group to the new element(temp), if necessary also a
			// a shift to the right of some of the elements in the sorted group is done 
			//here in the inner loop
			current =  pass; // this is the lowest index of unsorted group, SO ( current -1) is the
             //////////The current=pass; is only needed if we use while loop, not needed in for loop			
			//////////////////// highest index of sorted group
			// While loop represents traversal through members of partially sorted group
			// and comparison of them with the element of the unsorted group that we are trying to insert(temp)
			// loop continues until one is smaller than the value to be inserted(temp)
			/* Most implementations use while , but for loop is easier to see the boundaries of index
			while (current > 0 && in[current - 1] >= temp){//go through all sorted elements & do COMPARISON
				in[current] = in[current - 1];// shift right to open a slot
				current--; // go left, since we used while not for, we need to adjust index of loop here
			} // end of inner while loop, now current is the index of position of insertion
				*/
			//Let's make the while into a for loop, its easier to see the boundaries of the index in for
			for( current = pass;current>0;current--)//we are shifting right, so loop starts at right end
			{
				if (in[current - 1] >= temp)
					{in[current] = in[current - 1];// shift right to open a slot
					numberOfShifts++;
					}
			}
			in[current]=temp; //insert the unsorted temp member in the correct index position
				   
			
			/*System.out.println("");
			System.out.println("The array at the end of the PASS = " + pass );
			System.out.println("In this PASS we had " + numberOfShifts + " Shifts");
			printArray(in);
			*/
			//if no Swapping was done in last PASS, we are already all sorted
			// avoid going through more PASSES and COMPARISONS
			//if (numberOfShifts == 0) break;//wont work with partial sorting of insertion sort
		}// end of outer loop
		return in;
	}
	
	
	public static void main (String[] args){
		///////////////////////// Get the input from user
		// Get the list of numbers from user
		Scanner s = new Scanner(System.in);
		System.out.println("How many numbers would you like to sort? ");
		int n = s.nextInt();
		// create the input array
		int[] inputArray = new int[n];
		// Get the actual numbers and load them into your array
		System.out.println("Please provide your " + n + " numbers?");
		for (int i=0; i < n ; i++){
			inputArray[i]=s.nextInt();
		}
		//check the correct reading of user's input
		System.out.println("The input array you provided is : ");
		printArray(inputArray);
		///////////////////////// End of Get the input section
		
		////////////////////////// Now we need to run the Sort Algorithm
		int[] sortedOutput = insertionSort(inputArray);
		
		/////////////////////////// And finally print the sorted numbers
		System.out.println("");
		System.out.println("The sorted array is : ");
		printArray(sortedOutput);
			
		
	}
}
