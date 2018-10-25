/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param root: the root of binary tree
     * @return: the root of the minimum subtree
     */
    public TreeNode findSubtree(TreeNode root) {
        ResultType result = helper(root);
        return result.node;
    }
    
    public ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(null, 0, Integer.MAX_VALUE); //若节点为null，最小sum为最大整数，这样一定不会被选上
        }
        
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        
        ResultType rootnode = new ResultType (
            root, 
            left.sum + right.sum + root.val, 
            left.sum + right.sum + root.val         //根节点的sum = minsum；因为一旦选择根节点，所有相连节点都要相加
        );                                        
            
        if (left.minsum < right.minsum && left.minsum < rootnode.sum) {
            left.sum = rootnode.sum;                //更新sum，为了上一层的计算。若不更新，上一层的rootnode.sum会错误
            return left;
        }
        if (right.minsum < left.minsum && right.minsum < rootnode.sum) {
            right.sum = rootnode.sum;               //同上
            return right;
        }
        return rootnode;
    }
}

class ResultType {
    int sum, minsum;
    TreeNode node;
    ResultType (TreeNode node, int sum, int minsum) {
        this.node = node;           //表示最小sum出现的根节点
        this.minsum = minsum;       //最小sum的值
        this.sum = sum;             //用于储存某一结点的sum（不一定是node节点）
    }
}

//解题思路：1.找左子树minsum 2.找右子树minsum 3.算根节点的sum
//要点：1.递归函数需要多个返回值，用ResultType类。

