//Boss Zou
//APCS2 pd01
//HW51
//2018-05-21

public class HeapSort
{
   public  static void heapify(int arr[], int size, int root)
    {
        int largest = root;  // Initialize largest as root
        int l = 2*root + 1;  // left = 2*i + 1
        int r = 2*root + 2;  // right = 2*i + 2
 
        //left child > root
        if (l < size && arr[l] > arr[largest])
            largest = l;
 
        //right child > largest so far
        if (r < size && arr[r] > arr[largest])
            largest = r;
 
        //largest not root
        if (largest != root)
	    {
		int swap = arr[root];
		arr[root] = arr[largest];
		arr[largest] = swap;
 
		//Recursively heapify subtree
		heapify(arr, size, largest);
	    }
    }

    public static void sort(int arr[])
    {
	for (int i = (arr.length - 1)/2; i >= 0; i--)
            heapify(arr, arr.length - 1, i);
 
	for (int i = arr.length - 1; i >= 0; i--)
	    {	
		int temp = arr[0];
		arr[0] = arr[i];
		arr[i] = temp;
 
		heapify(arr, i, 0);
	    }
	
    }
 
    public static void toString(int[] arr){
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i]+ " ");
    }
 
    public static void main(String args[])
    {
        int[] arr = {1, 15, 10, 1, 13, 5, 20, 2};
	
	System.out.println("Before Sort: ");
	toString(arr);

	sort(arr);

	System.out.println();
        System.out.println("After Sort: ");
	toString(arr);
    }
}
