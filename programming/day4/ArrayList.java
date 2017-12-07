/**
 * List interface based on the 11/29 discussion of what a program using lists might
 * need to do. This will be our definition for the list ADT this block.
 */
public class ArrayList<T> implements IList<T> {
	
	private int defaultSize = 120;
	private int maxSize;
	private int listSize;
	private int curr;	
	private T [] backingArray;
	private T [] listArray;
	T v;


ArrayList() {
	
	listSize = curr = 0;
	listArray = (T[]) new Object[defaultSize];

	}
	
    /**
     * Inserts an item at a specific index in the list
     * @param idx where the item should be inserted
     * @param v the value to insert
     */
    public void insert(int idx, T v) {
    	backingArray = listArray.clone(); 
    	
    	int i = (Integer) v;
    	listArray[idx] = v;   	
    	for(int g=idx; g<listSize; g++) {
			listArray[g+1] = backingArray[g];
		}
    }
    
	/**
	 * Adds an item to the end of list. Called 'Add' in class, but more usually called 
	 * append in other libraries. Moves <i>current</i> to the end of the list.
	 * @param v Item to add
	 */
	public void append(T v) {
		if(listSize == 0) {
			listArray[0] = v;
		}
		listArray[listSize++] = v;
		

	}
		
	
	
	/**
	 * Removes the item at the <i>current</i> index in the list. <i>Current</i> becomes 
	 * the previous item in the list, if such element exists.
	 */
	public void remove() {
		backingArray = listArray.clone();
		
		for(int i=curr; i<(listSize-1); i++) {
			listArray[i] = backingArray[i+1];
		}
		
		listSize--;
	}	
	
	/**
	 * Removes the item at a specific index
	 * @param idx index of item to remove
	 */
	public void remove(int idx) {
		backingArray = listArray.clone(); 
		/*for(int i = 0; i <listSize; i++) {
		System.out.println(listArray[i]); 	
		}*/
		
		for(int i=idx; i<listSize-1; i++) {
			listArray[i] = backingArray[i+1];
		}
		listSize--;
	}
	
	/**
	 * Changes the location of an existing element in the list
	 * @param sidx - The initial index for the element to move
	 * @param didx - The final index for the element to move
	 */
	public void move(int sidx, int didx) {
		backingArray = listArray.clone();  /*assigns the final index the value of the initial index */ 

		listArray[didx] = listArray[sidx];
		
		if(sidx < didx) {
		for(int sidxHolder = sidx; sidxHolder<didx; sidxHolder++) {
			listArray[sidxHolder]=backingArray[sidxHolder+1];	/*shifts the list values down to the initial index value. All values after will be unaffected by the move */
		}
	}
		
		 if(didx < sidx) {
			 for(int didxHolder = didx; didxHolder<sidx; didxHolder++) {
					listArray[didxHolder+1]=backingArray[didxHolder];	/*shifts the list values down to the initial index value. All values after will be unaffected by the move */
				}

		}  
		
	}
	
	/**
	 * Fetches the value at the <i>current</i> index in the list.
	 * @return the requested item
	 */
	public T fetch() {
		
		return listArray[curr];
	}
	
	/**
	 * Fetches the value at a specific index in the list.
	 * @param idx index of the item to return
	 * @return the requested item
	 */
	public T fetch(int idx) {
		
		return listArray[idx];
	}
	
	/**
	 * Advances the <i>current</i> index to the next index, if possible.
	 */
	public void next() {
		curr++;
	}
	
	/**
	 * Advances the <i>current</i> index to the previous index, if possible.
	 */
	public void prev() {
		curr--;
	}
	
	/**
	 * Advances the <i>current</i> to the tail element
	 */
	public void jumpToTail() {
		curr = listSize-1;
	}
	
	/**
	 * Advances the <i>current</i> to the head element
	 */
	public void jumpToHead() {
		curr = 0;
	}

	/**
	 * Returns the number of elements in the list
	 */
	public int size() {
		
		return listSize;
	}
}