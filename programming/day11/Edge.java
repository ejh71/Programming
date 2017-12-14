
public class Edge<N, W> implements IEdge<N, W> {

    // Field
    W weight;
    Edge<N,W> tee;

    // Nodes connected by this edge
    INode<N> a;
    INode<N> b;
	
    public Edge(INode<N> source, INode<N> destination, W w) {
        this.a = source;
        this.b = destination;
        weight = w;
    }

    
	
	 // Implementors should implement a construct that takes in the 
    // source, destination, and weight
    
    /**
     * The source node of the edge
     * @return the source node
     */
    public INode<N> getSource(){
    	
    	return a;
    }
    
    /**
     * The destination node of the edge
     * @return the destination node
     */
    public INode<N> getDestination(){
    	
    	return b;
    }
    
    /**
     * The weight of the edge
     * @return the weight
     */
    public W getWeight() {
    	
    	
    	return weight;
    }
    
    /**
     * Test for equality of two edges.
     * Edges are equal when the node instances are exactly the same; i.e. this.src==o.src
     * and this.dst == o.dst
     * @param o the other edge
     * @return true if the edges are the same
     */
    public boolean equals(Object o) {
        Edge t = (Edge)o;
        if(t == t.tee) { return true; }
        return false;
    }
}
