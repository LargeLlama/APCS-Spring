//Wooobin Peco
//APCS2 pd2
//HW18 -- QuickSort
//2018-03-13t
  
/*****************************************************
 * class QuickSort
 * Implements quicksort algo to sort an array of ints in place
 *
 * 1. Summary of QuickSort algorithm:
 * QSort(arr): 
 * 1) Check if the right index given is greater than the left
 * 	a) if so, then we partition the value after the left and before the right
 * 	b) repeat this process untilwe no longer have a 
 *
 * 2a. Worst pivot choice and associated runtime: 
 *		picking the last item in the array in an already sorted array, or one sorted in reverse order
 *		this will lead to O(n^2) runtime
 *
 * 2b. Best pivot choice and associated runtime:
 * 		best pivot will be a middle value, or the median of the array, which is hard to accomplish without it being sorted already
 * 		but, we can use a random element or go for the middle element and get lucky, giving us a solid O(n) runtime in a best case.
 *
 * 3. Approach to handling duplicate values in array:
 * 		if we set the duplicate value as the pivot, it will be in its final resting place, along with the copies
 * 		also it just kinda works even with duplicates lol idk
 *
 *****************************************************/
import java.util.Random;
public class QuickSort
{
  //--------------v  HELPER METHODS  v--------------
  //swap values at indices x, y in array o
	public static void swap(int[] arr, int a, int b) {
		int temp = arr[a];

		arr[a] = arr[b];

		arr[b] = temp;
	}

  //print input array 
  public static void printArr( int[] a ) {
    for ( int o : a )
	    System.out.print( o + " " );
    System.out.println();
  }

  //shuffle elements of input array
  public static void shuffle( int[] d ) {
    int tmp;
    int swapPos;
    for( int i = 0; i < d.length; i++ ) {
	    tmp = d[i];
	    swapPos = i + (int)( (d.length - i) * Math.random() );
	    swap( d, swapPos, i );
    }
  }

  //return int array of size s, with each element fr range [0,maxVal)
  public static int[] buildArray( int s, int maxVal ) {
    int[] retArr = new int[s];
    for( int i = 0; i < retArr.length; i++ )
	    retArr[i] = (int)( maxVal * Math.random() );
    return retArr;
  }


  public static int partition( int arr[], int a, int b)
  {
	int pivotIndex = a + (int)(Math.random() * ((b-a)+1));
    int v = arr[pivotIndex];

    swap( arr, pivotIndex, b);
    int s = a;

    for( int i = a; i < b; i++ ) {
	    if ( arr[i] <= v) {
        	swap(arr, i, s);
        	s++;
		}
    }
    swap(arr, s,b);

    return s;
  }//end partition

  //--------------^  HELPER METHODS  ^--------------



  /*****************************************************
   * void qSort(int[])
   * @param d -- array of ints to be sorted in place
   *****************************************************/
  public static void qSort( int[] d )
  { 
	qSortH(d, 0, d.length - 1);
  }

  public static void qSortH(int[] arr, int left, int right) {
	if (left < right) {
		int pvt = partition(arr, left, right);
		qSortH(arr, left, pvt - 1);
		qSortH(arr, pvt + 1, right);
	}
  }	 

  //main method for testing
  public static void main( String[] args )
  {
  
    //get-it-up-and-running, static test case:
    int [] arr1 = {7,1,5,12,3};
    System.out.println("\narr1 init'd to: " );
    printArr(arr1);

    qSort( arr1 );	
    System.out.println("arr1 after qSort: " );
    printArr(arr1);
    // randomly-generated arrays of n distinct vals
    int[] arrN = new int[10];
    for( int i = 0; i < arrN.length; i++ )
    arrN[i] = i;
       
    System.out.println("\narrN init'd to: " );
    printArr(arrN);

    shuffle(arrN);
    System.out.println("arrN post-shuffle: " );
    printArr(arrN);

    qSort( arrN );
    System.out.println("arrN after sort: " );
    printArr(arrN);

	  /*~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y) 

    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/


    
    //get-it-up-and-running, static test case w/ dupes:
    int [] arr2 = {7,1,5,12,3,7};
    System.out.println("\narr2 init'd to: " );
    printArr(arr2);

    qSort( arr2 );	
    System.out.println("arr2 after qSort: " );
    printArr(arr2);


    // arrays of randomly generated ints
    int[] arrMatey = new int[20];
    for( int i = 0; i < arrMatey.length; i++ )
    arrMatey[i] = (int)( 48 * Math.random() );
       
    System.out.println("\narrMatey init'd to: " );
    printArr(arrMatey);

    shuffle(arrMatey);
    System.out.println("arrMatey post-shuffle: " );
    printArr(arrMatey);

    qSort( arrMatey );
    System.out.println("arrMatey after sort: " );
    printArr(arrMatey);

	/*~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y) 

    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

  }//end main

}//end class QuickSort
