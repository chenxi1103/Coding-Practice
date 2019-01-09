//这题好难…注意可以用recursion来写，只考虑root.val == value的时候的情况。最复杂的情况是root的左右都不是null。
//此时可将root.left的最大值找到，作为新的root，因为这值比所有左孩子里的值都大，比所有右孩子的值都小，然后把左孩子里的这个最大值点删掉，就可以构建新的树了！
//这是最好记得办法了…理解并背诵…
public class Solution {
    /*
     * @param root: The root of the binary search tree.
     * @param value: Remove the node with given value.
     * @return: The root of the binary search tree after removal.
     */
    public TreeNode removeNode(TreeNode root, int value) {
        // write your code here
        if(root == null) return root;
        if(root.val == value){
            if(root.left == null && root.right == null) return null;
            if(root.left == null) return root.right;
            if(root.right == null) return root.left;
            TreeNode leftChild = root.left;
            int max_left = findMax(leftChild);
            TreeNode newRoot = new TreeNode(max_left);
            leftChild = removeNode(leftChild, max_left);
            newRoot.left = leftChild;
            newRoot.right = root.right;
            return newRoot;
        }
        else if(root.val > value) root.left = removeNode(root.left, value);
        else root.right = removeNode(root.right, value);
        return root;
    }
    private int findMax(TreeNode root){
        if(root.right == null) return root.val;
        return findMax(root.right);
    }
}
