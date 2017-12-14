
public class Graph<N, W> implements IGraph<N, W> {
	
    IList<Node<N>> nodes; // 
    IList<Edge<N, W>> edges; // 
    Node<N> curr; 

    public Graph() {
        nodes = new DoubleLinkList<Node<N>>();
        edges = new DoubleLinkList<Edge<N, W>>();
        curr  = null;
    }

	
	
	
	/**
     * Gets an array of all the nodes in the graph
     * @return the node set
     */
    public INode<N>[] getNodeSet(){
    	Node[] array = new Node[nodes.size()];
    	nodes.jumpToHead();
    	
    	for(int i = 0; i<nodes.size(); i++) {
    		array[i] = nodes.fetch();
    		
    		nodes.next();
    	}
    	
    	return array;
    	
    }
    
    /**
     * An array of the neighbors of a node
     * @param n the node
     * @return neighbors of n
     */
    public INode<N>[] getNeighbors(INode<N> n){
    	INode[] array = new INode[nodes.size()];
    	edges.jumpToHead();
    	int curr = 0;
    	
    	for(int i = 0; i<edges.size(); i++) {
			boolean t = (edges.fetch().getSource().equals(n));
			boolean t2 = (edges.fetch().getDestination().equals(n));
    		
			if(t = true) { array[curr] = edges.fetch().getSource();	 curr++;}  
			if(t2 = true) { array[curr] = edges.fetch().getDestination();	 curr++;}  
			
    		edges.next();
    	}
    	
    	return array;
    }
    
    /**
     * Adds a node to the graph
     * @param v value at the node
     * @return the newly added node
     */
    public INode<N> addNode(N v){
        Node<N> n = new Node<N>(v);
        curr = n;
        nodes.append(n);
    	
        return n;
    }
    	
    /**
     * Gets an array of all the edges in the graph
     * @return the edge set
     */
    public IEdge<N,W>[] getEdgeSet(){
    	Edge[] array = new Edge[edges.size()];
    	edges.jumpToHead();
    	
    	for(int i = 0; i<edges.size(); i++) {
    		array[i] = edges.fetch();
    		
    		edges.next();
    	}
    	
    	return array;
    }
    
    /**
     * Gets an array of all the edges sourced at a particular node
     * @param n the source node
     * @return the edge set
     */
    public IEdge<N,W>[] getEdgesFrom(INode<N> n){
    	Edge[] array = new Edge[edges.size()];
    	edges.jumpToHead();
    	int curr = 0;
    	
    	for(int i = 0; i<edges.size(); i++) {
			boolean t = edges.fetch().getSource().equals(n);
    		if(t = true) { array[curr] = edges.fetch();	 curr++;}        		
    		edges.next();
    	}
    	
    	return array;
    }

    /**
     * Gets an array of all the edges destined for a particular node
     * @param n the destination node
     * @return the edge set
     */
    public IEdge<N,W>[] getEdgesTo(INode<N> n){
    	Edge[] array = new Edge[edges.size()];
    	edges.jumpToHead();
    	int curr = 0;
    	
    	for(int i = 0; i<edges.size(); i++) {
			boolean t = edges.fetch().getDestination().equals(n);
    		if(t = true) { array[curr] = edges.fetch();	 curr++;}        		
    		edges.next();
    	}
    	
    	return array;
    }

    
    /**
     * Adds an edge to the graph.
     * Duplicate edges are not allowed in the graph. The equals method of the edge can
     * be used to determine if two edges duplicate one another.
     * @param w weight of the edge
     * @param s source node
     * @param d destination node
     */
    public void addEdge(INode<N> s, INode<N> d, W w) {
    	int size = edges.size();
    	Edge<N, W> e = new Edge<N, W>(s, d, w);
    	edges.jumpToHead();
    	
    	if(size == 0) {
    		edges.append(e);
    	}
    	
    	else {
    		for(int i = 0; i<edges.size(); i++) {
    			boolean t = e.equals(edges.fetch());
        		if(t = true) {	}        		
        		edges.next();
        	}
    		edges.append(e);   		
    	}
    }
    
    public static void main(String[] args) {
        Graph<Integer, Integer> g = new Graph<Integer, Integer>();
       

        
        g.addNode(1);
        g.addNode(3);
        
     //   g.addEdge(s, d, w);
        
        System.out.println(g.getNodeSet());
      //  System.out.println(g.fetchNode("Bye bye"));
    }
    
    
    
}






