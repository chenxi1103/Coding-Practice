//因为没有求平均值所以不用重新搞一个class存size和sum，比平均最大那道题还简单！
/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param root: the root of binary tree
     * @return: the root of the minimum subtree
     */
    public TreeNode result = null;
    public int min = Integer.MAX_VALUE;
    public TreeNode findSubtree(TreeNode root) {
        // write your code here
       int min_sum = helper(root);
       return result;
    }
    private int helper(TreeNode root){
        if(root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        int curr_root = left + right + root.val;
        if(result == null || curr_root < min){
            min = curr_root;
            result = root;
        }
        return curr_root;
    }
}
