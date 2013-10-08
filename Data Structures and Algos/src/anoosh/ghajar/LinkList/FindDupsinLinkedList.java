package anoosh.ghajar.LinkList;

import java.util.Arrays;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class FindDupsinLinkedList {
	
	public static void main(String[] args) {
		FindDupsinLinkedList x = new FindDupsinLinkedList();
		//x.fastEZ(); //uses java collections
		singleEndedLinkedList LL1 = new singleEndedLinkedList();
		LL1.insertFirst(new Integer(1));
		LL1.insertFirst(new Integer(1));
		LL1.insertFirst(new Integer(2));
		
		
		
		
		LL1.displaySELinkedList();
		
		//x.removeDuplicates(LL1.first);
		
		//LL1.displaySELinkedList();

	}
    //fastEZ() uses the java.util.Collection data structures and the API of it removeAll() addAll()
    public void fastEZ(){
    	Integer[] a1 = {1,2,3,4,5,6};
        Integer[] a2 = {1,3,5,8};

        LinkedList<Integer> LL1 = new LinkedList(Arrays.asList(a1));
        LinkedList<Integer> LL2 = new LinkedList(Arrays.asList(a2));

        Set<Integer> set1 = new HashSet<Integer>(LL1);
        Set<Integer> set2 = new HashSet<Integer>(LL2);
        
        //removeAll() is subtraction and addAll() is union of sets.
    	set1.removeAll(LL2);
        set2.removeAll(LL1);
        set1.addAll(set2);

        System.out.println(set1);
   	
    }
    
    
    	public void removeDuplicates(doubleLink list) {// the input parameter list is the actual first Link = the header of LinkedList
    	    while (list != null) {
    	        // Walk to next unequal node:
    	       doubleLink current = list.next;
    	        while (current != null && (current.getObject().equals(list.getObject()) ) ){
    	            current = current.next;
    	        }
    	        // Skip the equal nodes:
    	        list.next = current;
    	        // Take the next unequal node:
    	        list = current;

    	    }
    	}
    
}
