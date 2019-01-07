public class Solution {
    /**
     * @param nums: a mountain sequence which increase firstly and then decrease
     * @return: then mountain top
     */
    public int mountainSequence(int[] nums) {
        // 山岭数列问题，也是xxoo的问题，只要找到mid的左右都比mid小，那就是山岭了！
        // 如果mid的左边比mid大，就落在右岭上，如果mid的右边比mid小，就落在左岭上。
        if(nums == null || nums.length == 0) return -1;
        int start = 0, end = nums.length - 1;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(nums[mid-1] < nums[mid] && nums[mid+1] < nums[mid]) return nums[mid];
            else if(nums[mid-1] > nums[mid]) end = mid;
            else start = mid;
        }
        return Math.max(nums[start], nums[end]);
    }
}
