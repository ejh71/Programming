/**
 * Implements the methods required for the CS2 day1 exercise
 */
public class IntPoint2D implements IIntPoint2D {
	
	int X;
	int Y;
	
	/**
     * Constructor that takes in an x and y integer
     */
	public IntPoint2D(int Xvalue, int Yvalue) {
		X = Xvalue;
		Y = Yvalue;
	}

	 /**
     * @returns the X coordinate
     */
    public int getX() {
    	
    	return X;
    }
    /**
     * @returns the Y coordinate
     */
    public int getY() {
    	
    	return Y;
    }
	   
    /**
     * Computes the manhattan distance to another point. 
     * formula: abs(x1-x2) + abs(y1-y2)
     * @param o the other point
     * @returns the manhattan distance
     */
    public int manhattanDistance(IIntPoint2D o) {
    	int Xdifference = Math.abs(o.getX() - this.X);
    	int Ydifference = Math.abs(o.getY() - this.Y);
    		int Mdifference = Xdifference + Ydifference;
    	
    	return Mdifference;
    }
    /**
     * Computes the euclidean distance to another point. 
     * formula: sqrt((x1-x2)^2 + (y1-y2)^2)
     * @param o the other point
     * @returns the euclidean distance
     */
    public double distance(IIntPoint2D o) {
    	int Xdist = (o.getX() - this.X);
    	int Xdistsquared = Xdist * Xdist;
    	int Ydist = (o.getY() - this.Y);
    	int Ydistsquared = Ydist * Ydist;
    	
    	double distsquare = Xdistsquared + Ydistsquared;
    	double Edistance = Math.sqrt(distsquare);
    	
    	return Edistance;
    }
    
    // The following methods make JAVA objects better behaved
    /**
     * Converts a point object to a string of the form (X,Y)
     * @returns human friendly point representation
     */
    public String toString() {
    	
    	return "("+ X +","+ Y +")";
    }
    /**
     * Determines if this point is the same as another (i.e. x1=x2 and y1=y2)
     * @returns true if this point is the same as point o
     */
    public boolean equals(IIntPoint2D o) {
    	if(o.getX() == this.X && o.getY() == this.Y) {return true;}    	
    	
    	else {return false;}
    	
    }
    /**
     * Hashcode to support some standard library data structures
     * formula: (x<<16)+y
     * @returns the hashcode for the point
     */
     public int hashcode() {
    	int hash = (this.X<<16) + this.Y;
    	
    	return hash;
    } 

     public static void main(String[] argv) {
    	 
    	 IntPoint2D point = new IntPoint2D(2, 2);
    	 IntPoint2D dot = new IntPoint2D(2, 2);
    	 
    	 System.out.println(point.getX());
    	 System.out.println(point.getY());
    	 System.out.println(point.toString());
    	 System.out.println(point.distance(dot));
    	 System.out.println(point.manhattanDistance(dot));
    	 System.out.println(point.equals(dot));
     }
     

}





