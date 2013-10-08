package anoosh.ghajar.Sort;


/**
 * In place - merge sort
 * 
 * Unlike regular Merge sort this one does not require an extra array
 * workspace of size=array1.size + array2.size
 * However it requires that one of the 2 already sorted arrays is large
 * enough with unused spaces available to add the elements of shorter array
 * to the end of it. This is shown in a[] where 0 means unused/available.
 */
public class InPlaceMergeSort {
 
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a = new int[]{8,12,15,20,22,0,0,0,0};
		int[] b = new int[]{6,13,18,19};
	
		System.out.println(" a.length="+a.length + " ; b.length="+b.length);
		int m = 5;//number of elems in large arr
		int n = 4;//number of elems in small arr
		int p = (m+n);//would be number of elems in large arr after merge,
		              // p is current a.length
		
		int i = p-1;//index of last element of a,we use it to insert b elems
		int sm = n-1;//index of last elem in small array
		int lg = m-1;//index of last used spot in large array
		
		while(sm>=0 && lg>=0) {
			if(a[lg] > b[sm]) {//compare 2 array elements starting at end(22 vs 19, 20 vs 19,...)
				a[i] = a[lg]; //populate a[] starting at end
				i--;lg--;//adjust indexes
			} else {
				a[i] = b[sm];//element in b was bigger
				i--;sm--;//adjust indexes
			}
		}
		//for(int e:a){		System.out.print(i + "<--i " + e+":: ");}
		while (sm >= 0 ) {//if b[0] < a[1] and a[0] it never got inserted
			a[i--] = b[sm--];//6 was less than 8 and 12,never got inserted
		}
		
		for(int e:a){		System.out.print(e+", ");}
	}
 
}