public class Solution {
    /**
     * @param nums: a list of integers.
     * @param k: length of window.
     * @return: the sum of the element inside the window at each moving.
     */
    public int[] winSum(int[] nums, int k) {
        // write your code here
        if(nums == null || nums.length == 0 || k == 0) return new int[0];
        if(k == 1) return nums;
        int[] result = new int[nums.length - k + 1];
        for(int i = 0; i<result.length; i++){
            result[i] = 0;
            for(int j = i; j < k+i; j++){
                result[i] += nums[j];
            }
        }
        return result;
    }
}
