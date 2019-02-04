public class Solution {
    /**
     * @param root: the root of binary tree
     * @return: the length of the longest consecutive sequence path
     */
    public int longestConsecutive(TreeNode root) {
        // write your code here
        return helper(root, null, 0);
    }
    public int helper(TreeNode currNode, TreeNode parent, int length){
        if(currNode == null) return 0;
        length = (parent!=null && parent.val + 1 == currNode.val) ? length + 1 : 1;
        int left = helper(currNode.left, currNode, length);
        int right = helper(currNode.right, currNode, length);
        return Math.max(length, Math.max(left, right));
    }
}
