//bottom up method 通过孩子节点推父节点
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}

//top down method 通过父节点推孩子节点
class Solution {
    int answer = 0;
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        helper(root, 1);
        return answer;
    }
    private void helper(TreeNode node, int depth) {
        if(node == null) return;
        if (node.left == null && node.right == null) {
            answer = Math.max(answer, depth);
        }
        helper(node.left, depth+1);
        helper(node.right, depth+1);
    }
}
