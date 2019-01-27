public class Solution {
    /**
     * @param t1: the root of the first tree
     * @param t2: the root of the second tree
     * @return: the new binary tree after merge
     */
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        // Write your code here
        TreeNode node = null;
        if(t1 != null && t2 != null) {
            node = new TreeNode(t1.val + t2.val);
            node.left = mergeTrees(t1.left, t2.left);
            node.right = mergeTrees(t1.right, t2.right);
        } else if (t1 == null && t2 ==null) {
            return node;
        } else {
            if(t1 == null) {
                node = new TreeNode(t2.val);
                node.left = mergeTrees(null, t2.left);
                node.right = mergeTrees(null, t2.right);
            } else {
                node = new TreeNode(t1.val);
                node.left = mergeTrees(t1.left, null);
                node.right = mergeTrees(t1.right, null);
            }
        }
        return node;
    }
}
