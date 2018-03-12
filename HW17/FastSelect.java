/*
Honk Honk Radish - Jude Grodesky, Rubin Peco, Xinyi Huang
APCS2 pd02
HW17 -- So So Fast
2018-03-11
*/

public class FastSelect
{
  //--------------v  HELPER METHODS  v--------------
  //swap values at indices x, y in array o
  public static void swap( int x, int y, int[] o ) {
    int tmp = o[x];
    o[x] = o[y];
    o[y] = tmp;
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
	    swap( i, swapPos, d );
    }
  }

  //return int array of size s, with each element fr range [0,maxVal)
  public static int[] buildArray( int s, int maxVal ) {
    int[] retArr = new int[s];
    for( int i = 0; i < retArr.length; i++ )
	    retArr[i] = (int)( maxVal * Math.random() );
    return retArr;
  }
  //--------------^  HELPER METHODS  ^--------------



  public static int partition( int arr[], int a, int b, int c)
  {
    int v = arr[c];

    swap( c, b, arr);
    int s = a;

    for( int i = a; i < b; i++ ) {
	    if ( arr[i] <= v) {
        swap( i, s, arr );
        s++;}
    }
    swap(s,b,arr);

    return s;
  }//end partition


    public static int FastSelect(int[] arr, int value){
	return FastSelectH(arr, value - 1, 0, arr.length - 1);
    }

    public static int FastSelectH(int[] arr, int value, int left, int right){
		//if the range is zero, we just return the value at the index left
		if (left == right)
			return arr[left];
		
		//otherwise, we set a split with a pivot point as the median
		int split = partition(arr,left, right, ((right - left )/ 2 + left));
		
		//if the split is equal to the value, then we have the right one
		if (split == value)
			return arr[split];
		
		//if its too large, we run it again with the split as the right value 
		if (split > value)
			return FastSelectH(arr, value, left, split);
		else
			//other wise, we check if there is only a difference of one between split and right, telling us that the int is at index right
			if (right - split == 1)
				return arr[right];
			
		//otherwise, we run the whole func again, with the left point as the split now
		return FastSelectH(arr, value, split, right);
		
    }
    
  //main method for testing
  public static void main( String[] args )
  {
		int[] arr1 = {8,21,17,69,343};
		int[] arr3 = {1,28,33,4982,37};
		int[] arr4 = {5,4,17,9000,6};
		int[] arr5 = {3,0,16,599,1024};
		int[] arr6 = {7, 1, 12, 3, 5};

		printArr(arr1);
		for (int i = 1; i < 6; i++)
			System.out.println( "arr1 " + i + " smallest value: " + FastSelect(arr1, i));
		System.out.println();

		printArr(arr3);
		for (int i = 1; i < 6; i++) 
			System.out.println( "arr3 " + i + " smallest value: " + FastSelect(arr3, i));
		System.out.println();

		printArr(arr4);
		for(int i = 1; i < 6; i++)
			System.out.println( "arr4 " + i + " smallest value: " + FastSelect(arr4, i));
		System.out.println();

		printArr(arr5);	
		for(int i = 1; i < 6; i++) 
			System.out.println( "arr5 " + i + " smallest value: " + FastSelect(arr5, i));	
		System.out.println();

		printArr(arr6);
		for(int i = 1; i < 6; i++)
			System.out.println( "arr6 " + i + " smallest value: " + FastSelect(arr6, i));	
		System.out.println();

		int[] arr7 = {9, 13, 21, 10, 81, 65, 19, 46, 72, 4};
		int[] arr8 = {8, 1, 7, 9, 13, 24, 36, 55, 18, 99};

		printArr(arr7);
		for (int i = 1; i < 11; i++) 
			System.out.println( "arr7 " + i + " smallest value: " + FastSelect(arr7, i));
		System.out.println();

		printArr(arr8);
		for (int i = 1; i < 11; i++) 
			System.out.println( "arr8 " + i + " smallest value: " + FastSelect(arr8, i));

    }//end main

}//end class FastSelect
