package anoosh.ghajar.LinkList;

public class Link {// this is a single link, only has next, no previous
	private Object o;   // content of the link
	public Link next; //pointer to the next link
	
	//constructor
	public  Link(Object obj) {
		o=obj;
		next=null;//not needed since by default its set to null anyway if undeclared
			}
    public Object getObject(){return o;}
    
	// I am testing with ints, for Object , add toString() appropriately inside your Object class
	public void displayLink(){ System.out.print(  ((Integer)o).toString() + " ");}  
}
