

public class Link<T> {
		private T value;
		private Link<T> next;
	
	Link(T val, Link<T> nextlink){
		this.value = val;
		this.next = nextlink;
		}
		Link(Link<T> nextlink){
			this.next = nextlink;
		}
		
	Link<T> next(){
		
		return next;
	}
	
	void setNext(Link<T> nextlink){
		 this.next = nextlink;
	}
	
	T value() {
		
		return value;
	}
	
	void setValue(T val) {
		this.value = val;
	}
	
	
}