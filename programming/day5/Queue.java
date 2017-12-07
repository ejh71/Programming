
public class Queue<T> implements IQueue<T> {
	
	private int defaultSize = 110;
	private int maxSize;
	private int front;
	private int rear;	
	private T [] listArray;
	
	Queue(int size){
		maxSize = size + 1;
		rear = 0;
		front = 1;
		listArray = (T[]) new Object[maxSize];
	}
	
    /**
     * Dequeues the Front element from the queue
     * @return dequeued element
     * @throws UnderFlowException if dequeueing an empty queue
     */
    public T dequeue() throws UnderFlowException{
    	T v = listArray[front];
    	front = (front +1) % maxSize;
    	return v;
    }
    
    /**
     * Enqueues an element at the back of the queue
     * @param v enqueued element
     * @throws OverFlowException if enqueueing a full queue
     */
    public void enqueue(T v) throws OverFlowException{
    	rear = (rear+1) % maxSize;
    	listArray[rear] = v;
    }  
}  
