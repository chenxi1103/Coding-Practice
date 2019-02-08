//跟maxdepth很像，但是得到左右子树的maxdepth后，要时刻判断左右子树的最大深度有没有差1以上
// 这道题只有分治法一种写法，因为分治法本来就比较像遍历法的后根遍历，这道题也不太适合遍历法来写
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    public boolean isBalanced(TreeNode root) {
        // write your code here
        return maxDepth(root) != -1;

    }
    private int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        if(left == -1 || right == -1) return -1;
        if(Math.abs(left - right) > 1) return -1;
        return Math.max(left, right) + 1;
    }
}
