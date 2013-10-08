package anoosh.ghajar.recursion;

import java.util.Arrays;

// This is the class that represents the exercise at the end of the recursion chapter in 
// Data Structures and Algo book by Robert Lafore 2nd edition, See knapSack() method below
// minWaste is a very close algo and will always return a solution representing a knapsack
// solution as close as possible to the target.
public class Knapsack
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		int level = 0;
		int[] A = {11,8,7,6,5};
		
		//knapsack(A,0, 20, level,0); //my own code, did not work
		//******************************* To test minWasted *********************
		System.out.println(" result of minWasted() = " + minWasted(A,0,38 ,level));
		//************************************** to test the working knapSack
		/**int[] result = knapSack(A, 39, 0, 0);//copied code knapSack with capital S
		
    	if(result == null)
    		System.out.println("Couldnt Find a solution");
    	else
    		System.out.println("The knapsack solution array is : " +  Arrays.toString(result));
    		//for(int j=0; j < result.length; j++)
    			//System.out.println(result[j]);
    	//*****************************************************************************
        */
	}

	////////////////////////////////////// This version with lower case sack does not work
	public static int[] knapsack(int[] a, int begIndex, int target, int lev, int solutionSize)
	{ 
		int[] answer=null; // put it up here so my last return statement at the end can see it
		System.out.println("Level = " + lev + " .Calling knapsack() with begIndex= " + begIndex + " and target = " +target);	
			
		for (int i=begIndex;i<a.length;i++ )
		{
	
			//base case
			  if (i == a.length ) System.out.println(" No more items");
			  if (a[i] == target) {// This is why this method will not work, we should not be 
				                   // looking for elements that match the target
				                   // but we should have 3 ifs to check if target=0, >0, <0
				                   // so we can have a base case (target =0) and return null otherwise
				  //this next for loop design only holds if the elements
				                   //are consecutive and start at index 0....
				                   //So do not use this...ITS WRONG
				  //for (int j=0; j <=i ;j++) System.out.print(a[j]+ " ");
				  System.out.println(" We are at base case with i= " + i + " and a[i]=" +a[i] );
				  int[] temp = new int[solutionSize];
				  return temp;
				
			  }
			  else if (a[i] > target) {
				  System.out.println(a[i]+ " is bigger than our target " + target + " continue...");
				  continue;
				 // return null;
			  }
			
			 else // (a[i] < target)
		  { //////////////////////// THIS IS THE RECURSIVE SECTION
			for (int j=0; j <=i ;j++) System.out.print(a[j]+ " ");
			
			System.out.println("   , Target = " + target + " , " + a[i]	+ " is too small");
			//DO NOT INCREMENT THE VALUES, simply in the recursive call, adjust their value
			//target = target - a[i];
			//begIndex++;
			//lev++;
			 answer= knapsack(a,begIndex + 1 ,target - a[i],lev + 1, solutionSize + 1);
			if (answer != null){answer[solutionSize]=a[i]; return answer;} 
			//fills the answer array from end
		 
		  } // end of else a[i] < target
		return null; //always by default return null, unless we have reached a base case which means answer!=null
		  
						
			
		}//end of for
		return answer;// i am putting a return here so that the compiler does not complain about not 
		              // returning an array of int[]
	}//end of knapsack()
	
	public static int minWasted(int[] items, int itemNum, int capLeft, int lev)
	{	int result = 0;
	
	System.out.println("Just called minWasted()...Level of Recursion= " + lev + " . itemNum= " + itemNum +" and capleft = " +capLeft);
		lev ++;
	// 2 special cases, 1-no more items, 2-We are done...
	    if(itemNum >= items.length)
		{System.out.println("no more items left.");
			result = capLeft;
		}
		else if( capLeft == 0)
		{System.out.println("We are DONE..."); 
			result = 0;
		}
		else  // recurse. once for calculation of if we take the item. 2nd time if we don't take it
		{	/// Here itemNum has not been incremented when we want to calculate the scenario
			// for with or without we simply add + 1
			
			int minWithout = minWasted(items, itemNum + 1, capLeft, lev);
			if( capLeft > items[itemNum])		
			{	int minWith = minWasted(items, itemNum + 1, capLeft - items[itemNum], lev);
				result = Math.min(minWith, minWithout);
				if (minWith < minWithout) 
				{
					System.out.println("for itemNum= " + itemNum+ "("+items[itemNum]+") minWithout of item is = "
							+ minWithout + " minWith of item is "+ minWith);
				}
			}
			else
				result = minWithout;
		}
		return result;	
	}
	
	// This function takes an array of items and a knapsack size. It attempts to
	// fill the knapsack exactly with the given items. It only considers items
	// in the array that are in slots first, first+1,... So when the function
	// is initially called it should be called with first equal to 0.
	// In addition the function also takes as input the size of the current
	// (partial) solution. This is initially 0.
