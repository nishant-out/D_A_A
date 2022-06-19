import java.util.*;

class Main{
   
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
    }
   
    void gpShow(){
       
        for( int v = 0; v < V; v++ ){
            List<Integer> edgs = adj.get( v );
           
            for( int e = 0; e < edgs.size(); e++ ){
               
                System.out.println( "Edge: " + v + "--->" + edgs.get( e ) );
            }
        }
    }
   
    boolean hasPath( int src, int dest ) {
        
        if( src == dest )   return true;
        
        List<Integer> nearV = adj.get( src );
        
        for( int e = 0; e < nearV.size(); e++ ){
            
            if( hasPath( nearV.get( e ), dest ) )
                return true;
        }
        return false;
    }
   
    public static void main(String[] args) {
       
       int nov = 8;    //  No. of vertices
       Main gp = new Main( nov );
       
      gp.addEdge( 1, 2 );
      gp.addEdge( 1, 3 );
      gp.addEdge( 0, 1 );
      gp.addEdge( 2, 3 );
      gp.addEdge( 3, 4 );
      gp.addEdge( 4, 1 );
       
      gp.addEdge( 5, 6 );
      gp.addEdge( 6, 7 );
      gp.addEdge( 7, 5 );
       
       gp.gpShow();
    
      System.out.println( gp.hasPath( 0, 6 ) );
    }
}

