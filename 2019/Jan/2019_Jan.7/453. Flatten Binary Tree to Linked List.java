//先序遍历（pre-order）指的是，中->左->右
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
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    TreeNode result = null;
    public void flatten(TreeNode root) {
        // write your code here
        if(root == null) return;
        if(result != null){
            result.left = null;
            result.right = root;
        }
        result = root;
        TreeNode right = root.right;
        flatten(root.left);
        flatten(right);
    }
}
