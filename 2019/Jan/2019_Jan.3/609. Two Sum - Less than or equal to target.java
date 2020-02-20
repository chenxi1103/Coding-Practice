// 也是三角形类的two sum！！！
public class Solution {
    /**
     * @param nums: an array of integer
     * @param target: an integer
     * @return: an integer
     */
    public int twoSum5(int[] nums, int target) {
        // write your code here
        if(nums == null || nums.length < 2) return 0;
        int left = 0, right = nums.length - 1, result = 0;
        Arrays.sort(nums);
        while(left < right){
            if(nums[left] + nums[right] > target){
                right--;
            }else{
                result += right - left;
                left++;
            }
        }
        return result;
    }
}
