class Solution {
    boolean flag = false;
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return flag;
        helper(root, 0, sum);
        return flag;
    }
    private void helper(TreeNode node, int sum, int target) {
        if(node == null) return;
        //这一步很重要，一定要是左右孩子都是null，才算是叶子结点！
        if(node.left == null && node.right == null) {
            if(target == sum + node.val) {
                flag = true;
            }
            return;
        }
        helper(node.left, sum + node.val, target);
        helper(node.right, sum + node.val, target);
    }
}

class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        if(root.left == null && root.right == null && sum == root.val) return true;
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
