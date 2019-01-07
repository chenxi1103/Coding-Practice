public class Solution {
    /**
     * @param nums: An integer array sorted in ascending order
     * @param target: An integer
     * @return: An integer
     * 经典不会出现死循环的模版，记住
     */
    public int findPosition(int[] nums, int target) {
        // write your code here
        if(nums == null || nums.length == 0) return -1;
        int start = 0, end = nums.length - 1;
        if(target < nums[start] || target > nums[end]) return -1;
        while(start + 1 < end){
            int mid = start + (end - start)/2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] < target){
                start = mid;
            }else{
                end = mid;
            }
        }
        if(nums[start] == target) return start;
        if(nums[end] == target) return end;
        return -1;
    }
}
