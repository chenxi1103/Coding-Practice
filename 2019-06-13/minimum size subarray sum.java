// 最优解法
public class Solution {
    /**
     * @param nums: an array of integers
     * @param s: An integer
     * @return: an integer representing the minimum size of subarray
     */
    public int minimumSize(int[] nums, int s) {
        // write your code here
        if (nums == null || nums.length == 0 || (nums.length == 1 && nums[0] < s)) return -1;
        int endIndex = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            while (endIndex < nums.length && sum < s) {
                sum += nums[endIndex];
                endIndex++;
            }
            if (sum >= s) {
                result = result > (endIndex - i) ? (endIndex - i) : result;
                sum -= nums[i];
            }
        }
        if (result == Integer.MAX_VALUE) return -1;
        return result;
    }
}

// 最傻解法
public class Solution {
    /**
     * @param nums: an array of integers
     * @param s: An integer
     * @return: an integer representing the minimum size of subarray
     */
    public int minimumSize(int[] nums, int s) {
        // write your code here
        if (nums == null || nums.length == 0 || (nums.length == 1 && nums[0] < s)) return -1;
        int startIndex = 0;
        int result = Integer.MAX_VALUE;
        while (startIndex < nums.length) {
            if (nums[startIndex] >= s) return 1;
            int endIndex = startIndex + 1;
            int sum = 0;
            while (endIndex < nums.length) {
                if (endIndex == (startIndex + 1)) {
                    sum = nums[startIndex] + nums[endIndex];
                } else {
                    sum += nums[endIndex];
                }
                if (sum >= s) {
                    result = result > (endIndex - startIndex + 1) ? (endIndex - startIndex + 1) : result;
                    break;
                }
                endIndex++;
            }
            startIndex++;
        }
        if (result == Integer.MAX_VALUE) return -1;
        return result;
    }
}
