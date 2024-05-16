
class Solution{
    
   
    // Function for finding maximum and value pair
    public static int lenOfLongSubarr (int A[], int N, int K) {
        //Complete the function
        Dictionary<Integer, Integer> cache= new Hashtable<>();
        cache.put(0, -1);
        int ans = 0;
        int sum = 0;
        for (int i=0; i<N; i++){
            sum += A[i]; // => x
            if (cache.get(sum) == null){
                cache.put(sum, i);
            }
            // ----------------------- x
            // -------- x-k ---------- k
            if (cache.get(sum - K) != null && (i - cache.get(sum - K)) > ans){
                ans = i - cache.get(sum - K);
            }
        }
        return ans;
    }
    
    
}
