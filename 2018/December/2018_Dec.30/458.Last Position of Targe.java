public class Solution {
    /**
     * @param nums: An integer array sorted in ascending order
     * @param target: An integer
     * @return: An integer
     */
    public int lastPosition(int[] nums, int target) {
        // write your code here
        if(nums == null || nums.length == 0) return -1;
        int start = 0, end = nums.length - 1;
        while(start+1<end){
            int mid = start + (end - start)/2;
            if(nums[mid] == target || nums[mid] < target){
                start = mid;
            }else{
                end = mid;
            }
        }
        //这里是重点2: 要先检测end是不是等于target，才能保证最先返回的是最后一个等于target的index！
        if(nums[end] == target) return end;
        if(nums[start] == target) return start;
        return -1;
    }
}
