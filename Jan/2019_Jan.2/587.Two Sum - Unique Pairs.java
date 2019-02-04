//记得先去重！！！
public class Solution {
    /**
     * @param nums: an array of integer
     * @param target: An integer
     * @return: An integer
     */
    public int twoSum6(int[] nums, int target) {
        // write your code here
        HashMap<Integer, Integer> map = noDuplicate(nums);
        int[] no_duplicate = new int[map.size()];
        int i = 0;
        for(int key : map.keySet()){
            no_duplicate[i++] = key;
        }
        int result = howManyTwoSum(no_duplicate, target);
        if(target % 2 == 0){
            if(map.containsKey(target/2) && map.get(target/2) > 1) result++;
        }
        return result;
    }
    private HashMap<Integer,Integer> noDuplicate(int[] nums){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<nums.length; i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i])+1);
            }else{
                map.put(nums[i], 1);
            }
        }
        return map;
    }
    private int howManyTwoSum(int[] nums, int target){
        int result = 0;
        for(int i = 0; i<nums.length-1; i++){
            for(int j = i+1; j<nums.length; j++){
                if(nums[i] + nums[j] == target) result++;
            }
        }
        return result;
    }
}
