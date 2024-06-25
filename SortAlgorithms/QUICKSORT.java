import java.util.Arrays;
/**
 *
 * @author ravisharma
 */
public class HelloWorld {
    public static void main(String[] args) {
        int arr[]={12,32,12,1,23,45,121};
        quicksort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    static void quicksort(int arr[],int start,int end){
        if (start < end) {
            // gets the pivot Index
            int pivotIndex = partition(arr, start, end);
            
            // sort array before pivot
            quicksort(arr, start, pivotIndex - 1);

            // sort array after pivot
            quicksort(arr, pivotIndex + 1, end);
        }
    }

    private static int partition(int[] arr,int start,int end) {
        int pivot = arr[start];
        int i = start; int j = end;
        while (i<j){
            // get element which is greater than pivot from start
            while (arr[i] <= pivot) i++;
            // get element which is smalle than pivot from end 
            while (arr[j] > pivot) j--;

            // swaps both the element
            if (i<j){
                swap(arr, i, j);
            }
        }
        swap(arr, start, j);
        return j;
    }
    
    private static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
