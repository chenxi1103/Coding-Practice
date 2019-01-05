//Partition的问题就和快排一毛一样！！！
//很不幸你已经快把快排忘记了 ：（
public class Solution {
    /**
     * @param nums: The integer array you should partition
     * @param k: An integer
     * @return: The index after partition
     */
    public int partitionArray(int[] nums, int k) {
        // write your code here
        if(nums == null || nums.length == 0) return 0;
        int left = 0, right = nums.length - 1;
        while(left<=right){
            while(left<=right && nums[left] < k) left++;
            while(left<=right && nums[right] >= k) right--;
            if(left<=right){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        return left;
    }
}
