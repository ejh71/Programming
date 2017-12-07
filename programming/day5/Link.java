

public class Link<T> {
		private T value;
		private Link<T> next;
	
	Link(T val, Link<T> nextlink){
		value = val;
		next = nextlink;
		}
		Link(Link<T> nextlink){
			next = nextlink;
		}
		
	Link<T> next(){
		
		return next;
	}
	
	void setNext(Link<T> nextlink){
		 next = nextlink;
	}
	
	T value() {
		
		return value;
	}
	
	void setValue(T val) {
		value = val;
	}
	
	
}