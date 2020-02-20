// 分别处理k是不是0的情况，有点麻烦…
public class Solution {
    /**
     * @param nums: an array of integers
     * @param k: an integer
     * @return: the number of unique k-diff pairs
     */
    public int findPairs(int[] nums, int k) {
        // Write your code here
        if(nums == null || nums.length <= 1) return 0;
        int result = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        if(k == 0) {
            for(int i = 0; i < nums.length; i++) {
                if(map.containsKey(nums[i])) {
                    map.put(nums[i], map.get(nums[i]) + 1);
                } else {
                    map.put(nums[i], 1);
                }
            }
            for(int key : map.keySet()) {
                if(map.get(key) > 1) result++;
            }
        } else {
            for(int i = 0; i < nums.length; i++) {
                if(map.containsKey(nums[i])) continue;
                if(map.containsKey(nums[i] - k) || map.containsKey(nums[i] + k)) result++;
                map.put(nums[i], 1);
            }
        }
        return result;
    }
}
