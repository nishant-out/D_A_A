// GIVEN AN ALREADY SORTED ARRAY OF POSITIVE INTEGERS, DESIGN AN ALGORITHM AND IMPLEMENT IT USING A PROGRAM TO FIND WHETHER A GIVEN KEY ELEMENT IS PRESENT IN THE SORTED ARRAY OR NOT. FOR AN ARRAY ARR[ N ], SEARCH AT INDEX ARR[ 0 ], ARR[ 2 ], ARR[ 4 ], ARR[ 2^K ] AND SO ON. ONCE THE INTERVAL ( ARR[ 2^K ] < KEY < ARR[ 2^( K +1) ] ) IS FOUND, PERFORM A LINEAR SEARCH OPERATIONS FROM THE INDEX 2^K TO FIND THE ELEMENT KEY. ( COMPLEXITY < O(N), WHERE N IS THE NUMBER OF ELEMENTS NEED TO BE SCANNED FOR SEARCHING ).

import java.util.*;
import java.lang.Math;  

public class Q3{

   public static void main( String[] argv ){
      int i = 0;
      int k = 0;
      
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
      
      int compares = 0;
      i = 0;
      while( i < n ){
      
         i = (int) Math.pow( 2, k ) -1;

		 if( i >= n )		break;

         if( arr[ i ] >= key ){
            break;
         }
         
         k++;
         compares++;
      }
      
      int st = (int) Math.pow( 2, k -1) -1;
      int en = (int) Math.pow( 2, k ) -1;

	//  System.out.println( "st: " + st + ", en: " + en );
		if( st < 0 )		st = 0;


      while( st < n && st <= en ){
         
         if( arr[ st ] == key )
            break;
         st++;
         compares++;
      }
      
      if( st >= n || st > en )
         System.out.println( "Key not Found" );
      else
         System.out.println( "Key Found in " + compares + "compares"  );
      
   }
}
