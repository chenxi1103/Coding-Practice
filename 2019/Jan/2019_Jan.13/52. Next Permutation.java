public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers
     */
    public int[] nextPermutation(int[] nums) {
        // write your code here
        if(nums.length <= 1) return nums;
        int index = nums.length - 1;
        while(index >= 1 && nums[index] <= nums[index-1]){
            index--;
        }
        if(index == 0){
            swapList(nums, index, nums.length-1);
            return nums;
        }
        int j = nums.length - 1;
        while(j >= index){
            if(nums[j] > nums[index-1]){
                swap(nums, index-1, j);
                break;
            }
            j--;
        }
        swapList(nums, index, nums.length-1);
        return nums;
    }
    private void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
        return;
    }
    private void swapList(int[] nums, int left, int right){
        while(left <= right){
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}
