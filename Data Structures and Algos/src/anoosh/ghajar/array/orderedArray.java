package anoosh.ghajar.array;



public class orderedArray implements ArrayInterface {
	
	private long[] a;     //reference to the ordered array
	private int nElems;   // number of data items in the array
	private static final int capacityFactor = 2; // doubles the size, change this line for triple(3) or higher factors
	// *** arraycopy is expensive operation so minimize it by using a good
	// capacityfactor, but you will have a lot of empty cells with higher factors.
	// so use your judgement...
	
	
	
	//constructor sets the instance variables
	public orderedArray(int initCapacity){
		a = new long[initCapacity];
		nElems = 0;
	}

	@Override
	public void delete(long l) {
		System.out.println("Running delete for value = " + l);

				
		// To delete an element from the array we must first find it
		// then remove it, using find() uses binary search O(log(N)) and 
		// is more efficient than using a for loop for linear search at O(N) cost
		// Binary search only works for ordered arrays.
		int indxOfFound = find(l); 
		if(indxOfFound==-1){;} // do nothing
		else {
			////////////*** REVIEW THIS LOOP ***** How to move, after delete
			//// Loop simulates both deletion(overwriting) and the move to left
			for (int i=indxOfFound; i < nElems;i++)
			{ //starting at the indxOfFound and moving to the end of array
			   // set each element to the value of the next one after it
				// thus moving each element to the left
				a[i] = a[i + 1]; 
			
			} //end of for
			nElems--;
		}

	}

	@Override
	///For the ordered array we will use the binary search for O(logN) cost
	// by dividing the range of the numbers to compare by 2 each time
	//////////// BINARY SEARCH ALGORITHM ////////////////////
	// returns the index at correct insertion point or -1
	public int find(long value) {
		System.out.println("Running Find() for value = "+ value);
		int res=0;
		int low=0, high=nElems - 1;//indexes of range extremes before the loop
		int j=0; // represent the index at middle of the range
		int pass =0; // monitor the number of division by 2 of range
		
		
		//Start an infinite loop for binary search, break out of it when needed
      while(true)
      {
    	pass++;  
      
		  j = (high + low)/2;  //mid-point of the range
    	  System.out.println("low = " + low + " high = " + high);
    	  System.out.println("PASS = "  + pass + " current index j = " + j + " a[j] = " + a[j]);
    	
    	  // 1st special case: We found it
    	  if (value == a[j])
    	  {System.out.println("Value " + value + " Found at index " + j);
    	   res= j; 
    	   break;//get out of the while comparison loop   
    	  }
    	  
    	  //2nd special case: We checked all elements and still did NOT find it
    	  if (low > high)
    	  {
    		  System.out.println("Value " + value + " NOT Found."); 
    		  res=-1;
    		  break;
    	  }
    	    	  
    	  if( value < a[j] ) {// value is in lower half, change high
    		  System.out.println("Reducing the range, value is in low half");
    		  System.out.println("changing high from  " + high +" to " + (j-1));
    		  high = j - 1;
    		  
    	  }
    	  else { // value is in upper half, change low
    		  System.out.println("Reducing the range, value is in upper half");
    		  System.out.println("changing low from  " + low +" to " + (j+1));
    		  low = j + 1;
    		  
    	  }
    	  	  
           
      }// end of while
      return res;
	}

	// Since this is ordered we will insert at the appropriate place index
	// for ordered arrays you must first find the place of insertion
	@Override
	public void insert(long value) {
		int i;//we declare int i here since if we declare in 1st for loop,
		      // it wont be visible inside 2nd for loop
		
		System.out.println("Now inserting " + value + " nElems = " + nElems +
				" length= " + a.length);
	   // Handle 2 special cases, array full or empty
		if (nElems ==0) {a[0]=value; nElems++;return;}
		if(nElems == a.length ){ ensureCapacity(a);}
		
		// 1st for loop is to find the place of insertion(Linear search used here, but can use binary search(better)
		for ( i=0; i<nElems;i++)//loop through all elements(linear search) and compare
		 if (value < a[i]) break;//this assumes ascending order.for descending use value > a[i]
		// OR REPLACE ABOVE O(N) algo with O(logN) similar to binary search of Find(), cant use find()
		//since if the value is not in array already find() cant find it and will return -1, see insertBS()
		// At the end of this for loop with only 1 if statement we have the index i of insertion point bcz of break
		
		//2nd for loop uses the i index from 1st loop + j index of 2nd loop to push elements to right
		// now we found the index i where our new value should go in an ASCENDING array
			//BUT FIRST PUSH ALL THE FOLLOWING CELLS TO THE RIGHT
			for (int j = nElems; j >= i; j--)
				a[j]=a[j - 1];
			
		// Now array has opened a position at i index to insert new value, insert it 
			// and increment the nElems
		
		a[i] = value;
		nElems++; // increment the number of elements
		}

