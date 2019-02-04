public class Solution {
    /**
     * @param nums: a continuous stream of numbers
     * @param number: a number
     * @return: returns the first unique number
     */
    public int firstUniqueNumber(int[] nums, int number) {
        // Write your code here
        boolean flag = false;
        int index = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], 1);
            }else{
                map.put(nums[i], map.get(nums[i]) + 1);
            }
            if(nums[i] == number) {
                flag = true;
                index = i;
                break;
            }
        }
        if(!flag) return -1;
        for(int i = 0; i <= index; i++){
            if(map.get(nums[i]) == 1) return nums[i];
        }
        return - 1;
    }
}
