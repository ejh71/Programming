
	/**
	 * Implements the methods required for the CS2 day1 exercise
	 */
	public class IntGrid2D implements IIntGrid2D {
		private char defaultChar;
		private IIntPoint2D topLeft;
		private IIntPoint2D botRight;
		char [][] grid = new char [3][3];
		
		/*
		 * Constructors
		 */
		IntGrid2D(int upLx, int upLy, int lowRx, int lowRy, char car){
			topLeft = new IntPoint2D(upLx, upLy);
			botRight = new IntPoint2D(lowRx, lowRy);
			defaultChar = car;
		}

	    /**
	     * Sets the value at a point on the grid, replacing the previous value if any.
	     * @param p The coordinate to set the value of
	     * @param v The value to set at the coordinate
	     */
	    public void setPoint(IIntPoint2D p, char v) {	    	
	    	grid [p.getX()+1][Math.abs(p.getY()-1)] = v;	    	
	    }
	    
	    /**
	     * Gets the value at a point on the grid
	     * @param p The coordinate to get the value of
	     * @returns the stored value
	     */
	    public char getPoint(IIntPoint2D p) {return grid[p.getX()+1][Math.abs(p.getY()-1)];}
	    
	    /**
	     * Gets the coordinate for the upper left most location
	     * @returns an IIntPoint that is the coordinate of the upper left corner
	     */
	    public IIntPoint2D getUpperLeftCorner() {return topLeft;}	
	    
	    /**
	     * Gets the coordinate for the lower right most location
	     * @returns an IIntPoint that is the lower right corner
	     */
	    public IIntPoint2D getLowerRightCorner() {return botRight;}
	    
	    
	    
	    
	    public static void main(String[] argv) {
	    	 
	    	 IntGrid2D grid = new IntGrid2D(-1, 5, 1, -4, 'f');
	    	 IntPoint2D dot = new IntPoint2D(-1,-1);
	    	 IntPoint2D point = new IntPoint2D(0,0);
	    	 grid.setPoint(dot, 'X');
	    	 grid.setPoint(dot, 'Y');
	    	 
	   	 System.out.println(grid.getPoint(dot));
	    	 System.out.println(grid.getLowerRightCorner());
	    	 System.out.println(grid.getUpperLeftCorner());
	    	 
	    	 
	    	 System.out.println(point.distance(dot));
	    	 System.out.println(point.manhattanDistance(dot));
	    	 System.out.println(point.equals(dot)); 
	     }
	    
	    
	}
		



		