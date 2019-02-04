public class Solution {
    /**
     * @param k: An integer
     * @param nums: An integer array
     * @return: kth smallest element
     */
    public int kthSmallest(int k, int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0) return -1;
        quicksort(nums, 0, nums.length - 1);
        return nums[k-1];
    }
    private void quicksort(int[] nums, int left, int right){
        if(nums == null || nums.length <=1) return;
        if(left >= right) return;
        int start = left, end = right;
        int mid = nums[start + (end - start) / 2];
        while(start <= end){
            while(start <= end && nums[start] < mid) start++;
            while(start <= end && nums[end] > mid) end--;
            if(start <= end){
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
        }
        quicksort(nums, left, end);
        quicksort(nums, start, right);
    }
}