	public void insertBS(long value) {//This version uses binary search to locate the index of correct insertion
		//int i; //we declare int i here since if we declare in 1st for loop,
		      // it wont be visible inside 2nd for loop
		int res=0; // res represents the index of the insertion point
		System.out.println("Now inserting " + value + " nElems = " + nElems +
				" length= " + a.length);
	   // Handle 2 special cases, array full or empty
		if(nElems == a.length ){ ensureCapacity(a);}
		if (nElems ==0) {a[0]=value; nElems++;     
		                 System.out.println("There was no elements in the array. Inserting the 1st value." + value);
                         return;}
		
		//value is the new min
		if ( a[0] > value){ 
            System.out.println("Inserting the new min value." + value);
			for (int k = nElems; k > 0; k--)		a[k]=a[k - 1];//push all cells to right
		                a[0]=value;nElems++;return;}
		//value is the new max
		if (a[nElems -1] < value){ System.out.println("Inserting the new max value." + value);a[nElems]=value;nElems++;return;}
		
		
		// 1st for loop is to find the place of insertion(Linear search used here, but can use binary search(better)
		//for ( i=0; i<nElems;i++)//loop through all elements(linear search) and compare
		// if (value < a[i]) break;//this assumes ascending order.for descending use value > a[i]
		// OR REPLACE ABOVE O(N) algo with O(logN) similar to binary search of Find(), cant use find()
		//since if the value is not in array already find() cant find it and will return -1, see insertBS()
		// i = find(value);
		
		//************************************** Binary Search section to find the position of insertion
		System.out.println("Running BS ALGO to find insertion index for value = " + value);
		
		int low=0, high=nElems - 1;//indexes of range extremes before the loop
		int j=0; // represent the index at middle of the range
		int pass =0; // monitor the number of division by 2 of range
		
		
		//Start an infinite loop for binary search, break out of it when needed
      while(true)
      {
    	pass++;  
      
		  j = (high + low)/2;
    	  System.out.println("low = " + low + " high = " + high);
    	  System.out.println("PASS = "  + pass + " current index j = " + j + " a[j] = " + a[j]);
    	
    	  // 1st special case: We found it, this new value already has an existing duplicate
    	  if (value == a[j])
    	  {System.out.println("Value " + value + " Found at index " + j);
    	   res= j; 
    	   break;//get out of the while comparison loop   
    	  }
    	  
    	//2nd special case: We checked all elements and still did NOT find it
    	  if (low > high)
    	  {
    		  System.out.println("Value " + value + " NOT Found between low and high range"); 
    		  res=low;
    		  break;
    	  }
    	  
    	  
    	    	  
    	  if( value > a[j] ) {// value must be inserted  in upper half, increment low
    		  System.out.println("Reducing the range, value is to be inserted in upper half");
    		  System.out.println("changing low from  " + low +" to " + (j+1));
    		  
    		  low = j + 1;
    		  
    		  
    	  }
    	  if (value < a[j]) { // value must be inserted in lower half, decrement high
    		  System.out.println("Reducing the range, value is to be inserted in low half");
    		  System.out.println("changing high from  " + high +" to " + (j-1));
    		  
    		  high = j - 1;
    		  
    	  }
    	
    	  	  
           
      }// end of while , now res holds the index of insertion point
      
		
		//2nd for loop uses the res index from our WHILE binary search loop + k index of 2nd loop to push elements to right
		// now we found the index res where our new value should go in an ASCENDING array
			//BUT FIRST PUSH ALL THE FOLLOWING CELLS TO THE RIGHT
			for (int k = nElems; k >= res; k--)
				a[k]=a[k - 1];
			
		// Now array has opened a position at res index to insert new value, insert it 
			// and increment the nElems
		
		a[res] = value;
		nElems++; // increment the number of elements
		}

	@Override
	public void printArray() {
		
		StringBuffer s = new StringBuffer();
		for (long x : a){
			              s.append(x + " ");
				}
		s.append("\n");
		 System.out.print(s.toString());
		 System.out.println("a.length(capacity of array) = " + a.length + " but number of elements is: " + nElems);
	}
	
	public void ensureCapacity(long[] old_data){
		
		long[] New = new long[capacityFactor * old_data.length];
		System.arraycopy(old_data, 0, New, 0, old_data.length);
		
		System.out.println("Double the capacity of the array. Now length = " + New.length);
		
		
	}
	
	
	@Override
	public  boolean isEmpty(){ return (nElems == 0);} ; 
	
	@Override
	public long getMax() {
		
		if (isEmpty()) return -1;
		else return a[nElems - 1];
	}
	
	@Override
	public void removeMax() { 
		a[nElems - 1]=0;
		nElems--;
	}
	
