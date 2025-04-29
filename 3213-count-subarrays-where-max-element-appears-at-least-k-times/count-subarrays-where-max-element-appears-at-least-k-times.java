public class Solution {
    public long countSubarrays(int[] nums, int k) {
        int maxVal = Integer.MIN_VALUE;
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }

        long count = 0;
        int l = 0;
        int maxCount = 0;

        for (int r = 0; r < nums.length; r++) {
            if (nums[r] == maxVal) {
                maxCount++;
            }

            while (maxCount >= k) {
                count += nums.length - r;
                if (nums[l] == maxVal) {
                    maxCount--;
                }
                l++;
            }
        }

        return count;
    }
}