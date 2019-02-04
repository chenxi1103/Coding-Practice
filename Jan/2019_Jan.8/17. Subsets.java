//基于组合排序的dfs，recursion的写法（最简单的）
public class Solution {
    /**
     * @param nums: A set of numbers
     * @return: A list of lists
     */
    public List<List<Integer>> subsets(int[] nums) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        if(nums == null) return result;
        dfs(nums, new ArrayList<Integer>(), 0, result);
        return result;
    }
    private void dfs(int[] nums, ArrayList<Integer> subset, int index, List<List<Integer>> result){
        if(index == nums.length){
            result.add(new ArrayList<Integer>(subset));
            return;
        }
        subset.add(nums[index]);
        dfs(nums, subset, index + 1, result);
        subset.remove(subset.size() - 1);
        dfs(nums, subset, index + 1, result);
    }
}

////////////////////////////普适性recursion写法1（不用回溯法）//////////////////////
public class Solution {
    /**
     * @param nums: A set of numbers
     * @return: A list of lists
     */
    public List<List<Integer>> subsets(int[] nums) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        if(nums == null) return result;
        dfs(nums, new ArrayList<Integer>(), 0, result);
        return result;
    }
    private void dfs(int[] nums, ArrayList<Integer> subset, int index, List<List<Integer>> result){
        result.add(subset);
        for(int i = index; i<nums.length; i++){
            ArrayList<Integer> newSet = new ArrayList<Integer>(subset);
            newSet.add(nums[i]);
            dfs(nums, newSet, i+1, result);
        }
    }
}

////////////////////////////普适性recursion写法2（需要回溯法）//////////////////////
public class Solution {
    /**
     * @param nums: A set of numbers
     * @return: A list of lists
     */
    public List<List<Integer>> subsets(int[] nums) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        if(nums == null) return result;
        dfs(nums, new ArrayList<Integer>(), 0, result);
        return result;
    }
    private void dfs(int[] nums, ArrayList<Integer> subset, int index, List<List<Integer>> result){
        result.add(new ArrayList<Integer>(subset));
        for(int i = index; i<nums.length; i++){
            subset.add(nums[i]);
            dfs(nums,subset,i+1,result);
            subset.remove(subset.size() - 1);
        }
    }
}
