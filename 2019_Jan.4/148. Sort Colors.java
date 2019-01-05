//不会写，注意复习
public class Solution {
    /**
     * @param nums: A list of integer which is 0, 1 or 2
     * @return: nothing
     */
    public void sortColors(int[] nums) {
        // write your code here
        if(nums == null || nums.length <= 1) return;
        int left = 0, right = nums.length - 1, count = 0;
        while(count <= right){
            if(nums[count] == 0){
                swap(nums, left, count);
                count++;
                left++;
            }else if(nums[count] == 2){
                swap(nums, right, count);
                right--;
            }else{
                count++;
            }
        }
        return;
    }
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
