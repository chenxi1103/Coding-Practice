// 记得多复习，总是想不到怎么解也是醉了…
public class Solution {
    /**
     * @param root: the root of binary tree
     * @return: the root of the maximum average of subtree
     */
        class newNode{
        int size, sum;
        public newNode(int size, int sum) {
            this.size = size;
            this.sum = sum;
        }
    }
    public TreeNode result = null;
    public newNode max = new newNode(0, 0);
    public TreeNode findSubtree2(TreeNode root) {
        // write your code here
        helper(root);
        return result;
    }
    private newNode helper(TreeNode node) {
        if(node == null) return new newNode(0, 0);
        newNode left = helper(node.left);
        newNode right = helper(node.right);
        newNode curr = new newNode(left.size + right.size + 1, left.sum + right.sum + node.val);
        if(result == null || (max.size * curr.sum > max.sum * curr.size)) {
            result = node;
            max = curr;
        }
        return curr;
    }
}
