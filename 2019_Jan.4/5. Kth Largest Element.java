//快排
public class Solution {
    /**
     * @param n: An integer
     * @param nums: An array
     * @return: the Kth largest element
     */
    public int kthLargestElement(int n, int[] nums) {
        // write your code here
        return quicksort(nums, 0, nums.length-1, nums.length - n);
    }
    private int quicksort(int[] nums, int head, int tail, int k){
        if(head >= tail) return nums[head];
        int left = head, right = tail, pivot = nums[head + (tail - head) / 2];
        while(left<=right){
            while(left<=right && nums[left] < pivot){
                left++;
            }
            while(left<=right && nums[right] > pivot){
                right--;
            }
            if(left<=right){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        if(k<=right && head <=right){
            return quicksort(nums, head, right, k);
        }
        else if(k>=left && left <= tail){
            return quicksort(nums, left, tail, k);
        }
        else{
            return nums[k];
        }
    }
}
