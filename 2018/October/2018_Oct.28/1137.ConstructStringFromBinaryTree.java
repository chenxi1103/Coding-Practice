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
     * @param t: the root of tree
     * @return: return a string
     * 这道题是亚马逊面试原题，做得不好，需要重新复习，注意二叉树的遍历和条件
     * 当左子树为空右子树不空时，左子树要加上（），如果左子树为空右子树为空，则什么也不加
     * 如果左子树不空，右子树为空，则右子树什么也不加，所以可以看出，不管左子树空不空，
     * 只要右子树空了，右子树这个部分是什么也不加的！
     * oct-28-11:16
     */
    public String tree2str(TreeNode t) {
        // write your code here
        String result = helper(t);
        //去掉首尾没有必要的括号
        return result.substring(1,result.length()-1);

    }
    private String helper(TreeNode t){
        if(t == null){
            return "()";
        }
        if(t.left == null && t.right == null){
            return "("+t.val+")";
        }
        String left = helper(t.left);
        String right = helper(t.right);
        //判断右子树是不是（），因为不管左子树空不空，右子树只要为空，就没必要写（）
        return "("+t.val+left+(right.equals("()")? "" : right)+")";
    }
}
