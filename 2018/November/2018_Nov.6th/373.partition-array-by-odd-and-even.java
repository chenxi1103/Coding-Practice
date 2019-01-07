public class Solution {
    /*
     * @param nums: an array of integers
     * @return: nothing
     */
    public void partitionArray(int[] nums) {
        // write your code here
        int count = 0;
        for(int i = 0; i<nums.length; i++){
            if(nums[i] % 2 == 1) continue;
            count = i;
            while(count<nums.length-1){
                count++;
                if(nums[count]%2 == 1){
                    int temp = nums[i];
                    nums[i] = nums[count];
                    nums[count] = temp;
                    break;
                }
            }
        }
    }
}

这个更快一点！！！！！
public class Solution {
    /*
     * @param nums: an array of integers
     * @return: nothing
     */
    public void partitionArray(int[] nums) {
        // write your code here
        int start = 0;
        int end = nums.length-1;
        while(start<end){
            while(start<end && nums[start] % 2 == 1){
                start++;
            }
            while(start<end&& nums[end] % 2 == 0){
                end--;
            }
            if(start<end){
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
            }
        }
    }
}
