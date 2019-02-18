class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0) return null;
        if (inorder.length == 1) return new TreeNode(inorder[0]);
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        int index = 0;
        for(int i = 0; i < inorder.length; i++) {
            if(inorder[i] == root.val) {
                index = i;
                break;
            }
        }
        int[] inleft = Arrays.copyOfRange(inorder, 0, index);
        int[] postleft = Arrays.copyOfRange(postorder, 0, index);
        int[] inright = Arrays.copyOfRange(inorder, index+1, inorder.length);
        int[] postright = Arrays.copyOfRange(postorder, index, postorder.length-1);
        root.left = buildTree(inleft, postleft);
        root.right = buildTree(inright, postright);
        return root;
    }
}
