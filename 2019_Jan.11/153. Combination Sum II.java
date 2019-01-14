public class Solution {
    /**
     * @param num: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(num);
        dfs(num, target, result, new ArrayList<>(), 0);
        return result;
    }
    private void dfs(int[] num, int remains, List<List<Integer>> result, ArrayList<Integer> subset, int index){
        if(remains == 0){
            result.add(new ArrayList<Integer>(subset));
            return;
        }
        for(int i = index; i < num.length; i++){
            if(i != 0 && num[i] == num[i-1] && i != index){
                continue;
            }
            if(num[i] > remains){
                break;
            }
            subset.add(num[i]);
            dfs(num, remains - num[i], result, subset, i+1);
            subset.remove(subset.size() - 1);
        }
    }
}
