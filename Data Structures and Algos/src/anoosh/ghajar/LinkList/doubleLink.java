package anoosh.ghajar.LinkList;

public class doubleLink {// this is doubly link, has next and previous
	private Object o;   // content of the link
	public doubleLink next; //pointer to the next link
	public doubleLink previous; //pointer to the next link
	
	//constructor
	public  doubleLink(Object obj) {
		o=obj;
		next=null;//not needed since by default its set to null anyway if undeclared
		previous=null;//not needed since by default its set to null anyway if undeclared
			}
    public Object getObject(){return o;}
    
	// I am testing with ints, for Object , add toString() appropriately inside your Object class
	public void displayLink(){ System.out.print(  ((Integer)o).toString() + " ");} 
}
