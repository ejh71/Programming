public class LinkStack<T> implements IStack<T>{
	
	Link<T> top = null;	
	
	
    /**
     * Pushes a new value onto the stack
     * @param v the value to push
     */
    public void push(T v) throws OverFlowException{
    	Link<T> nLink = new Link<T>(v, top);
    	top = nLink;
    }
    
    /**
     * Pops the top value from the stack
     * @return the value
     */
    public T pop() throws UnderFlowException{
    	if(top == null) {
    		throw new UnderFlowException();
    	}
    	
    	Link<T> r = top;
    	top = top.next();
    	return r.value();
    }
	
}
