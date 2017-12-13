
public class DoubleLinkListTP<K, V> implements IListTP<K, V>{
	
	private DLinkTP<K, V> head;
	private DLinkTP<K, V> tail;
	private DLinkTP<K, V> curr;
	private DLinkTP<K, V> temp;
	K tempKey;
	int listSize;
	
	
	
	DoubleLinkListTP() {
		this.head = new DLinkTP<K, V> (null, null, null, null);
		// Make a head with no pointers
		
		this.curr = this.tail = new DLinkTP<K, V> (null, null, null, head);
		// Make a tail and curr which point back to head
		
		head.setNext(tail);
		// Set next for head to tail
		
		listSize = 0;
	}
		
	
	

    
    public void insert(int idx, K k, V v) {
  		curr = head;
  		temp = new DLinkTP<K, V>(k, v, null, null); 
  		for(int i=0; i<idx; i++) {
  			curr = curr.getNext(); 
  		}
  		
  		temp.setNext(curr.getNext()); 
  		temp.setPrev(curr);
  		curr.getNext().setPrev(temp);
  		curr.setNext(temp);
  		listSize++;

    }
    	
  	/**
  	 * Adds an item to the end of list. Called 'Add' in class, but more usually called 
  	 * append in other libraries. Moves <i>current</i> to the end of the list.
  	 * @param v Item to add
  	 */
  	public void append(K k, V v) {

  		
  		//set next of t.prev.prev to t.prev 
  		
  		temp = new DLinkTP<K, V>(k, v, tail, tail.getPrev());
  		// make new cell
  		//set new cell prev to T prev
  		//set new cell next to T
  		
  		tail.setPrev(temp);
  		//set T prev to new 
  		
  		tail.getPrev().getPrev().setNext(tail.getPrev());
  		//set next of t.prev.prev to t.prev 
  		
  		listSize++;
  	}
  	
  	/**
  	 * Removes the item at the <i>current</i> index in the list. <i>Current</i> becomes 
  	 * the previous item in the list, if such element exists.
  	 */
  	public void remove() {
  		
  		if(curr == null) {
  			
  		}
  		
  		if(tail == curr.getNext()) {
  			tail = curr;
  		}
  		curr.getPrev().setNext(curr.getNext()); 
  		curr.getNext().setPrev(curr.getPrev());
  		curr.setPrev(null);
  		curr.setNext(null);
  		listSize--;
  		
  	}	
  	/**
  	 * Removes the item at a specific index
  	 * @param idx index of item to remove
  	 */
  	public void remove(int idx) {
  		curr = head;
  		 
  		for(int i=-1; i<idx; i++) {
  			curr = curr.getNext(); 
  		}
  		
  		curr.getPrev().setNext(curr.getNext()); 
  		curr.getNext().setPrev(curr.getPrev());
  		curr.setPrev(null);
  		curr.setNext(null);
  		
  		listSize--;
  		
  	}
  	
  	/**
  	 * Changes the location of an existing element in the list
  	 * @param sidx - The initial index for the element to move
  	 * @param didx - The final index for the element to move
  	 */
  /*	public void move(int sidx, int didx) { 
  		V v; 
  		K k;
  		curr = head;
  		
  		
  		for(int i = -1; i < sidx; i++) {
  			curr = curr.getNext();
  		}
  		v = curr.getValue();
  		
  		remove(sidx);
  		insert(sidx, k, v);
  		
  		
  	} */
  		
  	
  	
  	/**
  	 * Fetches the value at the <i>current</i> index in the list.
  	 * @return the requested item
  	 */
  	public V fetch() {
  		if(curr.getNext() == null) {
  			
  			return null;
  		}
  		
  		return curr.getValue();
  	}
  	/**
  	 * Fetches the value at a specific index in the list.
  	 * @param idx index of the item to return
  	 * @return the requested item
  	 */
  	public V fetch(int idx) {
  		curr = head;
  		for(int i = -1; i < idx; i++) {
  			curr = curr.getNext();
  		}
  		
  		return curr.getValue();
  	}
  		
  	/**
  	 * Advances the <i>current</i> index to the next index, if possible.
  	 */
  	
  	/*Apperently this throws null pointer on the last test. No idea why */
  	public void next() {
  		if(curr != tail) 
  			curr = curr.getNext();
  	}
  	
  	
  	/**
  	 * Advances the <i>current</i> index to the previous index, if possible.
  	 */
  	public void prev() {
  		if(curr != head) {
  			curr = curr.getPrev();
  			
  		}
  		
  	}		
  	/**
  	 * Advances the <i>current</i> to the tail element
  	 */
  	public void jumpToTail() {
  		curr = tail.getPrev();
  	}
  	
  	/**
  	 * Advances the <i>current</i> to the head element
  	 */
  	public void jumpToHead() {
  		curr = head.getNext();
  	}

  	/**
  	 * Returns the number of elements in the list
  	 */
  	public int size() {
  		
  		return listSize;
  	}
    
  	public K findKey(K k) {
  		curr = head;
  		tempKey = k;
  		
  		
  		for(int i=0; i< listSize && tempKey != curr.getKey(); i++) {
  			curr = curr.getNext();
  		}
  		
  		if(tempKey == curr.getKey()){
  			return curr.getKey();
  		}
  		
  		else{
  			
  			return null;
  		}
  	}
  	
  	public void movetoKey(K k) {
  		curr = head;
  		tempKey = k;
  		
  		
  		while(tempKey != curr.getKey()) {
  			curr = curr.getNext();
  		}
  	}
  	
  	public K getKey() {
  		
  		return curr.getKey();
  	}
  	
  	
  	
  	
  	public void replaceValue(V v) {
  		curr.setValue(v);
  	}
  	
  	
  	public static void main(String[] argv) {
  		 IListTP<Integer,Integer> list = new DoubleLinkListTP<Integer, Integer>();
  		 
  		 list.append(1,1);
  		 list.append(2,3);
  		 list.append(3,5);
  		list.append(4,8);
  		list.append(5,12);
  		list.append(6,55);
  		list.append(7,101);
  		
  		list.insert(5, 87, 4546);
  		
  		System.out.println(list.findKey(5));
  		System.out.println(list.findKey(8));
  		
  		list.jumpToHead();
  		list.next();
  		list.next();
  		list.next();
  		list.next();
  		System.out.println(list.getKey());
  		
   	/*	System.out.println(list.fetch(0));
   		System.out.println(list.findKey(1));
   		System.out.println(list.fetch(1));
   		System.out.println(list.findKey(2));
   		System.out.println(list.fetch(2));
   		System.out.println(list.findKey(3));
   		System.out.println(list.fetch(3));
   		
   		
   		
   		
   		//System.out.println(list.Key(87));
 /*  		list.movetoKey(87);
   		
   		System.out.println(list.fetch());
   		
   		//list.movetoKey(7);
   	//	System.out.println(list.fetch());
   		
   	//	System.out.println(""); */
   	  		

 		
 		
 		
 		}   
  	
}
