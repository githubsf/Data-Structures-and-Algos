package anoosh.ghajar.Sort;

public class MergeSort {
	
	/*
	 * Merge sort is a recursively designed algorithm. It executes in the following fashion:
 * Return if input is a single data element.(base case, stops the while loop)
 * If multiple data items are in input, split in half and sort each half.
 * Merge the sorted halves back together.
This algorithm is known as a divide-and-conquer technique. It divides the set in half and then attacks each half independently. 
Within each half it repeats itself dividing the set again in half and attacking each half.. 
Thus, if the list to be sorted consisted of eight items, merge sort would break the set up into sets of four,
 then sets of two, then sets of one. Then it would merge each set back together, placing items in appropriate order according 
 to the set they are currently in and the set they are being merged with. The structure looks as follows:
All Items
     1/2                                    1/2
   1/4 1/4                              1/4     1/4
1/8 1/8 1/8 1/8                     1/8 1/8    1/8 1/8
 
	 */
	
	//orig is used for testing, declared as a class variable to be seen by all methods
	// has to be static since the methods are static
	public static int[] orig = {65,34,23,2}; // an unordered array to be sorted using recMergeSort()

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		///////// This section tests the merge(). Input arrays are both sorted already.
		int[] A = {1,2};
		int[] B = {0,6,7};
		int[] M = new int[A.length + B.length];
	    System.out.println("1st array is : " + 
		java.util.Arrays.toString(A));
	    System.out.println("2nd array is : " + 
		java.util.Arrays.toString(B));
		merge(A, A.length, B, B.length, M);
		System.out.println("Merged array is : " + 
		java.util.Arrays.toString(M));
		//////////// End of section to test merge() non-recursively 
		
		///////////////// Now test the recursive merge
		System.out.println("Testing RECURSIVE MERGE SORT");
		//int[] orig = {65,34,23,2,45}; // an unordered array to be sorted using recMergeSort()

