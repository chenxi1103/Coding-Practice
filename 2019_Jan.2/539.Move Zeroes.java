public class Solution {
    /**
     * @param nums: an integer array
     * @return: nothing
     */
    public void moveZeroes(int[] nums) {
        // write your code here
        if(nums == null || nums.length <= 1) return;
        for(int i = 0; i<nums.length-1; i++){
            if(nums[i] == 0){
                for(int j = i+1; j<nums.length; j++){
                    if(nums[j] != 0){
                        nums[i] = nums[j];
                        nums[j] = 0;
                        break;
                    }
                }
            }
        }
        return;
    }
}
