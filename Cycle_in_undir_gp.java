import java.util.*;

//  Cycle detection in UnDirected gp

public class Main{
    
    private int V;  //  No of vertices in gp 
    private List<List<Integer>> adj;    //  Representing gp using adjacency List
    
    Main( int V ){
        
        this.V = V;
        adj = new ArrayList<>( V );
        
        for( int i = 0; i < V; i++ ){
            adj.add( new LinkedList<>() );
        }
    }
    
    void addEdge( int u, int v ){
        adj.get( u ).add( v );
        adj.get( v ).add( u );
    }
    
    void gpShow(){
        
        for( int v = 0; v < V; v++ ){
            List<Integer> edgs = adj.get( v );
            
            for( int e = 0; e < edgs.size(); e++ ){
                
                System.out.println( "Edge: " + v + "--->" + edgs.get( e ) );
            }
        }
    }
    
    boolean hlp( int v, boolean[] visited, int parent ){
        
        //  A Cycle is detected from node v, if
        //      a visited node x (node adjacent to v) , is encountered & x != parent of v
        //          then, Cycle detected
        
        visited[ v ] = true;
        
        for( Integer e : adj.get( v ) ){
            
            //  IF adjacent node is not visited,
            //      recurse for that node
            if( !visited[ e ] ){
                
                if( hlp( e, visited, v ) )      return true;
            }
            
            else if( e != parent )              return true;
        }
        
        return false;
    }
    
    boolean isCyclic(){
        
        //  For each unvisited node
        //      check if from that node a Cycle is made or not 
        boolean ans = false;
        boolean[] visited = new boolean[ V ];
        
        for( int v = 0; v < V; v++ ){
            
            if( !visited[ v ] ){
                
                ans = hlp( v, visited, -1 );
            }
            
            if( ans )   return true;
        }
        return false;
    }
    
	public static void main(String[] args) {
	    
	    int nov = 3;    //  No. of vertices
	    Main gp = new Main( nov );
	    
	    gp.addEdge( 1, 2 );
	    gp.addEdge( 2, 0 );
	   // gp.addEdge( 0, 1 );
	    
		gp.gpShow();
		
		System.out.println( gp.isCyclic() );
	}
}









