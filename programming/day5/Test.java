// folder to test stack 


public class Test {
	 public static void main(String[] argv) throws OverFlowException, UnderFlowException {
		 
		 //Constructors for Testing
		 
		 IStack<Double> stack  = new LinkStack<Double>();
		 IQueue<RPNToken> tokens = new RingQueue<RPNToken>(100); 
		 
		 
		 //Test
		 stack.push(3.0); 
		 stack.push(3.0);
		 stack.push(3.0);
		 stack.push(3.0);
		 System.out.println(stack.pop());
		 System.out.println(stack.pop());
		 System.out.println(stack.pop());
		 System.out.println(stack.pop());
		 

		 

	 }
}
