
public class SelectSort<T extends Comparable>  implements ISort<T> {

	private String name = "Select Sort";
	
	/**
     * Sorts an array of items in place
     * @param in An array to sort
     */
    public void sort(T[] in) {
    	for(int i = 0; i< in.length - 1; i++) { 			//begin by comparing in[0] to all other values of in[]
    		int lowIndex = i;							
    		
    		for(int j = in.length -1; j>i; j--) {			//compare in[0] to the last value and work your way up list
    			if(in[j].compareTo(in[lowIndex]) < 0) {		//if in[0] is less than then swap with that value
    				
    				lowIndex = j;
    				swap(in, i, lowIndex);
    				
    				lowIndex = i;							//reinstalize lowIdx other wise sort has order issues
    			}
    		}
    	}
    }
    
    /**
     * Swaps array values
     * @param T[] an array and two indexes to swap
     */
    public void swap(T[] in, int l, int k) {			
    	T[] temp = in;
    	T swap1 = temp[l];
    	T swap2 = temp[k];
    	
    	temp[l] = swap2;
    	temp[k] = swap1;
    }
    /**
     * Produces the name of the kind of sort implemented
     * @return the name of the sort algorithm
     */
    public String sortName() {
    	
    	return name;
    }



    public static void main(String[] argv) {
		
    	ISort[] sorts = new ISort[2];
        sorts[0] = new SelectSort<Integer>();
    	
        Integer[] array;
    	
    	
    	array = new Integer[6];
    	array[0] = 5;
    	array[1] = 2;
    	array[2] = 6;
    	array[3] = 1;
    	array[4] = 3;
    	array[5] = 4;
    /*	for(int i = 0; i < array.length; i++) {
    		array[i] = array.length - i;
    	} */
    	
    	System.out.println(array[0]);
    	System.out.println(array[1]);
    	System.out.println(array[2]);
    	System.out.println(array[3]);
    	System.out.println(array[4]);
    	System.out.println(array[5]); 
   // 	System.out.println(array.length);
    	
    	System.out.println(" ");

    	
    //	sorts[0].swap(array, 0, 2);
    	
   /* 	System.out.println(array[0]);
    	System.out.println(array[1]);
    	System.out.println(array[2]);
   /* 	System.out.println(array[3]);
    	System.out.println(array[4]);
    	System.out.println(array[5]); */
    	
    	
    	System.out.println(" ");
    	System.out.println(" ");
    	sorts[0].sort(array);
    	
    	System.out.println(array[0]);
    	System.out.println(array[1]);
    	System.out.println(array[2]);
    	System.out.println(array[3]);
    	System.out.println(array[4]);
    	System.out.println(array[5]);  
    }

}