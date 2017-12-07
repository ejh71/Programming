
public class DLink<T> implements IDLink<T> {
	
	private T value;			/*Value for the given link */
	private DLink<T> next;		/*pointer to next link */
	private DLink<T> prev;		/*pointer to the previous link*/
	
	
	/*
	 * Constructors
	 */
	DLink(T val, DLink<T> nextlink, DLink<T>prevlink){
		value = val;
		next = nextlink;
		prev = prevlink;
	}
		DLink(DLink<T> nextlink, DLink<T> prevlink){
			next = nextlink;
			prev = prevlink;
	}
	
	
	/*
	 * Methods for get and set
	 */
	
		public DLink<T> getNext(){
			
			return next;
		}
		
		public void setNext(DLink<T> nextlink){
			 next = nextlink;
		}
		
		public DLink<T> getPrev(){
			
			return prev;
		}
		
		public void setPrev(DLink<T> prevlink){
			 prev = prevlink;
		
		}
		
		public T getValue() {
			
			return value;
		}
		
		public void setValue(T val) {
			value = val;
		}
	
}
