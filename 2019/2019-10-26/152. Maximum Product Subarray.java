class Solution {
    public int maxProduct(int[] nums) {
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max[i] = nums[i];
            min[i] = nums[i];
            if (i > 0) {
                max[i] = Math.max(max[i], Math.max(max[i - 1] * nums[i], min[i - 1] * nums[i]));
                min[i] = Math.min(min[i], Math.min(max[i - 1] * nums[i], min[i - 1] * nums[i]));
            }

            result = Math.max(result, max[i]);
        }
        return result;
    }
}
