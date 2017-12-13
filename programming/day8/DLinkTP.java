
public class DLinkTP<K, V> implements IDLinkTP<K, V> {
	
	private V value;			/*Value for the given link */
	private K key;				//Key for link
	private DLinkTP<K, V> next;		/*pointer to next link */
	private DLinkTP<K, V> prev;		/*pointer to the previous link*/
	
	
	/*
	 * Constructors
	 */
	DLinkTP(K ky, V val, DLinkTP<K, V> nextlink, DLinkTP<K, V>prevlink){
		key = ky;
		value = val;
		next = nextlink;
		prev = prevlink;
	}
		DLinkTP(DLinkTP<K, V> nextlink, DLinkTP<K, V> prevlink){
			next = nextlink;
			prev = prevlink;
	}
	
	
	/*
	 * Methods for get and set
	 */
	
		public DLinkTP<K, V> getNext(){
			
			return next;
		}
		
		public void setNext(DLinkTP<K, V> nextlink){
			 next = nextlink;
		}
		
		public DLinkTP<K, V> getPrev(){
			
			return prev;
		}
		
		public void setPrev(DLinkTP<K, V> prevlink){
			 prev = prevlink;
		
		}
		
		public V getValue() {
			
			return value;
		}
		
		public void setValue(V val) {
			value = val;
		}
	
		
		public K getKey() {
			if(key == null) {
				
				return null;
			}
			else{
				return key;
			}
		}		
}
