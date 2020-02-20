class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(p == root || q == root) return root;
        TreeNode leftAncestor = lowestCommonAncestor(root.left, p, q);
        TreeNode rightAncestor = lowestCommonAncestor(root.right, p, q);
        if(leftAncestor != null && rightAncestor != null) return root;
        return leftAncestor == null ? rightAncestor : leftAncestor;
    }
}
