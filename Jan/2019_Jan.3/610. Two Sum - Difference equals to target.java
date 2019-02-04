//活用hashmap存index！！！
public class Solution {
    /**
     * @param nums: an array of Integer
     * @param target: an integer
     * @return: [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum7(int[] nums, int target) {
        // write your code here
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<nums.length; i++){
            int sum = target + nums[i];
            if(map.containsKey(sum)){
                result[0] = map.get(sum) + 1;
                result[1] = i+1;
                return result;
            }
            int diff = nums[i] - target;
            if(map.containsKey(diff)){
                result[0] = map.get(diff) + 1;
                result[1] = i+1;
                return result;
            }
            map.put(nums[i], i);
        }
        return result;
    }
}
