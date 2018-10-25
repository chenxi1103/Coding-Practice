这道题是个easy，easy的基础是已经知道怎么求二叉树的最大深度了（虽然这是一个基本功2333）
如果知道怎么求二叉树最大深度，那么这道题的思路可以是：
用递归Recursion，首先构建一个新的函数求树的最大深度，然后求左子树最大深度，右子树最大深度，两者之差大于1就return false，然后菜判断左右子树是不是分别依旧是高度平衡树，结束。

如何求二叉树的最大深度？
private int deepestHeight(TreeNode node){
        if(node == null) return 0;
        int lH = deepestHeight(node.left);
        int rH = deepestHeight(node.right);
        return lH>rH?lH+1 : rH+1;
    }
思路同样是一个递归Recursion,分别求左右子树的最大深度，谁深，谁再加1就是整棵树的最大深度了。
 
知道怎么求二叉树的最大深度后就可以写这道题了：
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int left = deepestHeight(root.left);
        int right = deepestHeight(root.right);
        if(Math.abs(left-right)>1) return false;
        return isBalanced(root.left)&&isBalanced(root.right);
        
    }
    
    private int deepestHeight(TreeNode node){
        if(node == null) return 0;
        int lH = deepestHeight(node.left);
        int rH = deepestHeight(node.right);
        return lH>rH?lH+1 : rH+1;
    }
}
