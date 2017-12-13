
public class BinaryNode<K extends Comparable<K>, V> {

	private K key;						//Key for link
	private V value;					/*Value for the given link */					
	private BinaryNode<K, V> left;		/*pointer to left node */
	private BinaryNode<K, V> right;		/*pointer to the previous link*/
	private int idx;

	
	BinaryNode(K k, V v, BinaryNode<K,V> l, BinaryNode<K, V> r){
		key = k;
		value = v;
		left = l;
		right = r;
	}

	BinaryNode(K k, V v){
		key = k;
		value = v;
		left = null;
		right = null;
	}
	
	BinaryNode(){
		key = null;
		value = null;
		left = null;
		right = null;
	}
	
	/*
	 * Sets the left child of the parent node
	 * parameter: l
	 */
	public void setLeft(BinaryNode<K, V> l){
		 left = l;
	}
	
	/*
	 * Gets and return the left child
	 * return: left child
	 */
	public BinaryNode<K, V> getLeft(){
		 
		return left;
	}
	
	/*
	 * Sets the right child of the parent node
	 * parameter: r
	 */
	public void setRight(BinaryNode<K, V> r){
		 right = r;
	}
	
	/*
	 * Gets and return the left child
	 * return: left child
	 */
	public BinaryNode<K, V> getRight(){
		 
		return right;
	}
	
	/*
	 * Sets value of current node
	 * parameter: val
	 */
	public void setValue(V val) {
		value = val;
	}
	
	/*
	 * Gets value of current node
	 * Return: value
	 */
	public V getValue() {
		
		return value;
	}
	
	/*
	 * Sets value of current node
	 * parameter: val
	 */
	public void setKey(K ky) {
		key = ky;
	}
	
	/*
	 * Gets the key of the current node
	 * Return: key
	 */
	
	public K getKey() {
		if(key == null) {
			
			return null;
		}
		else{
			return key;
		}
	}	
	
	/*
	 * Determines wether or not curr is a leaf
	 */
	public boolean isLeaf() {
		
        if(left==null && right==null) {
            return true;
        }
        return false;
	}
	
	
	public void inOrder(K[] arr) {
        if(left!=null) {
            // If there's a left child, make this the left childs problem
            left.inOrder(arr);
        }
        // Contribute my value to the array
        arr[idx] = key;
        idx=(idx+1)%arr.length; // loop to allow calling again
        if(right!=null) {
            // If there's a right child, make this the right childs problem
            right.inOrder(arr);
        }
    }
		
	
	public static void main(String[] argv) {
		 BinaryNode<Integer,Integer> tree = new BinaryNode<Integer, Integer>();
		 
		 tree.setLeft(null);		
		 System.out.println(tree.getRight());
		 System.out.println(tree.getKey());
		 
}
}