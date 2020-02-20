public class Solution {
    /**
     * @param candidates: A list of integers
     * @param target: An integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        int[] nodeplicate = removeDuplicate(candidates);
        dfs(nodeplicate, target, 0, result, new ArrayList<Integer>());
        return result;
    }
    private int[] removeDuplicate(int[] candidates){
        if(candidates == null || candidates.length <= 1) return candidates;
        int count = 1;
        for(int i = 1; i < candidates.length; i++){
            if(candidates[i] != candidates[i-1]){
                candidates[count++] = candidates[i];
            }
        }
        int[] result = new int[count];
        for(int i = 0; i<result.length; i++){
            result[i] = candidates[i];
        }
        return result;
    }
    private void dfs(int[] candidates, int remains, int index, List<List<Integer>> result, ArrayList<Integer> subset){
        if(remains == 0){
            result.add(new ArrayList<Integer>(subset));
            return;
        }
        for(int i = index; i < candidates.length; i++){
            if(remains < candidates[i]) break;
            subset.add(candidates[i]);
            dfs(candidates, remains - candidates[i], i, result, subset);
            subset.remove(subset.size() - 1);
        }
    }
}
