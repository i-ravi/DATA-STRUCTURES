class Solution {

    public void reverseArray(int start, int end, int[] nums){
        while (start<end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        if (k == 0) return;
        // reverse array from 0th index to kth index
        reverseArray(0, n-k-1, nums);
        // reverse array from kth index to last
        reverseArray(n-k, n-1, nums);
        // reverse array from 0th index to last
        reverseArray(0, n-1, nums);
    }
}
