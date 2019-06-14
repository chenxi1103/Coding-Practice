class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(inorder == null || inorder.length == 0) return null;
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private int findIndex(int[]inorder, int start, int end, int val) {
        for(int i = start; i <= end; i++) {
            if(inorder[i] == val) {
                return i;
            }
        }
        return -1;
    }
    private TreeNode build(int[] preorder, int prestart, int preend, int[] inorder, int instart, int inend) {
        if (instart > inend) return null;
        TreeNode root = new TreeNode(preorder[prestart]);
        int index = findIndex(inorder, instart, inend, preorder[prestart]);
        root.left = build(preorder, prestart + 1, prestart + index - instart, inorder, instart, index -1);
        root.right = build(preorder, prestart + index - instart + 1, preend, inorder, index+1, inend);
        return root;
    }
}
