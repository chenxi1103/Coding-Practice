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
        if(A == null) return result;
        dfs(A, target, k, result, new ArrayList<Integer>(), 0);
        return result;
    }
    private void dfs(int[] A, int remains, int k, List<List<Integer>> result, ArrayList<Integer> subset, int index){
        if(remains == 0 && subset.size() == k){
            result.add(new ArrayList<Integer>(subset));
        }
        for(int i = index; i < A.length; i++){
            if(remains < A[i] || subset.size() > k){
                break;
            }
            subset.add(A[i]);
            dfs(A, remains - A[i], k, result, subset, i+1);
            subset.remove(subset.size() - 1);
        }
    }
}
