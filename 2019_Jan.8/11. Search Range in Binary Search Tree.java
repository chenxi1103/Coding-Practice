public class Solution {
    /**
     * @param root: param root: The root of the binary search tree
     * @param k1: An integer
     * @param k2: An integer
     * @return: return: Return all keys that k1<=key<=k2 in ascending order
     */
    public List<Integer> searchRange(TreeNode root, int k1, int k2) {
        // write your code here
        List<Integer> result = new ArrayList<>();
        helper(root,k1,k2,result);
        return result;
    }
    private void helper(TreeNode root, int k1, int k2, List<Integer> result){
        if(root == null) return;
        helper(root.left, k1, k2, result);
        if(root.val >= k1 && root.val <= k2) result.add(root.val);
        helper(root.right, k1, k2, result);
    }
}
