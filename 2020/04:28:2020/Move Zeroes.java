/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/528/week-1/3286/
 */
class Solution {
    public void moveZeroes(int[] nums) {
        int left = 0;
        int right = 0;
        while(left < nums.length) {
            if (nums[left] == 0) {
                right = left + 1;
                while (right < nums.length && nums[right] == 0) {
                    right++;
                }
                if (right == nums.length) break;
                nums[left] = nums[right];
                nums[right] = 0;
            }
            left++;
        }
    }
}