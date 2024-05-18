import java.util.*;
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int ans[] = new int[2];
        Dictionary<Integer, Integer> cache = new Hashtable<>();
        for (int i=0; i<nums.length; i++){
            int K = target - nums[i];
            if (cache.get(K) != null) {
                ans[0] = i;
                ans[1] = cache.get(K);
                break;
            }
            cache.put(nums[i], i);
        }
        return ans;
    }
}
