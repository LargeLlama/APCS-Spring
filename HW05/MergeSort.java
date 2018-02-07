//WOooooooooooooooobin Peco
//APCS pd. 2
//HW05 - mergey mergey
//2018-02-06
//ahhhhhhhhhhhhhhhHHHHHHHHHHHHHHHHHHHH

/*======================================
  class MergeSort
  Implements mergesort on array of ints.

  Summary of Algorithm:
  First, cut the array in half and continue to do so until we reach arrays of size one
  we take those arrays and merge them, as arrays of size one are always sorted
  we repeat the merge until we are left with only two arrays, and when those are merged as well the
  result will be a sorted array :)

  ======================================*/

public class MergeSort
{
  /******************************************************
   * int[] merge(int[],int[])
   * Merges two input arrays
   * Precond:  Input arrays are sorted in ascending order
   * Postcond: Input arrays unchanged, and
   * output array sorted in ascending order.
   ******************************************************/
  private static int[] merge( int[] a, int[] b )
  {
	int[] retArray = new int[a.length + b.length];	//make the return array with the appropriate size
	
	int counter = 0;	//make the counter variable
	int aIndex = 0;		//tracks the index of array a and b
	int bIndex = 0;
	int length = Math.min(a.length, b.length);	//the length at first will be that of the smaller array

	while (aIndex < a.length && bIndex < b.length) {	//will run as long as we loop through one of the entire arrays
		if (a[aIndex] < b[bIndex]) {					
	//		System.out.println("a index: " + aIndex);
			retArray[counter] = a[aIndex];				//puts the smaller value in the returned array
														//and increments the index tracker of the appropriate array
			aIndex ++;
		} else {
	//		System.out.println("b index: " + bIndex);
			retArray[counter] = b[bIndex];
			bIndex ++;
		}
		counter ++;
	}

	//System.out.println("final values of index trackers:\na: " + aIndex + "\nb: " + bIndex);
	//printArray(retArray);

	//this part will take care of the left over parts of the given arrays
	//we know if we finished looping thru one of the arrays, but the other still
	//has stuff, it all should be added at the end
	//thus, we can make
	while (aIndex < a.length) {	
	//	System.out.println("a[" + aIndex + "]: " + a[aIndex]);
		retArray[counter] = a[aIndex];
		aIndex ++;
		counter++;
	}

	while (bIndex < b.length) {
	//	System.out.println("b[" + bIndex + "]: " + b[bIndex]);
		retArray[counter] = b[bIndex];
		bIndex ++;
		counter++;
	}

	return retArray;

  }//end merge()


  /******************************************************
   * int[] sort(int[])
   * Sorts input array using mergesort algorithm
   * Returns sorted version of input array (ascending)
   ******************************************************/
  public static int[] sort( int[] arr )
  {
	  //recursive solution
	  
	  //recursive case is when the array is not sorted - aka its size is > 1
	  if (arr.length > 1) {
		  //first, make two arrays that each hold a half of the input
		  int[] firstHalf = new int[arr.length / 2];				
		  int[] secondHalf = new int[arr.length - (arr.length / 2)];

		  //loop thru each and copy the respective values into them
		  for (int i = 0; i < firstHalf.length; i++) 
			  firstHalf[i] = arr[i];

		  for (int i = 0; i < secondHalf.length; i++) 
			  secondHalf[i] = arr[i + (arr.length / 2)];

		  //merge the two arrays, but first we gotta split it in half again until....
		  return merge(sort(firstHalf), sort(secondHalf));
		  
	  } else {
		  //when the array is of size one, it is sorted and thus does not need any actions other than
		  //returning it
		  return arr;

		  //by returning the array of size one, we can now merge it with another array of size one
		  //that gives us an array of size two, which will be merged with another array, and so
		  //on and so forth until we finally merge everything and the final sorted array is returned
	  }
  }//end sort()



  //-------------------HELPERS-------------------------
  //tester function for exploring how arrays are passed
  //usage: print array, mess(array), print array. Whaddayasee?
  public static void mess( int[] a ) {
    for( int i = 0 ; i<a.length; i++ )
      a[i] = 0;
  }
  //array is now filled with zeroes! gnarly!


  //helper method for displaying an array
  public static void printArray( int[] a ) {
    System.out.print("[");
    for( int i : a )
      System.out.print( i + ",");
    System.out.println("]");
  }
  //---------------------------------------------------


  //main method for testing
  public static void main( String [] args ) {

       int[] arr0 = {0};
      int[] arr1 = {1};
      int[] arr2 = {1,2};
      int[] arr3 = {3,4};
      int[] arr4 = {1,2,3,4};
      int[] arr5 = {4,3,2,1};
      int[] arr6 = {9,42,17,63,0,512,23};
      int[] arr7 = {9,42,17,63,0,9,512,23,9};
	  //added arrays to test merge
	  int[] arr8 = {0,7,13,17,29,39,47};
	  int[] arr9 = {1,5,6,10,14};

      System.out.println("\nTesting mess-with-array method...");
      printArray( arr3 );
      mess(arr3);
      printArray( arr3 );
  
      System.out.println("\nMerging arr1 and arr0: ");
	  
	  System.out.print("arr1: ");
	  printArray(arr1);

	  System.out.print("\narr0: ");
	  printArray(arr0);

      printArray( merge(arr1,arr0) );

      System.out.println("\nMerging arr4 and arr0: ");

	  System.out.print("arr4: ");
	  printArray(arr4);

	  System.out.print("\narr0: ");
	  printArray(arr0);

      printArray( merge(arr4,arr0) );

	
	  System.out.println("\nMerging arr8 and arr9");

	  printArray(arr8);
	  System.out.println();
	  printArray(arr9);
	 	
	  printArray( merge(arr8, arr9));


      System.out.println("\nSorting arr4-7...");
      printArray( sort( arr4 ) );
      printArray( sort( arr5 ) );
      printArray( sort( arr6 ) );
      printArray( sort( arr7 ) );

  }//end main()

}//end class MergeSort
