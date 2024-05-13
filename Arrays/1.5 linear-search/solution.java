


class Solution{
    static int searchInSorted(int arr[], int N, int K)
    {
        
        if (binarySearch(0, N-1, arr, K)) return 1;
        return -1;
    }
    
    static boolean binarySearch(int start, int end, int arr[], int K){
        if (start > end) return false;
        int mid = start + ((end - start)/2);
        if (arr[mid] ==  K) {
            return true;
            
        } else if (arr[mid] < K) {
            return binarySearch(mid+1, end, arr, K);
        }
        return binarySearch(start, mid-1, arr, K);
    }
}
