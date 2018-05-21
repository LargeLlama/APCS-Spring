//WOOOOOOOObin Peco
//APCS-2 pd02
//hw51 big yeet
//2018-05-19
//yote

public class HeapSort {
    
    public static void heapify (int[] arr, int size, int root)
    {
        int biggest = root;
        int left = (2 * root) + 1;
        int right = (2 * root) + 2;

        if (left < size && arr[left] > arr[biggest])
            biggest = left;
        
        if (right < size && arr[right] > arr[biggest])
            biggest = right;

        if (biggest != root) {
            int swap = arr[root];
            arr[root] = arr[biggest];
            arr[biggest] = swap;

            heapify(arr, size, biggest);
        }

    }

    public static void sort(int arr[])
    {
        for (int i = (arr.length - 1) / 2; i >= 0; i--)
            heapify(arr, arr.length - 1, i);

        for (int i = arr.length - 1; i >= 0; i--)
        {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
        
            heapify(arr, i, 0);
        }
    }
    
    public static void printArray(int[] arr)
    {
        String retString = "[";
        for (int i : arr)
            retString += i + ", ";

        if (retString.length() > 1)
            retString = retString.substring(0, retString.length() - 2);
        retString += "]";

        System.out.println(retString);
    }

    public static void main(String args[])
    {
        int[] test0 = {1, 9, 21, 39, -1, 31, 15};
        printArray(test0);
        sort(test0);
        printArray(test0);        
    }

}
