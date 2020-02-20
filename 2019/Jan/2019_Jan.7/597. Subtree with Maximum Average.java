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
     * @return: the root of the maximum average of subtree
     */
    private class resultType{
        int sum, size;
        public resultType(int sum, int size){
            this.sum = sum;
            this.size = size;
        }
    }
    public resultType max = new resultType(0,0);
    public TreeNode result = null;

    public TreeNode findSubtree2(TreeNode root) {
        // write your code here
        helper(root);
        return result;
    }
    private resultType helper(TreeNode root){
        if(root == null) return new resultType(0,0);
        //这里是精髓部分！！！分治法 + recursion！！！
        resultType left = helper(root.left);
        resultType right = helper(root.right);
        resultType curr_root = new resultType(left.sum + right.sum + root.val, left.size+right.size+1);

        //判断有木有大于max，大于就赋值
        if(result == null || curr_root.sum * max.size > max.sum * curr_root.size){
            max = curr_root;
            result = root;
        }
        return curr_root;
    }
}
