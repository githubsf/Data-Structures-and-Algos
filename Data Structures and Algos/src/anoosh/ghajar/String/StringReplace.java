package anoosh.ghajar.String;

public class StringReplace {//replace all spaces in a string with %20
	/// THE KEY HERE IS TO USE STRING CLASS and the replaceAll(String, String) or 
	// replace(char, char) method...In both methods 1st param is regexp and 2nd is replacement
	
	

	public static void main(String[] args)
	{
		String s = "Hello Anoosh How Are you?";
		
		System.out.println("replace All spaces in a string with %20  " + "String = " +s);
		System.out.println("After replacement, using string class replace(), string = " +s.replace(" ", "%20"));
		System.out.println("After replacement, not using java API string = " + replaceAlgorithm(s));
	}
	
	public static String replaceAlgorithm(String s){//DO NOT USE JAVA API of String class
		/* 
		 * The algorithm is as follows:
		 * 1) Count the number of spaces during the first scan of the string,using a for loop
		 * 2) Parse the string again from the end and for each character:
		 *    * if a space is encountered, store %20
		 *    * else, store the character as it is in the newly shifted position
		 */
		
		int spaceCount=0, newlength=0, i = 0;
		int length = s.length();
		
		//Count the white spaces in input string so we can find the newlength
		for( i =0; i< length;i++)
		{ if (s.charAt(i) == ' ') spaceCount++;
		}//looped through input string once and counted all spaces , time cost = O(n)
		
		// 3 new chars introduced for each space char = 2 new chars per space
		newlength = length + (2 * spaceCount); 
		
		//convert the string to a char array so we can start building at char level
		// and avoid constant calls to s.charAt(i)
		char[] str = s.toCharArray();//
		char[] arr = new char[newlength];
		//System.out.println(arr.length);
		System.arraycopy(str,0,arr,0,length);
		//for (char c : arr)		System.out.println(c + ", ");
		
		
		/////////////////// WE ARE CHANGING THE ARRAY OF CHAR IN PLACE
		//////////////////// AND ARE NOT USING ANOTHER DATA STRUCTURE AT ALL
		
		arr[newlength - 1] = '\0'; //set the end of the char array manually
		for(i = length - 1 ; i>=0; i--) // uses the original length to loop
		{                           //start setting the chars from the end of the array
			if (arr[i] == ' '){ 
				                arr[newlength -  1 ] = '0';
								arr[newlength -  2 ] = '2';
								arr[newlength -  3 ] = '%';
								newlength = newlength - 3;// keep track of insertion point index in array
			}
			else { arr[newlength - 1 ] = arr[i]; newlength = newlength -1;}
		}//end of for loop
		for (char c : arr)		System.out.println(c + ", ");

			return new String(arr);//convert char array to String, using string class constructor
			
		}
		
		
	
}
