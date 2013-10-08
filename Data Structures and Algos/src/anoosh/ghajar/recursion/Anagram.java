package anoosh.ghajar.recursion;

import java.util.Arrays;

public class Anagram {
	/**
	 * The number of permutations for words made out of n chars is n!.
	 * So for 3 letters we have 6 words. for 4 letters we have 24.
	 * 1- Anagram the rightmost n-1 letters
	 * 2- rotate ALL n letters=except for the first letter
	 *                         shift all of them to the left by one space in the word
	 *                         for the first one put at the end of the word
	 * 3- Repeat these steps n times.(Gives each letter the possibility of being in 1st position.
	 *                                all the other letters from 2nd-last will then be anagrammed
	 *                                to find all possible permutations.
	 *  During recursion the base case occurs when we only have 1 letter in the word to be anagrammed.
	 *  In the base case we just simply return (do nothing)
	 *  if word size is 2 we display , and then we call rotate()
	 *  The doAnagram() function takes only one parameter and that is the new size of the word to be
	 *  anagrammed in this recursion. The word itself is a class instance.
	 *  Each time the doAnagram calls itself, the size of the word is one letter smaller, 
	 *  and the starting position is one cell further to the right(rotate() does have this logic).
	 *  Creating smaller and smaller words and thus applying the dividing and conquer paradigm.
	 */

	
	static char[] word = {'c','a','t','s'}; 
	static int size;//this represents the size of our word array and will be used in rotate() to get
	                // the position in each iteration so we can move letters left
	static int count=0; // holds the number of permutations, used to format the output
	static int level=0; // represents the recursion level
	public static void main(String[] args) {
		System.out.println("hard coded static array word is "+Arrays.toString(word) + "\n");
		
		 size=word.length;
		doAnagram(size,0);

	}
	public static void doAnagram(int newSize, int level){
		System.out.println("Entering doAnagram with newSize="
				+ newSize + " and level="+level);//for seeing the flow in output
		// base case in an if statement to return immediately
		if(newSize==1) {
			System.out.println("returning from level     "+level);//just to see the flow of logic in output
		return;
		}
		
		// then iterate through all elements, makes sure that each letter gets 
		// the opportunity to be the 1st letter of the word
		for(int i=0;i<newSize;i++)
		{
			//recurse to divide and conquer, anagram the remaining rightmost n-1 elements
			doAnagram(newSize - 1,++level);
			
			//display the word when we are down to only 2 letters in the word
			if (newSize ==2) displayWord();
			
			//rotate the word, move all elements except the 1st one space left and then 
			// put the 1st element that we saved in a temp in the last position of word
			rotate(newSize); 
			
		}
	}//end of doAnagram()
	
		public static void displayWord(){
			if (count < 99) System.out.print(" ");
			if (count < 9) System.out.print(" ");
			System.out.print(++count + " ");
			for (int i =0; i < word.length;i++)
				System.out.print(word[i]);
			System.out.print("     "); //put a tab size space between permutations within the same line
			if(count%6 ==0)System.out.println("");//new line after each 6 permutations
				
		}//end of displayWord()
		
		
           // rotate left all letters from position to end
		public static void rotate(int newsize)
		{
		System.out.println("Entering rotate() with newSize="+ newsize );//for seeing the flow in output
			
			int position = size - newsize;//size is a constant depending on the original word
			                              //new size changes with every recursion
			char temp=word[position]; //save the  letter of the word at position so we can put it as last element
			                          // after we have moved all other elements to the left by one cell
			
			//*************** PAY ATTENTION TO THE starting point being set to position + 1, NOT ZERO ******
			for(int i=position + 1; i< size;i++)
			{
				word[i-1]=word[i];//shift left
			}
			word[size-1] = temp;//now set the last letter to our previous 1st letter at position
		}

}
