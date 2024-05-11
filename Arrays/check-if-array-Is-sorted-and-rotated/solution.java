class Solution {
    public boolean check(int[] nums) {
      
        int minVal = Integer.MAX_VALUE;
        int index = -1;
        int n = nums.length;
        int minCount = 0;

        for (int i=0; i<n; i++){
            // to cache min val
            if (nums[i] == minVal){
                // keep count of duplicates od min value
                minCount++;
                continue;
            }
  
            // condition for rotated array
            if (minVal >  nums[i]){
                minVal = nums[i];
                // start of rotated array smallest value or smallest value in an array
                index = i;
            }
        }
      
        int i=0;
        while (i<n-1-minCount){
            // condition to compare values from index th postion and next 
            if (nums[(index + i) % n] > nums[(index + i + 1) % n]){
                return false;
            }
            i++;
        }
      
        return true;
    }
}
