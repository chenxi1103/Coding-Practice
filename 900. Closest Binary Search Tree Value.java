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
     * @param root: the given BST
     * @param target: the given target
     * @return: the value in the BST that is closest to the target
     */
    
    public int closestValue(TreeNode root, double target) {
        if(root == null) return Integer.MAX_VALUE;
        if(root.val>target){
            if(root.left!=null){
                int left = closestValue(root.left,target);
                if(Math.abs(left-target)<Math.abs(root.val-target)){
                return left;
                }
            }
        }else if(root.val<target){
            if(root.right!=null){
                int right = closestValue(root.right,target);
                if(Math.abs(right-target)<Math.abs(root.val-target)){
                return right;
                }
            }
        }
        return root.val;
    }
}
