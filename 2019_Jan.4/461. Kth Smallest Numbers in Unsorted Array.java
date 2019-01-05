//快排快忘记了啊混蛋，记得是一个循环！！！
public class Solution {
    /**
     * @param k: An integer
     * @param nums: An integer array
     * @return: kth smallest element
     */
    public int kthSmallest(int k, int[] nums) {
        // write your code here
        return quicksort(nums, 0, nums.length-1, k-1);
    }
    private int quicksort(int[] nums, int head, int tail, int k){
        if(head>=tail || nums == null || nums.length <=1) return nums[head];
        int left = head, right = tail;
        int pivot = nums[left + (right - left) / 2];
        while(left <= right){
            while(left <= right && nums[left] < pivot){
                left++;
            }
            while(left <= right && nums[right] > pivot){
                right--;
            }
            if(left <= right){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        if(k <= right && head <= right){
            return quicksort(nums, head, right, k);
        }else if(k >= left && left <= tail){
            return quicksort(nums, left, tail, k);
        }else{
            return nums[k];
        }
    }
}
