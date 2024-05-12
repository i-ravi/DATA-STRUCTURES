class Solution {
    public void moveZeroes(int[] nums) {
        int index = 0;
        int i = 0;
        while (i < nums.length){
            if (nums[index] == 0){
                while (i < nums.length && nums[i] == 0){
                    i++;
                }
                if (i == nums.length) break;
                nums[index] = nums[i];
                nums[i] = 0;
            }
            index++;
            i++;
        }
    }
}
