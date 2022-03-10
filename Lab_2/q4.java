
// given a sorted array that can contain duplicate elements also
// you have to find no. of occurence of a key element in the array in log( n ) time

/*
Approach 1:
   
   1. find the key element in the array
   
   now more key elements can exist in left half and right half of the array
   so we have to find those elements in log( n ) time also
   
   2. find a point in the left half of the array 
		i.e. ith index from where my i -1th index < key
   
   3. illy, in the right half of the array
   		i.e here j +1th index element > key

	
	4.	total occurence = j -i +1

*/

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
      
      int mid = bs( arr, 0, arr.length -1, key );
      
      
      int st = focc( arr, 0, mid, arr[ mid ] );
      
      
      
      
      
      
      
      if( copies == 0 )
         System.out.println( "\nKey not Found" );
      else
         System.out.println( "\nKey Found " + copies + " times" );
      
   }
   
   
   public static int focc( int[] arr, int st, int en, int key ){
   			
   		if( st <= en ){
   		
   			int mid = ( st +en ) /2;
   		
   			if( arr[ mid ] == key )	//	THis can be a possible answer
   				if( arr[ mid -1 ] < key )	//	ANswer found
   					return mid;
   				else
   					return focc( arr, st, mid -1, key );
   				
   			else
   				return focc( arr, st, mid, key );
   		}
   }
   
   
   
   public static int bs( int[] arr, int st, int en, int key ){
      int cnt = 0;
      
      if( st <= en ){
         
         int mid = (st +en) /2;
         
         if( arr[ mid ] == key ){
            return mid;
         }
         else if( arr[ mid ] > key )
            return bs( arr, st, mid -1, key );
            
         else
            return bs( arr, mid +1, en, key );
      }
      
   }
}
