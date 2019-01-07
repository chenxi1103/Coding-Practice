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
     * @param root:
     * @return: the length of the longest path where each node in the path has the same value
     * 这道题依然是考二叉树，写起来依然有点困难，需要更深的理解
     * 需要二次做一下这道题
     * 2018-oct-28
     */
    public int count;
    public int longestUnivaluePath(TreeNode root) {
        // Write your code here
        if(root == null) return 0;
        helper(root);
        return count;
    }
    private int helper(TreeNode root){
        if(root == null) return 0;
        int left = 0;
        int right = 0;
        int leftCount = helper(root.left);
        int rightCount = helper(root.right);
        if(root.left!=null && root.val == root.left.val){
            left = leftCount + 1;
        }
        if(root.right!=null && root.val == root.right.val){
            right = rightCount+1;
        }
        count = Math.max(count,right+left);
        return Math.max(left,right);
    }
}
