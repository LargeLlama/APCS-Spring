//Wubin Peco
//APCS pd02
//HW16 ya yeet yaaa
//2018-03-07

public class Mysterion {
/*pseducode given in class
 *(a = 0, b = 4, c = 2)

function Mysterion(a, b, c, arr)
   v = arr[c]
   swap arr[c], arr[b]
   s = a
   for i in [a ... b-1]
      if arr[i] < v
         swap arr[s], arr[i]
         s += 1
   swap arr[b], arr[s]
   return s
*/

	//this is a semi-sorting algo, where it takes a lower bound and higher bound, and uses them, with the addition of a midpoint index, along with the actual
	//array itself as parameters
	//the median is set as the number at the midPoint index, and is the value that the other ints will be compared to
	//if a value is less than, you swap it with the value at index swapCounter, which is simply the number of ints
	//that fufill the above case
	//However, if there is a row of integers that are all less than the median chosen, then no swaps actually occur but the swap counter does go up
	//
	//I'm not really seeing much of a pattern other than that it maintains semi-sortedness and it can make things semi sorted if they aren't
	//This is definitely a smaller part in a bigger algo - why doesn't it account for when numbers are larger than the number given?
	//also, is it just a coincidence that c is halfway between a and b, or our "low" and "high" bounds.
	//This reminds me of a boneless quicksort, cuz that was used in my final project and though i wasnt responsibile for coding it, I looked it over
	//and some actions are very similar, but this is just a shot in the dark
	
	
	public static int partition(int low, int high, int midPoint, int[] arr) {
		int median = arr[midPoint];

		swap(arr, midPoint, high);

		int swapCounter = low;

		for (int i = 0; i < high - 1; i++) {
			if (arr[i] < median) {
				swap(arr, swapCounter, i);
				swapCounter++;
			}
			//comment out this line if u don't need diagnostics!
			for (int n : arr)
				System.out.print(n + ", ");
			System.out.println();

		}
		
		swap(arr, high, swapCounter);

		return swapCounter;
	}

	public static void swap(int[] arr, int a, int b) {
		int temp = arr[a];

		arr[a] = arr[b];

		arr[b] = temp;
	}

	public static void main(String[] args) {
	/*	for testint our swap method
	 *
	 *	int[] test = {0,1,2,3,4};
	 *	swap(test, 3, 1);
	 *
	 *	for(int i : test)
	 *		System.out.print(i + " ");
	 */
		
		int[] test = {7,1,12,5,3}; //magic array
		System.out.println("OG array: ");
		for (int i : test)
			System.out.print(i + ", ");
		System.out.println();

		System.out.println("Running partition!"); 
		System.out.println(partition(0, 4, 2, test) + " swaps counted!");

		for (int i : test )
			System.out.print(i + ", ");
		System.out.println();

		System.out.println("State of array afterwards: ");

		System.out.println();
		int[] test1 = {12,7,5,3,1}; //magic array

		System.out.println("OG array: ");
		for (int i : test1)
			System.out.print(i + ", ");
		System.out.println();

		System.out.println("Running partition!"); 
		System.out.println(partition(0, 4, 2, test1) + " swaps counted!");
		
		System.out.println("State of array afterwards: ");
		for (int i : test1 )
			System.out.print(i + ", ");
		System.out.println();

		System.out.println();
		int[] test2 = {1,3,5,7,12};
		System.out.println();
	
		System.out.println("OG array: ");
		for (int i : test2)
			System.out.print(i + ", ");
		System.out.println();

		System.out.println("Running partition!"); 
		System.out.println(partition(0, 4, 2, test2) + " swaps counted!");
		
		System.out.println("State of array afterwards: ");
		for (int i : test2 )
			System.out.print(i + ", ");
		System.out.println();

	}
}
