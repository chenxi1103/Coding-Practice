///如何在subset的基础上去重，注意，有重复的时候，子集的数量是比没有重复的要少的，不可以全循环一遍再去重，这样时间复杂度太高
public class Solution {
    /**
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null) return result;
        Arrays.sort(nums);
        dfs(nums,result,0,new ArrayList<Integer>());
        return result;
    }
    private void dfs(int[] nums, List<List<Integer>> result, int index, ArrayList<Integer> subset){
        result.add(new ArrayList<Integer>(subset));
        for(int i = index; i<nums.length; i++){
            if(i > 0 && nums[i] == nums[i-1] && i != index){
                continue;
            }
            subset.add(nums[i]);
            dfs(nums,result,i+1,subset);
            subset.remove(subset.size()-1);
        }
    }
}
