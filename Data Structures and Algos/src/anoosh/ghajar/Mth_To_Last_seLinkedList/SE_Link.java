package anoosh.ghajar.Mth_To_Last_seLinkedList;

public class SE_Link {// this is a single link, only has next, no previous
	private Object x;   // content of the link
	public SE_Link next; //pointer to the next link
	
	//constructor
	public  SE_Link(Object obj) {
		setObject(obj);
		next=null;//not needed since by default its set to null anyway if undeclared
			}
    public Object getObject(){return x;}
    
    public void setObject(Object obj ){ x=obj;}

    
	// I am testing with ints, for Object , add toString() appropriately inside your Object class
	public void displayLink(){ System.out.print( "|" + ((Integer)x).toString() + " ");}  
}
