public class Solution {
    /**
     * @param nums: an array
     * @return: the number occurs twice and the number that is missing
     */
    public int[] findErrorNums(int[] nums) {
        // Write your code here
        int[] mark = new int[nums.length + 1];
        int[] result = new int[2];
        for(int i = 0; i < nums.length; i++) {
            mark[nums[i]]++;
        }
        for(int i = 1; i < mark.length; i++) {
            if(mark[i] == 0) {
                result[1] = i;
            } else if (mark[i] > 1) {
                result[0] = i;
            }
        }
        return result;
    }
}
////////////////////////////////第二种解法，感觉不如第一种好//////////////////////////
public class Solution {
    /**
     * @param nums: an array
     * @return: the number occurs twice and the number that is missing
     */
    public int[] findErrorNums(int[] nums) {
        // Write your code here
        Arrays.sort(nums);
        int[] result = new int[2];
        for(int i = 1; i < nums.length; i++) {
            int diff = nums[i] - nums[i-1];
            if(diff != 1) {
                if (diff > 1) {
                    result[1] = nums[i-1] + 1;
                } else {
                    result[0] = nums[i];
                }
            }
        }
        if(result[1] == 0) {
            if (nums[0] != 1) result[1] = 1;
            else {
                result[1] = nums[nums.length - 1] + 1;
            }
        }
        return result;
    }
}
