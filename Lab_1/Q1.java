// LINEAR SEARCH USING ITERATION & RECURSION
import java.util.*;  

public class Q1{

   public static void main( String[] argv ){
      int i = 0;
      Scanner sc = new Scanner( System.in );
      
      System.out.println( "Enter Size in array: " );
      int n = sc.nextInt();
      
      System.out.println( "Enter Elements in array: " );
      int[] arr = new int[ n ] ;
      
      for( i = 0; i < n; i++){
         arr[ i ] = sc.nextInt();
      }
      
      System.out.println( "Enter Element to Search: " );
      int key = sc.nextInt();
      
      int compare = 1;  // Because comparisons here are always ( n +1 )
      
      for( i = 0; i < n; i++){
         
         compare++;
         if( key == arr[ i ] )
            break;
         
      }
      
      if( i == n )
         System.out.println( "Total Comparisons: " + compare + "\nKey not Found" );
      else
         System.out.println( "Total Comparisons: " + compare + "\nKey Found" );
      
   }
}
