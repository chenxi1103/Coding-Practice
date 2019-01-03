/////////////////////o(n) space, o(n) time/////////////////////////////
public class Solution {
    /**
     * @param nums: an array of integers
     * @return: the number of unique integers
     */
    public int deduplication(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0) return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for(int i = 0; i<nums.length - count; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], 1);
            }else{
                count++;
                int temp = nums[i];
                nums[i] = nums[nums.length - count];
                nums[nums.length-count] = temp;
                i--;
            }
        }
        return nums.length - count;
    }
}

///////////////////o(nlogn)时间复杂度 o(1) space 记住！！！///////////////////////
public class Solution {
    /**
     * @param nums: an array of integers
     * @return: the number of unique integers
     */
    public int deduplication(int[] nums) {
        // write your code here
        if(nums == null || nums.length ==0) return 0;
        Arrays.sort(nums);
        int count = 0;
        for(int i = 0; i<nums.length; i++){
            if(nums[count] != nums[i]){
                nums[++count] = nums[i];
            }
        }
        return count + 1;
    }
}
