package anoosh.ghajar.Sort;
import java.util.Scanner;


// each element is COMPAREd to the one after it and then SWAPPEd if needed
// SEE THIS YOUTUBE VIDEO 
//http://www.youtube.com/watch?feature=endscreen&NR=1&v=7HvaCwq-Pno
// YOU NEED AS MANY PASSES AS THEY ARE ELEMENTS IN YOUR INPUT ARRAY
// AT the end of the 1st pass the largest number bubbles up to last element of array
// AT the end of the 2nd pass the 2nd largest number bubbles up to one before last element of array
// AND SO ON....If you want the Xth largest element you will see it
// at the end of the Xth pass in the array at index (length - X)
public class BubbleSort {
	
	public static void printArray(int[] a ){
		int len = a.length;
		for (int i = 0; i < len;i++){
			System.out.print(" " + a[i]);
		}
		System.out.println("");
	}
	
	public static int[] bubbleSort(int[] in ){
		/// by using only an int temp variable we do the sorting "in-place"
		// without needing another data structure/Array for keeping the sorted
		// numbers
		int len= in.length;
		int temp = -123456;
		int numberOfSwaps ;//keeps how many swaps for each PASS
		
		//outer loop is for each PASS, only one element will 
		//bubble to its right position at the end of 
		//each pass. So it must be done for all elements
		for (int pass = 1;pass <= len; pass++){
			numberOfSwaps =0;
			// The inner loop is for COMPARISON of 
			// each element to the next one, if necessary also a
			// a SWAP is done here in the inner loop
			for (int current=0; current < len - pass ; current++){
				//next if statement does the COMPARISON
				if (in[current] > in[current + 1 ])//previous is bigger than next
				// the section that handles the SWAP
				{ temp=in[current];
				  in[current]=in[current + 1];
				  in[current + 1] = temp;
				  numberOfSwaps++;
				 }
				   
			}// end of inner loop
			System.out.println("");
			System.out.println("The array at the end of the PASS = " + pass );
			System.out.println("In this PASS we had " + numberOfSwaps + " Swaps");
			printArray(in);
			//if no Swapping was done in last PASS, we are already all sorted
			// avoid going through more PASSES and COMPARISONS
			if (numberOfSwaps == 0) break;
		}// end of outer loop
		return in;
	}
	
	/*
	 * To get random #s from Min-Max inclusive use : Min + (int)(Math.random() * ((Max - Min) + 1))
	 * The Java Math library function Math.random() generates a double value in the range [0,1). Notice this range does not include the 1.

In order to get a specific range of values first, you need to multiply by the magnitude of the range of values you want covered.

Math.random() * ( Max - Min )
This returns a value in the range [0,Max-Min).

For example, if you want [5,10], you need to cover five integer values so you use

Math.random() * 5
This would return a value in the range [0,5).

Now you need to shift this range up to the range that you are targeting. You do this by adding the Min value.

Min + (Math.random() * (Max - Min))
You now will get a value in the range [Min,Max). Following our example, that means [5,10):

5 + (Math.random() * (10 - 5))
But, this is still doesn't include Max and you are getting a double value. In order to get the Max value included, you need to add 1 to your
 range parameter (Max - Min) and then truncate the decimal part by casting to an int. This is accomplished via:
(Max
Min + (int)(Math.random() * ( Max - Min) + 1))
And there you have it. A random integer value in the range [Min,Max], or per the example [5,10]:

5 + (int)(Math.random() * ((10 - 5) + 1))
	 */
	
	public static void main (String[] args){
		///////////////////////// Get the input from user
		// Get the list of numbers from user
		Scanner s = new Scanner(System.in);
		System.out.println("How many numbers would you like to sort? ");
		int n = s.nextInt();
		int Min=0, Max=1000;
		System.out.println("What is the Minimum integer in the range?  ");
		 Min = s.nextInt();
		 System.out.println("What is the Maximum integer in the range?  ");
		 Max = s.nextInt();
		// create the input array
		int[] inputArray = new int[n];
		// Get the actual numbers and load them into your array
		//System.out.println("Please provide your " + n + " numbers?");
		//Instead of asking end user, generate the #s randomly
		for (int i=0; i <n ; i++){
			//inputArray[i]=s.nextInt();
			inputArray[i]= Min + (int)(Math.random() * (( Max - Min) + 1));
		}
		//check the correct reading of user's input
		System.out.println("The input array you provided is : ");
		printArray(inputArray);
		///////////////////////// End of Get the input section
		
		////////////////////////// Now we need to run the Sort Algorithm
		int[] sortedOutput = bubbleSort(inputArray);
		
		/////////////////////////// And finally print the sorted numbers
		System.out.println("");
		System.out.println("The sorted array is : ");
		printArray(sortedOutput);
			
		
	}

}
