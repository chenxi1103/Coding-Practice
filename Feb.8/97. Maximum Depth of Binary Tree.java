//分治法
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: An integer
     */
    public int maxDepth(TreeNode root) {
        // write your code here
        if(root == null) return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;
    }
}

//遍历法
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: An integer
     */
    public int depth = 0;
    public int maxDepth(TreeNode root) {
        // write your code here
        traversal(root, 1);
        return depth;
    }
    private void traversal(TreeNode root, int currDepth) {
        if(root == null) return;
        depth = Math.max(depth, currDepth);
        traversal(root.left, currDepth + 1);
        traversal(root.right, currDepth + 1);
    }
}
