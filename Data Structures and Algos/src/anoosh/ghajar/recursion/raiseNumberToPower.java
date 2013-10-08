package anoosh.ghajar.recursion;

import java.util.Scanner;

public class raiseNumberToPower {

	public static void main(String[] args)
	{
		// Get the base number from user
		Scanner s = new Scanner(System.in);
		/*System.out.println("Please input base number. X= ");
		int base = s.nextInt();
				
		// Get the actual numbers and load them into your array
		System.out.println("Please provide your Power number. Y =");
		int power = s.nextInt();
		
		System.out.println("X= " + base + " raised to the power of Y= "
				+ power  + " = " + powerO_n(base,power));
		*/
		///////////// The next section tests the multO_n()
		/*
		System.out.println("Testing mult() .Please input number. X= ");
		int one = s.nextInt();
				
		// Get the actual numbers and load them into your array
		System.out.println("Please provide your 2nd number. Y =");
		int two = s.nextInt();
		
		System.out.println("X= " + one + " multiplied by, using addition,  Y= "
				+ two  + " = " + multO_n(one,two));
		*/
		////////// The next section tests factorial()
		//System.out.println("Testing factorial() .Please input number. X= ");
		//int one = s.nextInt();
		for(int i=0; i < 16 ;i++)
		System.out.println("X= " + i + " ,factorial of X= " + factorial(i));
		
	}
	
	// This method uses recursion
	// but it's o(logN) as oppose to the powerO_n()
	// because it divides the power by 2 each time
	//until it reaches a power of 1 (base case) 
	// we have to be careful when power is ODD
	// as we need to multiply the res by base in that case.
	//
	public static int power(int x , int y)
	{
		System.out.println("Inside power(): X= " + x + " raised to the power of Y= "
				+ y);
		
	int res=1;
	if ( y == 1) return x;
	else{
		if (y % 2 == 0 )  res= res * power(x*x,y/2); //even y, power
		else res= res* x * power(x*x,y/2);          // odd power, multiply res by base
	}
	return res;
	}
	public static int powerO_n(int x , int y)
	{
		System.out.println("Inside powerO_n(): X= " + x + " raised to the power of Y= "
				+ y);
		
	
	 if (y > 1)
		 {System.out.println("In Y > 1: Returning " + x * powerO_n(x, y - 1) + 
				 " x = " +x + " y= " + y);
	      return x * powerO_n(x, y - 1); // Recursive call , O(N) cost
		 }
	   // else if (y < 0)
	     // return 1.0 / powerO_n(x, -y); // Negative power of x
	    else
	    {System.out.println("In Else, Returning " + 
				 " x = " +x + " y= " + y);
	      return x;
	    }
	  
	}
	
	// this recursive method uses addition to simulate 
	// multiplication . It will divide the y by 2 each time 
	// until it reaches 1, so it is O(logN)
	public static int multO_n(int x, int y)
	{
		if (y > 1)
		 {System.out.println("In Y > 1: Returning " + x + multO_n (x, y - 1) + 
				 " x = " +x + " y= " + y);
	      return x + multO_n(x, y - 1); // Recursive call , O(N) cost
		 }
	   // else if (y < 0)
	     // return 1.0 / powerO_n(x, -y); // Negative power of x
	    else
	    {System.out.println("In Else, Returning " + 
				 " x = " +x + " y= " + y);
	      return x;
	    }
	}
	
	// This is to calculate factorial of any number, its cost is O(N) 
	public static int factorial(int n){
		
		if (n == 0 || n == 1) return 1;
		else return n * factorial(n-1);//this is O(N)
		
		
	} // end of factorial
}
