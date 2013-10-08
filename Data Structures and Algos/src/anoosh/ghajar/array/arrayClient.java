package anoosh.ghajar.array;


public class arrayClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        System.out.println("Testing unordered array");

		//Always declare your array as an interface type to hide
		// the implementation details(ordered, unordered) from client
		ArrayInterface unordered = new unorderedArray(3);
        unordered.insert(2);
        unordered.insert(5);
        unordered.printArray();
        unordered.insert(1);
        unordered.printArray();
        System.out.println("The max is : " + unordered.getMax());

        unordered.insert(20);
        unordered.printArray();
        unordered.find(34);
        unordered.find(20);
        unordered.delete(1);
        unordered.printArray();
        System.out.println("The max is : " + unordered.getMax());
        unordered.removeMax();
        unordered.printArray();

        
        /////////////////////// Testing orderedArray now
      System.out.println("Testing ordered array");
        ArrayInterface ordered = new orderedArray(100);
        for (int i = 0; i < 10; i++) ordered.insert(i);
        ordered.printArray();
        ordered.find(7);
        System.out.println("The max is : " + ordered.getMax());
        ordered.printArray();
        ordered.removeMax();
        ordered.printArray();

        //////Now testing the mergeArray
        orderedArray merged=new orderedArray(10);
        System.out.println("Testing the mergeArrays()");
        long[] one = {1,3,5};
        long[] two = {0,2,4};
        System.out.println("one array is : " + java.util.Arrays.toString(one));
        System.out.println("two array is : " + java.util.Arrays.toString(two));
        
        long[] res = merged.mergeArrays(one, two);
        
        ///print the merged array
        System.out.println("merged array is : " + java.util.Arrays.toString(res));
        for(int i=0;i<res.length;i++)
        { System.out.print(" " + res[i]);}
        System.out.println();
       
      // Now testing the noDups
       orderedArray a =new orderedArray(5);
       System.out.println("Testing the noDups()");
       a.insert(1);
       a.insert(3);
       a.insert(3);
       a.insert(1);
       a.printArray();
       a.noDups();
       a.printArray();
       
    // Now testing the noDups
       orderedArray b =new orderedArray(5);
       
       System.out.println("Testing the insertBS()");
       b.printArray();
       b.insertBS(9);b.printArray();
       b.insertBS(3);b.printArray();
       b.insertBS(4);b.printArray();
       b.insertBS(1);b.printArray();
      
       

	}// end of main

}
