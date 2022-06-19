import java.util.*;

//  Cycle detection in Directed gp

class p16{
   
    private int V;  //  No of vertices in gp
    private List<List<Integer>> adj;    //  Representing gp using adjacency List
   
    p16( int V ){
       
        this.V = V;
        adj = new ArrayList<>( V );
       
        for( int i = 0; i < V; i++ ){
            adj.add( new LinkedList<>() );
        }
    }
   
    void addEdge( int u, int v ){
        adj.get( u ).add( v );
    }
   
    void gpShow(){
       
        for( int v = 0; v < V; v++ ){
            List<Integer> edgs = adj.get( v );
           
            for( int e = 0; e < edgs.size(); e++ ){
               
                System.out.println( "Edge: " + v + "--->" + edgs.get( e ) );
            }
        }
    }
   
    boolean hlp( int v, boolean[] visited, boolean[] recStack ){
       
        //  A Cycle is detected from node v, if
        //      a node x is encountered i.e. v ---> x , & recStack[ x ] == true
        //          then, Cycle detected
       
        if( recStack[ v ] ) //  If node v is already visited from path of 1st source node, then return true OR cycle detected
            return true;
        if( visited[ v ] )  //  If node v is already visited (& not in current path) then, no Cycle can be formed from this node
            return false;
       
        recStack[ v ] = true;
        visited[ v ] = true;
       
        for( Integer e : adj.get( v ) ){
           
            //  For all adjacenct nodes from current node
            //      recurse down the problem
           
            if( hlp( e, visited, recStack ) )      return true;
        }
       
        recStack[ v ] = false;
       
        return false;
    }
   
    boolean isCyclic(){
       
        //  For each node
        //      check if from that node a Cycle is made or not
        boolean ans = false;
        boolean[] visited = new boolean[ V ];
        boolean[] recStack = new boolean[ V ];
       
        for( int v = 0; v < V; v++ ){
            ans = hlp( v, visited, recStack );
           
            if( ans )   return true;
        }
        return false;
    }
   
public static void main(String[] args) {
   
   int nov = 3;    //  No. of vertices
   Main gp = new Main( nov );
   
   gp.addEdge( 1, 2 );
   gp.addEdge( 2, 0 );
   gp.addEdge( 0, 1 );
   
   gp.gpShow();

   System.out.println( gp.isCyclic() );
   }
}









