class Compute {
    
    public int largest(int arr[], int n)
    {
        int maxVal = Integer.MIN_VALUE;
        for (int i=0; i<n; i++){
            if (maxVal < arr[i]){
                maxVal = arr[i];
            }
        }
        return maxVal;
    }
}
