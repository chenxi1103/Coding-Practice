/**
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
class Solution {
    public int singleNumber(int[] nums) {
        Set<Integer> rem = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (rem.contains(nums[i])) {
                rem.remove(nums[i]);
            } else {
                rem.add(nums[i]);
            }
        }
        return rem.iterator().next();
    }
}