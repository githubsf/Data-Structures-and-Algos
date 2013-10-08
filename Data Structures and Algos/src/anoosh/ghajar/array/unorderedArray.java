package anoosh.ghajar.array;



public class unorderedArray implements ArrayInterface {
	
	private long[] a;     //reference to the unordered array
	private int nElems;   // number of data items in the array
	private static final int capacityFactor = 2; // doubles the size, change this line for triple(3) or higher factors
	// *** arraycopy is expensive operation so minimize it by using a good
	// capacityfactor, but you will have a lot of empty cells with higher factors.
	// so use your judgement...
	
	
	
	//constructor sets the instance variables
	public unorderedArray(int initCapacity){
		a = new long[initCapacity];
		nElems = 0;
	}

	@Override
	public void delete(long l) {
		// TODO Auto-generated method stub
		
		// To delete an element from the array we must first find it
		// then remove it
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
	public int find(long value) {
		// TODO Auto-generated method stub
		int res=0;
      for (int i=0; i < nElems;i++)	//comparison loop against all elements 
      {
    	  // 1st special case: We found it
    	  if (value == a[i])
    	  {System.out.println("Value " + value + " Found at index " + i);
    	   res= i; 
    	   break;//get out of the comparison loop   
    	  }
    	  
    	  //2nd special case: We checked all elements and still did NOT find it
    	  if (i == nElems - 1)
    	  {
    		  System.out.println("Value " + value + " NOT Found."); 
    		  res=-1;
    	  }
    	    	  
    	  
      }//end of for loop
       return res;
	}

	// SInce this is unordered we will insert at the last index
	// for ordered arrays you must first find the place of insertion
	@Override
	public void insert(long value) {
		// TODO Auto-generated method stub
		if(nElems == a.length - 1){ ensureCapacity(a);}
		a[nElems] = value;
		nElems++; // increment the number of elements
		}

	@Override
	public void printArray() {
		// TODO Auto-generated method stub
		StringBuffer s = new StringBuffer();
		for (long x : a){
			              s.append(x + " ");
				}
		s.append("\n");
		 System.out.print(s.toString());
		 System.out.println("a.length(capacity of array) = " + a.length + " but number of elements is: " + nElems);
	}
	
	public void ensureCapacity(long[] r){
		long[] old_data = r;
		a= new long[capacityFactor * old_data.length];
		System.arraycopy(old_data, 0, a, 0, old_data.length);
		
		System.out.println("Double the capacity of the array. Now length = " + a.length);
		
	}
	
	@Override
	public boolean isEmpty(){ return (nElems == 0);} ; 
	
	
	@Override
	public long getMax() {
		// out of the 3 elementary sort algorithm for random data
		// the fastest is selection sort when you save on # of swaps per pass
		// as compared to the bubble sort which has N*(N-1)/2 comparisons
		// and 1/4 * N *(N-1) swaps
		// In selection sort we do only one swap at the end of each outer loop
		// So we only have N - 1 Swaps.
		// To have the max element end up after the 1st pass we will start our 
		// loop at the last element
		int ind , max;
		max = nElems - 1; //SELECT YOUR current max(in this ex: last element is our initial max)
		for(ind=0;ind<nElems-1;ind++)
		{
			//System.out.println("The max is at index : " + max + 
				//	" in = " + in + " a[in]= " + a[in] + " a[max]= " + a[max]);
			if(a[ind] > a[max]) max = ind;      
			
		} // at the end of this comparison loop every element has been compared to our most 
		  // current max(started our initial max with the last element, but as the loop progressed
		 // our current max was changed to the index of that position.). So now we know
		// the index of the largest element.
		
		
		////Now outside the comparison inner loop swap the last element with your
		//// new max at the end of the 1st pass(No outer loop used, since
		/// at the end of the 1st pass we will know the max
		return a[max];
		// if i cared to actually place the max at the last array index
		// i would call Swap(nElems -1;max)
		
	}
	
	public void removeMax(){
		//This is a special case of SELECTION sort with only one pass
		int ind , max;
		long temp;
		max = nElems - 1; //SELECT your current max(in this ex: last element is our arbitrary initial max)
		for(ind=0;ind<nElems-1;ind++)
		{
			//System.out.println("The max is at index : " + max + 
				//	" in = " + in + " a[in]= " + a[in] + " a[max]= " + a[max]);
			if(a[ind] > a[max]) max = ind;
			
		}
		// Now we found the index at which maximum resides
		// Now swap this max with the last element and then delete the last element
		// to avoid costly shifting of elements if max is in the middle or
		// worst case scenario 1st element
		temp = a[max];
		a[nElems - 1] = temp;
		a[max]=a[nElems - 1];
		// Now delete the last element by setting the value to 0 and adjusting the
		// nElems
		a[nElems - 1] = 0;
		nElems--;
	}
	//=================================================================================
	public  boolean containsDuplicates()
	{
		
	    // Create a zero-initialized array the size of the maximum allowed value in a.
	    int[] count = new int[(int)getMax()];

	    for (int i = 0; i < a.length; i++)
	    {
	        if (count[(int) a[i]] != 0)
	        {
	            // The value at a[i] is already in the histogram -> duplicate!
	            return true;
	        }

	        // a[i] is not in the histogram yet.
	        count[(int) a[i]]++;
	    }

	    return false;
	}
	
	/////To return a copy of the array with duplicates removed you could then do:

		public   long[] stripped()
		{
			int[] count = new int[(int)getMax()];
		    int uniques = 0;

		    for (int i = 0; i < a.length; i++)
		    {
		        count[(int) a[i]]++;
		        if (count[(int) a[i]] == 1)
		        {
		            uniques++;
		        }
		    }

		    if (uniques == 0) return null;

		    long[] retArray = new long[uniques];
		    int retIndex = 0;
		    for (int i = 0; i < count.length; i++)
		    {
		        if (count[i] > 0)
		        {
		            retArray[retIndex++] = count[i];
		        }
		    }

		    return retArray;
		}
}
