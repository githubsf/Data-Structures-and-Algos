package anoosh.ghajar.array;

public interface ArrayInterface {
	/// This will serve as the contact point for the clients
	// Two implementation classes will implement this interface
	// but since the client uses this interface only, the details
	// of the implementation of the array(Ordered, Unordered) will 
	// be hidden from the user
	// I will provide methods for INSERT, DELETE, FIND, PRINTARRAY
	// isEmpty, getMax, and removeMax
	
	public abstract void insert(long l);
	
	public abstract void delete(long l);//needs the index returned by find() to delete
	
	public abstract int find(long l); //returns the index of found element
	
	public abstract void printArray();
	
	public abstract long getMax(); // returns the maximum int value or -1 if empty
	
	public abstract boolean isEmpty(); 
	
	public abstract void removeMax();
	
	
	}
