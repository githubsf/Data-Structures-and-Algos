package anoosh.ghajar.String;


import java.util.ArrayList;
import java.util.List;

/*
 * Determine if a String has all unique characters
 */
public class FindDuplicatesInString {
	
	public static boolean checkDups(String s){
		int length = s.length();
		
		if (length <= 256) return checkDups1(s); //low space requirement algorithm, cache structure=s.length()
		return checkDups2(s); // space requirement of 256 for ASCII char set, regardless of s.length()
	}
 
 public static boolean checkDups1(String s){//space usage of s.length(), time O(n)
	 List L = new ArrayList(s.length()); //use this List as a cache of already checked chars 
	 
	 for (int i=0;i<s.length();i++) //loop through input string
	 { char ch = s.charAt(i);
	 
		 if(L.contains(ch)) return true; 
	     else{ L.add(ch);}  //add to our cache for next char check
	 }
	 return false;
 }
 
 public static boolean checkDups2(String s){//space usage of 256, time O(n)
	 boolean[] charSet = new boolean[256]; //use this array of boolean as a cache of already checked chars 
	 
	 for (int i=0;i<s.length();i++) //loop through input string
	 { int val = s.charAt(i);//charAt returns a char, but when casted to int, val is ASCII index of char
	 
		 if(charSet[val]) return true; 
	     else{ charSet[val]=true;}  //add to our cache for next char check
	 }
	 return false;
 }
     public static void main(String[] args){
    	 System.out.println( " result is :" + FindDuplicatesInString.checkDups("miayam"));
    	 System.out.println( " result is :" + FindDuplicatesInString.checkDups("uniq"));
     }
}
