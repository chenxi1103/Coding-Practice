/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 * https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/528/week-1/3285/
 */
class Solution {
    public int maxSubArray(int[] nums) {
        int[] max = new int[nums.length];
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max[i] = nums[i];
            if (i > 0) max[i] = Math.max(max[i], max[i-1] + nums[i]);
            result = Math.max(result, max[i]);
        }
        return result;
    }
}