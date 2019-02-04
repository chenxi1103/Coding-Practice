
public class Solution {
    /*
     * @param A: an integer array
     * @param k: a postive integer <= length(A)
     * @param target: an integer
     * @return: A list of lists of integer
     */
    public List<List<Integer>> kSumII(int[] A, int k, int target) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        if(A == null || A.length == 0) return result;
        Arrays.sort(A);
        dfs(A, target, result, new ArrayList<>(), 0, k);
        return result;
    }
    private void dfs(int[] A, int remains, List<List<Integer>> result, ArrayList<Integer> subset, int index, int k){
        if(remains == 0 && subset.size() == k){
            result.add(new ArrayList<Integer>(subset));
        }
        for(int i = index; i < A.length; i++){
            if(A[i] > remains) break;
            subset.add(A[i]);
            dfs(A, remains - A[i], result, subset, i+1, k);
            subset.remove(subset.size() - 1);
        }
    }
}
