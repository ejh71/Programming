/**
 * Implments a Ring Queue
 */
public class RingQueue<T> implements IQueue<T> {

    int front;
    int back;
    int size; // maximum size
    T[] backingArray;

    /**
     * Constructor for a ring queue
     * @param size Maximum size of the ring queue
     */
    public RingQueue(int size) {
        this.size = size;
        backingArray = (T[])new Object[size];
        front = 0;
        back  = 0;
    }

    /**
     * Dequeues the Front element from the queue
     * @return dequeued element
     * @throws UnderFlowException if dequeueing an empty queue
     */
    public T dequeue() throws UnderFlowException {
        T ret = backingArray[front];
        backingArray[front] = null; // makes the old value really go away (security)
        front = (front+1)%size;
        return ret;
    }
    
    /**
     * Enqueues an element at the back of the queue
     * @param v enqueued element
     * @throws OverFlowException if enqueueing a full queue
     */
    public void enqueue(T v) throws OverFlowException {
        backingArray[back] = v;
        back = (back+1)%size;
    }

    public static void main(String[] argv) throws Exception {
        RingQueue<Integer> r = new RingQueue<Integer>(10);
        r.enqueue(1);
        r.enqueue(2);
        r.enqueue(3);
        System.out.println(r.dequeue());
        System.out.println(r.dequeue());
        System.out.println(r.dequeue());
    }
}
