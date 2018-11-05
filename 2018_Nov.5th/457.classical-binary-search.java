public class Solution {
    /**
     * @param nums: An integer array sorted in ascending order
     * @param target: An integer
     * @return: An integer
     * 真是醉了，一个最普通的二分查找居然还能写错好几回…记得熟练掌握
     */
    public int findPosition(int[] nums, int target) {
        // write your code here
        if(nums == null || nums.length == 0) return -1;
        return helper(nums,target,0,nums.length-1);
    }
    private int helper(int[] nums, int target, int start, int end){
        int mid = start+(end-start)/2;
        if(start<end && nums[mid] == target) return mid;
        if(start<end && nums[mid] > target) return helper(nums,target,start,mid-1);
        if(start<end && nums[mid] < target) return helper(nums,target,mid+1,end);
        return -1;
    }
}