	public long[] mergeArrays(long[] x , long[] y)
	{
		int size = 0;   // refers to number of elements in the resulting merge array
		long[] c = new long[x.length+ y.length];
		// SPECIAL CASES
		if (x.length == 0) { c = y;return c;}
		if (y.length == 0)  {c = x;return c;}
		if (x[x.length -1] < y[0]) 
		{	c=x; 
			for(int i=x.length;i<c.length;i++) {
			c[i]=y[i];
			}//end of for
			return c;
		}//end of if
		if (y[y.length -1] < x[0]) 
		{	c=y; 
			for(int i=y.length;i < c.length;i++) {
			c[i]=x[i];
			}//end of for
			return c;
		}//end of if
		
		//Main case, THIS ALGO IS A SPECIAL case of INSERTION SORT ALGORITHM
		// Where "x" would represent the already partially sorted group
		// and "y" would represent the new elements to be inserted(unsorted group)
		//Insertion Sort Algo  is O(N) instead of O(N*N) when the data is already partially sorted
		// which is our case here. As both arrays to be merged are ordered arrays
		for (int i =0;i<x.length;i++) c[i] = x[i]; //copy the first array into c
		size = x.length;
		long temp=0; // this will be used to hold the new element from y
		             // that we want to insert next
		int in =0;    // This is the index we use in the inner while loop
		// The FOR LOOP IN THE INSERTION SORT REPRESENTS THE NEW ELEMENTS 
		// TO BE INSERTED. IN THIS CASE IS THE 2nd array to be merged (Y)
		for (int out=0; out < y.length; out++)
		{
			temp= y[out]; // the item to be inserted is saved first in temp
			in = size; // start the shift(inner loop) from the *** last element + 1 ***
			           //of the already sorted group, X
			// The inner WHILE LOOP REPRESENTS THE FINDING OF THE CORRECT
			// INDEX FOR INSERTION OF NEW ELEMENT & ALL THE SHIFT TO THE RIGHT
			// THAT IS NECESSARY
			// IT STARTS FROM 1 AFTER (+ 1) THE LAST ELEMENT OF THE ALREADY SORTED GROUP
			// AND GOES TOWARD THE 1ST ELEMENT(AS USUAL,WHEN WE NEED TO 
			// SHIFT ARRAY ELEMENTS TO RIGHT DURING INSERTIONS.
			while(in > 0 && c[in-1] >= temp)
			{
				
				c[in] = c[in-1]; //shift all elements bigger than temp to right
				in--; // go left one position
			}// end of while(comparison and copy/shift right)
			// At the end of the above while loop "in" is the correct index
			// for insertion of the new element "temp" and all values bigger than
			// temp are shifted to the right
			c[in]=temp;    // insert the new value in the correct position
			size++;     // every time we add, we increment size
		}//end of outer for loop, which handles new elements to be inserted
		return c;
	}
	
	// There is another merge alternative that 
	// has an algo which is easier to follow
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
	
	public void noDups() {
		// This is at best O(N*N) as we need to traverse the array from 1st to last 
		//element compare each element with the ones that have not been compared with already
		//I tried to reduce it to O(logN) by using find(a[i]) and hence binary search
		//and mark duplicates but whatever number you use as a marker will be out of place
		// in an ordered array, and the following find() will not produce the desired results 
		// as the loops go through future iterations.
	//int numberDups =0;
		
		for (int i = 0; i < nElems-1; i++)
		{
     	   System.out.println("inside inner for loop of noDups() i = "+ i + " a[i] = " + a[i]);

			while (find(a[i]) > i)delete(a[i]); //wont work properly
          /* for (int j = nElems -1 ; j > i;j--)//start from end of array toward i,everything before i has already been compared and Dups deleted
			
					{
        	   System.out.println("inside inner for loop of noDups() j = "+ j + " a[j] = " + a[j]);
        	          if (a[j]==a[i]){	
        	        	  //Setting a cell to a marker value will not work since
        	        	  // the array is no longer in sorted array after that
        	        	  // and the binary search of find() used in delete() will not
        	        	  // work correctly.
        	        	  //a[j]= 987654321;//a value outside of the legal data range
        	        	  //numberDups++;
        	        	  // from J to last element we need to move cells left, thus deleting duplicate
        	        	  for (int x=j;x<nElems;x++){a[x]=a[x+1];} nElems--;
        	        	  
        	        	  
        	          System.out.println("Array is : " +Arrays.toString(a));}//mark all duplicates with a marker number
        	          }
			*/		
				
 
		}
		//Commented out since using markers in a sorted array will cause bugs in find()
		// which uses binary search
		/*for (int i = 0;i<numberDups;i++)
			
		{
     	   System.out.println("inside delete for loop of noDups() i = "+ i + " numberDups = " + numberDups);

		delete(-987654321);//delete all marked cells
		}
		*/
	}
	
	
}
