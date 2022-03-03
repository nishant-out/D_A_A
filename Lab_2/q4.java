

import java.util.*;  

public class q4{

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
      
      int copies = bs( arr, 0, arr.length -1, key );
      
      if( copies == 0 )
         System.out.println( "\nKey not Found" );
      else
         System.out.println( "\nKey Found " + copies + " times" );
      
   }
   
   public static int bs( int[] arr, int st, int en, int key ){
      int cnt = 0;
      
      if( st <= en ){
         
         int mid = (st +en) /2;
         
         if( arr[ mid ] == key ){
            cnt++;
            cnt += bs( arr, st, mid -1, key );
            cnt += bs( arr, mid +1, en, key );
         }
         else if( arr[ mid ] > key )
            cnt += bs( arr, st, mid -1, key );
            
         else
            cnt += bs( arr, mid +1, en, key );
      }
      
      return cnt;
   }
}
