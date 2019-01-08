//所有有关bst的题，首先想到的不应该是它的中序遍历，还要想到，你要找的这个点的value是大于root的value还是小于root的value
//如果小于直接去左子树找，大于就去右子树，等于直接返回，就这么简单！！！
public class Solution {
    /*
     * @param root: The root of the BST.
     * @param p: You need find the successor node of p.
     * @return: Successor of p.
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // write your code here
        if(root == null || p == null) return null;
        if(root.val <= p.val) return inorderSuccessor(root.right, p);
        else{
            TreeNode left = inorderSuccessor(root.left, p);
            return left == null ? root : left;
        }
    }
}
//////////////////////不用递归的方法////////////////////
//对bst这个结构理解的还是不够深刻，难受😣
public class Solution {
    /*
     * @param root: The root of the BST.
     * @param p: You need find the successor node of p.
     * @return: Successor of p.
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // write your code here
        if(root == null || p == null) return null;
        TreeNode successor = null;
        while(root!=null && root.val != p.val){
            // p at left side
            if(root.val > p.val){
                successor = root;
                root = root.left;
            //p at right side
            }else{
                root = root.right;
            }
        }
        //如果不存在右子树，则是走到当前路径中，第一个左拐的点（即successor）
        if(root.right == null) return successor;
        //如果存在右子树，那么就是右子树中一路向西最左边的点
        root = root.right;
        while(root.left!=null){
            root = root.left;
        }
        return root;
    }
}