/**
 * the for loop is to simulate the inclusion of each element in the bag(small bag with size=1)
 * the recursion part is to simulate the inclusion of all possible combinations 
 * for the remaining elements that are not in the small bag.
 */
	public static int[] knapSack(int[] items, int realtarget, int first, int solutionSize){
		
System.out.println("items="+Arrays.toString(items)+ " target = " + realtarget+ 
		" first = " + first + " SolutionSize = " + solutionSize);

		if(realtarget > 0)
		{
			// HERE WE CONSIDER TWO BAGS, THE SMALL BAG IS FIRST AND IT ONLY HOLDS
			// ONE ELEMENT AT A TIME, IN THE 1ST BAG WE ASSUME WE PUT ONE ELEMENT
			// THIS IS CODED WITH THE FOR LOOP. THEN FOR THAT 1ST SMALL BAG WE GO THROUGH RECURSION
			// EACH TIME TO SEE IF WE GET A SOLUTION WITH THE COMBINATIONS OF ELEMENTS 
			// THAT ARE NOT IN THE SMALL (1ST) BAG.
			// TO STOP RECURSION WE HAVE A BASE CASE FOR REALTARGET==0.
			// For each i, try placing the ith item in the knapsack
			// PAY ATTENTION THAT i=first in the loop and not a regular i=0, 1st time we call the function
			// we call it with 0, but during all following recursive calls we change it by adding 1
			for( int i= first; i < items.length; i++)//DEALS WITH SMALL BAG, ONLY 1 ELEMENT IN IT.
			
			{
				// Fit the smaller knapsack with items chosen from i+1, i+2,...
				// thus trying one by one each possible combination of the remaining
				// elements. 
				/*
				 * WE KEEP ITERATING THROUGH THE REMAINDER ELEMENTS BY RECURSING WHILE
				 * INCREMENTING THE POSITION OF THE FIRST ELEMENT AND SOLUTION SIZE
				 * AND DECREMENTING THE VALUE OF CURRENT ITEM. THUS SIMULATING THE 
				 * ADDING OF THE ELEMENTS TO THE SACK. IN GENERAL FOR TARGET > 0 WHERE THE
				 * RECURSIONS (ADDING OF REMAINDER ELEMENTS OCCUR) WE RETURN NULL.
				 * BUT ONLY WHEN WE REACH A TARGET==0
				 * CONDITION THE ELEMENTS IN THE BAG ARE A VALID SOLUTION AND 
				 * AT THAT POINT WE CHANGE THE ANSWER ARRAY FROM NULL TO AN ARRAY OF 
				 * SIZE SOLUTIONSIZE. THEN THE RECURSIVE CALLS ON THE STACK WILL RETURN
				 * BACK AND START POPULATING THE ANSWER ARRAY WITH THE ELEMENTS STARTING FROM 
				 * THE LAST INDEX AND FILLING THE ARRAY WITH EACH RECURSIVE RETURN UNTIL 
				 * WE REACH THE INDEX 0 OF THE ANSWER ARRAY AT WHICH POINT WE DO NOT HAVE
				 * ANY RECURSIVE CALLS ON THE STACK AND WE RETURN ANSWER.
				 */
				int [] answer = knapSack(items, realtarget-items[i], i+1, solutionSize+1);
				
						System.out.println("After recursive call return: answer="+Arrays.toString(answer)+ 
								" i = " + i );
				if (answer != null)
				{
					answer[solutionSize] = items[i];
					return answer;
				}
			}

			return null;
		}
		// We have found a solution. So we create an array of the right size
		// and send it back for filling
		else if(realtarget==0)
		{
			
			int[] temp = new int[solutionSize];
			System.out.println(" realtarget == 0 so now we change our answer array which is null " +
					"into an array of size=" + solutionSize + ". Now return array temp = " +
					Arrays.toString(temp));
			return temp;
		}
		
		else // realtarget is negative, so no solution is possible
			return null;

	}
	
}// end of class
