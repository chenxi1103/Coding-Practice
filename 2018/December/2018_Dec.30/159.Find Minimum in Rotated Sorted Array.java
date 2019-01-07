public class Solution {
    /**
     * @param nums: a rotated sorted array
     * @return: the minimum number in the array
     */
    //这是典型的xxoo题型，以数组末尾值为target，第一组是xx，第二组是oo，xx都比oo组的值要大，
    //要找出oo组的第一个值（最小值）
    public int findMin(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0) return -1;
        int start = 0, end = nums.length-1;
        int target = nums[end];
        if(nums[0]<target) return nums[0];
        while(start + 1 < end){
            int mid = start + (end - start)/2;
            if(nums[mid] > nums[mid+1]) return nums[mid+1];
            else{
                if(nums[mid] > target) start = mid;
                else end = mid;
            }
        }
        return Math.min(nums[start], nums[end]);
    }
}
