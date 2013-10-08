package anoosh.ghajar.Sort;
import java.util.*;

public class quickSort {
	
	
public static int[] A;

	/**
	 * quickSort is using Partitioning where a pivot parts the 
	 * array into two subarrays the left one having values less 
	 * and the right one having higher values than pivot. It does this 
	 * recursively. 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("Please input the size of the array to be sorted?");
		int size = s.nextInt();
		 A = new int[size];
		for(int i =0;i<size; i++) A[i]= (int)(Math.random() * size);
		System.out.println("A=" + Arrays.toString(A));
		/*      ****** TO TEST PARTITION()
		int pivot = size/2;// chosen value hard-coded by programmer, average
		partitionIt(0,size - 1,pivot);
		System.out.println("partitioned array using a pivot of " + pivot + " is A= " + Arrays.toString(A));
		*/
		recQuickSort(0,size-1);
		System.out.println("After sorting...  A = " + Arrays.toString(A));

	}
	
	public static void recQuickSort(int left, int right) 
	{
		//base case
		if( right - left <= 0 ) return; // base case of size 1 subarray, already considered sorted
		else
		{
			/*
			 * THIS IS WHERE YOU CHOOSE YOUR PIVOT IN ORDER TO PARTITION.
			 * 1) RIGHTMOST ELEMENT // not good O(N*N) when data is already sorted, or reverse sorted
			 * 2) MEDIAN OF 1st,MIDDLE, RIGHTMOST ELEMENTS. MEDIUM OF 3.(Better)
			 */
			
			// 1) RIGHTMOST, becomes O(N*N) for sorted or reverse sorted data 
			//int pivot = A[right]; //arbitrarily choose your pivot to be the value of rightmost cell 
			
			// 2) medianof3: much better, O(N*logN) always and also allows us to eliminate
			// the checks for array index out of bound since during the median calculation we 
			// also sort the 1st,last,and median cells
			int pivot = medianOf3(left,right);
			System.out.println("INSIDE QUICKSORT===> Pivot returned from medianOf3 is = " + pivot);
			
			int partition = partitionIt(left,right, pivot);//partition the range, you need a pivot value
			System.out.println("partitioned array using a pivot of " + pivot + " is A= " + Arrays.toString(A));
			recQuickSort(left,partition -1); // sort the left sub array
			recQuickSort(partition + 1,right);//sort the right sub array
		}//end of else
		
	}//end of QuickSort

	public static int medianOf3(int left, int right)
	{
		int center = (left + right)/2; 
		System.out.println("INSIDE medianOf3===> left = " + left + " right = "+ right + " center="
				+center);
		if (A[left] > A[center])  swap(left,center); // sort left & center
		if (A[left] > A[right])   swap(left,right); // sort left & center
		if (A[center] > A[right]) swap(center,right); // sort left & center, Now center holds the pivot/median
		swap(center,right-1); //put pivot in position  right - 1
		return A[right-1]; //return median value
		
	}
	
	/**
	 * This algo runs in O(N). There are N+1, N+2 comparison(since the pointers
	 * must cross each other before we stop the infinite loop, and N/2 Swaps on average depending 
	 * on the distribution of data.
	 * @param left
	 * @param right
	 * @param pivot
	 * @return the index number of the partition: the left element in the right(larger keys) subarray.
	 */
	public static int partitionIt(int left, int right, int pivot)
	//************ WHEN WE START THIS METHOD, WE HAVE ALREADY BEEN THROUGH MEDIAN OF 3
	//             SO WE HAVE SORTED THE 1st, last, center elements and we have no need to 
	//             include 1st and last in the partitioning, ALSO WE HAVE PLACED THE 
	//             MEDIAN/PIVOT IN POSITION right -1
	{      // We initialize the pointers to -1 and + 1 since they
		  // will get incremented and decremented before getting used
		  // The main reason for this is that the moving of the pointers must
		 // be done inside the inner while loops regardless of the conditions
		 // that's why we do not use leftPtr++ or rightPtr-- inside the inner
		// loop bodies because in that scenario the pointers will only get 
		// moving if the condition inside the while inner loops are met.
		int leftPtr = left ;//we are using median of 3 so the 1st and last cells are already partitioned and sorted
		int rightPtr = right - 1;// in the while loop the pointers get incr/decr b4 being used
		                     // and the 1st time the values should be left + 1, and right -1
		
		//start an infinite loop , break out of it when the pointers cross
		while(true)
		{
			// loop from the left and stop when a value is bigger than
			// pivot
			while (A[++leftPtr] < pivot  // we do not use <= here because the leftPtr would
					                       // end up at the end of the array if we do so
					                       // and we want it in the middle for using in quickSort
					//&& leftPtr < right       // do not pass array boundaries
					) 
			{
				;//do nothing
			}
			// loop from the right side and stop when a value is lower than
			// pivot
			while (A[--rightPtr] > pivot  // we do not use >= here because the leftPtr would
                    						// end up at the end of the array if we do so
                    						// and we want it in the middle for using in quickSort
					//&& rightPtr > left      // do not pass array boundaries
					)  
			{
				;//do nothing
			}
			System.out.println("INSIDE PARTITION======> leftPtr = " + leftPtr + " rightPtr = " + rightPtr);
			// At this point in the logic we have found an element in the left and
			// an element in the right that are misplaced
			// 1st check if we should get out of the outer infinite loop
			// otherwise swap these 2 misplaced elements and continue the infinite loop
			if ( leftPtr >= rightPtr) break;
			else swap(leftPtr, rightPtr);
			
		}//end of outer infinite while loop
		
		// Now return the leftPtr
		//the index number of the "partition": the leftmost element in the right(larger keys) subarray.
		// This "Partition" cell  marks the boundary between the two subarrays 
		//*************** "Partition" is leftmost cell of the larger subarray. It's different than 
		//*************** "Pivot". How do we choose our pivot? Last Element? MediumOf3?
		//*************** After we know our Pivot value, if we swap it with "partition" our 
		// ************** pivot would be in its final sorted position, since all the cells to its left
		// ************** have smaller values and all the cells to its right are larger.
		swap(leftPtr, right-1);//now pivot is in its final sorted position
	   return leftPtr;	//return pivot location
	}//end of partitionIt()
	
	// takes the indexes of the 2 array elements to be swapped and swaps the values
	public static void swap(int left, int right) 
	{
		System.out.println("INSIDE SWAP ======> Swapping indexes " + left + " and " + right);
		System.out.println("A[left]= " + A[left] + " A[right] = " + A[right]);
		int temp = A[left];
		A[left] = A[right];
		A[right]= temp;
	}
	
	
	
	
	
	
	
	
	
}
