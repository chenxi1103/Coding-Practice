class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] memo = new int[nums.length];
        memo[0] = 1;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
                memo[i] = nums[i] > nums[i-1] ? memo[i-1] + 1 : 1;
                max = Math.max(max, memo[i]);
        }
        return max;
    }
}
