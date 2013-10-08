package anoosh.ghajar.String;

public class StringReverse {
	
	//if using java API, use StringBuffer(yourInputString).reverse().toString()
	//if not use a loop, starting from string.length with charAt(index) and loop to index 0
		public static String reverser(String s)
		{
			String reverse = new StringBuffer(s).reverse().toString();
			return reverse;
		}
		
		public static String loopReverser(String s)
		{ StringBuffer sb = new StringBuffer();
		
			for(int i=s.length() -1 ;i>=0;i--)
			{
				sb.append(s.charAt(i));
			}
			return sb.toString();
			
		}
		
		public static String loopSentenceReverser(String s)  //assumes the words are separate with " "
		{ StringBuffer sb = new StringBuffer();
		
		String[] words = s.split(" ");
			for(int i=words.length -1 ;i>=0;i--)
			{
				sb.append(words[i] + " ");
			}
			return sb.toString();
			
		}
	  public static void main(String[] args)
	  {
		  System.out.println("An example of using the manual loop to get each char of the input string");
		  System.out.println("String before reverse: " + "DOG");
		  System.out.println("String after reverse: " + loopReverser("DOG"));
	  
		  System.out.println("An example of using the java API, StringBuffer.reverse() reverse the input string");
	      System.out.println("String before reverse: " + "CAT");
	      System.out.println("String after reverse: " + reverser("CAT"));
	  
	      System.out.println("An example of reversing the sentence of words separated by empty space");
	      System.out.println("String before reverse: " + "CAT EATS DOG");
	      System.out.println("String after reverse: " + loopSentenceReverser("CAT EATS DOG"));
	
	  } 
	} 


