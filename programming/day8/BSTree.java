
public class BSTree<K extends Comparable<K>, V> implements IDict<K, V> {

	private BinaryNode<K, V> root;
	private BinaryNode<K, V> curr;
	private V tempv;
	int TreeSize;
	
	/*
	 * Constructors
	 */
	
	
	BSTree(){
		root = curr = new BinaryNode<K, V>(null, null, null, null);
		TreeSize = 0;
	}
	
	/**
     * Adds a value to the dictionary, replacing the existing value if any.
     * @param k key for the new value
     * @param v value
     * @return the value replaced, otherwise null
     */
    public V add(K k, V v) {
    	curr = root;
    	
    	if(TreeSize == 0) {
    		root.setKey(k);
    		root.setValue(v);
    	
    		
    	TreeSize++;
    	return null;
    	}
    	
    	else {
    		
    		helper(k, v);
    			
    	if(k.compareTo(curr.getKey()) == 0) {		
    			return tempv;
    		
    	}	
    	
    	else {
    		
    		return null;
    	}
    	}	
 }
    	
    
    	
    
    /**
     * Removes a value and key from the dictionary. An unmatched key should return null.
     * @param k key to remove
     * @return the value of the removed key
     */

    public V remove(K k) {
    	// Find the node to remove and it's parent
        BinaryNode<K, V> parent = null;
        // start at the root
        curr = root;
        // while we haven't found the key
        while(curr.getKey()!=k) {
            if(k.compareTo(curr.getKey()) > 0) {
                // walk right
                parent = curr;
                curr = curr.getRight();
            } else {
                // walk left
                parent = curr;
                curr = curr.getLeft();
            }
        }
        // We have the node and it's parent
        
     // Case 1: no children, just kill the node
        // ...could have used isLeaf... but didn't think of that first
        if(curr.isLeaf()) {
        	
        	tempv = curr.getValue();
            if(parent.getRight()==curr) { 
            	parent.setRight(null); 
            }
            if(parent.getLeft()==curr)  { 
            	parent.setLeft(null); 
            }
            curr = root;
            return tempv;
        }
         // Case 2: 1 child, replace node with child
            // ...maybe redundant... might remove later
            if(curr.getRight()==null || curr.getLeft()==null) {
                // Set the parent to point at the child
                if(curr.getRight()==null) {
                    if(parent.getRight()==curr) {
                        parent.setRight(curr.getLeft());
                    } else {
                        parent.setLeft(curr.getLeft());
                    }
                } else {
                    // if(curr.getLeft()==null)
                    if(parent.getRight()==curr) {
                        parent.setRight(curr.getRight());
                    } else {
                        parent.setLeft(curr.getRight());
                    }
                }
                tempv=curr.getValue();
                curr=root;
                return tempv;
            }  
            
            // Case 3: Go right once, go left until you can't, remove that 
            //         left most node, replace the node you wanted to remove
            //         with the left most node
            // Does this work if the curr is the root... Probably not
            BinaryNode<K, V> swapparent = curr;
            BinaryNode<K, V> swapnode = curr.getRight(); // trying to find the one to swap
                                                // into curr's place in the tree
            while(swapnode.getLeft() != null) {
                swapparent=swapnode;
                swapnode=swapnode.getLeft();
            }
            // Have left most node, set the left most parent to the right child
            swapparent.setLeft(swapnode.getRight());
            swapnode.setLeft(curr.getLeft());
            swapnode.setRight(curr.getRight());
            if(parent.getRight()==curr) { parent.setRight(swapnode); }
            if(parent.getLeft()==curr)  { parent.setLeft(swapnode); }
            tempv=curr.getValue();
            curr = root;
            
    	return tempv;
    }
      
    /*
     * recursive method that helps with the add method
     */
    public V helper(K k, V v) {
    	tempv = curr.getValue();
    	
    	if(k.compareTo(curr.getKey()) == 0) {
    		
    		
    		curr.setValue(v);
    		return curr.getValue();
			
		}
		
		else {
    	// Does the new node fit as a direct child
        if((k.compareTo(curr.getKey()) < 0 && curr.getLeft()==null) || (k.compareTo(curr.getKey()) > 0 && curr.getRight()==null) ){
            if(k.compareTo(curr.getKey()) < 0) {
                // insert left
                curr.setLeft(new BinaryNode<K, V>(k,v)); 
            } else {
                // insert right
                curr.setRight(new BinaryNode<K, V>(k,v)); 
            }
            // Work done for the easy case
            
            TreeSize ++;
            return null;
        }
        // Place the node with one of the children, based on if the key
        // goes to the left or the right
        if(k.compareTo(curr.getKey()) < 0) {
            curr = curr.getLeft();
        } else {
            curr = curr.getRight();
        }
        helper(k,v);
    }
		return null; 
    }   
    
    /**
     * Returns the size of the dictionary
     * @return the number of values stored in the dictionary
     */
    public int size() {
    	
    	return TreeSize;
    }
    
    /**
     * Returns the value associated with a particular key in the dictionary.
     * Returns null if there is no matching key.
     * @param k key to retrieve the value for
     * @return the value
     */
    public V fetch(K k) {
    	 curr = root;
     
    	 while((k.compareTo(curr.getKey()) != 0 )) {		//While loop until curr has key = k.
    		 if((k.compareTo(curr.getKey()) < 0 )) {		// If curr.key < k go left other wise go right.
    			 curr = curr.getLeft();
    		 } 
    	 
    		 else {
    			 curr = curr.getRight();
    		 }
    	 }
    	 	
    	 	return curr.getValue();
    	 
    }
    	
    	
    
    /**
     * Returns an array of the keys in the dictionary
     * @return array of all keys
     */
    
	public K[] keys() {
		K[] keyArray = (K[]) new Comparable[TreeSize];
        // Start at root and reset index
        // Node, solve this for me
        root.inOrder(keyArray);

 /*       for(int i=0; i<keyArray.length; i++) {
            System.out.println(keyArray[i]);
        }*/
        return keyArray;
    }
    
    
    
    public V returnV(V v) {
    	
    	return curr.getValue();
    }


public static void main(String[] argv) {
		 IDict<Integer,Integer> tree = new BSTree<Integer, Integer>();
		 
		 

		 System.out.println(tree.add(20, 20));
		
		 System.out.println(tree.add(10, 10));
		 System.out.println(tree.add(30, 30));
		/* System.out.println(tree.add(5, 5));
		 System.out.println(tree.add(15, 15));
		 System.out.println(tree.add(35, 35));
		/* System.out.println(tree.size());
		 System.out.println(tree.add(35, 32));
		 System.out.println(tree.remove(10));	*/
		 System.out.println(tree.keys());
		 // remove worked for all cases except the root
		 
		 
	//	 System.out.println(tree.fetch(1));
	// System.out.println(tree.fetch(0));
		// System.out.println(tree.fetch(2)); */
	//	 System.out.println(tree.size());
}	 
}