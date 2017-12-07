/**
 * The class for the link cells in a singlely linked list
 */
public class SingleLinkList<T> implements IList<T> {
    
	private Link<T> head;
	private Link<T> tail;
	private Link<T> curr;
	private Link<T> temp;
	private Link<T> extratemp;
	int listSize;
	
	SingleLinkList(int size){
		this();
	}
	SingleLinkList() {
		this.curr = this.tail = new Link<T> (null, null);
		this.head = new Link<T> (null , curr);
		

	/*	head.setNext(tail); */
		listSize = 0;
	}
		
	
	
    
    
    public void insert(int idx, T v) {
    	
  		curr = head;
  		temp = head;
  		for(int i=0; i<idx; i++) {
  			curr = curr.next(); 
  			temp = temp.next();
  		}
  		curr.setNext(new Link<T>(v, temp.next()));  		
  		listSize++;

  	
    }
    	
  	/**
  	 * Adds an item to the end of list. Called 'Add' in class, but more usually called 
  	 * append in other libraries. Moves <i>current</i> to the end of the list.
  	 * @param v Item to add
  	 */
    

  	public void append(T v) { 	
  		temp = head;
  		
  		
  		
  		while(temp.next() != tail) {
  			temp = temp.next(); 
  		}
  		
  		temp.setNext(new Link<T>(v, tail));
  		
  		listSize++;

  	}
  	
  	/**
  	 * Removes the item at the <i>current</i> index in the list. <i>Current</i> becomes 
  	 * the previous item in the list, if such element exists.
  	 */
  	public void remove() {
  		if(curr == null) {
  			
  		}
  		
  		if(tail == curr.next()) {
  			tail = curr;
  		}
  		curr.setNext(curr.next().next());
  		listSize--;
  		
  	}	
  	/**
  	 * Removes the item at a specific index
  	 * @param idx index of item to remove
  	 */
  	public void remove(int idx) {
  		curr = head;
  		

  		
  		for(int i = 0; i < idx; i++) {
  			curr = curr.next();
  	  		
  		}
  		curr.setNext(curr.next().next());
  		
  		
  		listSize--;
  		
  	}
  	
  	/**
  	 * Changes the location of an existing element in the list
  	 * @param sidx - The initial index for the element to move
  	 * @param didx - The final index for the element to move
  	 */
  	public void move(int sidx, int didx) {
  		curr = head;
  		temp = head;
  		for(int i = -1; i < sidx-1; i++) {
  			curr = curr.next();
  		}
  		//copy sidx cell
  		
  		curr.setNext(curr.next());
  		//set sidx cell next to didx +1
  		
  		for(int i = -1; i < sidx-2; i++) {
  			temp = temp.next();
  		}
  		
  		//set sidx -1 cell next to sidx +1
  		
  		
  		
  		T v;
  		
  		if(sidx<didx){
  		curr = head.next();
  		for(int i = 0; i < sidx-1; i++) {
  			curr = curr.next();
  		}
  		v = curr.value();
  		
  		remove(sidx);
  		insert(didx, v);
  		}
  		
  		if(didx<sidx) {
  			temp = head.next();
  	  		for(int i = 0; i < sidx+1; i++) {
  	  			temp = temp.next();
  	  		}
  	  		v = temp.value();
  	  		
  	  		remove(sidx);
  	  		insert(didx+1, v);	
  		}
  	} 	
  		
  	
  	
  	/**
  	 * Fetches the value at the <i>current</i> index in the list.
  	 * @return the requested item
  	 */
  	public T fetch() {
  		if(curr.next() == null) {
  			
  			return null;
  		}
  		
  		return curr.next().value();
  	}
  	/**
  	 * Fetches the value at a specific index in the list.
  	 * @param idx index of the item to return
  	 * @return the requested item
  	 */
  	public T fetch(int idx) {
  		curr = head;
  		for(int i = 0; i < idx; i++) {
  			curr = curr.next();
  		}
  		
  		return curr.next().value();
  	}
  		
  	/**
  	 * Advances the <i>current</i> index to the next index, if possible.
  	 */
  	public void next() {
  		if(curr != tail) {
  			curr = curr.next();
  		}
  	}
  	
  	/**
  	 * Advances the <i>current</i> index to the previous index, if possible.
  	 */
  	public void prev() {
  		if(curr == head) {
  			
  			return;
  		}
  		
  	    temp = head;
  	   while(temp.next() != curr) {
			temp = temp.next(); 
		}
  		curr = temp;
  	}		
  	/**
  	 * Advances the <i>current</i> to the tail element
  	 */
  	public void jumpToTail() {
  		while(temp.next() != tail) {
  			temp = temp.next(); 
  		}
  		curr = temp;

  	}
  	
  	/**
  	 * Advances the <i>current</i> to the head element
  	 */
  	public void jumpToHead() {
  		curr = head;
  	}
  	
  	

  	/**
  	 * Returns the number of elements in the list
  	 */
  	public int size() {
  		
  		return listSize;
  	}
}