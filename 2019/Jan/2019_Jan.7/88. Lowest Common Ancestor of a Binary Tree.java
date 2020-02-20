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
    /*
     * @param root: The root of the binary search tree.
     * @param A: A TreeNode in a Binary.
     * @param B: A TreeNode in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        // write your code he
        if(root == null || A == null || B == null) return null;
        if(root == A || root == B) return root;
        TreeNode left_result = lowestCommonAncestor(root.left, A, B);
        TreeNode right_result = lowestCommonAncestor(root.right, A, B);
        if(left_result!=null && right_result!=null) return root;
        else if(left_result!=null) return left_result;
        else if(right_result!=null) return right_result;
        return null;
    }
}
