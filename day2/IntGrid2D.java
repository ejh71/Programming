
	/**
	 * Implements the methods required for the CS2 day1 exercise
	 */
	public class IntGrid2D implements IIntGrid2D {
		
		/**
		 * Creates the arrary grid used in the setPoint method
		 */
		char [][] grid = new char [3][3];  
		
		/**
		 * Creates the instances need for getupperleft and lowerright
		 */
		IIntPoint2D topl = new IntPoint2D(-1,1);
		
		IIntPoint2D botr = new IntPoint2D(1,-1);
		

	    /**
	     * Sets the value at a point on the grid, replacing the previous value if any.
	     * @param p The coordinate to set the value of
	     * @param v The value to set at the coordinate
	     */
	    public void setPoint(IIntPoint2D p, char v) {
	    	/* Assigns the array a char value at the X and Y value of p
	         */
	    	
	    	grid [p.getX()+1][Math.abs(p.getY()-1)] = v;	    	
	    }
	    
	    /**
	     * Gets the value at a point on the grid
	     * @param p The coordinate to get the value of
	     * @returns the stored value
	     */
	    public char getPoint(IIntPoint2D p) {
	    	
	    	return grid[p.getX()+1][Math.abs(p.getY()-1)];
	    }
	    
	    /**
	     * Gets the coordinate for the upper left most location
	     * @returns an IIntPoint that is the coordinate of the upper left corner
	     */
	    public IIntPoint2D getUpperLeftCorner() {
	    	
	    	
	    	return topl;
	    }	
	    /**
	     * Gets the coordinate for the lower right most location
	     * @returns an IIntPoint that is the lower right corner
	     */
	    public IIntPoint2D getLowerRightCorner() {
	    	
		    
	    	return botr;
	    }
			
	}
		



		