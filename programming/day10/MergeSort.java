/*
 * I received a lot of help structuring this class from url: https://stackoverflow.com/questions/13727030/mergesort-in-java
 * reading over the code was the single largest "oh duh" moment I've had in any compsci class.
 * This greatly helped my understanding of recursion within a method. Especially a method that calls another method at each 
 * level it is used.
 */

public class MergeSort<T extends Comparable>  implements ISort<T> {
	
	private T[] temp;
	private String name = "Merge Sort";
	/**
     * Sorts an array of items in place
     * @param in An array to sort
     */
    public void sort(T[] in) {
    	if(in.length > 1) {
    	
    	int mid = in.length/2;						//Determining the lengths for the arrays
    	int othermid = in.length - mid;
    	
    	T[] leftArray = (T[]) new Comparable[mid];	//Creating the new arrays each 1/2 size of the original
		for(int i = 0; i<mid; i++) {				//for odd length arrays othermid = mid+1
			leftArray[i] = in[i];
		}
		
		T[] rightArray = (T[]) new Comparable[othermid];
			for(int i = 0; i<othermid; i++) {
				rightArray[i] = in[mid+i];
		} 

    		sort(leftArray);							//recursivly calls the sort method till the arrays are length 1
    		sort(rightArray);
    		merge(in, leftArray, rightArray);			//merging arrays
    		
    	}	
    }
    
    
    public T[] merge(T[] in, T[] left, T[] right) {

    	temp = in;
    	int tempSize = temp.length;
    	
    	int l = 0;												//Counters for the left right and mergered arrays
    	int r = 0;
    	int curr = 0;
    	
    	while( curr< tempSize ) {
    		if((l < left.length && r < right.length )) {		//If neither array is exhausted compare the first values then
    			if(left[l].compareTo(right[r]) < 0) {			//Add to mergered array and updated counters until one array
    				temp[curr] = left[l];						//Is exhausted
    				
    				curr++;
    				l++;
    			}
    			
    			else {											
    				temp[curr] = right[r];
    				
    				curr++;
    				r++;
    			}
    		}	
    			else {											//If left array is exhausted fill in with right array 
    				if(l >= left.length) {
    					while(r < right.length){
    						temp[curr] = right[r];
    						
    						curr++;
    						r++;    						
    					}
    				}
    				
    				if(r >= right.length) {						//If right array is exhausted fill in with left array
    					while(l < left.length){
    						temp[curr] = left[l];
    						
    						curr++;
    						l++;    						
    					}
    				}
    			}	
    		}	
    		return temp;
    }
    /**
     * Produces the name of the kind of sort implemented
     * @return the name of the sort algorithm
     */
    public String sortName() {
    	
    	return name;
    }
    
    public void swap(T[] bum, int l, int k) {  //added because my select sort used a swap method
    	
    }
    
public static void main(String[] argv) {
		
    	ISort[] sorts = new ISort[2];
        sorts[0] = new MergeSort<Integer>();
    	
        Integer[] array;
    	
    	
    	array = new Integer[6];
    	array[0] = 5;
    	array[1] = 2;
    	array[2] = 6;
    	array[3] = 1;
    	array[4] = 3;
    	array[5] = 4;
    	
    	
    	System.out.println(array[0]);
    	System.out.println(array[1]);
    	System.out.println(array[2]);
    	System.out.println(array[3]);
    	System.out.println(array[4]);
    	System.out.println(array[5]); 
    	
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
