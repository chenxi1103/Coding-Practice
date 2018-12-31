public class Solution {
    /**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int binarySearch(int[] nums, int target) {
        // write your code here
        if(nums == null || nums.length == 0) return -1;
        int start = 0, end = nums.length-1;
        while(start + 1 < end){
            int mid = start + (end - start)/2;
            // 重点在这里！ 如果是找第一个等于target的数，即使找到了等于target的数也要把它的index当作end继续往前找！
            if(nums[mid] == target || nums[mid] > target){
                end = mid;
            }else{
                start = mid;
            }
        }
        if(nums[start] == target) return start;
        if(nums[end] == target) return end;
        return -1;
    }
}
