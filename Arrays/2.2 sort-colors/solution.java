class Solution {
    public void sortColors(int[] nums) {
        int low = 0;
        int end = nums.length - 1;
        int mid = 0;

        while (mid<=end){
            if (nums[mid] == 0){
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1){
                mid++;
            } else {
                swap(nums, mid, end);
                end--;
            }
        }
    }

    public void swap(int[] arr, int start, int end){
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
}
