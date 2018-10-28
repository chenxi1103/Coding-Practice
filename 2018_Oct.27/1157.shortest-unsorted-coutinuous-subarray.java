public class Solution {
    /**
     * @param nums: an array
     * @return: the shortest subarray's length
     * 方法不够好，依然用了arraycopy和arraysort的方法，不太好，以后看看是否能优化
     * 2018-0ct-27
     */
    public int findUnsortedSubarray(int[] nums) {
        // Write your code here
        int[] newNums = new int[nums.length];
        System.arraycopy(nums,0,newNums,0,nums.length);
        Arrays.sort(newNums);
        int head = 0;
        int tail = 0;
        for(int i = 0; i<nums.length; i++){
            if(nums[i] != newNums[i]){
                head = i;
                break;
            }
        }
        for(int i = nums.length-1; i > 0; i--){
            if(nums[i]!=newNums[i]){
                tail = i;
                break;
            }
        }
        if(tail-head == 0) return 0;
        return tail-head+1;
    }
}
