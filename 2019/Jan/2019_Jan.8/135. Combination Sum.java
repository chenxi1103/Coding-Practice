public class Solution {
    /**
     * @param candidates: A list of integers
     * @param target: An integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        if(candidates == null) return result;
        int[] noDuplicate = removeDuplicate(candidates);
        dfs(noDuplicate,result,target,new ArrayList<Integer>(),0);
        return result;
    }
    private int[] removeDuplicate(int[] candidates){
        if(candidates == null || candidates.length <= 1) return candidates;
        Arrays.sort(candidates);
        int index = 1;
        for(int i = 1; i<candidates.length; i++){
            if(candidates[i] != candidates[i-1]){
                candidates[index++] = candidates[i];
            }
        }
        int[] result = new int[index];
        for(int i = 0; i<index; i++){
            result[i] = candidates[i];
        }
        return result;
    }
    private void dfs(int[] candidates, List<List<Integer>> result, int remains, ArrayList<Integer> subset, int index){
        if(remains == 0){
            result.add(new ArrayList<Integer>(subset));
            return;
        }
        for(int i = index; i<candidates.length; i++){
            if(remains < candidates[i]) break;
            subset.add(candidates[i]);
            dfs(candidates,result,remains - candidates[i], subset, i);
            subset.remove(subset.size()-1);
        }
    }
}