		System.out.println("Unordered original array is : " + 
				java.util.Arrays.toString(orig));
		int[] workspace = new int[orig.length];
		recSortMerge(workspace, 0, orig.length -1);
		System.out.println("SORTED array original is : " + 
				java.util.Arrays.toString(orig));
	}//end of main
	
	/**
	 * 
	 * @param one : 1st ordered array of int
	 * @param size1: size/length of one
	 * @param two: 2nd ordered array of int
	 * @param size2: size/length of two
	 * @param res: the resulting ordered array of merging one & two
	 */
	public static void merge(int[] one, int size1,
			                 int[] two, int size2,
			                 int[] res)
	{
			int i1=0, i2=0, i3=0; // indexes of 3 arrays
		
		while(i1 < size1 && i2 < size2)  // neither array is empty
		{
			if (one[i1] < two[i2]) res[i3++] = one[i1++];
			else                   res[i3++] = two[i2++];
		}
		
		while(i1 < size1) // two is empty, but one isn't
		{
			res[i3++] = one[i1++];	
		}
		
		while(i2 < size2) // one is empty, but two isn't
		{
			res[i3++] = two[i2++];	
		}
	} // end of merge, ordered arrays
	
	private static void recSortMerge(int[] workspace, int low, int high)
	{
		//// RECURSIVE SORTING OF LOWER AND UPPER HALF, AND USES recMerge()
		//// TO MERGE THE SORTED SUBARRAYS BACK INTO AN ARRAY.
		int mid;
		System.out.println("INSIDE RECURSIVESORTMERGE(): low= " +low + " High = " + high + " workspace = "+java.util.Arrays.toString(workspace));
		/// base case
		if( low == high) return;   // if there is only one element in range, no sorting needed, ENDS RECURSION,BASE CASE
		else
		{
			mid = (low + high) / 2; // calculate the mid level of range, divide into 2 subarrays
			recSortMerge(workspace, low,mid); //sort lower half
			recSortMerge(workspace, mid + 1,high); //sort upper half
		
		
		// NOW THE SORTING IS COMPLETED ON THE 2 unordered halves, we have 2 sorted halves now
		// Merge the 2 sorted halves
		recMerge(workspace, low, mid +1, high);
		}
	}
	/**
	 * This method is called recursively after the recMergeSort() has already
	 * been called and produced 2 ordered arrays to be merged. Low half and High half.
	 * That's why the workspace that is passed to it needs to be defined in the main 
	 * so that there is visibility at this level recursively. So we make it private method
	 * in order to be unavailable for being called outside this class.
	 * A NOTE ABOUT workspace: DURING RECURSIVE CALLS THIS TEMPORARY ARRAY AREA IN MEMORY
	 * CHANGES DURING THE SORT AND ALSO MERGE. ITS BOUNDARIES CHANGES DURING DIFFERENT
	 * RECURSIVE CALLS AND HENCE ITS SIZE CHANGES.
	 * @param workspace: This is the area occupied in memory by 2 ordered subarrays(1st and 2nd half) that we need to merge
	 * @param begLow: index of the beginning of the lower half of array to be sorted
	 * @param begHigh:index of the beginning of the upper half of array to be sorted
	 * @param endHigh: index of the end of the upper half of array to be sorted
	 * @return the sorted array using Merge Sort
	 */
	 private static void recMerge(int[] workspace, int begLow, int begHigh, int endHigh)
	{
		// We use workspace boundaries to divide it into lower & upper half sorted subarrays
		 // so we can use the algo for merging 2 ordered arrays.(see merge() above)
		 // During the algo we use the orig unordered array to compare and see 
		 // which half holds the next smallest value among the 2 halves
		 // our while loop uses and deals with the boundaries of lower and upper half
		 // or workspace, but we use orig array inside the loops since that's where the 
		 // actual values are held that we need during comparisons. 
		 //Thus we slowly populate the workspace in a sorted 
		 // ascending order. Once we have completed comparison of all elements of both 
		 // halves and populated workspace in sorted order, then we go through a for loop
		 // to copy from workspace into original array, so we can release the memory space
		 // that workspace is occupying in memory. 
		 System.out.println("orig as seen inside recMerge()="+java.util.Arrays.toString(orig));
		 System.out.println("workspace passed to recMerge()="+java.util.Arrays.toString(workspace));
		 System.out.println("begLow= " +begLow + " begHigh = " + begHigh + " endHigh = "+endHigh);
		
		int j=0; // the index of the temporary array data structure "workspace" that
		         // will be in memory, this workspace is the overhead of Merge Sort
		         // we need another array of the same size as the original to 
		         // reside in memory so we can handle the merges recursively 
		         // during sorting
		int mid= begHigh - 1; /// the index of the midpoint of the array
		int n = endHigh - begLow + 1; //number of elements in this workspace
		int lowerBound = begLow;
		
		    ///// Now we will treat the workspace array as 2 ordered arrays
		    ///// which has already been sorted by recMergeSort(). Low half,High half.
		    while(begLow <= mid && begHigh <= endHigh ) // neither of the 2 already ordered halves is empty
		    
		    	if(orig[begLow] < orig[begHigh]) workspace[j++]= orig[begLow++];
		    	else    						 workspace[j++]= orig[begHigh++];
		    
		    
		    while(begLow <= mid) workspace[j++]= orig[begLow++];// upper half empty, but lower 1/2 is not
		    
		    while(begHigh <= endHigh) workspace[j++]= orig[begHigh++];// lower half empty, but upper 1/2 is not
		    
		    
		//return workspace;
		    
		    System.out.println("workspace at end of while loops in recMerge()="+java.util.Arrays.toString(workspace));
		   // Now we copy the contents from workspace into orig
		   
		    
		    ////// Here we see the m-Behind relationship between the orig and workspace.
		    // the index of workspace is begLow-Behind orig. 
		    for( j =0;j<n;j++)     
		    	{
		    	int x = lowerBound + j;
		    	System.out.println(" INSIDE THE FOR LOOP THAT COPIES FROM workspace back into orig");
		    	System.out.println("j= " + j + " nElems = " + n + " lowerBound= "
		    			+ lowerBound + " setting orig at index "  + x + " to "
		    			+ workspace[j]);
		    	orig[lowerBound + j] = workspace[j];
		    	}
		
	}

}
