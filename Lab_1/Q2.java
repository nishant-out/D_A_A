// BINARY SEARCH USING ITERATION & RECURSION

import java.util.*;  

public class Q2{

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
      
      int compare = 0;
      
      int st = 0;
      int en = n -1;
      
      while( st <= en ){
      
         compare++;
         
         int mid = ( st + en ) /2;
         
         if( arr[ mid ] == key )
            break;
            
         else if( key < arr[ mid ] )
            en = mid -1;
            
         else
            st = mid +1;
      }
      
      if( st > en )
         System.out.println( "Total Comparisons: " + compare + "\nKey not Found" );
      else
         System.out.println( "Total Comparisons: " + compare + "\nKey Found" );
      
   }
}
