

class Solution {
    int print2largest(int arr[], int n) {
      
        int maxVal = Integer.MIN_VALUE;
        int maxVal2 = Integer.MIN_VALUE;
        
        for (int i=0; i<n ;i++){
            if (maxVal < arr[i]){
                maxVal2 = maxVal;
                maxVal = arr[i];
            } else if (maxVal2 < arr[i] && arr[i] != maxVal){
                maxVal2 = arr[i];
            }
        }
        if (maxVal2 == Integer.MIN_VALUE) return -1;
        return maxVal2;
    }
}
