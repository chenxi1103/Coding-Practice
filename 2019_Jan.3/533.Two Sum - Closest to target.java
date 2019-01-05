//做了好久这道题啊，还是相向双指针！其实很简单的题目，记得复习！
public class Solution {
    /**
     * @param nums: an integer array
     * @param target: An integer
     * @return: the difference between the sum and the target
     */
    public int twoSumClosest(int[] nums, int target) {
        // write your code here
        if(nums == null || nums.length < 2) return target;
        Arrays.sort(nums);
        int left = 0, right = nums.length -1;
        int result = Integer.MAX_VALUE;
        while(left < right){
            int diff = nums[left] + nums[right] - target;
            if(diff == 0) return 0;
            else if(diff < 0){
                result = Math.min(Math.abs(diff), result);
                left++;
            }else{
                result = Math.min(diff, result);
                right--;
            }
        }
        return result;
    }
}
