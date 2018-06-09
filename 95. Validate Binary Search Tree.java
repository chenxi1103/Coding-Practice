public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        return helper(root).isBST;
    }
    
    private ResultType helper(TreeNode root) {  //helper返回传入节点的子树中的最大值与最小值节点，及bst信息
        //二叉树的分治法大致模板：
        //1. 边界情况
        if (root == null) {
            return new ResultType(true);
        }
        if (root.right == null && root.left == null) { 
            return new ResultType(true, root, root);
        }
        //2.无脑递归左右子树
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        //3.分析“左根右”子树
        //这一步的思路就是假设递归函数已经完善(isBST真实反映左右子树的bst信息)
        //那么一旦左右子树中出现非bst，我们可以直接返回false
        if (left.isBST == false || right.isBST == false) {  
            return new ResultType(false);
        }
        if (left.maxNode != null && left.maxNode.val >= root.val) {     //剩余两种false的情况
            return new ResultType(false);
        }
        if (right.minNode != null && right.minNode.val <= root.val) {   //剩余两种false的情况
            return new ResultType(false);
        }
        //4.返回值
        ResultType node = new ResultType(true);
        node.maxNode = right.maxNode != null ? right.maxNode : root;    //返回值的赋值
        node.minNode = left.minNode != null ? left.minNode : root;
        return node;
    }
}

class ResultType {
    boolean isBST;
    TreeNode maxNode, minNode;
    ResultType (boolean isBST) {
        this.isBST = isBST;
        this.maxNode = null;
        this.minNode = null;
    }
    ResultType (boolean isBST, TreeNode maxNode, TreeNode minNode) {
        this.isBST = isBST;
        this.maxNode = maxNode;
        this.minNode = minNode;
    }
}


//遍历法:利用二叉搜索树的中序遍历为一个上升数组的特性
//**遍历法的递归函数不需要返回值；通过改变全局变量来储存结果
public class Solution {
    private TreeNode lastNode;
    private boolean isBST;
    
    public boolean isValidBST(TreeNode root) {
        lastNode = null;
        isBST = true;
        traversal(root);
        return isBST;
    }
    
    private void traversal(TreeNode root) {
        if (root == null) {
            return;
        }
        
        traversal(root.left);
        if (lastNode != null && root.val <= lastNode.val) {     //一旦出现下降树，就改bst状态
            isBST = false;
            return;
        } else {
            lastNode = root;
        }
        traversal(root.right);
    }
}
