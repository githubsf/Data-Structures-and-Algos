package anoosh.ghajar.Sort;

import java.util.Scanner;

public class SelectionSort {
	/*
	 * Use selection sort because its faster than bubble sort for random(unordered data)
	 * for smaller amount of data. Its faster because you only do one swap at the end of each pass.
	 * You save on swap time for small data compared to bubble sort. For larger amount of data
	 * the comparison overshadows the savings in swaps and selection sort becomes also(N*N) like Bubble.
	 * With Bubble the larger numbers bubble to the right end of the array. With Selection sort the 
	 * smaller numbers show up at the left end of the array.
	 * For each pass you set the min to the index equal to pass(all elements with lower index are 
	 * already in place and sorted) then in the inner loop you compare all other elements to your min
	 * and keep changing the min for each pass if any current element is smaller than your existing min.(a[pass])
	 * if you have a new min then swap a[min] and a[current]using a temp(in-place).
	 * 
	 * The outer loop(PASS): start=0; end = one before last element(a.length -2)(pass<length-1)
	 * The inner loop(current):start=outer index + 1(pass+1); end =last elem(a.length-1)(current<length)
	 * Only the last statement of the outer for loop handles swap(one swap per pass)(use a temp
	 * to swap a[min] with a[pass]
	 * The first statement in the outer loop sets the min=pass;
	 * The inner loop compares a[current] and a[min] and keeps changing the min if we have a new min, min=current;
	 * To break out of comparison you can use the numberofNewMin to stop future comparisons if no new min
	 * are found during your current pass.
	 */

	public static void printArray(int[] a ){
		int len = a.length;
		for (int i = 0; i < len;i++){
			System.out.print( a[i] + " ");
		}
		System.out.println("");
	}
	
	public static int[] SelectionSort(int[] in ){
		/// by using only an int temp variable we do the sorting "in-place"
		// without needing another data structure/Array for keeping the sorted
		// numbers
		int len= in.length;
		
		
		int numberOfNewMin ;//keeps how many new minimum for each PASS
		
		//outer loop is for each PASS, only one element will 
		//be selected to its right position at the end of 
		//each pass. So it must be done for all elements
		for (int pass = 0;pass < len-1; pass++){
			numberOfNewMin =0;//Actually rather than Swaps this tracks the number of new min found in inner loop
			int min=pass;//index of minimum
			System.out.println("Beginning of pass = " +pass + " index of min is " + min);
			// The inner loop is for COMPARISON of 
			// each element to the right of elements that were already sorted
			// during the last pass. We loop through until we find a new min
			for (int current=pass + 1; current < len  ; current++){
				System.out.println("Beginning of inner loop PASS = " +pass + " current =  " + in[current] + " min= " + in[min]);
				//next if statement does the COMPARISON
				if (in[current] < in[min])//current is smaller than min
					{System.out.println("Finding new min in PASS=" + pass+ " current(new min)" + in[current] + " oldmin= "+in[min]);
					min=current;
					numberOfNewMin++;}

			}// end of inner loop
			
			//if no Swapping was done in last PASS, we are already all sorted
			// avoid going through more PASSES and COMPARISONS
			if (numberOfNewMin == 0) break;
			
			
				// the section that handles the SWAP (ONLY ONCE PER PASS)(bubble has many per pass)
				{ System.out.println("Finally swaping in PASS=" + pass+ " in[pass]=" + in[pass] + " min= "+in[min]);
				  int temp=in[min];
				  in[min]=in[pass];
				  in[pass] = temp;
				 }
				   
				   
			
			System.out.println("");
			System.out.println("The array at the end of the PASS = " + pass );
			System.out.println("In this PASS we had " + numberOfNewMin + " new minimum(s).");
			printArray(in);
			
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
		for (int i=0; i <n ; i++){
			inputArray[i]=s.nextInt();
		}
		//check the correct reading of user's input
		System.out.println("The input array you provided is : ");
		printArray(inputArray);
		///////////////////////// End of Get the input section
		
		////////////////////////// Now we need to run the Sort Algorithm
		int[] sortedOutput = SelectionSort(inputArray);
		
		/////////////////////////// And finally print the sorted numbers
		System.out.println("");
		System.out.println("The sorted array is : ");
		printArray(sortedOutput);
			
		
	}

}
