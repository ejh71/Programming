import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;

/**
 * Class that is capable of reading in a graph file from disk.
 * Graph files are line based. Node names have type String and edge weights have 
 * type Double. Fields on the line are separated by ':' and there is no extra white space.
 */
public class DiGraphReader implements IGraphReader {
    // Fields needed for the Graph Reader should be added here
    Graph<String, Double> graph;
	
    /**
     * Creates a new graph reader instance
     */
    public DiGraphReader() {
        // Configure the graph reader here
    	graph = new Graph<String, Double>();
    }
    
    /**
     * Reads in a file and instantiates the graph
     * @param filename the file to read
     * @return the instantiated graph
     */
    public IGraph<String,Double> read(String filename) throws FileNotFoundException, IOException {
    	//Instalizing Rows. Creating array for adding edges and a new graph instance
    	int rows = 0;
    	String l;
    	INode [] array = new INode[rows];
    	Graph<String, Double> r = new Graph<String, Double>();			
    	
    	// Open the file
    	BufferedReader br=new BufferedReader(new FileReader(filename));
    	
    	//Count number of rows in file
        while(br.readLine()!=null) {
            rows++;
        }
    	
        //New file reader
        BufferedReader brs=new BufferedReader(new FileReader(filename));
        //Loop through lines 
    	for(int i=0; i<rows*2; i+=2) {
            l=brs.readLine();
      //  System.out.println(l);
    	// Parse the lines. If a line does not have exactly 3 fields, ignore the line
    	
        String[] parts = l.split(":");
    	String part1 = parts[0];
    	String part2 = parts[1];
    	String part3 = parts[2];
    	double weight = (Double.parseDouble(part3));
    	
    	// For each line, add the nodes and edge		DIDNT MAKE IT SO THAT IT CHECKS FOR EXISTING NODES
    	
    	r.addNode(part1);
    	r.addNode(part2);
    	array = r.getNodeSet();
    	r.addEdge(array[i], array[i+1], weight);
    	}

        // Return the graph instance
        return r;
    	}
    
    
    
    /**
     * Simple main method to open and process a file
     */
    public static void main(String[] argv) throws Exception {
        // This code should work without modification once your reader code is working
        IGraphReader r = new DiGraphReader();
        IGraph<String,Double> g = r.read("graphfile.cs2");
        IEdge<String,Double>[] edges = g.getEdgeSet();
        for(int i=0; i<edges.length; i++) {
            System.out.println(edges[i].getSource().getValue()+" -> "+edges[i].getDestination().getValue()+"  w: "+edges[i].getWeight());
        }
    }
}