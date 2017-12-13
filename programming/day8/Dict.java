
public class Dict<K extends Comparable<K>, V> implements IDict<K, V> {

	private DoubleLinkListTP<K, V> LinkedList ;	
	int listSize;
	
	
	
		Dict(){
			LinkedList = new DoubleLinkListTP<K, V>();
		}
	
	
	  /**
     * Adds a value to the dictionary, replacing the existing value if any.
     * @param k key for the new value
     * @param v value
     * @return the value replaced, otherwise null
     */
    public V add(K k, V v) {

    	//check for existing K
    	//if no Key has value K then append K and V.
    	
    		if(LinkedList.findKey(k) == null) {		
    			LinkedList.append(k, v);
    		
    			listSize++;
    			return null;
    		}
    	   	
    	
    	
    	//if K exists move to and replace.
    	else {  		
    		LinkedList.movetoKey(k);
    		LinkedList.replaceValue(v);
    		
    		return v;
    	}
    		
    } 

    	
    	
//  }
    
    /**
     * Removes a value and key from the dictionary. An unmatched key should return null.
     * @param k key to remove
     * @return the value of the removed key
     */
    public V remove(K k) {
    	V tempValue;
    	
    	LinkedList.movetoKey(k);
    	tempValue = LinkedList.fetch();
    	LinkedList.remove();
    	
    	listSize --;
    	return tempValue;
    }
    
    /**
     * Returns the size of the dictionary
     * @return the number of values stored in the dictionary
     */
    public int size() {
    	
    	return listSize;
    }
    
    /**
     * Returns the value associated with a particular key in the dictionary.
     * Returns null if there is no matching key.
     * @param k key to retrieve the value for
     * @return the value
     */
    public V fetch(K k) {
    	LinkedList.movetoKey(k);
    
    	return LinkedList.fetch();
    }
    
    
    /**
     * Returns an array of the keys in the dictionary
     * @return array of all keys
     */
    public K[] keys() {		// Be sure to figure out how to print K[] instead of int[]
    	
    	K[] keyArray = (K[]) new Comparable[listSize];
    	LinkedList.jumpToHead();		
    	
    	
    	for(int i=0; i<listSize; i++) {
    		keyArray[i] = LinkedList.getKey();
    		LinkedList.next();
    	}
    	
    	return keyArray; 
    	
    }
    
    public V returnV(V v) {
    	return v;
    }
	
    public static void main(String[] argv) {
 		 IDict<Integer,Integer> dict = new Dict<Integer, Integer>();
 		 
 		System.out.println(dict.add(1,1));
 	/*	System.out.println(dict.add(2,43));
 		System.out.println(dict.add(2,13));
 		System.out.println(dict.add(2,13));
 		System.out.println(dict.add(2,13));*/
 		 dict.add(1,1);
 		 dict.add(2,45);
 		 dict.add(3,5674);  
 		 dict.add(2,53);
 		dict.add(4,67);
 		dict.add(5,85);
 		dict.add(6,99);
 		System.out.println(dict.fetch(3)); 
 		System.out.println(dict.size()); 
 		
 		System.out.println(dict.remove(4)); 
 		System.out.println(dict.size()); 
 		System.out.println(dict.keys()); 
 		 
    }
    
}
