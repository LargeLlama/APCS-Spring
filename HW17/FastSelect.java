//Honk Honk Radish - Jude the Dude, Wubin Peco, Xinyeet Huang
//APCS pd02
//HW17
//2018-03-09

public class FastSelect {

  public static void swap( int[] o, int x, int y ) {
    int tmp = o[x];
    o[x] = o[y];
    o[y] = tmp;
  }

  public static void printArr( int[] a ) {
    for ( int o : a )
	    System.out.print( o + " " );
    System.out.println();
  }

	public static int partition(int low, int high, int pvtPoint, int[] arr) {
		int pivot = arr[pvtPoint];
		swap(arr, pvtPoint, high);
		int swapCounter = low;

		for (int i = 0; i < high - 1; i++) {
			if (arr[i] < pivot) {
				swap(arr, swapCounter, i);
				swapCounter++;
			}

		}
		swap(arr, high, swapCounter);

		return swapCounter;
	}

	public static void main(String[] args) {
		int[] test = {7,1,5,12,3};

		partition(0, 4, 1, test);

		printArr(test);
	}




}
